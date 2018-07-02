package card;

public class CardNumberFormatException extends Exception {
    public CardNumberFormatException() {
        super("New number didn't match the regex");
    }
}
