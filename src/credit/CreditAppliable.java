package credit;

import client.Client;

public interface CreditAppliable {
    void applyingForAConsumerCredit(Client guarantor, double balance, int periodInMonths);
    void applyingForAHousingCredit(double balance, int periodInMonths);
}
