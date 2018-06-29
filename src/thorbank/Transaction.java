package thorbank;

public class Transaction {
    private String date;
    private double transactionAmount;
    private TransactionType transactionType;
    private String email;

    public Transaction(String date, double transactionAmount, TransactionType transactionType, String email) {
        setDate(date);
        setTransactionAmount(transactionAmount);
        setTransactionType(transactionType);
        setEmail(email);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
