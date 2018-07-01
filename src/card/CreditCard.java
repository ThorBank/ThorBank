package card;

import client.Client;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class CreditCard extends Card {
    private Client client;
    private double balance;
    private Currency currency;

    public CreditCard(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Client client, double balance, Currency currency) {
        super(number, firstName, lastName, expirationDate, CVV, CVV2);
        setClient(client);
        setBalance(balance);
        setCurrency(currency);
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
