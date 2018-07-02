package db;

import client.Client;
import thorbank.BankOnWeb;

import java.util.LinkedList;
import java.util.List;

public class DB {
    private static final DB instance = new DB();
    private List<Client> clientList;
    private List<BankOnWeb> bankOnWebList;

    {
        clientList = new LinkedList<>();
        bankOnWebList = new LinkedList<>();
    }

    private DB() { }

    public static DB getInstance(){
        return instance;
    }

    public List<Client> getClientList(){
        return this.clientList;
    }

    public List<BankOnWeb> getBankOnWebList() {
        return bankOnWebList;
    }
}
