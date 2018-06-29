package card;

import client.Client;
import thorbank.Bill;

import java.util.Date;

public class CreditCard extends Card {
    private Client client;

    public CreditCard(String number, String firstName, String lastName, Date expirationDate, String CVV, String CVV2, Client client) {
        super(number, firstName, lastName, expirationDate, CVV, CVV2);
        setClient(client);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
