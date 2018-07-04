package card;

import webbanking.Bill;
import webbanking.Currency;

public interface AppliableForANewCard {
    void applyForCreditCard(PaymentNetwork paymentNetwork, double balance, Currency currency, Bill bill) throws CardNumberFormatException;
    void applyForDebitCard(PaymentNetwork paymentNetwork, double balance, Currency currency, Bill bill) throws CardNumberFormatException;
}
