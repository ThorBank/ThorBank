package bank;

import client.Client;

import java.util.LinkedList;
import java.util.List;

/**
 * Bank class represents all other banks except the GringottsBank.
 */
class Bank {
    /**
     * clientList is the list of
     * the clients of the current instance of the bank.
     */
    private List<Client> clientList;

    /**
     *
     */
    Bank() {
        this.clientList = new LinkedList<>();
    }

    /**
     *
     * @return **fdsfsd**
     */
    public List<Client> getClientList() {
        return clientList;
    }
}
