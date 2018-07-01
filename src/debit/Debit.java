package debit;

import card.Card;
import credit.Credit;
import thorbank.Bill;

public class Debit {
    private String name;
    private String iban;
    private double balance;

    public Debit(String name, String iban, double balance) {
        this.name = name;
        this.iban = iban;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdrawalMoney() {

    }

    public void injectMoney() {

    }

    public static interface DebitPayable {
        void injectMoney(Credit credit, Bill bill);
        void withdrawMoney(Credit credit, Card card);
    }

    public static interface IndefiniteDebitAppliable {
        void applyingForAIndefiniteDebit(IndefiniteDebit debit);
    }

    public static interface TermDebitAppliable {
        void applyForATermDebit(TermDebit termDebit);
    }
}
