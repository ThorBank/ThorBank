package debit;

import card.Card;
import card.CreditCard;
import card.DebitCard;
import card.NotEnoughMoneyInCardException;
import client.Client;

import java.util.Currency;
import java.util.List;

public class Debit {
    private Client client;
    private String iban;
    private List<Card> card;
    private double balance;

    public Debit(Client client, double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdrawMoney(CreditCard creditCard, double amount, Currency currency) throws NotEnoughMoneyInCardException {
        if (creditCard.getBalance() <= 0 || creditCard.getBalance() - amount < 0){
            throw new NotEnoughMoneyInCardException();
        }
        else {
            creditCard.setBalance(creditCard.getBalance() - amount);
            System.out.println(amount + " " + currency.toString() + " has been withdrawn!");
            System.out.println("New card balance: " + creditCard.getBalance() + " " + currency.toString());
        }
    }

    public void withdrawMoney(DebitCard debitCard, double amount, Currency currency) throws NotEnoughMoneyInCardException {
        if (debitCard.getBalance() <= 0 || debitCard.getBalance() - amount < 0)
            throw new NotEnoughMoneyInCardException();
        else {
            debitCard.setBalance(debitCard.getBalance() - amount);
            System.out.println(amount + " " + currency.toString() + " has been withdrawn!");
            System.out.println("New card balance: " + debitCard.getBalance() + " " + currency.toString());
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

    public void injectMoney(double amount){
        this.balance += amount;
    }

    public void withdrawMoney(double amount){
        this.balance -= amount;
    }

    public String getIban() {
        return iban;
    }
}
