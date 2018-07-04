package debit;

public interface DebitAppliable {
    void applyingForAIndefiniteDebit(double balance);
    void applyingForATermDebit(double balance, int timeInMonths);
}
