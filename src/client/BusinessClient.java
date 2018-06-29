package client;

import thorbank.FactorConnect;

import java.net.PasswordAuthentication;
import java.util.List;

public class BusinessClient extends Client {
    List<IndividualClient> individualClientList;
    FactorConnect factorConnect;

    public BusinessClient(PasswordAuthentication passwordAuthentication, String email) {
        super(passwordAuthentication, email);
    }


    public void createFactorConnect(){

    }

    public void addNewWorker(IndividualClient individualClient){
        individualClientList.add(individualClient);
    }
}