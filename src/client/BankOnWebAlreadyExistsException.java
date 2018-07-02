package client;

public class BankOnWebAlreadyExistsException extends Exception {
    public BankOnWebAlreadyExistsException(){
        super("You already have an existing BankOnWeb account");
    }
}
