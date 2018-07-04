package debit;

import client.Client;

public class TermDebit extends Debit {
    private int timeInDays;

    public TermDebit(Client client, double balance, int timeInDays) {
        super(client, balance);
        this.timeInDays = timeInDays;
    }
}
