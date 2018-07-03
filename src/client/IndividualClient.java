package client;

import java.net.PasswordAuthentication;
import java.util.GregorianCalendar;

public class IndividualClient extends Client {
    private double salary;

    public IndividualClient(String firstName, String lastName, String email, GregorianCalendar dateofBirth, boolean isWorking) {
        super(firstName, lastName, email, dateofBirth, isWorking);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
