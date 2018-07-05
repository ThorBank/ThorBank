package credit;

import client.Client;

import java.util.Date;

public abstract class Credit {
    private Client client;
    private Date dateApproval;
    private double amount;
    private int creditPeriodInMonths;
    //TODO: update logic
    private double monthlyPayment = amount/creditPeriodInMonths;

    //TODO: setters
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

    //TODO: update logic
    public void payedCreditInstallment(final double amount){
        this.amount -= monthlyPayment;
    }

}
