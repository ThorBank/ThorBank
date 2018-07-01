package debit;

public class TermDebit extends Debit {
    private int time;

    public TermDebit(String name, String iban, double balance) {
        super(name, iban, balance);
    }
}
