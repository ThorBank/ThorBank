package client;

import java.net.PasswordAuthentication;

public class IndividualClient extends Client {
    private double salary;

    public IndividualClient(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
