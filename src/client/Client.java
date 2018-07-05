package client;

import bank.GringottsBank;
import card.*;
import credit.*;
import debit.*;
import webbanking.BankOnWeb;
import webbanking.Bill;
import webbanking.Currency;

import java.util.*;

public class Client implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable, AppliableForANewCard {
    private String firstName;
    private String lastName;
    private String email;
    private Calendar dateofBirth;
    private boolean isWorking;
    private DebitCard paySalaryDebitCard;
    private List<Bill> billList;
    private List<Card> cardList;
    private List<Credit> creditList;
    private List<Debit> debitList;
    private BankOnWeb bankOnWeb;

    public Client(final String firstName, final String lastName, final String email, final GregorianCalendar dateofBirth, final boolean isWorking) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setDateofBirth(dateofBirth);
        setWorking(isWorking);
        setBillList(new LinkedList<>());
        setCardList(new LinkedList<>());
        setDebitList(new LinkedList<>());
    }

    public String getEmail() {
        return email;
    }

    public DebitCard getPaySalaryDebitCard() {
        return paySalaryDebitCard;
    }

    public void setBillList(final List<Bill> billList) {
        this.billList = billList;
    }

    public void setCardList(final List<Card> cardList) {
        this.cardList = cardList;
    }

    public void setCreditList(final List<Credit> creditList) {
        this.creditList = creditList;
    }

    public void setDebitList(final List<Debit> debitList) {
        this.debitList = debitList;
    }

    public List<Debit> getDebitList() {
        return debitList;
    }

    public List<Credit> getCreditList() {
        return creditList;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(final boolean working) {
        isWorking = working;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(final String email) {
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

    public Calendar getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(final Calendar dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public void createBankOnWeb() throws BankOnWebAlreadyExistsException {
        if (bankOnWeb == null) {
            bankOnWeb = new BankOnWeb(this);
        } else {
            throw new BankOnWebAlreadyExistsException();
        }
    }

    public void changePaySalaryDebitCard(final DebitCard debitCard){
        paySalaryDebitCard = debitCard;
    }

    @Override
    public void payCredit(final Credit credit, final Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment());
    }

    @Override
    public void payCredit(final Credit credit, final Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment());
        credit.payedcreditInstallment(credit.getMonthlyPayment());
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
    public void withdrawMoneyFromDebit(final Debit debit,final  Bill bill, final double amount) {
        bill.setBalance(bill.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Card card, final double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.withdrawMoney(amount);
    }

    @Override
    public void applyingForAIndefiniteDebit(final double balance) {
        GringottsBank.getInstance().createIndefiniteDebit(this, balance, 1);
    }

    @Override
    public void applyingForATermDebit(final double balance, final int timeInMonths) {
        GringottsBank.getInstance().createTermDebit(this, balance, timeInMonths, 1);
    }

    @Override
    public void applyingForAConsumerCredit(final Client guarantor, final double balance, final int periodInMonths) {
        GringottsBank.getInstance().createConsumerCredit(this, guarantor, balance, periodInMonths);
    }

    @Override
    public void applyingForAHousingCredit(final double balance, final int periodInMonths) {
        GringottsBank.getInstance().createHousingCredit(this, balance, periodInMonths, TaxAssessment.EIGHT, 1);
    }

    @Override
    public void applyForCreditCard(final PaymentNetwork paymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        GringottsBank.getInstance().createCreditCard(this, paymentNetwork, balance, currency);
    }

    @Override
    public void applyForDebitCard(final PaymentNetwork paymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        GringottsBank.getInstance().createDebitCard(this, paymentNetwork, balance, currency, bill);
    }
}
