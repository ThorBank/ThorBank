package client;

import java.net.PasswordAuthentication;
import java.util.GregorianCalendar;

public class IndividualClient extends Client {
    private double salary;

    public IndividualClient(final String firstName, final String lastName, final String email, final GregorianCalendar dateofBirth, final boolean isWorking) {
        super(firstName, lastName, email, dateofBirth, isWorking);
        setSalary(0);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }
    //TODO: when start working for a company which has Factory Connect in our bank
}
