package thorbank;

import bank.GringottsBank;
import card.Card;
import client.Client;
import db.DB;
import tool.Message;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.UUID;

public class BankOnWeb {
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,}$";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private UUID id;
    private PasswordAuthentication passwordAuthentication;
    private List<Bill> billList;
    private double balance;
    private double billAvailability;
    private List<Transaction> transactionList;
    private List<Card> cardList;
    private List<Message> messagesWithTheBank;
    private Client client;

    public BankOnWeb(Client client) {
        this.balance = 0;
        this.client = client;
    }

    public double getBalance() {
        return this.balance;
    }

    public Client getClient() {
        return client;
    }

    public void setPasswordAuthentication(PasswordAuthentication passwordAuthentication) {
        this.passwordAuthentication = passwordAuthentication;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return passwordAuthentication;
    }

    public void changePassword(String newPassword){
        if (newPassword.matches(PASSWORD_REGEX)){
            this.setPasswordAuthentication(new PasswordAuthentication(getPasswordAuthentication().getUserName(), newPassword.toCharArray()));
        }
    }

    public void changeUsername(String newUserName){
        boolean isNewUserNameTaken = false;
        for (int i = 0; i < DB.getInstance().getBankOnWebList().size(); i++){
            if (DB.getInstance().getBankOnWebList().get(i).getPasswordAuthentication().getUserName() == newUserName){
                isNewUserNameTaken = true;
                break;
            }
        }
        if (newUserName.matches(USERNAME_REGEX) && !isNewUserNameTaken){
            this.setPasswordAuthentication(new PasswordAuthentication(newUserName, getPasswordAuthentication().getPassword()));
        }
    }
}
