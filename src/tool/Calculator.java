package tool;

import credit.ConsumerCredit;
import credit.HousingCredit;
import credit.TaxAssessment;

public class Calculator {
    //TODO: Need to add max and min amount of credit
    //TODO: Need assessment of the house/apartment
    public void calculateMonthlyPaymentHousingCredit(HousingCredit housingCredit){
    }

    public double calculateMonthlyPaymentConsumerCredit(ConsumerCredit consumerCredit){
        return consumerCredit.getAmount() + consumerCredit.getAmount()*((consumerCredit.getCreditPeriodInMonths()/36)*consumerCredit.getYearlyInterestRate()/100)/consumerCredit.getCreditPeriodInMonths();
    }
}
