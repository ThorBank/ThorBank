/*
 * GringottsBank
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package bank;

import card.CardNumberFormatException;
import card.DebitCardPaymentNetwork;
import card.CreditCard;
import card.DebitCard;
import card.CreditCardPaymentNetwork;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import credit.TaxAssessment;
import debit.Debit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import message.Message;
import message.Sender;
import webbanking.Bill;
import webbanking.Currency;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * GringottsBank is our bank. Here are all the functions that only the staff of the bank can do.
 */
public final class GringottsBank implements Sender, Bank {

    private static final int MIN_BALANCE_TERM_DEBIT = 100;
    private static final int MIN_BALANCE_CONSUMER_DEBIT = 5000;
    /**
     * The amount charged, expressed as a percentage of principal,
     * by a lender to a borrower for the use of assets.
     */
    private static final int MIN_YEARS_OWN_CREDIT_CARD = 23;
    private static final int MAX_YEARS_OWN_CREDIT_CARD = 63;
    private static final int CARD_NUMBER_LENGTH = 16;
    private static final int CARD_CVV_LENGTH = 3;
    /**
     * Gringotts Bank can change its own credit percent, but when program is started we need some by default.
     * Same for all the STARTING_* constants.
     */
    private static final int STARTING_ANNUAL_PERCENTAGE_CREDIT = 3;
    private static final int STARTING_ONLINE_DISCOUNT_PERCENT = 3;
    private double annualRatePercentageConsumerCredit;
    private double annualRatePercentageHousingCredit;
    private double onlineDiscountPercent;

    /**
     * Only one instance.
     */
    private static final GringottsBank INSTANCE = new GringottsBank();

    private GringottsBank() {
    }

    public static synchronized GringottsBank getInstance() {
        return INSTANCE;
    }

    {
        setAnnualRatePercentageConsumerCredit(STARTING_ANNUAL_PERCENTAGE_CREDIT);
        setAnnualRatePercentageHousingCredit(STARTING_ANNUAL_PERCENTAGE_CREDIT);
        setOnlineDiscountPercent(STARTING_ONLINE_DISCOUNT_PERCENT);
    }

    public double getOnlineDiscountPercent() {
        return onlineDiscountPercent;
    }

    public void setOnlineDiscountPercent(final double onlineDiscountPercent) {
        this.onlineDiscountPercent = onlineDiscountPercent;
    }

    public double getAnnualRatePercentageConsumerCredit() {
        return annualRatePercentageConsumerCredit;
    }

    public void setAnnualRatePercentageConsumerCredit(final double annualRatePercentageConsumerCredit) {
        this.annualRatePercentageConsumerCredit = annualRatePercentageConsumerCredit;
    }

    public double getAnnualRatePercentageHousingCredit() {
        return annualRatePercentageHousingCredit;
    }

    public void setAnnualRatePercentageHousingCredit(final double annualRatePercentage) {
        this.annualRatePercentageHousingCredit = annualRatePercentage;
    }

