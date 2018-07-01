package card;

import client.Client;

import java.util.Currency;
import java.util.Date;

public class Card {
    private static String NUMBER_REGEX = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    private String number;
    private String firstName;
    private String lastName;
    private Date expirationDate;
    private String CVV;
    private String CVV2;
    private Client client;
    private double balance;
    private Currency currency;

    public Card(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Client client, double balance, Currency currency) {
        setNumber(number);
        setFirstName(firstName);
        setLastName(lastName);
        setExpirationDate(expirationDate);
        setCVV(CVV);
        setCVV2(CVV2);
        setClient(client);
        setBalance(balance);
        setCurrency(currency);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!number.matches(NUMBER_REGEX)){

        }
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

}
