package card;

import client.Client;
import thorbank.Currency;

public class CreditCard extends Card {

    public CreditCard(final Client client, final String number, final PaymentNetwork paymentNetwork, final String cVV, final double balance, final Currency currency) throws CardNumberFormatException {
        super(client, number, paymentNetwork, cVV, balance, currency);
    }
}
