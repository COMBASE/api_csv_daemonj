package net.combase.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AbstractApiService {
	// public final static String KoronaApiUrl = new String(
	// "https://www.koronacloud.com/web/api/");
	public final static String KoronaApiUrl = new String(
			"http://10.0.0.201:8080/web/api/");
	public final static String KoronaApiVersion = new String("v1");

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

	public static JSONArray fetchByNumber(final String token,
			final String objType, final Long number) throws IOException {

		String url = KoronaApiUrl + KoronaApiVersion + "/" + token + "/"
				+ objType + "/number/" + number;
		String obj = fetchData(url).toString();
		JSONObject jsonObject = new JSONObject(obj);
		JSONArray results = new JSONArray();
		if (jsonObject != null && jsonObject.has("result")) {
			results.put(jsonObject.getJSONObject("result"));
		}
		return results;
	}



	public static JSONArray fetchByCustomerGroup(final String token,
			final String objType, final Long number) throws IOException {

		String url = KoronaApiUrl + KoronaApiVersion + "/" + token + "/"
				+ objType + "/customergroup/" + number;
		String obj = fetchData(url).toString();
		JSONArray results = new JSONArray();
		JSONObject jsonObject = new JSONObject(obj);
		if (jsonObject != null && jsonObject.has("result")) {
			results.put(jsonObject.getJSONObject("result"));
			return results;
		}
		if (jsonObject != null && jsonObject.has("resultList"))
			results = jsonObject.getJSONArray("resultList");
		return results;
	}

	public static JSONArray fetchById(final String token, final String objType,
			final String id) throws IOException {
		String url = KoronaApiUrl + KoronaApiVersion + "/" + token + "/"
				+ objType + "/id/" + id;
		String obj = fetchData(url).toString();
		JSONObject jsonObject = new JSONObject(obj);
		JSONArray results = new JSONArray();
		if (jsonObject != null && jsonObject.has("result"))
			results = jsonObject.getJSONArray("result");
		return results;
	}

	/**
	 * fetchData holt uns die benötigten Daten per Https-GET-Requests vom Server
	 * 
	 * @param url
	 *            stellt die aktuelle URL für die jeweils gesuchten Infos dar
	 * @return Stringbuffer response enthält alles in JSONForm was unter der URL
	 *         zu finden war
	 * @throws IOException
	 */
	protected static StringBuffer fetchData(String url) throws IOException {
		URL obj = new URL(url);
		URLConnection con;
		if (url.startsWith("https")) {
			setupConnection();
			con = (HttpsURLConnection) obj.openConnection(); // öffnet die
																// Connection
																// zum Server
																// (Https)
		} else {
			con = (HttpURLConnection) obj.openConnection(); // öffnet die
															// Connection zum
															// Server
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream())); // kopiert die Daten in einen Buffer
		String inputLine;
		StringBuffer response = new StringBuffer();
		// die folgende Schleife liest den Buffered Reader den wir oben gefüllt
		// haben line für line in einen Stringbuffer
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response;
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

	private static void setupConnection() {
		// im Folgenden werden wir unsere sehr schwache SecurityPolicy von oben
		// auf unsere Httpsconnection an
		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	protected static String getStringOutputLine(String titel, String referenz,
			JSONObject obj) throws JSONException, IOException {
		if (obj.has(referenz)) {
			if (obj.get(referenz).toString().length() < 35) {
				return titel + ": " + obj.get(referenz) + "\n";
			} else {
				// JSONObject childobj = fetchObject(referenz + "s",
				// obj.get(referenz).toString());
				// JSONObject result = childobj.getJSONObject("result");
				// return getStringOutputLine(titel, "name", result);
			}
		}
		return null;
	}

	protected static Boolean toBool(final Object object) {
		return Boolean.valueOf(object.toString());
	}
}
