/*
 * Transaction
 *
 * version 1.0
 *
 * Last updated 03.07.18
 *
 * MIT Copyright
 */
package webbanking;

import java.util.Date;

public class Transaction {
    private Date date;
    private double transactionAmount;
    private String email;

    public Transaction(final Date date, final double transactionAmount, final String email) {
        setDate(date);
        setTransactionAmount(transactionAmount);
        setEmail(email);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(final double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getDate() + " " + getEmail() + " " + getTransactionAmount();
    }
}
