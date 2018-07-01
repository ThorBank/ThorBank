package card;

import client.Client;
import thorbank.Bill;

import java.util.Currency;
import java.util.Date;

public class DebitCard extends Card {
    private Bill bill;

    public DebitCard(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Bill bill, Client client, double balance, Currency currency) {
        super(number, firstName, lastName, expirationDate, CVV, CVV2, client, balance, currency);
        setBill(bill);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
