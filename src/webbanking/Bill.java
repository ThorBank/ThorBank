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
import bank.GringottsBank;

public class Bill {
    private String iban;
    private Currency currency;
    private double balance;
    private double availability;
    private Bank bank;

    public Bill(final String iban, final Currency currency, final double balance) {
        setBank(GringottsBank.getInstance());
        setIban(iban);
        setCurrency(currency);
        setBalance(balance);
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
}
