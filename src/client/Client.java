/*
 * Client
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package client;

import bank.GringottsBank;
import card.AppliableForANewCard;
import card.Card;
import card.CardNumberFormatException;
import card.CreditCardPaymentNetwork;
import card.DebitCardPaymentNetwork;
import card.NotEnoughMoneyInCardException;
import credit.CreditPayable;
import credit.CreditAppliable;
import credit.Credit;
import credit.TaxAssessment;
import debit.Debit;
import debit.DebitAppliable;
import debit.DebitInjectableWithdrawable;
import message.Sender;
import webbanking.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.LinkedList;

public abstract class Client implements CreditAppliable, CreditPayable, DebitAppliable, DebitInjectableWithdrawable, AppliableForANewCard, Sender, BillAppliable {
    private static final int MAX_CREDITS_PER_CLIENT = 3;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private GregorianCalendar dateofBirth;
    private boolean isWorking;
    private Bill paySalaryBill;
    private List<Bill> billList;
    private List<Card> cardList;
    private List<Credit> creditList;
    private List<Debit> debitList;
    private BankOnWeb bankOnWeb;
    private BankOnWebPro bankOnWebPro;

    public Client(final String firstName, final String lastName, final String email, final String password, final GregorianCalendar dateofBirth, final boolean isWorking) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setDateofBirth(dateofBirth);
        setWorking(isWorking);
        setBillList(new LinkedList<>());
        setCardList(new LinkedList<>());
        setDebitList(new LinkedList<>());
        setBankOnWeb(null);
        setBankOnWebPro(null);
        setCreditList(new LinkedList<>());
    }

    public void setBankOnWeb(BankOnWeb bankOnWeb) {
        this.bankOnWeb = bankOnWeb;
    }

    public BankOnWebPro getBankOnWebPro() {
        return this.bankOnWebPro;
    }

    public void setBankOnWebPro(BankOnWebPro bankOnWebPro) {
        this.bankOnWebPro = bankOnWebPro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public BankOnWeb getBankOnWeb() {
        return bankOnWeb;
    }

    public String getEmail() {
        return email;
    }

    public Bill getPaySalaryBill() {
        return paySalaryBill;
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

    public GregorianCalendar getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(final GregorianCalendar dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public void createBankOnWeb() throws BankOnWebAlreadyExistsException {
        if (bankOnWeb == null) {
            bankOnWeb = new BankOnWeb(this);
        } else {
            throw new BankOnWebAlreadyExistsException();
        }
    }

    public void createBankOnWebPro() throws BankOnWebAlreadyExistsException {
        if (bankOnWebPro == null) {
            bankOnWebPro = new BankOnWebPro(this);
        } else {
            throw new BankOnWebAlreadyExistsException();
        }
    }

    public void changePaySalaryBill(final Bill bill) {
        paySalaryBill = bill;
    }


    public boolean doesHaveGoodBankHistory() {
        if (this.getCreditList().size() >= MAX_CREDITS_PER_CLIENT) {
            return false;
        }
        return true;
    }

    @Override
    public void payCredit(final Credit credit, final Bill bill) {
        bill.setBalance(bill.getBalance() - credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), credit.getMonthlyPayment(), this.getEmail()));
    }

    @Override
    public void payCredit(final Credit credit, final Card card) {
        card.setBalance(card.getBalance() - credit.getMonthlyPayment());
        credit.payedCreditInstallment(credit.getMonthlyPayment());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), credit.getMonthlyPayment(), this.getEmail()));
    }


    @Override
    public void injectMoneyInDebit(final Debit debit, final Bill bill, final double amount) {
        System.out.println(bill.getBalance());
        bill.setBalance(bill.getBalance() - amount);
        System.out.println(bill.getBalance());
        debit.injectMoney(bill, amount, bill.getCurrency());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), amount, this.getEmail()));
    }

    @Override
    public void injectMoneyInDebit(final Debit debit, final Card card, final double amount) {
        card.setBalance(card.getBalance() - amount);
        debit.injectMoney(card, amount, card.getCurrency());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), amount, this.getEmail()));
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Bill bill, final double amount) throws NotEnoughMoneyInCardException {
        bill.setBalance(bill.getBalance() - amount);
        debit.withdrawMoney(bill, amount, bill.getCurrency());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), amount, this.getEmail()));
    }

    @Override
    public void withdrawMoneyFromDebit(final Debit debit, final Card card, final double amount) throws NotEnoughMoneyInCardException {
        card.setBalance(card.getBalance() - amount);
        debit.withdrawMoney(card, amount, card.getCurrency());
        this.getBankOnWeb().getTransactionList().add(new Transaction(new Date(), amount, this.getEmail()));
    }

    @Override
    public void applyingForAIndefiniteDebit(final double balance) {
        GringottsBank.getInstance().createIndefiniteDebit(this, balance, 0);
    }

    @Override
    public void applyingForATermDebit(final double balance, final int timeInMonths) {
        GringottsBank.getInstance().createTermDebit(this, balance, timeInMonths, 0);
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
    public void applyForCreditCard(final CreditCardPaymentNetwork creditCardPaymentNetwork, final double balance, final Currency currency) throws CardNumberFormatException {
        GringottsBank.getInstance().createCreditCard(this, creditCardPaymentNetwork, balance, currency);
    }

    @Override
    public void applyForDebitCard(final DebitCardPaymentNetwork debitCardPaymentNetwork, final double balance, final Currency currency, final Bill bill) throws CardNumberFormatException {
        GringottsBank.getInstance().createDebitCard(this, debitCardPaymentNetwork, balance, currency, bill);
    }

    @Override
    public void applyForAbill(Currency currency, double balance) {
        GringottsBank.getInstance().createBill(this, currency, balance);
    }
}
