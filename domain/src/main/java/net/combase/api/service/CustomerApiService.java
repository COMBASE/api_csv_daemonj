package net.combase.api.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import net.combase.api.ApiProperties;
import net.combase.api.domain.Customer;

public class CustomerApiService extends AbstractApiService {

	private static final String object = "customers";

	public static Customer getByNumber(final Long number) {
		JSONArray fetchByNumber = null;
		try {
			fetchByNumber = fetchByNumber(ApiProperties.get().getToken(), object, number);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Customer> formatOutputs = formatOutputs(fetchByNumber);
		if (formatOutputs.size() > 0)
			return formatOutputs.get(0);
		return null;
	}

	public static Customer saveCustomer(Customer newCloudCustomer) {
		try {
			post(new JSONObject(newCloudCustomer), object);
			Customer byNumber = getByNumber(Long.valueOf(newCloudCustomer.getNumber()));
			return byNumber;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}



	public static List<Customer> formatOutputs(JSONArray results) {
		final List<Customer> ret = new ArrayList<Customer>();

		for (int i = 0; i < results.length(); i++) {
			JSONObject r = null;
			if (results.get(i) instanceof JSONObject)
				r = (JSONObject) results.get(i);
			if (r != null) {
				final Customer c = new Customer();
				if (r.has("name"))
					c.setName(r.get("name").toString());
				c.setNumber(r.get("number").toString());
				c.setCustomerGroup(r.get("customerGroup").toString());
				c.setFirstName(r.get("firstName").toString());
				c.setLastName(r.get("lastName").toString());
				c.setUuid(r.get("uuid").toString());
				ret.add(c);
			}
		}
		return ret;
	}

}
