//package test.bank;
//
//import bank.BanksBank;
//import client.Client;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import java.util.GregorianCalendar;
//import java.util.LinkedList;
//import java.util.List;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(BanksBank.class)
//public class BanksBankTest {
//    @Mock
//    Client client;
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Test
//    public void initialisationBlockFirstClientCreated(){
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().contains(), "Nikolai");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(0).getLastName(), "Nikolaev");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(0).getEmail(), "n.nikolaev@gmail.com");
//    }
//
//    @Test
//    public void initialisationBlockSecondClientCreated(){
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getFirstName(), "Petur");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getLastName(), "Petrov");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(1).getEmail(), "p.petrov@gmail.com");
//    }
//
//    @Test
//    public void initialisationBlockThirdClientCreated(){
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getFirstName(), "Hristo");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getLastName(), "Hristov");
//        Assert.assertEquals(BanksBank.getInstance().getBankClientList().get(2).getEmail(), "h.hristov@gmail.com");
//    }
//
//    @Test
//    public void singletonPattern(){
//        BanksBank object1 = BanksBank.getInstance();
//        object1.getBankClientList().add(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), client.getDateofBirth(), client.isWorking()));
//        BanksBank object2 = BanksBank.getInstance();
//
//        Assert.assertTrue(object1 == object2);
//    }
//}
