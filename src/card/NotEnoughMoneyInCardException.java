package card;

public class NotEnoughMoneyInCardException extends Exception {
    public NotEnoughMoneyInCardException(){
        super("Card doesn't have enough money");
    }
}
