package net.combase.cloud.buttler.swoppen;

import java.math.BigDecimal;
import java.util.List;

import net.combase.api.domain.Cashier;
import net.combase.api.domain.Currency;
import net.combase.api.domain.Receipt;
import net.combase.api.domain.Sale;
import net.combase.api.service.CashierApiService;
import net.combase.api.service.CurrencyApiService;
import net.combase.api.service.ReceiptApiService;
import net.combase.api.service.SaleApiService;

public class CashOut {
	public void writeCashOutFile(final Long customerGroup, final Long revision) {

		final Currency currency = CurrencyApiService.getByNumber(Long.valueOf(1));
		List<Receipt> receipts = ReceiptApiService.getUpdatesByRevision(revision);
		Long maxRevision = Long.valueOf(0);
		StringBuilder line = new StringBuilder();
		for (Receipt receipt : receipts) {
			if (receipt.getRevision() > maxRevision)
				maxRevision = receipt.getRevision();
			List<Sale> sales = SaleApiService.getAllFromReceipt(receipt.getUuid());
			for (Sale sale : sales) {
				Cashier cashier = CashierApiService.getByNumber(Long.valueOf(sale.getCashier()));
				line.append(receipt.getCustomer());//Customer number
				line.append(receipt.getNumber());//receipt number
				// $s->{date} = qq~$day.$month.$year~;
				// $s->{time} = $time;
				// $s->{tax} = sprintf "%.0f,00",
				final BigDecimal subtract = sale.getGrossItemPrice().subtract(sale.getNetItemPrice());
				final BigDecimal grossItemPrice = subtract.divide((sale.getNetItemPrice().divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP)), 2, BigDecimal.ROUND_HALF_UP);
				line.append(cashier.getFirstname());
				line.append(currency.getSymbol());
				line.append(grossItemPrice);
				line.append(sale.getNetItemPrice());
				line.append(sale.getQuantity());
			}
		}
	}
}
