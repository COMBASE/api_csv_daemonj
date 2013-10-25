package net.combase.api;

import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

import net.combase.api.service.ApiUtil;

public class ApiProperties {
	static private ApiProperties _instance = null;
	private String version;
	private String url;
	private String apiAccesKey;
	private String appSecret;
	private String appId;
	private String token;
	private String protocol;
	private String cloudUrl;
	private String cashin;
	private String cashout;
	private int timeOut;
	private String customerGroupNumber;
	private static final Pattern IP_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}");

	protected ApiProperties() {
		try {

			InputStream file = new FileInputStream(
					new File("butler.properties"));
			Properties props = new Properties();
			props.load(file);
			appId = props.getProperty("appId");
			appSecret = props.getProperty("appSecret");
			apiAccesKey = props.getProperty("apiAccesKey");
			cloudUrl = props.getProperty("url");
			version = props.getProperty("version");
			protocol = props.getProperty("protocol");
			customerGroupNumber = props.getProperty("customerGroupNumber");
			timeOut = Integer.valueOf(props.getProperty("timeOut")).intValue();

			cashin = props.getProperty("cashin");
			cashout = props.getProperty("cashout");

			if (protocol == null || !protocol.equals("http")
					&& !protocol.equals("https"))
				protocol = "https";
			StringBuilder sb = new StringBuilder();
			sb.append(protocol);
			sb.append("://");
//			if (!cloudUrl.startsWith("www.") && !isValidIP(cloudUrl))
//				sb.append("www.");
			sb.append(cloudUrl);
			if (!cloudUrl.endsWith("/"))
				sb.append("/");
			sb.append(version);
			if (!version.endsWith("/"))
				sb.append("/");
			url = sb.toString();
		} catch (Exception e) {
			System.out.println("error" + e);
		}

	}

	public static boolean isValidIP(String ip) {
		boolean matches = IP_PATTERN.matcher(ip).matches();
		return matches;
	}

	/**
	 * diese Methode fordert das Token-Authentifizierungselement vom Cloudserver
	 * an und speichert es in die token.txt
	 * 
	 * @throws IOException
	 */

	public static Token generateToken(TrayIcon processTrayIcon) {
		String token = null;

		final String url = get().getUrl() + "/auth/"
				+ ApiProperties.get().getAppId() + "/"
				+ ApiProperties.get().getAppSecret() + "/"
				+ ApiProperties.get().getApiAccesKey();
		token = ApiUtil.fetchData(url, processTrayIcon).toString();
		if (token != null) {
			Token t = new Token();
			t.setToken(token);
			return t;
		}
		return null;
	}

	public String getCloudUrl() {
		return cloudUrl;
	}

	public String getToken() {
		return token;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getVersion() {
		return version;
	}

	public String getUrl() {
		return url;
	}

	public String getApiAccesKey() {
		return apiAccesKey;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	static public ApiProperties get() {
		if (_instance == null) {
			_instance = new ApiProperties();
		}
		return _instance;
	}

	public void setToken(String token) {
		this.token = token;
		url = url + token + "/";
	}

	public String getCashin() {
		return cashin;
	}

	public String getCashout() {
		return cashout;
	}

	public int getTimeOut() {
		return timeOut * 1000;
	}

	public String getCustomerGroupNumber() {
		return customerGroupNumber;
	}
}
