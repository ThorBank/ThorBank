package ui;

import client.BusinessClient;
import client.IndividualClient;
import db.GringottsBankDB;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Tsveta Getova
 */
public class Register extends JFrame {

    /**
     * Creates new form Register Form
     */

    public Register() {
        initComponents();

    }

    private void backToLoginBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void registerBtnActionPerformed(ActionEvent e) {
        if (!GringottsBankDB.getInstance().getClientList().stream()
                .filter((client) -> client.getEmail().equals(emailTextField2.getText()))
                .anyMatch(client -> true) && !firstNameTextField.getText().toString().isEmpty() && !lastNameTextField2.getText().toString().isEmpty()
                && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {

            if (individual.isSelected())
            {
                GringottsBankDB.getInstance().getClientList().add(new IndividualClient(firstNameTextField.getText().toString(), lastNameTextField2.getText().toString(),
                        emailTextField2.getText().toString(), passwordTextField.getText().toString(), new GregorianCalendar(Integer.parseInt(yearOfBirth.getSelectedItem().toString()), Integer.parseInt(monthOfBirth.getSelectedItem().toString()), Integer.parseInt(dayOfBirth.getSelectedItem().toString())), isWorking.isSelected()));
            }
            else {
                GringottsBankDB.getInstance().getClientList().add(new BusinessClient(new IndividualClient(firstNameTextField.getText().toString(), lastNameTextField2.getText().toString(),
                        emailTextField2.getText().toString(), passwordTextField.getText().toString(), new GregorianCalendar(Integer.parseInt(yearOfBirth.getSelectedItem().toString()), Integer.parseInt(monthOfBirth.getSelectedItem().toString()), Integer.parseInt(dayOfBirth.getSelectedItem().toString())), isWorking.isSelected()), companyName.getText()));
            }

            Register.super.dispose();
            new Login().setVisible(true);
        }
    }

    private void backTologinBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void dayOfBirthActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    /**
     //     * To determine whether a year is a leap year, follow these steps:
     //     * 1.If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
     //     * 2.If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 4.
     //     * 3.If the year is evenly divisible by 400, go to step 4. Otherwise, go to step 5.
     //     * 4.The year is a leap year (it has 366 days).
     //     * 5.The year is not a leap year (it has 365 days).
     //     */

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


    private void monthOfBirthActionPerformed(ActionEvent e) {
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

    private void yearOfBirthActionPerformed(ActionEvent e) {
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
        else if (monthOfBirth.getSelectedItem().toString().equals("2")){
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

    private void individualMouseClicked(MouseEvent e) {
        companyName.setVisible(false);
    }

    private void businessMouseClicked(MouseEvent e) {
        companyName.setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        panel1 = new JPanel();
        panel2 = new JPanel();
        ThorBankLabel = new JLabel();
        label2 = new JLabel();
        separator1 = new JSeparator();
        registerForm = new JLabel();
        firstName = new JLabel();
        firstNameTextField = new JTextField();
        lastName = new JLabel();
        lastNameTextField2 = new JTextField();
        email = new JLabel();
        emailTextField2 = new JTextField();
        password = new JLabel();
        passwordTextField = new JTextField();
        dateOfBirth = new JLabel();
        isWorkingLb = new JLabel();
        isWorking = new JRadioButton();
        registerBtn = new JButton();
        dayOfBirth = new JComboBox();
        monthOfBirth = new JComboBox();
        yearOfBirth = new JComboBox();
        individual = new JRadioButton();
        business = new JRadioButton();
        companyName = new JTextField();

        Date date = new Date();
        Calendar timeNow = new GregorianCalendar();
        timeNow.setTime(date);

        for (int i = 1950; i < timeNow.get(Calendar.YEAR); i++){
            yearOfBirth.addItem(i);
        }

        for (int i = 1; i <= 12; i++){
            monthOfBirth.addItem(i);
        }
        for (int i = 1; i <= 31; i++){
            dayOfBirth.addItem(i);
        }

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setName("1\n2\n3\n4\n5");

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(204, 0, 51));
                panel2.setLayout(null);

                //---- ThorBankLabel ----
                ThorBankLabel.setText("Thor Bank");
                ThorBankLabel.setForeground(Color.white);
                ThorBankLabel.setFont(new Font("FrankRuehl", Font.BOLD, 48));
                ThorBankLabel.setRequestFocusEnabled(false);
                ThorBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(ThorBankLabel);
                ThorBankLabel.setBounds(285, 45, 255, 55);

                //---- label2 ----
                label2.setIcon(new ImageIcon(getClass().getResource("/resources/7234-256x256x32resize.png")));
                panel2.add(label2);
                label2.setBounds(195, 35, 80, 80);

                //---- separator1 ----
                separator1.setBackground(Color.white);
                separator1.setForeground(Color.white);
                separator1.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator1);
                separator1.setBounds(300, 95, 230, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(0, 0, 735, 120);

            //---- registerForm ----
            registerForm.setText("  Register Form");
            registerForm.setFont(new Font("FrankRuehl", Font.BOLD, 36));
            registerForm.setForeground(new Color(102, 102, 102));
            panel1.add(registerForm);
            registerForm.setBounds(240, 125, 255, 40);

            //---- firstName ----
            firstName.setText("First Name");
            firstName.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(firstName);
            firstName.setBounds(105, 170, 130, 35);

            //---- firstNameTextField ----
            firstNameTextField.setBackground(Color.white);
            firstNameTextField.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            firstNameTextField.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(firstNameTextField);
            firstNameTextField.setBounds(285, 170, 330, 35);

            //---- lastName ----
            lastName.setText("Last Name");
            lastName.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(lastName);
            lastName.setBounds(105, 210, 130, 35);

            //---- lastNameTextField2 ----
            lastNameTextField2.setBackground(Color.white);
            lastNameTextField2.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            lastNameTextField2.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(lastNameTextField2);
            lastNameTextField2.setBounds(285, 210, 330, 35);

            //---- email ----
            email.setText("e-mail");
            email.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(email);
            email.setBounds(105, 250, 130, 35);

            //---- emailTextField2 ----
            emailTextField2.setBackground(Color.white);
            emailTextField2.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            emailTextField2.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(emailTextField2);
            emailTextField2.setBounds(285, 250, 330, 35);

            //---- password ----
            password.setText("password");
            password.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(password);
            password.setBounds(105, 290, 130, 35);

            //---- passwordTextField ----
            passwordTextField.setBackground(Color.white);
            passwordTextField.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            passwordTextField.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(passwordTextField);
            passwordTextField.setBounds(285, 290, 330, 35);

            //---- dateOfBirth ----
            dateOfBirth.setText("Date of Birth");
            dateOfBirth.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(dateOfBirth);
            dateOfBirth.setBounds(105, 355, 130, 35);

            //---- isWorkingLb ----
            isWorkingLb.setText("Are you working: ");
            isWorkingLb.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            panel1.add(isWorkingLb);
            isWorkingLb.setBounds(100, 415, isWorkingLb.getPreferredSize().width, 35);

            //---- isWorking ----
            isWorking.setBackground(Color.white);
            isWorking.setBorder(null);
            panel1.add(isWorking);
            isWorking.setBounds(new Rectangle(new Point(215, 427), isWorking.getPreferredSize()));

            //---- registerBtn ----
            registerBtn.setText("REGISTER");
            registerBtn.setBackground(new Color(102, 102, 102));
            registerBtn.setForeground(Color.white);
            registerBtn.setBorder(null);
            registerBtn.addActionListener(e -> registerBtnActionPerformed(e));
            panel1.add(registerBtn);
            registerBtn.setBounds(455, 410, 160, 55);

            //---- dayOfBirth ----
            dayOfBirth.setMaximumRowCount(31);
            dayOfBirth.setName("day");
            dayOfBirth.setSelectedIndex(-1);
            dayOfBirth.setBackground(new Color(102, 102, 102));
            dayOfBirth.setBorder(null);
            dayOfBirth.addActionListener(e -> dayOfBirthActionPerformed(e));
            panel1.add(dayOfBirth);
            dayOfBirth.setBounds(285, 355, 65, dayOfBirth.getPreferredSize().height);

            //---- monthOfBirth ----
            monthOfBirth.setMaximumRowCount(31);
            monthOfBirth.setName("day");
            monthOfBirth.setSelectedIndex(-1);
            monthOfBirth.setBackground(new Color(102, 102, 102));
            monthOfBirth.setBorder(null);
            monthOfBirth.addActionListener(e -> monthOfBirthActionPerformed(e));
            panel1.add(monthOfBirth);
            monthOfBirth.setBounds(360, 355, 125, 30);

            //---- yearOfBirth ----
            yearOfBirth.setMaximumRowCount(31);
            yearOfBirth.setName("day");
            yearOfBirth.setSelectedIndex(-1);
            yearOfBirth.setBackground(new Color(102, 102, 102));
            yearOfBirth.setBorder(null);
            yearOfBirth.addActionListener(e -> yearOfBirthActionPerformed(e));
            panel1.add(yearOfBirth);
            yearOfBirth.setBounds(495, 355, 120, 30);

            //---- individual ----
            individual.setText("Individ");
            individual.setSelected(true);
            individual.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    individualMouseClicked(e);
                }
            });
            panel1.add(individual);
            individual.setBounds(new Rectangle(new Point(280, 430), individual.getPreferredSize()));

            //---- business ----
            business.setText("Bisnes");
            business.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    businessMouseClicked(e);
                }
            });
            panel1.add(business);
            business.setBounds(new Rectangle(new Point(340, 430), business.getPreferredSize()));

            //---- companyName ----
            companyName.setVisible(false);
            panel1.add(companyName);
            companyName.setBounds(285, 330, 330, companyName.getPreferredSize().height);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, -30, 735, 515);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(individual);
        buttonGroup1.add(business);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Tsveta Getova
    private JPanel panel1;
    private JPanel panel2;
    private JLabel ThorBankLabel;
    private JLabel label2;
    private JSeparator separator1;
    private JLabel registerForm;
    private JLabel firstName;
    private JTextField firstNameTextField;
    private JLabel lastName;
    private JTextField lastNameTextField2;
    private JLabel email;
    private JTextField emailTextField2;
    private JLabel password;
    private JTextField passwordTextField;
    private JLabel dateOfBirth;
    private JLabel isWorkingLb;
    private JRadioButton isWorking;
    private JButton registerBtn;
    private JComboBox dayOfBirth;
    private JComboBox monthOfBirth;
    private JComboBox yearOfBirth;
    private JRadioButton individual;
    private JRadioButton business;
    private JTextField companyName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}