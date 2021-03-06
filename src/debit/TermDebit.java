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

public class TermDebit extends Debit {
    private int timeInMonths;

    public TermDebit(final double balance, final int timeInMonths, final double percentYearly) {
        super(balance, percentYearly);
        setTimeInMonths(timeInMonths);
    }

    public void setTimeInMonths(final int timeInMonths) {
        this.timeInMonths = timeInMonths;
    }
}
