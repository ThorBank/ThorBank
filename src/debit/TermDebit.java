package debit;

import client.Client;

public class TermDebit extends Debit {
    private int timeInMonths;

    public TermDebit(final Client client, final double balance, final int timeInMonths) {
        super(client, balance);
        this.timeInMonths = timeInMonths;
    }
}
