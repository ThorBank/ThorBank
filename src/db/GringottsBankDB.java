package db;

import client.Client;
import webbanking.BankOnWeb;

import java.util.LinkedList;
import java.util.List;

public class GringottsBankDB {
    private static final GringottsBankDB instance = new GringottsBankDB();
    private List<Client> clientList;
    private List<BankOnWeb> bankOnWebList;

    {
        setClientList(new LinkedList<>());
        setBankOnWebList(new LinkedList<>());
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public void setBankOnWebList(List<BankOnWeb> bankOnWebList) {
        this.bankOnWebList = bankOnWebList;
    }

    private GringottsBankDB() { }

    public static GringottsBankDB getInstance(){
        return instance;
    }

    public List<Client> getClientList(){
        return this.clientList;
    }

    public List<BankOnWeb> getBankOnWebList() {
        return bankOnWebList;
    }
}
