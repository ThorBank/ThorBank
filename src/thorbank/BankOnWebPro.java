package thorbank;

public class BankOnWebPro extends BankOnWeb {
    private Bill currentBill;

    public BankOnWebPro(double balance, Bill currentBill) {
        super(balance);
        this.currentBill = currentBill;
    }

    public Bill getCurrentBill() {
        return this.currentBill;
    }

    public void transactionBetweenBills(Client client, List<Bill> billList, double amount) {

    }

    public void payingTaxes(Taxes taxes) {
        switch (taxes) {
            case TAXES: ...; break;
            case HOUSEHOLD_BILLS: ...; break;
            case FEES: ...; break;
        }
    }
}
