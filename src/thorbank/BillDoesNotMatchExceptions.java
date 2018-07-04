package thorbank;

public class BillDoesNotMatchExceptions extends Exception {
    public BillDoesNotMatchExceptions(){
        super("Bill does not match with client's bills");
    }
}
