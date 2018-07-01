package client;

import card.Card;
import credit.Credit;
import thorbank.Bill;

public interface CreditPayable {
    void payCredit(Credit credit, Bill bill);
    void payCredit(Credit credit, Card card);
}
