package net.combase.cloud.buttler.swoppen;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.combase.api.domain.Cashier;
import net.combase.api.domain.Currency;
import net.combase.api.domain.Receipt;
import net.combase.api.domain.Sale;
import net.combase.api.service.CashierApiService;
import net.combase.api.service.CurrencyApiService;
import net.combase.api.service.ReceiptApiService;
import net.combase.api.service.SaleApiService;
import net.combase.cloud.buttler.db.DbReader;

public class CashOut {
	public class ReceiptSaleSummaryBean {
		private final String date;
		private final String time;
		private final Sale sale;
		private final Receipt receipt;
		private final Currency currency;
		private final Cashier cashier;

		public ReceiptSaleSummaryBean(final String date, final String time,
				final Currency currency, final Receipt receipt,
				final Cashier cashier, final Sale sale) {
			this.date = date;
			this.time = time;
			this.sale = sale;
			this.receipt = receipt;
			this.cashier = cashier;
			this.currency = currency;

		}

		public Cashier getCashier() {
			return cashier;
		}

		public Sale getSale() {
			return sale;
		}

		public String getDate() {
			return date;
		}

		public String getTime() {
			return time;
		}

		public Receipt getReceipt() {
			return receipt;
		}

		public Currency getCurrency() {
			return currency;
		}

		public BigDecimal getTax() {
			final BigDecimal subtract = sale.getGrossItemPrice().subtract(
					sale.getNetItemPrice());
			return subtract.divide((sale.getNetItemPrice().divide(
					BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP)), 2,
					BigDecimal.ROUND_HALF_UP);
		}

	}

	public void writeCashOutFile(final Long customerGroup, final Long revision) {

		List<Receipt> receipts = ReceiptApiService
				.getUpdatesByRevision(revision);
		Long maxRevision = Long.valueOf(0);
		StringBuilder line = new StringBuilder();
		try {
			final Currency currency = CurrencyApiService.getByNumber(
					DbReader.getToken(), Long.valueOf(1));
			for (Receipt receipt : receipts) {
				if (receipt.getRevision() > maxRevision)
					maxRevision = receipt.getRevision();

				List<Sale> sales = SaleApiService.getAllFromReceipt(
						DbReader.getToken(), receipt.getUuid());
				for (Sale sale : sales) {
					Cashier cashier = CashierApiService.getByNumber(
							DbReader.getToken(),
							Long.valueOf(sale.getCashier()));
					line.append(receipt.getCustomer());// Customer number
					line.append(receipt.getNumber());// receipt number
					// $s->{date} = qq~$day.$month.$year~;
					// $s->{time} = $time;
					// $s->{tax} = sprintf "%.0f,00",
					final BigDecimal subtract = sale.getGrossItemPrice()
							.subtract(sale.getNetItemPrice());
					final BigDecimal grossItemPrice = subtract.divide((sale
							.getNetItemPrice().divide(BigDecimal.valueOf(100),
							2, BigDecimal.ROUND_HALF_UP)), 2,
							BigDecimal.ROUND_HALF_UP);
					line.append(cashier.getFirstname());
					line.append(currency.getSymbol());
					line.append(grossItemPrice);
					line.append(sale.getNetItemPrice());
					line.append(sale.getQuantity());
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ReceiptSaleSummaryBean> getCashOutData(
			final Long customerGroup, final Long revision) {

		List<ReceiptSaleSummaryBean> ret = new ArrayList<ReceiptSaleSummaryBean>();

		List<Receipt> receipts = null;
		Currency currency = null;
		try {
			currency = CurrencyApiService.getByNumber(DbReader.getToken(),
					Long.valueOf(1));
			receipts = ReceiptApiService.getPageByCustomerGroup(
					DbReader.getToken(), Long.valueOf(123456));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (receipts != null) {
			for (Receipt receipt : receipts) {

				try {
					List<Sale> sales = SaleApiService.getAllFromReceipt(
							DbReader.getToken(), receipt.getUuid());
					for (Sale sale : sales) {
						Cashier cashier = CashierApiService.getByNumber(
								DbReader.getToken(),
								Long.valueOf(sale.getCashier()));
						ret.add(new ReceiptSaleSummaryBean("", "", currency,
								receipt, cashier, sale));

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

	public static void writeFolder(File file) {
		// TODO Auto-generated method stub
		
	}
}
