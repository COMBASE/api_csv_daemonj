package net.combase.api.service;

import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import net.combase.api.ApiProperties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Diese Klasse regelt uns den Zugriff auf die Cloud bzw deren Schnittstelle
 * durch HTTPS GETs und POSTs
 *
 * @author Gordon Bosch
 *
 */
public class ApiUtil {

	/**
	 * formatOutput sorgt für die Formatierung der erstellten Produktdaten, die
	 * dann fertig an das Textfeld zurückgegeben werden können
	 *
	 * @param s
	 *            ist der String in JSON-Syntax, den wir für unsere Ausgabe
	 *            durchparsen
	 * @return den formatierten Fensterinhalt als String
	 * @throws JSONException
	 * @throws IOException
	 */
	public static String formatOutput(JSONObject obj) {
		String ausgabe = "";
		JSONObject result = new JSONObject();
		try {
			result = obj.getJSONObject("result"); // result ist unser Referenz
													// JSON-Objekt. von da aus
													// erreichen wir alle Daten
			ausgabe = getStringOutputLine("Produktname", "name", result)
					+ getStringOutputLine("Revision", "revision", result)
					+ getStringOutputLine("Rabattfähig", "discountable", result)
					+ getStringOutputLine("Preisänderbarkeit", "priceChangable", result)
					+ getStringOutputLine("Gelöscht", "deleted", result)
					+ getStringOutputLine("Type", "@xsi.type", result)
					+ getStringOutputLine("Warengruppe", "commodityGroup", result)
					+ getStringOutputLine("Sektor", "sector", result);

			if (result.has("prices")) // nicht jedes Produkt besitzt einen Preis
			{ // und falls kann es ein einzelner Preis oder eine Preisliste sein
				Object price = result.get("prices");
				if (price instanceof JSONObject) {
					ausgabe = ausgabe + "Preis: " + ((JSONObject) price).get("value") + " €";
				}
				if (price instanceof JSONArray) {
					ausgabe = ausgabe + "Preis: " + ((JSONObject) ((JSONArray) price).get(0)).get("value") + " €";
				}
			}

		} catch (JSONException e) {
			// UI.throwPopup("Kein Produkt unter dieser Nummer",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
		}
		return ausgabe;
	}

	/**
	 * Diese Methode prüft ob die Referenz (zB.: "name" oder "Revision") gültig
	 * ist und falls ja generiert es eine Ausgabezeile daraus
	 *
	 * @param titel
	 *            Der Zeilenname
	 * @param referenz
	 *            die Referenz im JSON-Objekt
	 * @param obj
	 *            das zu untersuchende JSON-Objekt
	 * @return Ausgabe wie: Produktname: Coca Cola
	 * @throws JSONException
	 * @throws IOException
	 */
	private static String getStringOutputLine(String titel, String referenz, JSONObject obj) throws JSONException,
			IOException {
		if (obj.has(referenz)) {
			if (obj.get(referenz).toString().length() < 35) {
				return titel + ": " + obj.get(referenz) + "\n";
			} else {
				JSONObject childobj = fetchObject(referenz + "s", obj.get(referenz).toString());
				JSONObject result = childobj.getJSONObject("result");
				return getStringOutputLine(titel, "name", result);
			}
		}
		return null;
	}

	/**
	 * fetchObject zieht das gesuchte Object anhand
	 *
	 * @param objType
	 *            dem ObjectType
	 * @param referenz
	 *            und der Referenz, in dem Fall number oder id
	 * @return das gesuchte JSON Object
	 * @throws IOException
	 */
	public static JSONObject fetchObject(String objType, String referenz) throws IOException {
		String indicator; // dieser String weist zu ob wir unsere gesuchtes
							// Object per number oder id referenzieren wollen
		if (isID(referenz)) {
			indicator = "id";
		} else {
			indicator = "number";
		}
		String url = ApiProperties.get().getUrl() + "/" + objType + "/" + indicator + "/" + referenz;
		String obj = ApiUtil.fetchData(url, null).toString();
		return new JSONObject(obj);
	}

	/**
	 * isID prüft einen String ob es sich um eine ID handelt oder Nummer
	 *
	 * @param s
	 *            der Eingabestring
	 * @return true falls ID, false fals Nummer
	 */
	private static boolean isID(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

	// Trustmanager sorgt dafür, dass wir kein Zertifikat brauchen werden wie
	// sonst bei SSL-verschlüsselungen
	static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public void checkClientTrusted(X509Certificate[] certs, String authType) {
		}

		public void checkServerTrusted(X509Certificate[] certs, String authType) {
		}
	} };

	private static void setupConnection() {
		// im Folgenden werden wir unsere sehr schwache SecurityPolicy von oben
		// auf unsere Httpsconnection an
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * fetchData holt uns die benötigten Daten per Https-GET-Requests vom Server
	 *
	 * @param url
	 *            stellt die aktuelle URL für die jeweils gesuchten Infos dar
	 * @param processTrayIcon
	 * @return Stringbuffer response enthält alles in JSONForm was unter der URL
	 *         zu finden war
	 * @throws IOException
	 */
	public static StringBuffer fetchData(final String url, final TrayIcon processTrayIcon) {

		URL obj = null;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		URLConnection con = null;
		try {
			if (ApiProperties.get().getUrl().contains("https")) {
				setupConnection();
				con = (HttpsURLConnection) obj.openConnection();
			} else {
				con = (HttpURLConnection) obj.openConnection();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader in;
		try {
			InputStream inputStream = con.getInputStream();
			InputStreamReader inR = new InputStreamReader(inputStream);
			in = new BufferedReader(inR);
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response;
		} catch (IOException e) {
			// e.printStackTrace();
			processTrayIcon.displayMessage("Connection Error Message", "Could not connect to " + url,
					TrayIcon.MessageType.ERROR);
		}

		return null;
	}

	/**
	 * postData sendet ein JSON-Objekt per POST zurück an die CLOUD
	 *
	 * @param url
	 *            des Servers
	 * @param obj
	 *            das JSON-Objekt
	 * @throws IOException
	 */
	public static void postData(String url, JSONObject obj) throws IOException {
		URL posturl = new URL(url);
		HttpURLConnection con;
		if (ApiProperties.get().getUrl().contains("https")) {
			setupConnection();
			con = (HttpsURLConnection) posturl.openConnection();
		} else {
			con = (HttpURLConnection) posturl.openConnection();
		}
		JSONObject.testValidity(obj); // testet ob valides JSON
		con.setRequestMethod("POST"); // setzt PostMethode
		con.setDoOutput(true); // ermöglicht Transferinput
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);
		con.setUseCaches(false);
		con.setRequestProperty("Content-Type", "application/json"); // setzt den
																	// type auf
																	// json
		con.connect();

		OutputStream out = con.getOutputStream();
		try {
			OutputStreamWriter wr = new OutputStreamWriter(out);
			wr.write(obj.toString());
			wr.flush();
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
		if (con.getResponseCode() == 200) {
			// UI.throwPopup("Produktname erfolgreich geändert",JOptionPane.INFORMATION_MESSAGE);
		}
		con.disconnect(); // Disconnect
		// ApiCsvDaemon.requestProduct(); //aktualisiere Produktanzeige
	}
}
