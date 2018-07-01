package bank;

import card.Card;
import card.CreditCard;
import card.DebitCard;
import client.Client;
import credit.Credit;
import thorbank.Bill;

public class GringottsBank extends Bank {
    private static final double AVERAGE_INTEREST_RATE = 0.01d;
    private static final double ATTRACTED_RESOURCE = 0.03d;
    private static final double LOANS = 10.0d;
    private static final double OTHER_RECEIVABLES = 6.0d;
    private static final double DISCOUNTS = 2.0d;

    public void changeCreditInterestRate(Credit credit) {
//      SGEBBIR= (S*K1) + (R*K2) - D
    }

    public void issuanceCard(CreditCard card, Client client) {
        client.getCardList().add(card);
    }

    public void issuanceAccountCard(Client client, String iban, DebitCard debitCard) {
        for (Bill bill : client.getBillList()) {
            if (bill.getIban().equals(iban)) {
                debitCard.setBill(bill);
            }
        }
    }

    public void issuanceAccount(Client client, String iban) {

    }
}
