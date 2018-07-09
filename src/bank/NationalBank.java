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
import client.IndividualClient;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * GringottsBank is our bank.
 */
public final class NationalBank implements Bank {
    private Set<Client> clientList;
    /**
     * Only one instance.
     */
    private static final NationalBank INSTANCE = new NationalBank();
    private NationalBank() {
    }
    public static synchronized NationalBank getInstance() {
        return INSTANCE;
    }
    /**
     * Created clients so we can test BankHub.
     */
    {
        clientList = new HashSet<>();
        clientList.add(new IndividualClient("Georgi", "Georgiev", "g.georgiev@gmail.com", "123456", new GregorianCalendar(1990, 2,4), true));
        clientList.add(new IndividualClient("Ivan", "Ivanov", "i.ivanov@gmail.com", "654321", new GregorianCalendar(2009, 3, 25), true));
        clientList.add(new IndividualClient("Dimitur", "Dimitrov", "d.dimitrov@gmail.com", "asdfg", new GregorianCalendar(1950, 3,27), false));
    }
}
