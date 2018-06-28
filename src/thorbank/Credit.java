package thorbank;

public abstract class Credit {
    private double amount;
    private int creditPeriodInMonths;

    public Credit(double amount, int creditPeriodInMonths) {
        this.amount = amount;
        this.creditPeriodInMonths = creditPeriodInMonths;
    }

    public abstract double calculateCreditInterestRate();

}
