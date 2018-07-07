package ui;

import client.Client;
import db.GringottsBankDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class Register extends JFrame {
    public Register() {
        this.setSize(400, 400);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Login");

        JPanel panel1 = new JPanel();

        JLabel emailLabel = new JLabel("Email: ");
        JTextField email = new JTextField("", 15);
        email.setColumns(10);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField("", 15);
        email.setColumns(10);

        JButton login = new JButton("Register");
        GringottsBankDB.getInstance().getClientList().add(new Client("aa", "aa", "a", "a",
                new GregorianCalendar(1,2,3), true));
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!GringottsBankDB.getInstance().getClientList().stream()
                        .filter((client) -> client.getEmail().equals(email.getText()))
                        .anyMatch(client -> true)) {
                    Register.super.dispose();
                }
            }
        });
        panel1.add(login);

        panel1.add(emailLabel);
        panel1.add(email);
        panel1.add(passwordLabel);
        panel1.add(password);

        this.add(panel1);

        this.setVisible(true);
    }
}
