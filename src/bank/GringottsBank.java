package bank;

import card.CreditCard;
import card.DebitCard;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import thorbank.Bill;

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
    private static final double AVERAGE_INTEREST_RATE = 0.01d;
    /**
     *
     */
    private static final double ATTRACTED_RESOURCE = 0.03d;
    /**
     *
     */
    private static final double LOANS = 10.0d;
    /**
     *
     */
    private static final double OTHER_RECEIVABLES = 6.0d;
    /**
     *
     */
    private static final double DISCOUNTS = 2.0d;

    /**
     * This is for app.
     *
     * @param card **The cardgf gsdg dsg d**
     * @param client **The client dsg dsgds**
     */
    public void approveCreditCard(final CreditCard card, final Client client) {
        client.getCardList().add(card);
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
