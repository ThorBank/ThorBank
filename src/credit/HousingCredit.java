package credit;

public class HousingCredit extends ConsumerCredit{
    private static final int MONTHS_PER_YEAR = 12;
    private static final double PERCENT_TO_NUM = 0.01d;
    private TaxAssessment taxAssessment;
    private double assessment;

    public HousingCredit(String consumer, double amount, int creditPeriodInMonths, double yearlyInterestRate, double assessment) {
        super(consumer, amount, creditPeriodInMonths, yearlyInterestRate);
        setAssessment(assessment);
    }

    public TaxAssessment getTaxAssessment() {
        return taxAssessment;
    }

    public void setTaxAssessment(TaxAssessment taxAssessment) {
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

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    @Override
    public double calculateCreditInterestRate() {
        return (getCreditPeriodInMonths() / MONTHS_PER_YEAR) * (getYearlyInterestRate() * PERCENT_TO_NUM) * getAmount() * assessment;
    }
}
