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
        return (((GringottsBank.getInstance().getAnnualRatePercentageConsumerCredit()/100)/12)*this.getAmount())*100;
    }
}
