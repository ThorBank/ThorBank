package test.bank;

import bank.BanksBank;
import client.Client;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(BanksBank.class)
public class BanksBankTest {
    @Test
    public void testinItialisationBlockFirstClientCreated(){
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(0).getFirstName(), "Nikolai");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(0).getLastName(), "Nikolaev");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(0).getEmail(), "n.nikolaev@gmail.com");
    }

    @Test
    public void testinItialisationBlockSecondClientCreated(){
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getFirstName(), "Petur");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getLastName(), "Petrov");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getEmail(), "p.petrov@gmail.com");
    }

    @Test
    public void testinItialisationBlockThirdClientCreated(){
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getFirstName(), "Hristo");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getLastName(), "Hristov");
        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getEmail(), "h.hristov@gmail.com");
    }


}
