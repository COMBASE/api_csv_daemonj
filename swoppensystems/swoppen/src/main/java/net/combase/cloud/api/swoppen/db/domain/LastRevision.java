package net.combase.cloud.api.swoppen.db.domain;

/**
 * 
 * @author Mario Zieschang
 * 
 */
public class LastRevision extends ButlerDbObject {
	private static final long serialVersionUID = 1300889591673772120L;
	private String revision;
	private Long customerGroupNumber;

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public Long getCustomerGroupNumber() {
		return customerGroupNumber;
	}

	public void setCustomerGroupNumber(Long customerGroupNumber) {
		this.customerGroupNumber = customerGroupNumber;
	}

}
