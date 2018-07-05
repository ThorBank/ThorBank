package bank;

import client.Client;

import java.util.*;

/**
 *  BanksBank is test bank to test BankHub.
 */
public final class BanksBank {
    /**
     * List of all clients of BanksBank.
     */
    private List<Client> bankClientList;
    /**
     * The only instance of BanksBank.
     */
    private static final BanksBank INSTANCE = new BanksBank();

    private BanksBank() {
    }

    /**
     * Getter for the only instance of BanksBank.
     *
     * @return **instance of BanksBank**
     */
    public static synchronized BanksBank getInstance() {
        return INSTANCE;
    }

    {
        bankClientList = new LinkedList<>();
        bankClientList.add(new Client("Nikolai", "Nikolaev", "n.nikolaev@gmail.com",
                new GregorianCalendar(2002, 3, 5), true));
        bankClientList.add(new Client("Petur", "Petrov", "p.petrov@gmail.com",
                new GregorianCalendar(1960, 3, 5), true));
        bankClientList.add(new Client("Hristo", "Hristov", "h.hristov@gmail.com",
                new GregorianCalendar(1940, 3, 5), false));
    }

    public List<Client> getBankClientList() {
        return bankClientList;
    }
}
