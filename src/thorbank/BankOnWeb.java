package thorbank;

import java.util.List;

public class BankOnWeb {
    private int id;
    private String email;
    private String username;
    private List<Bill> billList;
    private double balance;
    private double billAavailability;
    private List<Transaction> transactionList;
    private List<Card> cardList;
    private List<Message> messagesWithTheBank;

    public BankOnWeb(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }


    public void changePassword(){

    }

    public void changeUsername(){

    }

}
}
