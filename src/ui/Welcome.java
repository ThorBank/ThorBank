package ui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame {
    public Welcome() {
        this.setSize(400, 400);
        /**
         * show the window.
         */

        //TODO: change position of this window to center with setLocationRelativeTo(null)
        Toolkit tk = Toolkit.getDefaultToolkit();

        Dimension dim = tk.getScreenSize();

        /**
         * centering the window in the center of the screen
         */

        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);

        this.setResizable(false);

        /**
         * not properly closed window without this.
         */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Welcome to Gringotts Bank");

        JPanel panel1 = new JPanel();

        JLabel label1 = new JLabel("My ideas, my future, my bank.Just like you, the Bank is embracing new technologies. Come discover our all-new application!", SwingConstants.CENTER);
        panel1.add(label1);

        JButton button1 = new JButton("Login");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome.super.dispose();
                new Login().setVisible(true);
            }
        });
        panel1.add(button1);

        JButton button2 = new JButton("Register");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Welcome.super.dispose();
            }
        });
        panel1.add(button2);

        this.add(panel1);

        this.setVisible(true);
    }
}