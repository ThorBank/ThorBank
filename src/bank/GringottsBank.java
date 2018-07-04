package bank;

import card.CardNumberFormatException;
import card.CreditCard;
import card.DebitCard;
import card.PaymentNetwork;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import credit.TaxAssessment;
import debit.Debit;
import debit.TermDebit;
import thorbank.Bill;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *  GringottsBank is our bank.
 */
public final class GringottsBank {
    /**
     * Singleton pattern. The only instance of GringottsBank.
     */
    private static final GringottsBank INSTANCE = new GringottsBank();

    /**
     * Empty private constructor.
     */
    private GringottsBank() {
    }

    /**
     * Getter for the only instance of GringottsBank.
     *
     * @return **The only instance of GringottsBank.**
     */
    public static GringottsBank getInstance() {
        return INSTANCE;
    }

    /**
     * The minimum balance of the term debit.
     */
    private static final int MIN_BALANCE_TERM_DEBIT = 100;
    /**
     * The minimum balance of the consumer debit.
     */
    private static final int MIN_BALANCE_CONSUMER_DEBIT = 5000;
    /**
     * The amount charged, expressed as a percentage of principal,
     * by a lender to a borrower for the use of assets.
     */
    private static final int MIN_YEARS_OWN_CREDIT_CARD = 23;
    /**
     * Oldest people which could create a credit card.
     */
    private static final int MAX_YEARS_OWN_CREDIT_CARD = 63;
    /**
     * Number to create a 16-digit number for the Credit Card
     */
    private static final long NUMBER_CREDIT_CARD_GENERATOR_MAGIC_NUMBER = 10000000000000000L;
    /**
     * Number to create a 3-digit number for the Credit Card
     */
    private static final long CVV_CREDIT_CARD_GENERATOR_MAGIC_NUMBER = 1000L;
    /**
     * Bank should approve the credit card before creating.
     *
     * @param client **Client who is applying for the credit card**
     */
    public boolean approveCreditCard(final Client client) {
        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);
        int clientYears = timeNow.get(Calendar.YEAR) - client.getDateofBirth().get(Calendar.YEAR);
        if (!(clientYears >= MIN_YEARS_OWN_CREDIT_CARD && clientYears <= MAX_YEARS_OWN_CREDIT_CARD)){
            return false;
        }
        else
        {
            return client.isWorking();
        }
    }

    /**
     * Creation of credit card.
     *
     * @param client **Client who is applying for the credit card**
     * @param paymentNetwork **Payment Method reuired by the client**
     * @param balance **Balance reuired by the client**
     * @param currency **Currency reuired by the client**
     * @throws CardNumberFormatException **Throws if number doesn't match the regex**
     */
    public void createCreditCard(final Client client, final PaymentNetwork paymentNetwork, final double balance, final Currency currency) throws CardNumberFormatException {
        if (approveCreditCard(client)){
            long numberCreditCard = (long) (Math.random() * NUMBER_CREDIT_CARD_GENERATOR_MAGIC_NUMBER);
            long cVV = (long) (Math.random() * CVV_CREDIT_CARD_GENERATOR_MAGIC_NUMBER);
            client.getCardList().add(new CreditCard(client, Long.toString(numberCreditCard), paymentNetwork, Long.toString(cVV), balance, currency));
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
     * Creating Debit Card cicle
     *
     * @param client **Client applying for a Debit Card**
     * @param paymentNetwork **Wanted Payment Network**
     * @param balance **Initial injected balance**
     * @param currency **Picked currency from the client**
     * @param bill **The bill conected to the Debit Card**
     * @throws CardNumberFormatException **For number of the card matching the regex**
     */
    public void createDebitCard(final Client client, final PaymentNetwork paymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        if (approveDebitCard(client)){
            long numberCreditCard = (long) (Math.random() * NUMBER_CREDIT_CARD_GENERATOR_MAGIC_NUMBER);
            long cVV = (long) (Math.random() * CVV_CREDIT_CARD_GENERATOR_MAGIC_NUMBER);
            client.getCardList().add(new DebitCard(client, Long.toString(numberCreditCard), paymentNetwork, Long.toString(cVV), balance, currency, bill));
        }
    }

    /**
     * For now all of our clients can create Indefinite Debit without checking for some restrictions.
     * @return **always true**
     */
    public boolean approveIndefiniteDebit(){
        return true;
    }

    /**
     * Creating a IndefiniteDebit for a Individual Client.
     *
     * @param client **Client applying for the debit**
     * @param balance **Initially injected balance from the client**
     * @param bonus **Bonus if the creation is made online**
     */
    public void createIndefiniteDebit(final Client client, final double balance, final double bonus){
        if (approveIndefiniteDebit()){
            client.getDebitList().add(new Debit(client, balance * bonus));
        }
    }

    /**
     * Approving a Term Debit.
     *
     * @return **Return the response if debit is approved**
     */
    public boolean approveTermDebit(final double balance){
        if (balance < MIN_BALANCE_TERM_DEBIT){
            return false;
        }
        return true;
    }

    /**
     * Creating the Term Debit.
     *
     * @param client **Client applying for the Term Debit**
     * @param balance **Initial balance**
     * @param timeInDays **Time in which client is not going to withdraw without getting a fine**
     * @param bonus **Bonus debit is applied online**
     */
    public void createTermDebit(final Client client, final double balance, final int timeInDays, final double bonus){
        if (approveTermDebit(balance)){
            client.getDebitList().add(new TermDebit(client, balance*bonus, timeInDays));
        }
    }

    /**
     * Approving a Consumer Credit from an Individual Client
     *
     * @param client **The individual client applying for the credit**
     * @param amount **The amount of the possible credit**
     * @param discount **Discount if credit is applied from the online platform of the bank**
     * @return
     */
    public boolean approveConsumerCredit(Client client, double amount, double discount){
        if (amount > MIN_BALANCE_CONSUMER_DEBIT){
            return true;
        }
        return false;
    }

    /**
     * Create Consumer Credit for Individual Client
     *
     * @param client **Client applied for the credit**
     * @param amount **The amount wanted from the client**
     * @param creditPeriodInMonths **The period of months in which the client will return the whole credit**
     */
    public void createConsumerCredit(Client client, double amount, int creditPeriodInMonths){
        if (approveConsumerCredit(client, amount, creditPeriodInMonths)){
            client.getCreditList().add(new ConsumerCredit(client, amount, creditPeriodInMonths));
        }
    }

    public boolean approveHousingCredit(){
        return true;
    }

    public void createHousingCredit(Client client, double amount, int creditPeriodInMonths, TaxAssessment taxAssessment, double discount){
        if (approveHousingCredit()){
            client.getCreditList().add(new HousingCredit(client, amount, creditPeriodInMonths, taxAssessment));
        }
    }
}
