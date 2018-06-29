package client;

import thorbank.Bill;
import thorbank.Currency;
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
        //TODO: 2 balances/bank creates iban/availability and balance always 0 at the beginning maybe ?
        if (factorConnect == null){
            factorConnect = new FactorConnect(0, new Bill("fasfds", Currency.BGN, 0, 0));
        }
    }

    public void addNewWorker(IndividualClient individualClient){
        individualClientList.add(individualClient);
    }
}
