package credit;

import card.Card;
import webbanking.Bill;

public interface CreditPayable {
        void payCredit(Credit credit, Bill bill);
        void payCredit(Credit credit, Card card);
}
