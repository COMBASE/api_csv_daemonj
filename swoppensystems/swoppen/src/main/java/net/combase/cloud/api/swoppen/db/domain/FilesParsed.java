package net.combase.cloud.api.swoppen.db.domain;

/**
 * 
 * @author Mario Zieschang
 * 
 */
public class FilesParsed extends ButlerDbObject {
	private static final long serialVersionUID = 3083594622268480176L;
	private String name;
	private String md5Hash;
	private String customerGroup;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMd5Hash() {
		return md5Hash;
	}

	public void setMd5Hash(String md5Hash) {
		this.md5Hash = md5Hash;
	}

	public String getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}
}