    public boolean approveCreditCard(final Client client) {
        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);
        int clientYears = timeNow.get(Calendar.YEAR) - client.getDateofBirth().get(Calendar.YEAR);
        if (timeNow.get(Calendar.MONTH) < client.getDateofBirth().get(Calendar.MONTH)
                || timeNow.get(Calendar.MONTH) == client.getDateofBirth().get(Calendar.MONTH)
                && timeNow.get(Calendar.DAY_OF_MONTH) < client.getDateofBirth().get(Calendar.DAY_OF_MONTH)) {
            clientYears--;
        }
        if (!(clientYears >= MIN_YEARS_OWN_CREDIT_CARD && clientYears <= MAX_YEARS_OWN_CREDIT_CARD)) {
            return false;
        } else {
            return client.isWorking();
        }
    }

    public void createCreditCard(final Client client, final CreditCardPaymentNetwork creditCardPaymentNetwork, final double balance, final Currency currency) throws CardNumberFormatException {
        System.out.println(approveCreditCard(client));
        if (approveCreditCard(client)) {
            String numberCreditCard = randomNDigitString(CARD_NUMBER_LENGTH);
            String cVV = randomNDigitString(CARD_CVV_LENGTH);
            client.getCardList().add(new CreditCard(client, numberCreditCard, cVV, balance, currency, creditCardPaymentNetwork));
            System.out.println("size" + client.getCardList().size());
        }
    }

    public boolean approveDebitCard(final Client client) throws CardNumberFormatException {
        return true;
    }

    public void createDebitCard(final Client client, final DebitCardPaymentNetwork debitCardPaymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        if (approveDebitCard(client)) {
            String numberDebitCard = randomNDigitString(CARD_NUMBER_LENGTH);
            String cVV = randomNDigitString(CARD_CVV_LENGTH);
            client.getCardList().add(new DebitCard(client, numberDebitCard, cVV, balance, currency, bill, debitCardPaymentNetwork));
        }
    }

    /**
     * For now all of our clients can create Indefinite Debit without checking for some restrictions.
     *
     * @return **always true**
     */
    private boolean approveIndefiniteDebit() {
        return true;
    }

    public void createIndefiniteDebit(final Client client, final double balance, final double bonus) {
        if (approveIndefiniteDebit()) {
            client.getDebitList().add(new IndefiniteDebit(balance, Debit.getDefaultDebitPercent() + bonus));
        }
    }

    /**
     * Approving a Term Debit.
     *
     * @param balance **The initial injected balance**
     * @return **Return the response if debit is approved**
     */
    private boolean approveTermDebit(final double balance) {
        return !(balance <= MIN_BALANCE_TERM_DEBIT);
    }

    /**
     * Creating the Term Debit.
     *
     * @param client       **Client applying for the Term Debit**
     * @param balance      **Initial balance**
     * @param timeInMonths **Time in which client is not going to withdraw without getting a fine**
     * @param bonus        **Bonus debit is applied online**
     */
    public void createTermDebit(final Client client, final double balance, final int timeInMonths, final double bonus) {
        if (approveTermDebit(balance)) {
            client.getDebitList().add(new TermDebit(balance, timeInMonths, Debit.getDefaultDebitPercent() + bonus));
        }
    }

    /**
     * Approving a Consumer Credit from an Individual Client
     *
     * @param client   **The individual client applying for the credit**
     * @param amount   **The amount of the possible credit**
     * @param discount **Discount if credit is applied from the online platform of the bank**
     * @return
     */
    private boolean approveConsumerCredit(final Client client, final double amount, final double discount) {
        return (amount <= MIN_BALANCE_CONSUMER_DEBIT && client.doesHaveGoodBankHistory());
    }

    /**
     * Create Consumer Credit for Individual Client
     *
     * @param client               **Client applied for the credit**
     * @param amount               **The amount wanted from the client**
     * @param creditPeriodInMonths **The period of months in which the client will return the whole credit**
     */
    public void createConsumerCredit(final Client client, final Client guarantor, final double amount, final int creditPeriodInMonths) {
        if (approveConsumerCredit(client, amount, creditPeriodInMonths)) {
            client.getCreditList().add(new ConsumerCredit(client, guarantor, amount, creditPeriodInMonths));
        }
    }

    private boolean approveHousingCredit(final Client client) {
        return client.doesHaveGoodBankHistory();
    }

    /**
     * Creating a House Credit for an Individual Client
     *
     * @param client               **The individual client**
     * @param amount               **The amount wanted from the client**
     * @param creditPeriodInMonths **Period in which the client will return the credit**
     * @param taxAssessment        **The tax assesment for calculating the actual assesment**
     * @param discount             **The discount if the client applied from our web platform**
     */
    public void createHousingCredit(final Client client, final double amount, final int creditPeriodInMonths, final TaxAssessment taxAssessment, final double discount) {
        if (approveHousingCredit(client)) {
            client.getCreditList().add(new HousingCredit(client, amount * discount, creditPeriodInMonths, taxAssessment));
        }
    }

    /**
     * Only Client BankOnWebPro can send messages one to another
     *
     * @param client
     * @param message
     */
    public void sendMessageToClient(final Client client, final Message message) {
        client.getBankOnWeb().getMessagesWithTheBank().add(message);
    }

    /**
     * Generates digit string for creation of CVV and Number of the cards.
     *
     * @param n
     * @return
     */
    private String randomNDigitString(final int n) {
        Random r = new Random();
        char[] v = new char[n];
        for (int j = 0; j < n; j++) v[j] = (char) (r.nextDouble() * 10 + 48);
        return new String(v);
    }

    private boolean approveBill(Client client) {
        return client.doesHaveGoodBankHistory();
    }

    public void createBill(Client client, Currency currency, double amount) {
        if (client.doesHaveGoodBankHistory()) {
            client.getBillList().add(new Bill(randomNDigitString(20), currency, amount));
        }
    }
}
