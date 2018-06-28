package db;

import client.Client;

import java.util.LinkedList;
import java.util.List;

public final class DB {
    private static final DB instance = new DB();
    List<Client> clientList;

    private DB() {
        this.clientList = new LinkedList<>();
    }

    public DB getInstance(){
        return instance;
    }
}
