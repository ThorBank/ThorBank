package client;

import thorbank.BankOnWeb;

import java.net.PasswordAuthentication;
import java.util.UUID;

public class Client {
    private UUID id;
    private PasswordAuthentication passwordAuthentication;
    private String email;
    List<Bill> billList;
    List<Card> cardList;
    List<Credit> creditList;
    BankOnWeb bankOnWeb;

    public Client(PasswordAuthentication passwordAuthentication, String email) {
        this.id = UUID.randomUUID();
        setPasswordAuthentication(new PasswordAuthentication(passwordAuthentication.getUserName(), passwordAuthentication.getPassword()));
        setEmail(email);
    }

    private void setPasswordAuthentication(PasswordAuthentication passwordAuthentication) {
        if (!passwordAuthentication.getPassword().toString().matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}")){

        }
        if (!passwordAuthentication.getUserName().matches("^[a-zA-Z0-9._-]{3,}$")){

        }
        this.passwordAuthentication = passwordAuthentication;
    }

    private void setEmail(String email) {
        if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
        }
        this.email = email;
    }

    public void changeUsername(String username){
        this.passwordAuthentication = new PasswordAuthentication(username, this.passwordAuthentication.getPassword());
    }

    public void changePassword(String password){
        this.passwordAuthentication = new PasswordAuthentication(this.passwordAuthentication.getUserName(), password.toCharArray());
    }

    public void changeEmail(String email){
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
}
