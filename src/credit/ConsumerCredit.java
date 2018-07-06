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

import client.Client;

public class ConsumerCredit extends Credit {
    private Client client;
    private Client guarantor;

    public ConsumerCredit(final Client client, final Client guarantor, final double amount, final int creditPeriodInMonths) {
        super(client, amount, creditPeriodInMonths);
        setGuarantor(guarantor);
    }

    public void setGuarantor(Client guarantor) {
        this.guarantor = guarantor;
    }
}
