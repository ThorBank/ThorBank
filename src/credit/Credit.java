/*
 * Credit
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package credit;

import bank.GringottsBank;
import client.Client;

import java.util.Date;

public abstract class Credit {
    private Client client;
    private Date dateApproval;
    private double amount;
    private int creditPeriodInMonths;
    private double monthlyPayment = amount/creditPeriodInMonths + amount/creditPeriodInMonths*this.calculateMonthlyInterestRate();

    public Credit(final Client client, final double amount, final int creditPeriodInMonths) {
        dateApproval = new Date();
        setAmount(amount);
        setCreditPeriodInMonths(creditPeriodInMonths);
        setClient(client);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreditPeriodInMonths(int creditPeriodInMonths) {
        this.creditPeriodInMonths = creditPeriodInMonths;
    }

    public double getAmount() {
        return amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public abstract double calculateMonthlyInterestRate();

    public void payedCreditInstallment(final double amount){
        this.amount -= monthlyPayment;
    }

}
