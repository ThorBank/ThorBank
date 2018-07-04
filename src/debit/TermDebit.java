package debit;

import client.Client;

public class TermDebit extends Debit {
    private int timeInMonths;

    public TermDebit(Client client, double balance, int timeInMonths) {
        super(client, balance);
        this.timeInMonths = timeInMonths;
    }
}
