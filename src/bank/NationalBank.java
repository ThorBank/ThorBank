package bank;

import client.Client;

import java.util.HashSet;
import java.util.Set;

/**
 * GringottsBank is our bank.
 */
public final class NationalBank {
    private Set<Client> clientList = new HashSet<>();
    private static final NationalBank INSTANCE = new NationalBank();

    private NationalBank() {
    }

    public static NationalBank getInstance() {
        return INSTANCE;
    }

    {
        clientList = new HashSet<>();
        clientList.add(new Client("Georgi", "Georgiev", "g.georgiev@gmail.com"));
        clientList.add(new Client("Ivan", "Ivanov", "i.ivanov@gmail.com"));
        clientList.add(new Client("Dimitur", "Dimitrov", "d.dimitrov@gmail.com"));
    }
}
