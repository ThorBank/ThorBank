package debit;

import card.Card;
import thorbank.Bill;

public interface DebitInjectableWithdrawable {
    void injectMoneyInDebit(Debit debit, Bill bill);
    void injectMoneyInDebit(Debit debit, Card card);
    void withdrawMoneyFromDebit(Debit debit, Bill bill);
    void withdrawMoneyFromDebit(Debit debit, Card card);
}
