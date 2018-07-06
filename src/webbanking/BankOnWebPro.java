/*
 * BankOnWebPro
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package webbanking;

import bank.GringottsBank;
import card.Card;
import client.Client;
import credit.CreditAppliable;
import credit.CreditPayable;
import credit.Credit;
import credit.TaxAssessment;
import debit.Debit;
import debit.DebitAppliable;
import debit.DebitInjectableWithdrawable;

public class BankOnWebPro extends BankOnWeb implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable {
    public BankOnWebPro(final Client client) {
        super(client);
    }

    public void transactionBetweenBills(final Client client, final Bill sender, final Bill receiver, final double amount) throws BillDoesNotMatchExceptions, NotEnoughMoneyInYourBill, BillNotFromGringottsBankException {
        if (!this.getClient().getBillList().contains(sender) || !client.getBillList().contains(receiver)) {
            throw new BillDoesNotMatchExceptions();
        } else  if (sender.getAvailability() < amount) {
            throw new NotEnoughMoneyInYourBill();
        }
        else if (!sender.getBank().equals(GringottsBank.getInstance())){
            throw new BillNotFromGringottsBankException();
        }

        sender.setAvailability(sender.getAvailability()-amount);
        receiver.setAvailability(receiver.getAvailability()+amount);
    }

    @Override
    public void payCredit(final Credit credit, final Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment() + (GringottsBank.getInstance().getOnlineDiscountPercent()/100)*credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - (GringottsBank.getInstance().getOnlineDiscountPercent()/100)*credit.getMonthlyPayment());
    }

    @Override
    public void payCredit(final Credit credit, final Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment() + (GringottsBank.getInstance().getOnlineDiscountPercent()/100)*credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - (GringottsBank.getInstance().getOnlineDiscountPercent()/100)*credit.getMonthlyPayment());
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
