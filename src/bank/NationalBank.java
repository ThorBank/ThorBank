package bank;

import client.Client;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

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
        clientList.add(new Client("Georgi", "Georgiev", "g.georgiev@gmail.com", new GregorianCalendar(1990, 2,4), true));
        clientList.add(new Client("Ivan", "Ivanov", "i.ivanov@gmail.com", new GregorianCalendar(2009, 3, 25), true));
        clientList.add(new Client("Dimitur", "Dimitrov", "d.dimitrov@gmail.com", new GregorianCalendar(1950, 3,27), false));
    }
}
