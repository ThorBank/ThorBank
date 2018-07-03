package bank;

import card.CreditCard;
import card.DebitCard;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import thorbank.Bill;

import java.util.Calendar;
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

    private GringottsBank(){}

    /**
     * Getter for the only instance of GringottsBank.
     *
     * @return **The only instance of GringottsBank.**
     */
    public static GringottsBank getInstance() {
        return INSTANCE;
    }

    /**
     *
     */
    private static final int MIN_BALANCE_TERM_DEBIT = 100;
    /**
     *
     */
    private static final int MIN_BALANCE_CONSUMER_DEBIT = 5000;
    /**
     * The amount charged, expressed as a percentage of principal,
     * by a lender to a borrower for the use of assets.
     */
    private static final int MIN_YEARS_OWN_CREDIT_CARD = 23;
    private static final int MAX_YEARS_OWN_CREDIT_CARD = 63;

    /**
     * This is for app.
     *
     * @param card **The cardgf gsdg dsg d**
     * @param client **The client dsg dsgds**
     */
    public boolean approveCreditCard(final CreditCard card, final Client client) {
        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);
        int clientYears = timeNow.get(Calendar.YEAR) - client.getDateofBirth().get(Calendar.YEAR);
        if (!(clientYears >= MIN_YEARS_OWN_CREDIT_CARD && clientYears <= MAX_YEARS_OWN_CREDIT_CARD)){
            return false;
        }
        else if (!client.isWorking())
        {
            return false;
        }
        return true;
    }

    /**
     *
     *
     * @param client **fdsfds**
     * @param iban **fdsfsd**
     * @param debitCard **fsfds**
     */
    public void issuanceDebitCard(final Client client, final String iban, final DebitCard debitCard) {
        for (Bill bill : client.getBillList()) {
            if (bill.getIban().equals(iban)) {
                debitCard.setBill(bill);
            }
        }
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
