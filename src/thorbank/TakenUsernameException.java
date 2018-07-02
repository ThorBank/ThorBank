package thorbank;

public class TakenUsernameException extends Exception {
    public TakenUsernameException(){
        super("Username is already taken");
    }
}
