/*
 * HousingCredit
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package credit;

import bank.GringottsBank;
import client.Client;

public class HousingCredit extends Credit{
    private static final Integer CONVERT_TO_PERCENT_DIVIDER = 100;
    private static final Integer MONTHS_IN_YEAR = 12;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_ONE = 0.82;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_TWO = 0.84;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_THREE = 0.86;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_FOUR = 0.88;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_FIVE = 0.90;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_SIX = 0.92;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_SEVEN = 0.94;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_EIGHT = 0.96;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_NINE = 0.98;
    private static final Double ASSESMENT_WHEN_TAX_ASSESSMENT_TEN = 1.0;
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
            case ONE: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_ONE; break;
            case TWO: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_TWO; break;
            case THREE: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_THREE; break;
            case FOUR: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_FOUR; break;
            case FIVE: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_FIVE; break;
            case SIX: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_SIX; break;
            case SEVEN: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_SEVEN; break;
            case EIGHT: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_EIGHT; break;
            case NINE: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_NINE; break;
            case TEN: assessment = ASSESMENT_WHEN_TAX_ASSESSMENT_TEN; break;
        }
        this.taxAssessment = taxAssessment;
    }

    public double getAssessment() {
        return assessment;
    }

    @Override
    public double calculateMonthlyInterestRate() {
        return (((GringottsBank.getInstance().getAnnualRatePercentageHousingCredit()/ CONVERT_TO_PERCENT_DIVIDER)/ MONTHS_IN_YEAR)* this.getAmount())* CONVERT_TO_PERCENT_DIVIDER;
    }
}
