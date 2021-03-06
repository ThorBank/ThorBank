/*
 * IndividualClient
 *
 * version 1.0
 *
 * Last updated 06.07.18
 *
 * MIT Copyright
 */
package client;

import java.util.GregorianCalendar;

public class IndividualClient extends Client {
    private double salary;

    public IndividualClient(final String firstName, final String lastName, final String email, final String password, final GregorianCalendar dateofBirth, final boolean isWorking) {
        super(firstName, lastName, email, password, dateofBirth, isWorking);
        setSalary(0);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        this.salary = salary;
    }
}
