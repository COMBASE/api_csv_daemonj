package net.combase.api.domain;

/**
 *
 * @author mziescha
 *
 */
public class Currency extends AbstractDomainRootAndNumberObject {

	private static final long serialVersionUID = 6889926417805372147L;
	private String symbol;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}
