/*
 * Debit
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package debit;

import card.Card;
import card.NotEnoughMoneyInCardException;
import webbanking.Bill;
import webbanking.Currency;

import java.util.List;

public class Debit {
    private String iban;
    private List<Card> card;
    private double balance;

    public Debit(final double balance) {
        setBalance(balance);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdrawMoney(final Card card, final double amount, final Currency currency) throws NotEnoughMoneyInCardException {
        if (card.getBalance() <= 0 || card.getBalance() - amount < 0){
            throw new NotEnoughMoneyInCardException();
        }
        else {
            card.setBalance(card.getBalance() - amount);
        }
    }

    public void withdrawMoney(final Bill bill, final double amount, final Currency currency) throws NotEnoughMoneyInCardException {
        if (bill.getBalance() <= 0 || bill.getBalance() - amount < 0){
            throw new NotEnoughMoneyInCardException();
        }
        else {
            bill.setBalance(bill.getBalance() - amount);
        }
    }

    public void injectMoney(final Card card, final double amount, final Currency currency) {
        card.setBalance(card.getBalance() + amount);
    }

    public void injectMoney(final Bill bill, final double amount, final Currency currency) {
        bill.setBalance(bill.getBalance() + amount);
    }
}
