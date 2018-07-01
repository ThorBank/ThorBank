package credit;

import java.util.Date;

public abstract class Credit {
    private Date dateApproval;
    private double amount;
    private int creditPeriodInMonths;

    public Credit(double amount, int creditPeriodInMonths) {
        dateApproval = new Date();
        this.amount = amount;
        this.creditPeriodInMonths = creditPeriodInMonths;
    }

    public abstract double calculateCreditInterestRate();

}
