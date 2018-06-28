package thorbank;

public class ConsumerCredit extends Credit {
    private double amount;
    private int creditPeriodInMonths;
    private double yearlyInterestRate;
    private static final int MONTHS_PER_YEAR = 12;
    private static final double PERCENT_TO_NUM = 0.01d;

    public ConsumerCredit(double amount, int creditPeriodInMonths, double yearlyInterestRate) {
        super(amount, creditPeriodInMonths);
        this.yearlyInterestRate = yearlyInterestRate;
    }


    @Override
    public double calculateCreditInterestRate() {
        return (creditPeriodInMonths / MONTHS_PER_YEAR) * (yearlyInterestRate * PERCENT_TO_NUM) * amount;
    }
}
