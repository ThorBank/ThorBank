package webbanking;

public class BillNotFromGringottsBankException extends Throwable {
    public BillNotFromGringottsBankException(){
        super("Bill is not from Gringotts Bank");
    }
}
