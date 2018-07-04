package card;

import client.Client;
import thorbank.Bill;

import java.util.Currency;
import java.util.Date;

public class DebitCard extends Card {
    private Bill bill;

    public DebitCard(Client client, String number, PaymentNetwork paymentNetwork, String CVV, double balance, Currency currency, Bill bill) throws CardNumberFormatException {
        super(client, number, paymentNetwork, CVV, balance, currency);
        setBill(bill);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
