package ui;

import client.Client;
import db.GringottsBankDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Register extends JFrame {
    public Register() {
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Login");

        JPanel panel1 = new JPanel();

        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField firstName = new JTextField("", 15);
        firstName.setColumns(10);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField lastName = new JTextField("", 15);
        lastName.setColumns(10);

        JLabel emailLabel = new JLabel("Last Name: ");
        JTextField email = new JTextField("", 15);
        email.setColumns(10);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField("", 15);
        password.setColumns(10);

        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);

        JComboBox<Integer> yearOfBirth = new JComboBox<>();
        for (int i = 1950; i < timeNow.get(Calendar.YEAR); i++){
            yearOfBirth.addItem(i);
        }


        JComboBox<Integer> monthOfBirth = new JComboBox<>();
        for (int i = 1; i <= 12; i++){
            monthOfBirth.addItem(i);
        }

        JComboBox<Integer> dayOfBirth = new JComboBox<>();
        for (int i = 1; i <= 31; i++){
            dayOfBirth.addItem(i);
        }

        yearOfBirth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monthOfBirth.getSelectedItem().toString() == "1"
                        || monthOfBirth.getSelectedItem().toString() == "3"
                        || monthOfBirth.getSelectedItem().toString() == "5"
                        || monthOfBirth.getSelectedItem().toString() == "7"
                        || monthOfBirth.getSelectedItem().toString() == "8"
                        || monthOfBirth.getSelectedItem().toString() == "10"
                        || monthOfBirth.getSelectedItem().toString() == "12"){
                    dayOfBirth.removeAllItems();
                    for (int i = 1; i <= 31; i++){
                        dayOfBirth.addItem(i);
                    }
                }
                else if (monthOfBirth.getSelectedItem().toString() == "2"){
                    if (isLeapYear(Integer.parseInt(yearOfBirth.getSelectedItem().toString()))){
                        dayOfBirth.removeAllItems();
                        for (int i = 1; i <= 29; i++){
                            dayOfBirth.addItem(i);
                        }
                    }
                    else {
                        dayOfBirth.removeAllItems();
                        for (int i = 1; i <= 28; i++){
                            dayOfBirth.addItem(i);
                        }
                    }
                }
                else {
                    dayOfBirth.removeAllItems();
                    for (int i = 1; i <= 30; i++){
                        dayOfBirth.addItem(i);
                    }
                }
            }
        });

        monthOfBirth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(monthOfBirth.getSelectedItem().toString())%2 != 0){
                    dayOfBirth.removeAllItems();
                    for (int i = 1; i <= 31; i++){
                        dayOfBirth.addItem(i);
                    }
                }
                else if (Integer.parseInt(monthOfBirth.getSelectedItem().toString()) == 2){
                    if (isLeapYear(Integer.parseInt(yearOfBirth.getSelectedItem().toString()))){
                        dayOfBirth.removeAllItems();
                        for (int i = 1; i <= 29; i++){
                            dayOfBirth.addItem(i);
                        }
                    }
                    else {
                        dayOfBirth.removeAllItems();
                        for (int i = 1; i <= 28; i++){
                            dayOfBirth.addItem(i);
                        }
                    }
                }
                else {
                    dayOfBirth.removeAllItems();
                    for (int i = 1; i <= 30; i++){
                        dayOfBirth.addItem(i);
                    }
                }
            }
        });

        JRadioButton isWorking = new JRadioButton("Are you working: ");


        JButton login = new JButton("Register");
//        GringottsBankDB.getInstance().getClientList().add(new Client("aa", "aa", "a", "a",
//                new GregorianCalendar(1,2,3), true));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!GringottsBankDB.getInstance().getClientList().stream()
                        .filter((client) -> client.getEmail().equals(email.getText()))
                        .anyMatch(client -> true) && !firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()
                        && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {

                    GringottsBankDB.getInstance().getClientList().add(new Client(firstName.getText().toString(), lastName.getText().toString(),
                            email.getText().toString(), password.getText().toString(), new GregorianCalendar(Integer.parseInt(yearOfBirth.getSelectedItem().toString()), Integer.parseInt(monthOfBirth.getSelectedItem().toString()), Integer.parseInt(dayOfBirth.getSelectedItem().toString())), isWorking.isSelected()));
                    Register.super.dispose();
                    new Login().setVisible(true);
                }
            }
        });
        panel1.add(login);

        panel1.add(firstNameLabel);
        panel1.add(firstName);
        panel1.add(lastNameLabel);
        panel1.add(lastName);
        panel1.add(emailLabel);
        panel1.add(email);
        panel1.add(passwordLabel);
        panel1.add(password);
        panel1.add(yearOfBirth);
        panel1.add(monthOfBirth);
        panel1.add(dayOfBirth);
        panel1.add(isWorking);


        this.add(panel1);

        this.setVisible(true);
    }

    /**
     * To determine whether a year is a leap year, follow these steps:
     * 1.If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
     * 2.If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 4.
     * 3.If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.
     * 4.The year is a leap year (it has 366 days).
     * 5.The year is not a leap year (it has 365 days).
     */

    private boolean isLeapYear(int year){
        if (year%4 == 0){
            if (year%100 == 0){
                if (year%400 == 0){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
