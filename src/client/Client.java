package client;

import credit.Credit;
import db.DB;
import thorbank.BankOnWeb;
import thorbank.Bill;
import thorbank.Card;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.UUID;

public class Client {
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,}$";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private UUID id;
    private PasswordAuthentication passwordAuthentication;
    private String email;
    private List<Bill> billList;
    private List<Card> cardList;
    private List<Credit> creditList;
    private BankOnWeb bankOnWeb;

    public Client(PasswordAuthentication passwordAuthentication, String email) {
        this.id = UUID.randomUUID();
        setPasswordAuthentication(new PasswordAuthentication(passwordAuthentication.getUserName(), passwordAuthentication.getPassword()));
        setEmail(email);
    }

    private void setPasswordAuthentication(PasswordAuthentication passwordAuthentication) {
        if (!passwordAuthentication.getPassword().toString().matches(PASSWORD_REGEX)){

        }
        if (!passwordAuthentication.getUserName().matches(USERNAME_REGEX)){

        }
        this.passwordAuthentication = passwordAuthentication;
    }

    private void setEmail(String email) {
        if (!email.matches(EMAIL_REGEX)){
        }
        this.email = email;
    }

    public void changeUsername(String username){
        for (int i = 0; i < DB.getInstance().getClientList().size(); i++){
            if (DB.getInstance().getClientList().get(i).toString() == username){

            }
        }
        this.passwordAuthentication = new PasswordAuthentication(username, this.passwordAuthentication.getPassword());
    }

    public void changePassword(String password){
        if (!password.matches(PASSWORD_REGEX)){

        }
        this.passwordAuthentication = new PasswordAuthentication(this.passwordAuthentication.getUserName(), password.toCharArray());
    }

    public void changeEmail(String email){
        if (!email.matches(EMAIL_REGEX)){

        }
        this.email = email;
    }

    public void payCredit(Credit credit, Bill bill){

    }

    public void payCredit(Credit credit, Card card){

    }

    public void createBankOnWeb(){
        if (bankOnWeb == null){

        }
    }

    public void applyingForACredit(){

    }
}
