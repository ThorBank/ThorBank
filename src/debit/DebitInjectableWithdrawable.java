package debit;

import card.Card;
import thorbank.Bill;

public interface DebitInjectableWithdrawable {
    void injectMoneyFromDebit(Debit debit, Bill bill);
    void injectMoneyFromDebit(Debit debit, Card card);
    void withdrawMoneyFromDebit(Debit debit, Bill bill);
    void withdrawMoneyFromDebit(Debit debit, Card card);
}
