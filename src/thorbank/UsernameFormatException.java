package thorbank;

public class UsernameFormatException extends Exception {
    public UsernameFormatException(){
        super("Username doesnt match the regex");
    }
}
