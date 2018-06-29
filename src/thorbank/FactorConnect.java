package thorbank;

import client.IndividualClient;

import java.util.LinkedList;

public class FactorConnect extends BankOnWebPro {

    public FactorConnect(double balance, Bill currentBill) {
        super(balance, currentBill);
    }

    public void payingSalary(LinkedList<IndividualClient> individualClients) {
        for (Object individualClient : individualClients) {

        }
    }

    public void discount() {

    }
}
