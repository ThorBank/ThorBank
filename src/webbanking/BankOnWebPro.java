package webbanking;

import bank.GringottsBank;
import card.Card;
import client.*;
import credit.*;
import debit.*;

public class BankOnWebPro extends BankOnWeb implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable {
    //TODO: in gringottsbank
    private static final double ONLINE_DISCOUNT_PERCENT = 2;

    public BankOnWebPro(final Client client) {
        super(client);
    }

    //check if bill is in our bank
    public void transactionBetweenBills(final Client client, final Bill firstBill, final Bill secondBill, final double amount) throws BillDoesNotMatchExceptions, NotEnoughMoneyInYourBill {
        if (!client.getBillList().contains(firstBill) || !client.getBillList().contains(secondBill)) {
            throw new BillDoesNotMatchExceptions();
        } else  if (firstBill.getAvailability() < amount) {
            throw new NotEnoughMoneyInYourBill();
        }

        firstBill.setAvailability(firstBill.getAvailability()-amount);
        secondBill.setAvailability(secondBill.getAvailability()+amount);
    }

    @Override
    public void payCredit(final Credit credit, final Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment() + 2/100*credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - 2/100*credit.getMonthlyPayment());
    }

    @Override
    public void payCredit(final Credit credit, final Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment() + 2/100*credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - 2/100*credit.getMonthlyPayment());
    }

    @Override
    public void injectMoneyInDebit(final Debit debit, final Bill bill, final double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.injectMoney(amount);
    }

    @Override
    public void injectMoneyInDebit(final Debit debit, final Card card, final double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.injectMoney(amount);
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Bill bill, final double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Card card, final double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void applyingForAConsumerCredit(final Client guarantor, final double amount, final int periodInMonths) {
        GringottsBank.getInstance().createConsumerCredit(this.getClient(), guarantor, amount, periodInMonths);
    }

    @Override
    public void applyingForAHousingCredit(final double amount, final int periodInMonths) {
        GringottsBank.getInstance().createHousingCredit(this.getClient(), amount, periodInMonths, TaxAssessment.EIGHT, 0.8d);
    }

    @Override
    public void applyingForAIndefiniteDebit(final double balance) {
        GringottsBank.getInstance().createIndefiniteDebit(this.getClient(), balance, 1.2d);
    }

    @Override
    public void applyingForATermDebit(final double balance, final int timeInMonths) {
        GringottsBank.getInstance().createTermDebit(this.getClient(), balance, timeInMonths, 1.2d);
    }
}
