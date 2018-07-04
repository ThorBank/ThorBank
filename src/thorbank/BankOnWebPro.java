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

    public void transactionBetweenBills(Client client, Bill firstBill, Bill secondBill, double amount) throws BillDoesNotMatchExceptions, NotEnoughMoneyInYourBill {
        if (!client.getBillList().contains(firstBill) || !client.getBillList().contains(secondBill)) {
            throw new BillDoesNotMatchExceptions();
        } else  if (firstBill.getAvailability() < amount) {
            throw new NotEnoughMoneyInYourBill();
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
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment() + 2/100*credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment() - 2/100*credit.getMonthlyPayment());
    }

    @Override
    public void payCredit(Credit credit, Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment() + 2/100*credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment() - 2/100*credit.getMonthlyPayment());
    }

    @Override
    public void injectMoneyInDebit(Debit debit, Bill bill, double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.injectMoney(amount);
    }

    @Override
    public void injectMoneyInDebit(Debit debit, Card card, double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.injectMoney(amount);
    }

    @Override
    public void withdrawMoneyFromDebit(Debit debit, Bill bill, double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void withdrawMoneyFromDebit(Debit debit, Card card, double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void applyingForAConsumerCredit(Client guarantor, double amount, int periodInMonths) {
        GringottsBank.getInstance().createConsumerCredit(this.getClient(), guarantor, amount, periodInMonths);
    }

    @Override
    public void applyingForAHousingCredit(double amount, int periodInMonths) {
        GringottsBank.getInstance().createHousingCredit(this.getClient(), amount, periodInMonths, TaxAssessment.EIGHT, 0.8d);
    }

    @Override
    public void applyingForAIndefiniteDebit(double balance) {
        GringottsBank.getInstance().createIndefiniteDebit(this.getClient(), balance, 1.2d);
    }

    @Override
    public void applyingForATermDebit(double balance, int timeInMonths) {
        GringottsBank.getInstance().createTermDebit(this.getClient(), balance, timeInMonths, 1.2d);
    }
}
