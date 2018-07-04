package credit;

import client.Client;

import java.util.Date;

public abstract class Credit {
    private Client client;
    private Date dateApproval;
    private double amount;
    private int creditPeriodInMonths;
    private double monthlyPayment = amount/creditPeriodInMonths;

    public Credit(final Client client, final double amount, final int creditPeriodInMonths) {
        dateApproval = new Date();
        this.amount = amount;
        this.creditPeriodInMonths = creditPeriodInMonths;
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public abstract double calculateCreditInterestRate();

    public void payedcreditInstallment(final double amount){
        this.amount -= monthlyPayment;
    }

}
