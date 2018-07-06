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
 * GringottsBank is our bank.
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
    /**
     * Number to create a 3-digit number for the Credit Card.
     */
    private static final long CVV_CREDIT_CARD_GENERATOR_MAGIC_NUMBER = 1000L;
    private double annualRatePercentageConsumerCredit;
    private double annualRatePercentageHousingCredit;
    private double onlineDiscountPercent;

    /**
     * Singleton pattern
     */
    private static final GringottsBank INSTANCE = new GringottsBank();
    private GringottsBank() {
    }
    public static synchronized GringottsBank getInstance() {
        return INSTANCE;
    }

    {
        setAnnualRatePercentageConsumerCredit(3);
        setAnnualRatePercentageHousingCredit(3);
        setOnlineDiscountPercent(2);
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


    public static long getCvvCreditCardGeneratorMagicNumber() {
        return CVV_CREDIT_CARD_GENERATOR_MAGIC_NUMBER;
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

    /**
     * @param client   **Client who is applying for the credit card**
     * @param balance  **Balance reuired by the client**
     * @param currency **Currency reuired by the client**
     * @throws CardNumberFormatException **Throws if number doesn't match the regex**
     */
    public void createCreditCard(final Client client, final CreditCardPaymentNetwork creditCardPaymentNetwork, final double balance, final Currency currency) throws CardNumberFormatException {
        if (approveCreditCard(client)) {
            String numberCreditCard = randomNDigitString(16);
            String cVV = randomNDigitString(3);
            client.getCardList().add(new CreditCard(client, numberCreditCard, cVV, balance, currency, creditCardPaymentNetwork));
        }
    }

    /**
     * For now all of our clients can create Debit Card without checking for some restrictions.
     *
     * @param client **Client who applies for the Debit Card**
     * @throws CardNumberFormatException **Throws if number doesn't match the regex**
     */
    public boolean approveDebitCard(final Client client) throws CardNumberFormatException {
        return true;
    }

    /**
     * @throws CardNumberFormatException **For number of the card matching the regex**
     */
    public void createDebitCard(final Client client, final DebitCardPaymentNetwork debitCardPaymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        if (approveDebitCard(client)) {
            String numberDebitCard = randomNDigitString(16);
            String cVV = randomNDigitString(3);
            client.getCardList().add(new DebitCard(client, numberDebitCard, cVV, balance, currency, bill, debitCardPaymentNetwork));
        }
    }

    /**
     * For now all of our clients can create Indefinite Debit without checking for some restrictions.
     *
     * @return **always true**
     */
    public boolean approveIndefiniteDebit() {
        return true;
    }

    /**
     * Creating a IndefiniteDebit for a Individual Client.
     *
     * @param client  **Client applying for the debit**
     * @param balance **Initially injected balance from the client**
     * @param bonus   **Bonus if the creation is made online**
     */
    public void createIndefiniteDebit(final Client client, final double balance, final double bonus) {
        if (approveIndefiniteDebit()) {
            client.getDebitList().add(new Debit(balance * bonus));
        }
    }

    /**
     * Approving a Term Debit.
     *
     * @param balance **The initial injected balance**
     * @return **Return the response if debit is approved**
     */
    public boolean approveTermDebit(final double balance) {
        if (balance <= MIN_BALANCE_TERM_DEBIT) {
            return false;
        }
        return true;
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
            client.getDebitList().add(new TermDebit(balance * bonus, timeInMonths));
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
    public boolean approveConsumerCredit(final Client client, final double amount, final double discount) {
        if (amount <= MIN_BALANCE_CONSUMER_DEBIT && client.doesHaveGoodBankHistory()) {
            return true;
        }
        return false;
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

    /**
     * No requirements for Housing Credit
     *
     * @return **always true**
     */
    public boolean approveHousingCredit(final Client client) {
        if (client.doesHaveGoodBankHistory()) {
            return true;
        }
        return false;
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

    public void sendMessageToClient(final Client client, final Message message){
        client.getBankOnWeb().sendMessageToGringottsBank(message);
    }

    private String randomNDigitString(int n) {
        Random r = new Random();
        char[] v = new char[n];
        for (int j = 0; j < n; j++) v[j] = (char) (r.nextDouble() * 10 + 48);
        return new String(v);
    }
}
