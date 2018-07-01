package debit;

import card.Card;
import credit.Credit;
import thorbank.Bill;

public interface DebitPayable {
    void injectMoneyFromDebit(Debit credit, Bill bill);
    void withdrawMoneyFromDebit(Debit credit, Card card);
}
