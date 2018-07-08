package ui;

import client.Client;
import db.GringottsBankDB;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                .filter((client) -> client.getEmail().equals(email.getText()))
                .anyMatch(client -> true) && !firstName.getText().toString().isEmpty() && !lastName.getText().toString().isEmpty()
                && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {

            GringottsBankDB.getInstance().getClientList().add(new Client(firstName.getText().toString(), lastName.getText().toString(),
                    email.getText().toString(), password.getText().toString(), new GregorianCalendar(Integer.parseInt(yearOfBirth.getSelectedItem().toString()), Integer.parseInt(monthOfBirth.getSelectedItem().toString()), Integer.parseInt(dayOfBirth.getSelectedItem().toString())), isWorking.isSelected()));
            Register.super.dispose();
            new Login().setVisible(true);
        }
    }

    private void backTologinBtnMouseClicked(MouseEvent e) {
        // TODO add your code here
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
        passwordField1 = new JPasswordField();
        dateOfBirth = new JLabel();
        isWorkingLb = new JLabel();
        isWorking = new JRadioButton();
        backToLoginBtn = new JButton();
        registerBtn = new JButton();
        dayOfBirth = new JComboBox();
        monthOfBirth = new JComboBox();
        yearOfBirth = new JComboBox();

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
                    " ", javax.swing.border.TitledBorder.CENTER,
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

            //---- passwordField1 ----
            passwordField1.setBackground(Color.white);
            passwordField1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            passwordField1.setFont(new Font("FrankRuehl", Font.BOLD, 20));
            panel1.add(passwordField1);
            passwordField1.setBounds(285, 290, 330, 35);

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

            //---- backToLoginBtn ----
            backToLoginBtn.setText("GO TO LOGIN");
            backToLoginBtn.setBackground(new Color(102, 102, 102));
            backToLoginBtn.setForeground(Color.white);
            backToLoginBtn.setBorder(null);
            backToLoginBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    backTologinBtnMouseClicked(e);
                }
            });
            panel1.add(backToLoginBtn);
            backToLoginBtn.setBounds(285, 410, 160, 55);

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
            panel1.add(dayOfBirth);
            dayOfBirth.setBounds(285, 355, 65, dayOfBirth.getPreferredSize().height);

            //---- monthOfBirth ----
            monthOfBirth.setMaximumRowCount(31);
            monthOfBirth.setName("day");
            monthOfBirth.setSelectedIndex(-1);
            monthOfBirth.setBackground(new Color(102, 102, 102));
            monthOfBirth.setBorder(null);
            panel1.add(monthOfBirth);
            monthOfBirth.setBounds(360, 355, 125, 30);

            //---- yearOfBirth ----
            yearOfBirth.setMaximumRowCount(31);
            yearOfBirth.setName("day");
            yearOfBirth.setSelectedIndex(-1);
            yearOfBirth.setBackground(new Color(102, 102, 102));
            yearOfBirth.setBorder(null);
            panel1.add(yearOfBirth);
            yearOfBirth.setBounds(495, 355, 120, 30);

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
    private JPasswordField passwordField1;
    private JLabel dateOfBirth;
    private JLabel isWorkingLb;
    private JRadioButton isWorking;
    private JButton backToLoginBtn;
    private JButton registerBtn;
    private JComboBox dayOfBirth;
    private JComboBox monthOfBirth;
    private JComboBox yearOfBirth;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
