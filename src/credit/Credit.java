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

    public double calculateMonthlyInterestRate(){
        return (((GringottsBank.getInstance().getAnnualRatePercentageConsumerCredit()/100)/12)*this.getAmount())*100;
    }

    public void payedCreditInstallment(final double amount){
        this.amount -= monthlyPayment;
    }

}
