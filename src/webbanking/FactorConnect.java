package webbanking;

import client.BusinessClient;

public class FactorConnect extends BankOnWebPro {
    BusinessClient businessClient;

    public FactorConnect(final BusinessClient businessClient) {
        super(null);
        this.businessClient = businessClient;
    }

    public void payingSalary() {
        for (int i = 0; i < this.businessClient.getEmployeeList().size(); i++){
            this.businessClient.setBalance(this.businessClient.getBalance() - this.businessClient.getEmployeeList().get(i).getSalary()*countDiscountPayingSalaryFromBankWebsite());
            this.businessClient.getEmployeeList().get(i).getPaySalaryDebitCard().setBalance(this.businessClient.getEmployeeList().get(i).getPaySalaryDebitCard().getBalance() + this.businessClient.getEmployeeList().get(i).getSalary());
        }
    }

    public double countDiscountPayingSalaryFromBankWebsite() {
        return this.businessClient.getEmployeeList().size()*0.1;
    }
}
