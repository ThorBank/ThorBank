/*
 * CreditCard
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package card;

import client.Client;
import webbanking.Currency;

public class CreditCard extends Card {
    private CreditCardPaymentNetwork creditCardPaymentNetwork;

    public CreditCard(final Client client, final String number, final String cVV, final double balance, final Currency currency, final CreditCardPaymentNetwork creditCardPaymentNetwork) throws CardNumberFormatException {
        super(client, number, cVV, balance, currency);
        setCreditCardPaymentNetwork(creditCardPaymentNetwork);
    }

    public void setCreditCardPaymentNetwork(final CreditCardPaymentNetwork creditCardPaymentNetwork) {
        this.creditCardPaymentNetwork = creditCardPaymentNetwork;
    }
}
