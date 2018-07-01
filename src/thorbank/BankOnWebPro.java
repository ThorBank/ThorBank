package thorbank;

import bank.GringottsBank;
import card.Card;
import client.*;
import credit.ConsumerCredit;
import credit.Credit;
import debit.Debit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import housetaxes.Taxes;

public class BankOnWebPro extends BankOnWeb implements ConsumerCredit.CreditAppliable, ConsumerCredit.CreditPayable, Debit.DebitPayable, Debit.IndefiniteDebitAppliable, Debit.TermDebitAppliable {
    private static final double ONLINE_DISCOUNT_PERCENT = 2;

    public BankOnWebPro(Client client) {
        super(client);
    }

    public void transactionBetweenBills(Client client, Bill firstBill, Bill secondBill, double amount) {
        if (!client.getBillList().contains(firstBill) || !client.getBillList().contains(secondBill)) {

        }

        firstBill.setAvailability(firstBill.getAvailability()-amount);
        secondBill.setAvailability(secondBill.getAvailability()+amount);
    }


    public void payingTaxes(Taxes taxes) {
        switch (taxes) {
            case TAXES: break;
            case HOUSEHOLD_BILLS: break;
            case FEES: break;
        }
    }

    @Override
    public void applyingForACredit() {

    }

    @Override
    public void payCredit(Credit credit, Bill bill) {

    }

    @Override
    public void payCredit(Credit credit, Card card) {

    }



    @Override
    public void injectMoney(Credit credit, Bill bill) {

    }

    @Override
    public void withdrawMoney(Credit credit, Card card) {

    }

    @Override
    public void applyingForADebit(IndefiniteDebit indefiniteDebit) {
        GringottsBank.getInstance().approveIndefiniteDebit(this.getClient(), indefiniteDebit, ONLINE_DISCOUNT_PERCENT);
    }

    @Override
    public void applyForATermDebit(TermDebit termDebit) {
        GringottsBank.getInstance().approveTermDebit(this.getClient(), termDebit, ONLINE_DISCOUNT_PERCENT);
    }
}
