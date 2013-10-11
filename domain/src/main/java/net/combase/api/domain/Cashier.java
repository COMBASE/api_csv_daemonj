package net.combase.api.domain;

/**
 *
 * @author mziescha
 *
 */
public class Cashier extends AbstractDomainRootAndNumberObject {

	private static final long serialVersionUID = 4152772838594308195L;
	private String firstName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
