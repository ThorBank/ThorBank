package client;

import thorbank.Bill;
import thorbank.Currency;
import thorbank.FactorConnect;

import java.net.PasswordAuthentication;
import java.util.List;

public class BusinessClient extends Client {
    List<IndividualClient> employeeList;
    FactorConnect factorConnect;

    public BusinessClient(String CEOFirstName, String CEOLirstName, String CEOEmail) {
        super(CEOFirstName, CEOLirstName, CEOEmail);
    }


    public void createFactorConnect(){
        if (factorConnect == null){
            factorConnect = new FactorConnect(this);
        }
    }

    public void addNewWorker(IndividualClient individualClient){
        employeeList.add(individualClient);
    }
}
