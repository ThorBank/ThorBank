package webbanking;

import client.BusinessClient;
import client.IndividualClient;

public class FactorConnect extends BankOnWebPro {
    BusinessClient businessClient;

    public FactorConnect(final BusinessClient businessClient) {
        super(null);
        setBusinessClient(businessClient);
    }

    public void setBusinessClient(BusinessClient businessClient) {
        this.businessClient = businessClient;
    }

    public void payingSalary() {
        for (int i = 0; i < this.businessClient.getEmployeeList().size(); i++){
            this.businessClient.setBalance(this.businessClient.getBalance() - this.businessClient.getEmployeeList().get(i).getSalary()*countDiscountPayingSalaryFromBankWebsite());
            this.businessClient.getEmployeeList().get(i).getPaySalaryBill().setBalance(this.businessClient.getEmployeeList().get(i).getPaySalaryBill().getBalance() + this.businessClient.getEmployeeList().get(i).getSalary());
        }
    }

    public double countDiscountPayingSalaryFromBankWebsite() {
        return this.businessClient.getEmployeeList().size()*0.1;
    }

    private void setSalaryEmployee(final IndividualClient individualClient, final double salary){
        if (this.businessClient.getEmployeeList().contains(individualClient)){
            individualClient.setSalary(salary);
        }
    }
}