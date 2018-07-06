package debit;

import client.Client;

public class TermDebit extends Debit {
    private int timeInMonths;

    public TermDebit(final double balance, final int timeInMonths) {
        super(balance);
        setTimeInMonths(timeInMonths);
    }

    public void setTimeInMonths(int timeInMonths) {
        this.timeInMonths = timeInMonths;
    }
}
