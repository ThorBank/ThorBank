package webbanking;

public class Bill {
    private String iban;
    private Currency currency;
    private double balance;
    private double availability;

    public Bill(String iban, Currency currency, double balance, double availability) {
        setIban(iban);
        setCurrency(currency);
        setBalance(balance);
        setAvailability(availability);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailability() {
        return availability;
    }

    public void setAvailability(double availability) {
        this.availability = availability;
    }
}
