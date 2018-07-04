package credit;

import card.Card;
import client.Client;
import thorbank.Bill;

public class ConsumerCredit extends Credit {
    private Client client;
    private double amount;
    private int creditPeriodInMonths;
    private static final int MONTHS_PER_YEAR = 12;
    private static final double PERCENT_TO_NUM = 0.01d;

    public ConsumerCredit(Client client, double amount, int creditPeriodInMonths) {
        super(amount, creditPeriodInMonths);
        setConsumer(consumer);
        setYearlyInterestRate(yearlyInterestRate);
    }

    public String getConsumer() {
        return consumer;
    }

    public double getAmount() {
        return amount;
    }

    public int getCreditPeriodInMonths() {
        return creditPeriodInMonths;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreditPeriodInMonths(int creditPeriodInMonths) {
        this.creditPeriodInMonths = creditPeriodInMonths;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    @Override
    public double calculateCreditInterestRate() {
        return (creditPeriodInMonths / MONTHS_PER_YEAR) * (yearlyInterestRate * PERCENT_TO_NUM) * amount;
    }
}
