package net.combase.api.domain;

/**
 *
 * @author mziescha
 *
 */
public class AbstractDomainRootAndNumberObject extends AbstractDomainRootObject {

	private static final long serialVersionUID = 427433649857114325L;
	private Long number;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}
}
