package net.combase.cloud.api.swoppen.db.domain;

/**
 *
 * @author Mario Zieschang
 *
 */
public class ImportedCustomer extends ButlerDbObject {
	private static final long serialVersionUID = 5960027197342091210L;
	private int status;
	private int fileId;
	private Long customerNumber;
	private String customerName;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setFirstName(String string) {
		// TODO Auto-generated method stub

	}

	public void setLastName(String string) {
		// TODO Auto-generated method stub

	}

	public void setCustomerGroupNumber(Long valueOf) {
		// TODO Auto-generated method stub

	}
}
