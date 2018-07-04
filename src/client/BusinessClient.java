package client;

import thorbank.FactorConnect;
import java.util.GregorianCalendar;
import java.util.List;

public class BusinessClient extends Client {
    private List<IndividualClient> employeeList;
    private FactorConnect factorConnect;
    private double balance;

    public BusinessClient(final String CEOFirstName, final String CEOLirstName, final String CEOEmail, final GregorianCalendar dateofBirth, final boolean isWorking) {
        super(CEOFirstName, CEOLirstName, CEOEmail, dateofBirth, isWorking);
        setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<IndividualClient> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(final List<IndividualClient> employeeList) {
        this.employeeList = employeeList;
    }

    public void createFactorConnect(){
        if (factorConnect == null){
            factorConnect = new FactorConnect(this);
        }
    }

    public void addNewWorker(final IndividualClient individualClient){
        employeeList.add(individualClient);
    }
}
