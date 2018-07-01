package debit;

import card.Card;
import card.CreditCard;
import card.DebitCard;

import java.util.Currency;
import java.util.List;
import credit.Credit;
import thorbank.Bill;

public class Debit {
    private String name;
    private String iban;
    private List<Card> card;
    private double balance;

    public Debit(String name, String iban, double balance) {
        this.name = name;
        this.iban = iban;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdrawMoney(CreditCard card, double amount, Currency currency) {
        if (card.getBalance() <= 0 || card.getBalance() - amount < 0){
            System.out.println("Cannot withdraw money! Not enough money.");
            System.out.println("Your balance is: " + card.getBalance() + " " + currency.toString());
        }
        else {
            card.setBalance(card.getBalance() - amount);
            System.out.println(amount + " " + currency.toString() + " has been withdrawn!");
            System.out.println("New card balance: " + card.getBalance() + " " + currency.toString());
        }
    }

    public void withdrawMoney(DebitCard card, double amount, Currency currency) {
        if (card.getBalance() <= 0 || card.getBalance() - amount < 0){
            System.out.println("Cannot withdraw money! Not enough money.");
            System.out.println("Your balance is: " + card.getBalance() + " " + currency.toString());
        }
        else {
            card.setBalance(card.getBalance() - amount);
            System.out.println(amount + " " + currency.toString() + " has been withdrawn!");
            System.out.println("New card balance: " + card.getBalance() + " " + currency.toString());
        }
    }

    public void injectMoney(CreditCard card, double amount, Currency currency) {
        card.setBalance(card.getBalance() + amount);
        System.out.println(amount + " " + currency.toString() + " has been injected!");
        System.out.println("New card balance: " + card.getBalance() + " " + card.getBalance());
    }

    public void injectMoney(DebitCard card, double amount, Currency currency) {
        card.setBalance(card.getBalance() + amount);
        System.out.println(amount + " " + currency.toString() + " has been injected!");
        System.out.println("New card balance: " + card.getBalance() + " " + card.getBalance());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
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
