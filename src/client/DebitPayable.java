package client;

import card.Card;
import credit.Credit;
import thorbank.Bill;

public interface DebitPayable {
    void injectMoney(Credit credit, Bill bill);
    void withdrawMoney(Credit credit, Card card);
}
