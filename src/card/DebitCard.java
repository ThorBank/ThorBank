package card;

import client.Client;
import thorbank.Bill;

import java.util.Currency;
import java.util.Date;

public class DebitCard extends Card {
    private Bill bill;
    private Client client;
    private double balance;
    private Currency currency;

    public DebitCard(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Bill bill, double balance, Currency currency) {
        super(number, firstName, lastName, expirationDate, CVV, CVV2);
        setBill(bill);
        setBalance(balance);
        setBalance(balance);
        setCurrency(currency);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
