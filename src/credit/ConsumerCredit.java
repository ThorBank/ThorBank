package credit;

import client.Client;

public class ConsumerCredit extends Credit {
    private Client client;
    private Client guarantor;
    private double amount;
    private int creditPeriodInMonths;
    private static final int MONTHS_PER_YEAR = 12;
    private static final double PERCENT_TO_NUM = 0.01d;

    public ConsumerCredit(final Client client, final Client guarantor, final double amount, final int creditPeriodInMonths) {
        super(client, amount, creditPeriodInMonths);
        this.guarantor = guarantor;
    }

    public double getAmount() {
        return amount;
    }

    public int getCreditPeriodInMonths() {
        return creditPeriodInMonths;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public void setCreditPeriodInMonths(final int creditPeriodInMonths) {
        this.creditPeriodInMonths = creditPeriodInMonths;
    }
    @Override
    public double calculateCreditInterestRate() {
        return (creditPeriodInMonths / MONTHS_PER_YEAR) * (2 * PERCENT_TO_NUM) * amount;//2 is the yearly interest rate
    }
}
