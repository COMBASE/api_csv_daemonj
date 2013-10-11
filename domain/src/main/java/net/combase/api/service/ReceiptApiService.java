package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.domain.Receipt;

public class ReceiptApiService extends AbstractApiService {

	private static final String object = "receipts";

	public static List<Receipt> getPageByCustomerGroup(final String token,
			final Long customerGroup) {
		JSONArray fetch = null;
		try {
			fetch = fetchByCustomerGroup(token, object, customerGroup);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return formatOutputs(fetch);
	}

	public static List<Receipt> getUpdatesByRevision(final Long revision) {

		return null;
	}

	public static Receipt getByNumber(final String token, final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(token, object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Receipt> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static Receipt getById(final String token, final String id) {
		JSONArray fetchById = null;
		try {
			fetchById = fetchById(token, object, id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Receipt> formatOutputs = formatOutputs(fetchById);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static List<Receipt> formatOutputs(JSONArray results) {
		final List<Receipt> ret = new ArrayList<Receipt>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Receipt receipt = new Receipt();
				receipt.setUuid(r.get("uuid").toString());
				receipt.setCashier(r.get("cashier").toString());
				// receipt.setCreateTime(toBool(result.get("createTime")));
				if (r.has("currency"))
					receipt.setCurrency(r.get("currency").toString());
				if (r.has("customer"))
					receipt.setCustomer(r.get("customer").toString());
				receipt.setDeleted(toBool(r.get("deleted")).booleanValue());
				// receipt.setFinishTime(result.get("finishTime").toString());
				// receipt.setGrossTotalAmount(result.get("grossTotalAmount").toString());
				// receipt.setNetTotalAmount(result.get("netTotalAmount").toString());
				receipt.setNumber(r.get("number").toString());
				// receipt.setTaxAmount(result.get("taxAmount").toString());
				if (r.has("priceGroup"))
				receipt.setPriceGroup(r.get("priceGroup").toString());
				ret.add(receipt);
			}
		}
		return ret;
	}
}
