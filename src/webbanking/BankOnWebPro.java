/*
 * BankOnWeb
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
import card.NotEnoughMoneyInCardException;
import client.Client;
import credit.CreditAppliable;
import credit.CreditPayable;
import credit.Credit;
import credit.TaxAssessment;
import debit.Debit;
import debit.DebitAppliable;
import debit.DebitInjectableWithdrawable;

import java.util.Date;

public class BankOnWebPro extends BankOnWeb implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable, BillAppliable {
    private static final double BONUS_DEBIT_WHEN_THROUGH_BANK_ON_WEB = 0.2d;
    private static final double DISCOUNT_CREDIT_WHEN_THROUGH_BANK_ON_WEB = 0.8d;
    private static final Integer CONVERT_TO_PERCENT_DIVIDER = 100;

    public BankOnWebPro(final Client client) {
        super(client);
    }

    public void transactionBetweenBills(final Client client, final Bill sender, final Bill receiver, final double amount) throws BillDoesNotMatchExceptions, NotEnoughMoneyInYourBill, BillNotFromGringottsBankException {
        if (!this.getClient().getBillList().contains(sender) || !client.getBillList().contains(receiver)) {
            throw new BillDoesNotMatchExceptions();
        } else  if (sender.getBalance() < amount) {
            throw new NotEnoughMoneyInYourBill();
        }
        else if (!sender.getBank().equals(GringottsBank.getInstance())) {
            throw new BillNotFromGringottsBankException();
        }

        sender.setBalance(sender.getBalance()- amount);
        receiver.setBalance(receiver.getBalance()+ amount);
    }

    @Override
    public void payCredit(final Credit credit, final Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment() + (GringottsBank.getInstance().getOnlineDiscountPercent()/ CONVERT_TO_PERCENT_DIVIDER)* credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - (GringottsBank.getInstance().getOnlineDiscountPercent()/ CONVERT_TO_PERCENT_DIVIDER)* credit.getMonthlyPayment());
        this.getTransactionList().add(new Transaction(new Date(), credit.getMonthlyPayment(), this.getClient().getEmail()));
    }

    @Override
    public void payCredit(final Credit credit, final Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment() + (GringottsBank.getInstance().getOnlineDiscountPercent()/ CONVERT_TO_PERCENT_DIVIDER)* credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment() - (GringottsBank.getInstance().getOnlineDiscountPercent()/ CONVERT_TO_PERCENT_DIVIDER)* credit.getMonthlyPayment());
        this.getTransactionList().add(new Transaction(new Date(), credit.getMonthlyPayment(), this.getClient().getEmail()));
    }

    @Override
    public void injectMoneyInDebit(final Debit debit, final Bill bill, final double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.injectMoney(bill, amount, bill.getCurrency());
        this.getTransactionList().add(new Transaction(new Date(), amount, this.getClient().getEmail()));
    }

    @Override
    public void injectMoneyInDebit(final Debit debit, final Card card, final double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.injectMoney(card, amount, card.getCurrency());
        this.getTransactionList().add(new Transaction(new Date(), amount, this.getClient().getEmail()));
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Bill bill, final double amount) throws NotEnoughMoneyInCardException {
        bill.setBalance(bill.getBalance() - amount);
        debit.withdrawMoney(bill, amount, bill.getCurrency());
        this.getTransactionList().add(new Transaction(new Date(), amount, this.getClient().getEmail()));
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Card card, final double amount) throws NotEnoughMoneyInCardException {
        card.setBalance(card.getBalance() - amount);
        debit.withdrawMoney(card, amount, card.getCurrency());
        this.getTransactionList().add(new Transaction(new Date(), amount, this.getClient().getEmail()));
    }

    @Override
    public void applyingForAConsumerCredit(final Client guarantor, final double amount, final int periodInMonths) {
        GringottsBank.getInstance().createConsumerCredit(this.getClient(), guarantor, amount, periodInMonths);
    }

    @Override
    public void applyingForAHousingCredit(final double amount, final int periodInMonths) {
        GringottsBank.getInstance().createHousingCredit(this.getClient(), amount, periodInMonths, TaxAssessment.EIGHT, DISCOUNT_CREDIT_WHEN_THROUGH_BANK_ON_WEB);
    }

    @Override
    public void applyingForAIndefiniteDebit(final double balance) {
        GringottsBank.getInstance().createIndefiniteDebit(this.getClient(), balance, BONUS_DEBIT_WHEN_THROUGH_BANK_ON_WEB);
    }

    @Override
    public void applyingForATermDebit(final double balance, final int timeInMonths) {
        GringottsBank.getInstance().createTermDebit(this.getClient(), balance, timeInMonths, BONUS_DEBIT_WHEN_THROUGH_BANK_ON_WEB);
    }

    @Override
    public void applyForAbill(Currency currency, double balance) {
        GringottsBank.getInstance().createBill(this.getClient(), currency, balance);
    }
}
