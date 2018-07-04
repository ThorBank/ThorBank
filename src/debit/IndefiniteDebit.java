package debit;

import client.Client;

public class IndefiniteDebit extends Debit {
    public IndefiniteDebit(final Client client, final double balance) {
        super(client, balance);
    }
}
