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
import card.CreditCard;
import card.DebitCard;
import card.NotEnoughMoneyInCardException;

import java.util.Currency;
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

    public void withdrawMoney(final CreditCard creditCard, final double amount, final Currency currency) throws NotEnoughMoneyInCardException {
        if (creditCard.getBalance() <= 0 || creditCard.getBalance() - amount < 0){
            throw new NotEnoughMoneyInCardException();
        }
        else {
            creditCard.setBalance(creditCard.getBalance() - amount);
        }
    }

    public void withdrawMoney(final DebitCard debitCard, final double amount, final Currency currency) throws NotEnoughMoneyInCardException {
        if (debitCard.getBalance() <= 0 || debitCard.getBalance() - amount < 0)
            throw new NotEnoughMoneyInCardException();
        else {
            debitCard.setBalance(debitCard.getBalance() - amount);
        }
    }

    public void injectMoney(final CreditCard card, final double amount, final Currency currency) {
        card.setBalance(card.getBalance() + amount);
    }

    public void injectMoney(final DebitCard card, final double amount, final Currency currency) {
        card.setBalance(card.getBalance() + amount);
    }
}
