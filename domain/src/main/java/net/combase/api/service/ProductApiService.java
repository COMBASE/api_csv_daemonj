package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import net.combase.api.domain.Product;

public class ProductApiService extends AbstractApiService {

	public static Product getByNumber(final String token, final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(token, "products", number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Product> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static Product getById(final String token, final String id) {
		JSONArray fetchById = null;
		try {
			fetchById = fetchById(token, "products", id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Product> formatOutputs = formatOutputs(fetchById);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

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
	public static List<Product> formatOutputs(JSONArray result) {
		List<Product> ret = new ArrayList<Product>();

		try {
//			Product product = new Product();
//			ret.setName(result.get("name").toString());
//			ret.setRevision(Long.valueOf(result.get("revision").toString())
//					.longValue());
//			ret.setDiscountable(Boolean.valueOf(result.get("discountable")
//					.toString()));
//			ret.setPriceChangable(Boolean.valueOf(
//					result.get("priceChangable").toString()).booleanValue());
//			ret.setDeleted(Boolean.valueOf(result.get("deleted").toString())
//					.booleanValue());
//			ret.setCommodityGroup(result.get("commodityGroup").toString());
//			ret.setSector(result.get("sector").toString());

			// if (result.has("prices")) // nicht jedes Produkt besitzt einen
			// Preis
			// { // und falls kann es ein einzelner Preis oder eine Preisliste
			// sein
			// Object price = result.get("prices");
			// if(price instanceof JSONObject)
			// {
			// ausgabe = ausgabe + "Preis: " + ((JSONObject)price).get("value")
			// +" €";
			// }
			// if(price instanceof JSONArray)
			// {
			// ausgabe = ausgabe + "Preis: "+
			// ((JSONObject)((JSONArray)price).get(0)).get("value") + " €";
			// }
			// }

		} catch (JSONException e) {
			// UI.throwPopup("Kein Produkt unter dieser Nummer",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return ret;
	}
}
