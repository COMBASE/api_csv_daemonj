package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.ApiProperties;
import net.combase.api.domain.Supplier;

public class SupplierApiService extends AbstractApiService {
	private static final String object = "suppliers";

	public static Supplier getByNumber(final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(ApiProperties.get().getToken(), object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Supplier> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static List<Supplier> formatOutputs(JSONArray results) {
		final List<Supplier> ret = new ArrayList<Supplier>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Supplier c = new Supplier();
				if (r.has("name"))
					c.setName(r.get("name").toString());
				c.setNumber(r.get("number").toString());
				c.setUuid(r.get("uuid").toString());
				c.setCustomerNumber(r.get("customerNumber").toString());	

				ret.add(c);
			}
		}
		return ret;
	}

}
