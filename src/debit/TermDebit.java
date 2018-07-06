/*
 * TermDebit
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
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
