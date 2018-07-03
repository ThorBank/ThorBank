package bank;

import card.CreditCard;
import card.DebitCard;
import client.Client;
import credit.ConsumerCredit;
import credit.HousingCredit;
import debit.IndefiniteDebit;
import debit.TermDebit;
import thorbank.Bill;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *  GringottsBank is our bank.
 */
public final class BanksBank {
    Set<Client> clientList;
    private static final BanksBank INSTANCE = new BanksBank();
    private BanksBank(){}
    public static BanksBank getInstance() {
        return INSTANCE;
    }

    {
        clientList = new HashSet<>();
        clientList.add(new Client("Nikolai", "Nikolaev", "n.nikolaev@gmail.com", new GregorianCalendar(2002, 3, 5), true));
        clientList.add(new Client("Petur", "Petrov", "p.petrov@gmail.com", new GregorianCalendar(1960, 3, 5), true));
        clientList.add(new Client("Hristo", "Hristov", "h.hristov@gmail.com", new GregorianCalendar(1940, 3, 5), false));
    }
}
