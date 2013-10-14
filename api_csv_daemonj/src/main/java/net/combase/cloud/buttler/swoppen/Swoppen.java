package net.combase.cloud.buttler.swoppen;

import java.awt.TrayIcon;
import java.io.File;

public class Swoppen {
	private final CashIn cashIn;
	private final CashOut cashOut;

	public Swoppen(TrayIcon processTrayIcon) {
		cashIn = new CashIn(processTrayIcon);
		cashOut = new CashOut(processTrayIcon);
		// TODO Auto-generated constructor stub
	}

	public CashIn getCashIn() {
		return cashIn;
	}

	public CashOut getCashOut() {
		return cashOut;
	}

	public void doRun(String cashIn, String cashOut) {
		// TODO Auto-generated method stub
		if (getCashIn().readFolder(new File(cashIn)))
			;
		getCashOut().writeFolder(new File(cashOut));
	}

}
