package card;

import client.Client;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Card {
    private static String NUMBER_REGEX = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    private String bankName;
    private String number;
    private Calendar expirationDate;
    private String CVV;
    private Client client;
    private double balance;
    private Currency currency;

    public Card(Client client, String number, PaymentNetwork paymentNetwork, String CVV, double balance, Currency currency) throws CardNumberFormatException {
        this.bankName = "GringottsBank";
        setNumber(number);
        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);
        setExpirationDate(new GregorianCalendar(timeNow.get(Calendar.YEAR + 4), timeNow.get(Calendar.MONTH), timeNow.get(Calendar.DAY_OF_MONTH)));
        setCVV(CVV);
        setClient(client);
        setBalance(balance);
        setCurrency(currency);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) throws CardNumberFormatException {
        if (!number.matches(NUMBER_REGEX)){
            throw new CardNumberFormatException();
        }
        this.number = number;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
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

}
