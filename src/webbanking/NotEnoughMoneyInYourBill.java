package webbanking;

public class NotEnoughMoneyInYourBill extends Exception {
        public NotEnoughMoneyInYourBill(){
            super("Bill doesn't have enough money");
        }
}
