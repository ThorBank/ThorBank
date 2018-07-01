package debit;

import card.Card;
import credit.Credit;
import thorbank.Bill;

public interface DebitPayable {
    void injectMoneyFromDebit(Credit credit, Bill bill);
    void withdrawMoneyFromDebit(Credit credit, Card card);
}
