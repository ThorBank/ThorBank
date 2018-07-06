/*
 * Business Client
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package client;

import webbanking.FactorConnect;
import java.util.GregorianCalendar;
import java.util.List;

public class BusinessClient extends Client {
    private String companyName;
    private List<IndividualClient> employeeList;
    private FactorConnect factorConnect;
    private double balance;
    public BusinessClient(IndividualClient individualClient, String companyName) {
        super(individualClient.getFirstName(), individualClient.getLastName(), individualClient.getEmail(), individualClient.getDateofBirth(), true);
        setBalance(balance);
        setCompanyName(companyName);
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
