/*
 * NationalBank
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package bank;

import client.Client;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * GringottsBank is our bank.
 */
public final class NationalBank implements Bank {
    /**
     * List of all clients of BanksBank.
     */
    private Set<Client> clientList;
    /**
     * The only instance of BanksBank.
     */
    private static final NationalBank INSTANCE = new NationalBank();

    private NationalBank() {
    }
    /**
     * Getter for the only instance of BanksBank.
     *
     * @return **instance of BanksBank**
     */
    public static synchronized NationalBank getInstance() {
        return INSTANCE;
    }

    {
        clientList = new HashSet<>();
        clientList.add(new Client("Georgi", "Georgiev", "g.georgiev@gmail.com", new GregorianCalendar(1990, 2,4), true));
        clientList.add(new Client("Ivan", "Ivanov", "i.ivanov@gmail.com", new GregorianCalendar(2009, 3, 25), true));
        clientList.add(new Client("Dimitur", "Dimitrov", "d.dimitrov@gmail.com", new GregorianCalendar(1950, 3,27), false));
    }
}
