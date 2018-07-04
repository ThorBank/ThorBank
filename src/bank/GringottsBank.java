package bank;

import card.CardNumberFormatException;
import card.CreditCard;
import card.DebitCard;
import card.PaymentNetwork;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import debit.IndefiniteDebit;
import debit.TermDebit;

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
     * This is for app.
     *
     * @param client **The client dsg dsgds**
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

    public void createCreditCard(final Client client, PaymentNetwork paymentNetwork, double balance, Currency currency) throws CardNumberFormatException {
        if (approveCreditCard(client)){
            long numberCreditCard = (long) (Math.random() * 10000000000000000L);
            long CVV = (long) (Math.random() * 1000L);
            client.getCardList().add(new CreditCard(client, Long.toString(numberCreditCard), paymentNetwork, Long.toString(CVV), balance, currency));
        }
    }
    /**
     *
     *
     * @param client **fdsfds**
     * @param iban **fdsfsd**
     * @param debitCard **fsfds**
     */
    public boolean issuanceDebitCard(final Client client) throws CardNumberFormatException {
        //client.getCardList().add(new DebitCard());
        return true;
    }

    /**
     *
     * @param client **client**
     * @param debit **fdsfsdfd**
     * @param discount **fdsfsd**
     * @return
     */
    public boolean approveIndefiniteDebit(final Client client, final IndefiniteDebit debit, final double discount){
        return true;
    }

    /**
     *
     * @param client **Hi**
     * @param debit **Come ein debit**
     * @param discount **fdffds**
     * @return **fdsfssfd**
     */
    public boolean approveTermDebit(final Client client, final TermDebit debit, final double discount){
        if (debit.getBalance() < MIN_BALANCE_TERM_DEBIT){
            return false;
        }
        return true;
    }

    public boolean approveConsumerCredit(Client client, ConsumerCredit consumerCredit, double discount){
        if (consumerCredit.getAmount() > MIN_BALANCE_CONSUMER_DEBIT){
            return true;
        }
        return false;
    }

    public boolean approveHousingCredit(Client client, HousingCredit housingCredit, double discount){
        return true;
    }
}
