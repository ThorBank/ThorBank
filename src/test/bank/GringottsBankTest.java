//package test.bank;
//
//import bank.GringottsBank;
//import card.CardNumberFormatException;
//import card.CreditCard;
//import card.PaymentNetwork;
//import client.Client;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import webbanking.Currency;
//
//import java.util.GregorianCalendar;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(GringottsBank.class)
//public class GringottsBankTest {
//    @Mock
//    Client client;
//    PaymentNetwork paymentNetwork;
//    double aDouble;
//    Currency currency;
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();
//
//    @Test
//    public void singletonPattern() {
//
//        GringottsBank object1 = GringottsBank.getInstance();
//        object1.getClients().add(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), client.getDateofBirth(), client.isWorking()));
//        GringottsBank object2 = GringottsBank.getInstance();
//
//        Assert.assertTrue(object1 == object2);
//        /**
//         * For the test getClients()
//         */
//        object1.getClients().clear();
//    }
//
//    @Test
//    public void getClients() {
//        Assert.assertEquals(GringottsBank.getInstance().getClients().size(), 0);
//    }
//
//    @Test
//    public void approveCreditCardFulfillConditions1() {
//        boolean isFullfillingConditions = GringottsBank.getInstance().approveCreditCard(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), new GregorianCalendar(1995, 7, 4), true));
//        Assert.assertTrue(isFullfillingConditions);
//    }
//
//    @Test
//    public void approveCreditCardFulfillConditions2() {
//        boolean isFullfillingConditions = GringottsBank.getInstance().approveCreditCard(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), new GregorianCalendar(1955, 7, 4), true));
//        Assert.assertTrue(isFullfillingConditions);
//    }
//
//    @Test
//    public void approveCreditCardDontFulfillConditionsTooYoung() {
//        boolean isFullfillingConditions = GringottsBank.getInstance().approveCreditCard(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), new GregorianCalendar(1996, 7, 4), true));
//        Assert.assertTrue(!isFullfillingConditions);
//    }
//
//    @Test
//    public void approveCreditCardDontFulfillConditionsTooOld() {
//        boolean isFullfillingConditions = GringottsBank.getInstance().approveCreditCard(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), new GregorianCalendar(1954, 7, 4), true));
//        Assert.assertTrue(!isFullfillingConditions);
//    }
//
//    @Test
//    public void approveCreditCardDontFulfillConditionsNotWorking() {
//        boolean isFullfillingConditions = GringottsBank.getInstance().approveCreditCard(new Client(client.getFirstName(), client.getLastName(), client.getEmail(), new GregorianCalendar(1955, 7, 4), false));
//        Assert.assertTrue(!isFullfillingConditions);
//    }
//
//    public void createCreditCardMethodHelper(final Client client, final PaymentNetwork paymentNetwork, final double balance, final Currency currency) throws CardNumberFormatException {
//        long numberCreditCard = 9999999999999999L;
//        long cVV = (long) (Math.random() * GringottsBank.getInstance().getCvvCreditCardGeneratorMagicNumber());
//        client.getCardList().add(new CreditCard(client, Long.toString(numberCreditCard), paymentNetwork, Long.toString(cVV), balance, currency));
//    }
//
//    @Test
//    public void createCreditCardCanNumberCreditCardHoldBiggestPossibleNumber() throws CardNumberFormatException {
//        client = new Client(client.getFirstName(), client.getLastName(), client.getEmail(), client.getDateofBirth(), client.isWorking());
//        createCreditCardMethodHelper(client, paymentNetwork, aDouble, currency);
//        Assert.assertEquals(client.getCardList().get(0).getNumber(), Long.toString(9999999999999999L));
//    }
//
//    @Test
//    public void createCreditCardCanNumberCreditCardZeros() throws CardNumberFormatException {
//        client = new Client(client.getFirstName(), client.getLastName(), client.getEmail(), client.getDateofBirth(), client.isWorking());
//        createCreditCardMethodHelper(client, paymentNetwork, aDouble, currency);
//        Assert.assertEquals(client.getCardList().get(0).getNumber(), Long.toString(0000000000000000L));
//    }
//}
