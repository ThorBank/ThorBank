package client;

import bank.GringottsBank;
import card.Card;
import credit.Credit;
import db.DB;
import thorbank.BankOnWeb;
import thorbank.Bill;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.UUID;

public class Client implements CreditAppliable {
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

    public void payCredit(Credit credit, Bill bill){
        //TODO: Need to calculate how much to pay every month
        bill.setAvailability(bill.getAvailability() - credit.calculateCreditInterestRate());
    }

    public void payCredit(Credit credit, Card card){
        //TODO: Need to calculate how much to pay every month
    }

    public void createBankOnWeb(){
        //TODO: BankOnWeb remove balance from constructor
        if (bankOnWeb == null){
            bankOnWeb = new BankOnWeb(0);
        }
    }

    @Override
    public void applyingForACredit() {
        //TODO: SingletonPattern - Gringotts Bank
        //TODO: The date on which we take the credit
    }
}
