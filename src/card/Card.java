/*
 * Card
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package card;

import client.Client;
import webbanking.Currency;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The class which both Credit and Debit Card extends.
 */
public abstract class Card {
    private static final String NUMBER_CARD_REGEX = "\\b\\d{4}(| |-)\\d{4}\\1\\d{4}\\1\\d{4}\\b";
    private String bankName;
    private String number;
    private Calendar expirationDate;
    /**
     * The code on the bank of the card - 3 digits.
     */
    private String cVV;
    /**
     * Client owning the card.
     */
    private Client client;
    private double balance;
    /**
     * You cannot withdraw anything else, but the currency of the card.
     */
    private Currency currency;

    public Card(final Client client, final String number, final String cVV, final double balance, final Currency currency) throws CardNumberFormatException {
        setBankName("GringottsBank");
        setNumber(number);
        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);
        setExpirationDate(new GregorianCalendar(timeNow.get(Calendar.YEAR + 4), Calendar.MONTH, Calendar.DAY_OF_MONTH));
        setCVV(cVV);
        setClient(client);
        setBalance(balance);
        setCurrency(currency);
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public void setNumber(final String number) throws CardNumberFormatException {
        if (!number.matches(NUMBER_CARD_REGEX)){
                throw new CardNumberFormatException();
        }
        this.number = number;
    }

    public void setExpirationDate(final Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCVV(final String cVV) {
        this.cVV = cVV;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }

}
