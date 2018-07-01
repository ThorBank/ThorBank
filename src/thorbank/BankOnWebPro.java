package thorbank;

import card.Card;
import client.Client;
import client.CreditAppliable;
import client.CreditPayable;
import credit.Credit;
import housetaxes.Taxes;

import java.util.List;

public class BankOnWebPro extends BankOnWeb implements CreditAppliable, CreditPayable {
    private Bill currentBill;

    public BankOnWebPro(double balance, Bill currentBill) {
        super(balance);
        this.currentBill = currentBill;
    }

    public Bill getCurrentBill() {
        return this.currentBill;
    }

    public void transactionBetweenBills(Client client, Bill firstBill, Bill secondBill, double amount) {
        if (!client.getBillList().contains(firstBill) || !client.getBillList().contains(secondBill)) {

        }

        firstBill.setAvailability(firstBill.getAvailability()-amount);
        secondBill.setAvailability(secondBill.getAvailability()+amount);
    }


    public void payingTaxes(Taxes taxes) {
        switch (taxes) {
            case TAXES: break;
            case HOUSEHOLD_BILLS: break;
            case FEES: break;
        }
    }

    @Override
    public void applyingForACredit() {

    }

    @Override
    public void payCredit(Credit credit, Bill bill) {
        
    }

    @Override
    public void payCredit(Credit credit, Card card) {

    }
}
