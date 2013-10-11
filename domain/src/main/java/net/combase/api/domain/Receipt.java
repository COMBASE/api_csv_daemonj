package net.combase.api.domain;

/**
 *
 * @author mziescha
 *
 */
public class Receipt extends AbstractDomainRootAndNumberObject {

	private static final long serialVersionUID = -1277692727064558362L;
	private Long customer;

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}

}
