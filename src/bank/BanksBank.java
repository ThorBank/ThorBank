/*
 * BanksBank
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
 *  BanksBank is test bank to test BankHub.
 */
public final class BanksBank implements Bank {
    private Set<Client> bankClientList;
    /**
     * Singleton pattern.
     */
    private static final BanksBank INSTANCE = new BanksBank();
    private BanksBank() {
    }
    public static synchronized BanksBank getInstance() {
        return INSTANCE;
    }
    /**
     * Created clients so we can test BankHub.
     */
    {
        bankClientList = new HashSet<>();
        bankClientList.add(new Client("Nikolai", "Nikolaev", "n.nikolaev@gmail.com", "123",
                new GregorianCalendar(2002, 3, 5), true));
        bankClientList.add(new Client("Petur", "Petrov", "p.petrov@gmail.com", "321",
                new GregorianCalendar(1960, 3, 5), true));
        bankClientList.add(new Client("Hristo", "Hristov", "h.hristov@gmail.com", "qwer",
                new GregorianCalendar(1940, 3, 5), false));
    }
}
