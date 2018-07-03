package client;

import thorbank.Bill;
import thorbank.Currency;
import thorbank.FactorConnect;

import java.net.PasswordAuthentication;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BusinessClient extends Client {
    private List<IndividualClient> employeeList;
    private FactorConnect factorConnect;

    public BusinessClient(String CEOFirstName, String CEOLirstName, String CEOEmail, GregorianCalendar dateofBirth, boolean isWorking) {
        super(CEOFirstName, CEOLirstName, CEOEmail, dateofBirth, isWorking);
    }

    public List<IndividualClient> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<IndividualClient> employeeList) {
        this.employeeList = employeeList;
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
