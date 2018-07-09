package card;

import webbanking.Bill;
import webbanking.Currency;

public interface AppliableForANewCard {
    void applyForCreditCard(CreditCardPaymentNetwork creditCardPaymentNetwork, double balance, Currency currency) throws CardNumberFormatException;
    void applyForDebitCard(DebitCardPaymentNetwork debitCardPaymentNetwork, double balance, Currency currency, Bill bill) throws CardNumberFormatException;
}
