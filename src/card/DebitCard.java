package card;

import client.Client;
import webbanking.Bill;
import webbanking.Currency;

public class DebitCard extends Card {
    private Bill bill;
    private DebitCardPaymentNetwork debitCardPaymentNetwork;

    public DebitCard(final Client client, final String number, final String cVV, final double balance, final Currency currency, final Bill bill, final DebitCardPaymentNetwork debitCardPaymentNetwork) throws CardNumberFormatException {
        super(client, number, cVV, balance, currency);
        setBill(bill);
        this.debitCardPaymentNetwork = debitCardPaymentNetwork;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

}
