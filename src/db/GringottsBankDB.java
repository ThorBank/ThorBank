package db;

import client.Client;
import webbanking.BankOnWeb;

import java.util.LinkedList;
import java.util.List;

public class GringottsBankDB {
    private static final GringottsBankDB INSTANCE = new GringottsBankDB();
    private List<Client> clientList;
    private List<BankOnWeb> bankOnWebList;

    {
        clientList = new LinkedList<>();
        bankOnWebList = new LinkedList<>();
    }

    private GringottsBankDB() { }

    public static GringottsBankDB getInstance() {
        return INSTANCE;
    }

    public List<Client> getClientList() {
        return this.clientList;
    }

    public List<BankOnWeb> getBankOnWebList() {
        return bankOnWebList;
    }
}
