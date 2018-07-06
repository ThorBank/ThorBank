package card;

import client.Client;
import webbanking.Currency;

public class CreditCard extends Card {
    private CreditCardPaymentNetwork creditCardPaymentNetwork;

    public CreditCard(final Client client, final String number, final String cVV, final double balance, final Currency currency, final CreditCardPaymentNetwork creditCardPaymentNetwork) throws CardNumberFormatException {
        super(client, number, cVV, balance, currency);
        this.creditCardPaymentNetwork = creditCardPaymentNetwork;
    }
}
