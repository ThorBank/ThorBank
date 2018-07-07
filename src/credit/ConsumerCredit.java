/*
 * ConsumerCredit
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

public class ConsumerCredit extends Credit {
    private static final Integer CONVERT_TO_PERCENT_DIVIDER = 100;
    private static final Integer MONTHS_IN_YEAR = 12;
    private Client client;
    private Client guarantor;

    public ConsumerCredit(final Client client, final Client guarantor, final double amount, final int creditPeriodInMonths) {
        super(client, amount, creditPeriodInMonths);
        setGuarantor(guarantor);
    }

    public void setGuarantor(final Client guarantor) {
        this.guarantor = guarantor;
    }

    @Override
    public double calculateMonthlyInterestRate() {
        return (((GringottsBank.getInstance().getAnnualRatePercentageConsumerCredit()/ CONVERT_TO_PERCENT_DIVIDER)/ MONTHS_IN_YEAR)* this.getAmount())* CONVERT_TO_PERCENT_DIVIDER;
    }
}
