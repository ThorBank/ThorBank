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
    private static final String NUMBER_CARD_REGEX = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    private String bankName;
    /**
     * The number of the card
     */
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

    /**
     *  The only constructor for creating some type of card
     *
     * @param client
     * @param number
     * @param paymentNetwork
     * @param cVV
     * @param balance
     * @param currency
     * @throws CardNumberFormatException **When number doesn't match the regex**
     */
    public Card(final Client client, final String number, final PaymentNetwork paymentNetwork, final String cVV, final double balance, final Currency currency) throws CardNumberFormatException {
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
