package thorbank;

import client.Client;
import client.IndividualClient;

import java.util.LinkedList;

public class FactorConnect extends BankOnWebPro {

    public FactorConnect(Client client) {
        super(client);
    }

    public void payingSalary(LinkedList<IndividualClient> individualClients) {
        for (Object individualClient : individualClients) {

        }
    }

    public void discount() {

    }
}
