package card;

import client.Client;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class CreditCard extends Card {

    public CreditCard(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Client client, double balance, Currency currency) {
        super(number, firstName, lastName, expirationDate, CVV, CVV2, client, balance, currency);

    }

}
