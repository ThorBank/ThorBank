package client;

import bank.GringottsBank;
import card.Card;
import credit.ConsumerCredit;
import credit.Credit;
import debit.Debit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import thorbank.BankOnWeb;
import thorbank.Bill;

import java.util.List;

public class Client implements ConsumerCredit.CreditAppliable, ConsumerCredit.CreditPayable, Debit.DebitPayable, Debit.TermDebitAppliable, Debit.IndefiniteDebitAppliable {
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
    public void applyingForACredit() {
        //TODO: The date on which we take the credit
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
    public void applyingForAIndefiniteDebit(IndefiniteDebit indefiniteDebit) {
        GringottsBank.getInstance().approveIndefiniteDebit(this, indefiniteDebit, 0);
    }

    @Override
    public void applyForATermDebit(TermDebit termDebit) {
        GringottsBank.getInstance().approveTermDebit(this, termDebit, 0);
    }
}
