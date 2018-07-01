package debit;

public interface DebitAppliable {
    void applyingForAIndefiniteDebit(IndefiniteDebit indefiniteDebit);
    void applyingForATermDebit(TermDebit termDebit);
}
