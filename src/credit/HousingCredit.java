package credit;

public class HousingCredit extends ConsumerCredit{
    private TaxAssessment taxAssessment;
    public HousingCredit(String consumer, double amount, int creditPeriodInMonths, double yearlyInterestRate) {
        super(consumer, amount, creditPeriodInMonths, yearlyInterestRate);
    }
}
