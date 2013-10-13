package net.combase.api;

import java.awt.TrayIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

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

	protected ApiProperties() {
		try {

			InputStream file = new FileInputStream(new File("butler.properties"));
			Properties props = new Properties();
			props.load(file);
			appId = props.getProperty("appId");
			appSecret = props.getProperty("appSecret");
			apiAccesKey = props.getProperty("apiAccesKey");
			cloudUrl = props.getProperty("url");
			version = props.getProperty("version");
			protocol = props.getProperty("protocol");
			if (protocol == null || !protocol.equals("http") && !protocol.equals("https"))
				protocol = "https";
			StringBuilder sb = new StringBuilder();
			sb.append(protocol);
			sb.append("://");
			if (!cloudUrl.startsWith("www."))
				sb.append("www.");
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

	/**
	 * diese Methode fordert das Token-Authentifizierungselement vom Cloudserver
	 * an und speichert es in die token.txt
	 * 
	 * @throws IOException
	 */

	public static Token generateToken(TrayIcon processTrayIcon) {
		String token = null;

		final String url = get().getProtocol() + get().getCloudUrl() + get().getVersion() + "/auth/"
				+ ApiProperties.get().getAppId() + "/" + ApiProperties.get().getAppSecret() + "/"
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
}