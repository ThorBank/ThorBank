package client;

import bank.GringottsBank;
import card.Card;
import credit.*;
import debit.*;
import thorbank.BankOnWeb;
import thorbank.Bill;

import java.util.List;

public class Client implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable {
    private String firstName;
    private String lastName;
    private String email;
    private List<Bill> billList;
    private List<Card> cardList;
    private List<Credit> creditList;
    private BankOnWeb bankOnWeb;

    public Client(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public List<Bill> getBillList() {
        return billList;
    }

    public List<Card> getCardList() {
        return cardList;
    }



    public void createBankOnWeb(){
        if (bankOnWeb == null){
            bankOnWeb = new BankOnWeb(this);
        }
    }

    @Override
    public void payCredit(Credit credit, Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment());
    }

    @Override
    public void payCredit(Credit credit, Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment());
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
    public void applyingForAIndefiniteDebit(IndefiniteDebit indefiniteDebit) {
        GringottsBank.getInstance().approveIndefiniteDebit(this, indefiniteDebit, 0);
    }

    @Override
    public void applyingForATermDebit(TermDebit termDebit) {
        GringottsBank.getInstance().approveTermDebit(this, termDebit, 0);
    }

    @Override
    public void applyingForAConsumerCredit(ConsumerCredit consumerCredit) {
        GringottsBank.getInstance().approveConsumerCredit(this, consumerCredit, 0);
    }

    @Override
    public void applyingForAHousingCredit(HousingCredit housingCredit) {
        GringottsBank.getInstance().approveHousingCredit(this, housingCredit, 0);
    }
}
