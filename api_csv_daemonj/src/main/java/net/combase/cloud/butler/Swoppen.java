package net.combase.cloud.butler;

import java.awt.TrayIcon;
import java.io.File;

import net.combase.api.ApiProperties;
import net.combase.api.domain.CustomerGroup;
import net.combase.api.service.CustomerGroupApiService;
import net.combase.cloud.api.swoppen.CashIn;
import net.combase.cloud.api.swoppen.CashOut;


public class Swoppen {
	private final CashIn cashIn;
	private final CashOut cashOut;
	private final CustomerGroup customerGroup;

	public Swoppen(TrayIcon processTrayIcon) {
		customerGroup = CustomerGroupApiService.getByNumber(ApiProperties.get().getToken(), Long.valueOf(ApiProperties.get().getCustomerGroupNumber()));
		cashIn = new CashIn(processTrayIcon, customerGroup);
		cashOut = new CashOut(processTrayIcon);
	}

	public CashIn getCashIn() {
		return cashIn;
	}

	public CashOut getCashOut() {
		return cashOut;
	}

	public void doRun(final String cashIn, final String cashOut) {

		if (getCashIn().readFolder(new File(cashIn)))
			; 		// TODO for releas remove semikolon
		getCashOut().writeFolder(new File(cashOut));
	}

}
