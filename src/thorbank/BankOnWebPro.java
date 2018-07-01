package thorbank;

import bank.GringottsBank;
import card.Card;
import client.*;
import credit.*;
import debit.*;
import housetaxes.Taxes;

public class BankOnWebPro extends BankOnWeb implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable {
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
    public void payCredit(Credit credit, Bill bill) {

    }

    @Override
    public void payCredit(Credit credit, Card card) {

    }

    @Override
    public void applyingForATermDebit(TermDebit termDebit) {
        GringottsBank.getInstance().approveTermDebit(this.getClient(), termDebit, ONLINE_DISCOUNT_PERCENT);
    }

    @Override
    public void applyingForAIndefiniteDebit(IndefiniteDebit debit) {

    }

    @Override
    public void applyingForAConsumerCredit(ConsumerCredit consumerCredit) {

    }

    @Override
    public void applyingForAHousingCredit(HousingCredit housingCredit) {

    }

    @Override
    public void injectMoneyInDebit(Debit credit, Bill bill) {

    }

    @Override
    public void injectMoneyInDebit(Debit debit, Card card) {

    }

    @Override
    public void withdrawMoneyFromDebit(Debit debit, Bill bill) {

    }

    @Override
    public void withdrawMoneyFromDebit(Debit credit, Card card) {

    }
}
