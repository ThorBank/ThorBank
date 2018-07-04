package card;

import client.Client;
import thorbank.Bill;

import java.util.Currency;
import java.util.Date;

public class DebitCard extends Card {
    private Bill bill;

    public DebitCard(final Client client, final String number, final PaymentNetwork paymentNetwork, final String CVV, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        super(client, number, paymentNetwork, CVV, balance, currency);
        setBill(bill);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

}
