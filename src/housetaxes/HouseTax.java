/*
 * HouseTax
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package housetaxes;

import webbanking.Bill;

public class HouseTax {
    private String subscriberNumber;
    private Bill bill;
    private String payName;
    private boolean isPayingAutomated;
    private boolean smsNotification;
    private String mobile;
    private ServiceType serviceType;

    public HouseTax(final String subscriberNumber, final Bill bill, final String payName, final boolean isPayingAutomated, final boolean smsNotification, final String mobile, final ServiceType serviceType) {
        setSubscriberNumber(subscriberNumber);
        setBill(bill);
        setPayName(payName);
        setPayingAutomated(isPayingAutomated);
        setSmsNotification(smsNotification);
        setMobile(mobile);
        setServiceType(serviceType);
    }

    public void setSubscriberNumber(final String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    public void setPayName(final String payName) {
        this.payName = payName;
    }

    public void setPayingAutomated(final boolean payingAutomated) {
        isPayingAutomated = payingAutomated;
    }

    public void setSmsNotification(final boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    public void setServiceType(final ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
