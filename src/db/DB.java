package db;

import client.Client;

import java.util.LinkedList;
import java.util.List;

public class DB {
    private static final DB instance = new DB();
    List<Client> clientList;

    {
        clientList = new LinkedList<>();
    }

    private DB() { }

    public static DB getInstance(){
        return instance;
    }

    public List<Client> getClientList(){
        return this.clientList;
    }
}
