package net.combase.api.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JsonDateAdapter extends XmlAdapter<String, Date>
{

	private static final SimpleDateFormat inputDf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ssZ");

	@Override
	public String marshal(Date date) throws Exception
	{
		if (date == null)
			return null;
		return JsonDateAdapter.inputDf.format(date);
	}

	@Override
	public Date unmarshal(String v) throws Exception
	{
		try
		{
			final Date date = JsonDateAdapter.inputDf.parse(v);
			return date;
		}
		catch (Exception e)
		{
			// TODO: handle exception

			return null;
		}
	}

}
