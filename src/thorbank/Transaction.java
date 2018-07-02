package thorbank;

import java.util.Date;
import java.util.List;

public class Transaction {
    private Date date;
    private double transactionAmount;
    private String email;

    public Transaction(Date date, double transactionAmount, String email) {
        setDate(date);
        setTransactionAmount(transactionAmount);
        setEmail(email);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getDate() + " " + getEmail() + " " + getTransactionAmount();
    }
}
