package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.domain.Currency;

public class CurrencyApiService extends AbstractApiService {
	private static final String object = "currencies";

	public static Currency getByNumber(final String token, final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(token, object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Currency> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static List<Currency> formatOutputs(JSONArray results) {
		final List<Currency> ret = new ArrayList<Currency>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Currency c = new Currency();
				if (r.has("name"))
					c.setName(r.get("name").toString());
				c.setNumber(r.get("number").toString());
				c.setSymbol(r.get("symbol").toString());
				c.setUuid(r.get("uuid").toString());
				ret.add(c);
			}
		}
		return ret;
	}

}
