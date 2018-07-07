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

import client.Client;

import java.util.Date;

public abstract class Credit {
    private Client client;
    private Date dateApproval;
    private double amount;
    private int creditPeriodInMonths;
    private double monthlyPayment;

    public Credit(final Client client, final double amount, final int creditPeriodInMonths) {
        dateApproval = new Date();
        setAmount(amount);
        setCreditPeriodInMonths(creditPeriodInMonths);
        setClient(client);
        setMonthlyPayment(amount / creditPeriodInMonths + amount / creditPeriodInMonths * this.calculateMonthlyInterestRate());
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public void setCreditPeriodInMonths(final int creditPeriodInMonths) {
        this.creditPeriodInMonths = creditPeriodInMonths;
    }

    public double getAmount() {
        return amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(final double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void payedCreditInstallment(final double amount){
        this.amount -= monthlyPayment;
    }

    public abstract double calculateMonthlyInterestRate();

}
