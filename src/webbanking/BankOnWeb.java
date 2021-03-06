/*
 * BankOnWebPro
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package webbanking;

import client.Client;
import db.GringottsBankDB;
import message.Message;

import java.net.PasswordAuthentication;
import java.util.UUID;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Comparator;

public class BankOnWeb {
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9._-]{3,}$";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final Integer DATE_COMPARE_ZERO = 0;
    private UUID id;
    private PasswordAuthentication passwordAuthentication;
    private List<Transaction> transactionList;
    private List<Message> messagesWithTheBank;
    private Client client;
    private List<Message> messagesWithGringottsBank;

    public List<Transaction> getTransactionList() {
        return this.transactionList;
    }

    public List<Message> getMessagesWithTheBank() {
        return messagesWithTheBank;
    }

    public BankOnWeb(final Client client) {
        setClient(client);
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setPasswordAuthentication(final PasswordAuthentication passwordAuthentication) {
        this.passwordAuthentication = passwordAuthentication;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return passwordAuthentication;
    }

    public void changePassword(final String newPassword){
        if (newPassword.matches(PASSWORD_REGEX)){
            this.setPasswordAuthentication(new PasswordAuthentication(getPasswordAuthentication().getUserName(), newPassword.toCharArray()));
        }
    }

    public void changeUsername(final String newUserName) throws UsernameFormatException, TakenUsernameException {
        boolean isNewUserNameTaken = false;
        for (int i = 0; i < GringottsBankDB.getInstance().getBankOnWebList().size(); i++){
            if (GringottsBankDB.getInstance().getBankOnWebList().get(i).getPasswordAuthentication().getUserName() == newUserName){
                isNewUserNameTaken = true;
                break;
            }
        }
        if (!newUserName.matches(USERNAME_REGEX)){
            throw new UsernameFormatException();
        }
        else if (isNewUserNameTaken){
            throw new TakenUsernameException();
        }
        else {
            this.setPasswordAuthentication(new PasswordAuthentication(newUserName, getPasswordAuthentication().getPassword()));
        }
    }

    public List<Transaction> searchInTransactionListByDate(final Date startDate, final Date endDate){
        List<Transaction> resultTransactionsFromSearch = new LinkedList<>();
        for (Transaction aTransactionList : transactionList) {
            if (aTransactionList.getDate().compareTo(startDate) >= DATE_COMPARE_ZERO && aTransactionList.getDate().compareTo(endDate) <= DATE_COMPARE_ZERO) {
                resultTransactionsFromSearch.add(aTransactionList);
            }
        }

        return resultTransactionsFromSearch;
    }

    public void sortTransactionByDescendingOrderOfAmount(final List<Transaction> transactionList) {
        List<Transaction> resultTransactions = transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getTransactionAmount).reversed())
                .collect(Collectors.toList());
        printTransactionList(resultTransactions);
    }

    public void printTransactionList(final List<? extends Transaction> transactionList){
        transactionList.forEach(t -> System.out.print(t.toString()));
    }

    public void sendMessageToGringottsBank(final Message message){
        this.messagesWithGringottsBank.add(message);
    }
}
