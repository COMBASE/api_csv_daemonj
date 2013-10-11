package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.domain.Cashier;

public class CashierApiService extends AbstractApiService {

	private static final String object = "cashiers";

	public static Cashier getByNumber(final String token, final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(token, object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Cashier> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static List<Cashier> formatOutputs(JSONArray results) {
		final List<Cashier> ret = new ArrayList<Cashier>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Cashier c = new Cashier();
				// c.setDeleted(deleted);r.get("deleted").toString()
				c.setFirstname(r.get("firstname").toString());
				if (r.has("name"))
					c.setName(r.get("name").toString());
				c.setNumber(r.get("number").toString());
				c.setSurname(r.get("surname").toString());
				c.setUuid(r.get("uuid").toString());
				ret.add(c);
			}
		}
		return ret;
	}
}
