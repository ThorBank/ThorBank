/*
 * Bill
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package webbanking;

import bank.Bank;

public class Bill {
    private String iban;
    private Currency currency;
    private double balance;
    private double availability;
    private Bank bank;

    public Bill(final Bank bank, final String iban, final Currency currency, final double balance, final double availability) {
        setIban(iban);
        setCurrency(currency);
        setBalance(balance);
        setAvailability(availability);
        setBank(bank);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(final Bank bank) {
        this.bank = bank;
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
