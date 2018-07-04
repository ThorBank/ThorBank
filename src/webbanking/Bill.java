package webbanking;

public class Bill {
    private String iban;
    private Currency currency;
    private double balance;
    private double availability;

    public Bill(final String iban, final Currency currency, final double balance, final double availability) {
        setIban(iban);
        setCurrency(currency);
        setBalance(balance);
        setAvailability(availability);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(final String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(final Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getAvailability() {
        return availability;
    }

    public void setAvailability(final double availability) {
        this.availability = availability;
    }
}
