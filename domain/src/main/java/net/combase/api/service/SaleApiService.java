package net.combase.api.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.combase.api.domain.Sale;

public class SaleApiService extends AbstractApiService {

	private static final String object = "sales";

	public static List<Sale> getAllFromReceipt(final String token,
			final String receiptUuid) {
		JSONArray fetchById = null;
		try {
			fetchById = fetchAllFromReceipt(token, object, receiptUuid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Sale> formatOutputs = formatOutputs(fetchById);
		return formatOutputs;
	}

	public static JSONArray fetchAllFromReceipt(final String token,
			final String objType, final String receiptUuid) throws IOException {

		String url = KoronaApiUrl + KoronaApiVersion + "/" + token + "/"
				+ objType + "/all/" + receiptUuid;
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

	public static List<Sale> formatOutputs(JSONArray results) {
		final List<Sale> ret = new ArrayList<Sale>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Sale s = new Sale();
				s.setSector(r.get("sector").toString());
				s.setCommodityGroup(r.get("commodityGroup").toString());
				s.setArticle(r.get("article").toString());
				s.setDeleted(toBool(r.get("deleted")).booleanValue());
				s.setCashier(r.get("cashier").toString());
				s.setUuid(r.get("uuid").toString());
				s.setDescription(r.get("description").toString());
				s.setItemNumber(r.get("itemNumber").toString());
				s.setPos(r.get("pos").toString());
				s.setGrossItemPrice(new BigDecimal(r.get("grossItemPrice")
						.toString()));
				s.setBaseItemPrice(new BigDecimal(r.get("baseItemPrice")
						.toString()));
				s.setQuantity(new BigDecimal(r.get("quantity").toString()));
				s.setItemPrice(new BigDecimal(r.get("itemPrice").toString()));
				s.setNetItemPrice(new BigDecimal(r.get("netItemPrice")
						.toString()));
				try {
					Date date = DatatypeConverter.parseDateTime(
							r.get("bookingTime").toString()).getTime();
					s.setBookingTime(date);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				// "receiptIndex":0,s.setReceiptIndex(receiptIndex);
				// "deleted":false,s.setDeleted(deleted);
				// "revision":7621,s.setRevision(revision);
				ret.add(s);
			}
		}
		return ret;
	}
}