package bank;

import client.Client;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *  BanksBank is test bank to test BankHub.
 */
public final class BanksBank {
    /**
     * List of all clients of BanksBank.
     */
    private Set<Client> bankClientList;
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
    public static BanksBank getInstance() {
        return INSTANCE;
    }

    {
        bankClientList = new HashSet<>();
        bankClientList.add(new Client("Nikolai", "Nikolaev", "n.nikolaev@gmail.com",
                new GregorianCalendar(2002, 3, 5), true));
        bankClientList.add(new Client("Petur", "Petrov", "p.petrov@gmail.com",
                new GregorianCalendar(1960, 3, 5), true));
        bankClientList.add(new Client("Hristo", "Hristov", "h.hristov@gmail.com",
                new GregorianCalendar(1940, 3, 5), false));
    }
}
