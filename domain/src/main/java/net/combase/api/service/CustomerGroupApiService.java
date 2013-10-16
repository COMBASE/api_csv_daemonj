package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.domain.CustomerGroup;

public class CustomerGroupApiService extends AbstractApiService {

	private static final String object = "customergroups";

	public static CustomerGroup getByNumber(final String token, final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(token, object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<CustomerGroup> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static CustomerGroup save(CustomerGroup customerGroup) {
		return null;
		// TODO Auto-generated method stub

	}

	public static List<CustomerGroup> formatOutputs(JSONArray results) {
		final List<CustomerGroup> ret = new ArrayList<CustomerGroup>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final CustomerGroup c = new CustomerGroup();
				if (r.has("name"))
					c.setName(r.get("name").toString());
				c.setNumber(r.get("number").toString());
				c.setPriceGroup(r.get("priceGroup").toString());
				c.setUuid(r.get("uuid").toString());
				ret.add(c);
			}
		}
		return ret;
	}
}
