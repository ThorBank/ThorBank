package client;

import thorbank.Bill;
import thorbank.Currency;
import thorbank.FactorConnect;

import java.net.PasswordAuthentication;
import java.util.List;

public class BusinessClient extends Client {
    List<IndividualClient> individualClientList;
    FactorConnect factorConnect;

    public BusinessClient(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }


    public void createFactorConnect(){
        if (factorConnect == null){
            factorConnect = new FactorConnect(this);
        }
    }

    public void addNewWorker(IndividualClient individualClient){
        individualClientList.add(individualClient);
    }
}
