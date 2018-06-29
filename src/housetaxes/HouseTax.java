package housetaxes;

import thorbank.Bill;

public class HouseTax {
    //TODO: Add other enums
    //TODO: Adding Supplier. If not delete GasCompany, Charity and WaterSupply
    private String subscriberNumber;
    private Bill bill;
    private String payName;
    private boolean isPayingAutomated;
    private boolean smsNotification;
    private String mobile;
    private ServiceType serviceType;

    public HouseTax(String subscriberNumber, Bill bill, String payName, boolean isPayingAutomated, boolean smsNotification, String mobile, ServiceType serviceType) {
        setSubscriberNumber(subscriberNumber);
        setBill(bill);
        setPayName(payName);
        setPayingAutomated(isPayingAutomated);
        setSmsNotification(smsNotification);
        setMobile(mobile);
        setServiceType(serviceType);
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public void setPayingAutomated(boolean payingAutomated) {
        isPayingAutomated = payingAutomated;
    }

    public void setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
