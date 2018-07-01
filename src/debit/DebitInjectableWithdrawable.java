package debit;

import card.Card;
import thorbank.Bill;

public interface DebitInjectableWithdrawable {
    void injectMoneyInDebit(Debit debit, Bill bill, double amount);
    void injectMoneyInDebit(Debit debit, Card card, double amount);
    void withdrawMoneyFromDebit(Debit debit, Bill bill, double amount);
    void withdrawMoneyFromDebit(Debit debit, Card card, double amount);
}
