package card;

import client.Client;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class CreditCard extends Card {

    public CreditCard(Client client, String number, PaymentNetwork paymentNetwork, String CVV, double balance, Currency currency) throws CardNumberFormatException {
        super(client, number, paymentNetwork, CVV, balance, currency);
    }
}
