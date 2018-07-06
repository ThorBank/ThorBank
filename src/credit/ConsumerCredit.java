package credit;

import client.Client;

public class ConsumerCredit extends Credit {
    private Client client;
    private Client guarantor;

    public ConsumerCredit(final Client client, final Client guarantor, final double amount, final int creditPeriodInMonths) {
        super(client, amount, creditPeriodInMonths);
        this.guarantor = guarantor;
    }
}
