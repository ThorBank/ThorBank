import bank.BanksBank;
import bank.GringottsBank;

public class ThorBank {
    public static void main(String[] args) {
        System.out.println(BanksBank.getInstance().getBankClientList().get(1).getEmail());
    }
}
