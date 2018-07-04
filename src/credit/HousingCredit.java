package credit;

import client.Client;

public class HousingCredit extends Credit{
    private static final int MONTHS_PER_YEAR = 12;
    private static final double PERCENT_TO_NUM = 0.01d;
    private TaxAssessment taxAssessment;
    private double assessment;

    public HousingCredit(final Client client, final double amount, final int creditPeriodInMonths, final TaxAssessment taxAssessment) {
        super(client, amount, creditPeriodInMonths);
        setTaxAssessment(taxAssessment);
    }

    public TaxAssessment getTaxAssessment() {
        return taxAssessment;
    }

    public void setTaxAssessment(final TaxAssessment taxAssessment) {
        switch (taxAssessment){
            case ONE: assessment = 0.82d; break;
            case TWO: assessment = 0.84d; break;
            case THREE: assessment = 0.86d; break;
            case FOUR: assessment = 0.88d; break;
            case FIVE: assessment = 0.90d; break;
            case SIX: assessment = 0.92d; break;
            case SEVEN: assessment = 0.94d; break;
            case EIGHT: assessment = 0.96d; break;
            case NINE: assessment = 0.98d; break;
            case TEN: assessment = 1.0d; break;
        }
        this.taxAssessment = taxAssessment;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(final double assessment) {
        this.assessment = assessment;
    }

    @Override
    public double calculateCreditInterestRate() {
        return (1 / MONTHS_PER_YEAR) * (2 * PERCENT_TO_NUM) * getAmount() * assessment; //1 is getCreditPeriodInMonths, 2 is getYearlyInterestRate
    }
}
