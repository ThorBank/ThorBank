package ui;

import client.Client;
import db.GringottsBankDB;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Tsveta Getova
 */
public class Login extends JFrame {

    /**
     * Creates new form Login Form
     */

    public Login() {
        initComponents();
    }


    private void loginBtnActionPerformed(ActionEvent e) {
        Client client;
        for (int i = 0; i < GringottsBankDB.getInstance().getClientList().size(); i++) {
            if (GringottsBankDB.getInstance().getClientList().get(i).getEmail().equals(textField1.getText()) && GringottsBankDB.getInstance().getClientList().get(i).getPassword().equals(passwordF.getText())) {
                Login.super.dispose();
                new Home(GringottsBankDB.getInstance().getClientList().get(i)).setVisible(true);
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        loginPanel = new JPanel();
        second_login_panel = new JPanel();
        icon = new JLabel();
        label1 = new JLabel();
        separator1 = new JSeparator();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        label6 = new JLabel();
        label7 = new JLabel();
        second_login_panel2 = new JPanel();
        email = new JLabel();
        textField1 = new JTextField();
        password = new JLabel();
        checkBox1 = new JCheckBox();
        loginBtn = new JButton();
        loginForm = new JLabel();
        passwordF = new JTextField();

        //======== this ========
        setBackground(new Color(255, 0, 51));
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== loginPanel ========
        {
            loginPanel.setBackground(Color.white);

            // JFormDesigner evaluation mark
            loginPanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), loginPanel.getBorder())); loginPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            loginPanel.setLayout(null);

            //======== second_login_panel ========
            {
                second_login_panel.setBackground(new Color(204, 0, 51));
                second_login_panel.setLayout(null);

                //---- icon ----
                icon.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\7234-256x256x32resize.png"));
                second_login_panel.add(icon);
                icon.setBounds(new Rectangle(new Point(75, 80), icon.getPreferredSize()));

                //---- label1 ----
                label1.setText("Thor Bank");
                label1.setForeground(Color.white);
                label1.setFont(new Font("FrankRuehl", Font.BOLD, 28));
                label1.setRequestFocusEnabled(false);
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                second_login_panel.add(label1);
                label1.setBounds(165, 80, 185, 45);

                //---- separator1 ----
                separator1.setForeground(Color.white);
                separator1.setBackground(new Color(204, 204, 204));
                second_login_panel.add(separator1);
                separator1.setBounds(185, 115, 145, 15);

                //---- label2 ----
                label2.setText("some text");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
                label2.setHorizontalTextPosition(SwingConstants.RIGHT);
                label2.setHorizontalAlignment(SwingConstants.CENTER);
                second_login_panel.add(label2);
                label2.setBounds(170, 130, 170, label2.getPreferredSize().height);

                //---- label3 ----
                label3.setText("Welcome");
                label3.setForeground(Color.white);
                label3.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                second_login_panel.add(label3);
                label3.setBounds(55, 190, 170, label3.getPreferredSize().height);

                //======== scrollPane1 ========
                {
                    scrollPane1.setBackground(new Color(204, 0, 51));
                    scrollPane1.setBorder(null);

                    //---- textArea1 ----
                    textArea1.setBackground(new Color(204, 0, 51));
                    textArea1.setForeground(Color.white);
                    textArea1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    textArea1.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum.");
                    textArea1.setFont(new Font("Arial", Font.PLAIN, 16));
                    textArea1.setRows(6);
                    textArea1.setColumns(20);
                    textArea1.setLineWrap(true);
                    textArea1.setEditable(false);
                    textArea1.setBorder(null);
                    scrollPane1.setViewportView(textArea1);
                }
                second_login_panel.add(scrollPane1);
                scrollPane1.setBounds(60, 240, 330, 190);

                //---- label6 ----
                label6.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\social-facebook-button-blue-icon.png"));
                second_login_panel.add(label6);
                label6.setBounds(175, 450, 35, label6.getPreferredSize().height);

                //---- label7 ----
                label7.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\twitter-icon.png"));
                second_login_panel.add(label7);
                label7.setBounds(225, 445, 35, 40);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < second_login_panel.getComponentCount(); i++) {
                        Rectangle bounds = second_login_panel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = second_login_panel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    second_login_panel.setMinimumSize(preferredSize);
                    second_login_panel.setPreferredSize(preferredSize);
                }
            }
            loginPanel.add(second_login_panel);
            second_login_panel.setBounds(-5, 0, 440, 515);

            //======== second_login_panel2 ========
            {
                second_login_panel2.setBackground(Color.white);
                second_login_panel2.setBorder(null);
                second_login_panel2.setForeground(new Color(153, 153, 153));
                second_login_panel2.setLayout(null);

                //---- email ----
                email.setText("  e-mail");
                email.setFont(new Font("FrankRuehl", Font.BOLD, 20));
                email.setHorizontalAlignment(SwingConstants.LEFT);
                email.setBackground(new Color(225, 231, 230));
                email.setForeground(new Color(204, 204, 204));
                second_login_panel2.add(email);
                email.setBounds(55, 160, 200, 40);

                //---- textField1 ----
                textField1.setBackground(Color.white);
                textField1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
                textField1.setForeground(new Color(153, 153, 153));
                textField1.setFont(new Font("FrankRuehl", Font.BOLD, 20));
                second_login_panel2.add(textField1);
                textField1.setBounds(55, 210, 200, 40);

                //---- password ----
                password.setText("  password");
                password.setBackground(new Color(225, 231, 230));
                password.setFont(new Font("FrankRuehl", Font.BOLD, 20));
                password.setForeground(new Color(204, 204, 204));
                second_login_panel2.add(password);
                password.setBounds(55, 265, 200, 40);

                //---- checkBox1 ----
                checkBox1.setText("Remember me");
                checkBox1.setFont(new Font("FrankRuehl", Font.PLAIN, 14));
                checkBox1.setBackground(Color.white);
                checkBox1.setForeground(new Color(204, 204, 204));
                checkBox1.setBorder(null);
                second_login_panel2.add(checkBox1);
                checkBox1.setBounds(60, 370, 195, checkBox1.getPreferredSize().height);

                //---- loginBtn ----
                loginBtn.setText("LOGIN");
                loginBtn.setBackground(new Color(102, 102, 102));
                loginBtn.setForeground(Color.white);
                loginBtn.setBorder(null);
                loginBtn.addActionListener(e -> loginBtnActionPerformed(e));
                second_login_panel2.add(loginBtn);
                loginBtn.setBounds(90, 415, 125, 40);

                //---- loginForm ----
                loginForm.setText("Login Form");
                loginForm.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                loginForm.setForeground(new Color(102, 102, 102));
                second_login_panel2.add(loginForm);
                loginForm.setBounds(55, 95, 200, 40);

                //---- passwordF ----
                passwordF.setBackground(Color.white);
                passwordF.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
                passwordF.setForeground(new Color(153, 153, 153));
                passwordF.setFont(new Font("FrankRuehl", Font.BOLD, 20));
                second_login_panel2.add(passwordF);
                passwordF.setBounds(55, 315, 200, 40);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < second_login_panel2.getComponentCount(); i++) {
                        Rectangle bounds = second_login_panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = second_login_panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    second_login_panel2.setMinimumSize(preferredSize);
                    second_login_panel2.setPreferredSize(preferredSize);
                }
            }
            loginPanel.add(second_login_panel2);
            second_login_panel2.setBounds(435, 0, 300, 515);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < loginPanel.getComponentCount(); i++) {
                    Rectangle bounds = loginPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = loginPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                loginPanel.setMinimumSize(preferredSize);
                loginPanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(loginPanel);
        loginPanel.setBounds(-5, -30, 735, 515);

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
    private JPanel loginPanel;
    private JPanel second_login_panel;
    private JLabel icon;
    private JLabel label1;
    private JSeparator separator1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JLabel label6;
    private JLabel label7;
    private JPanel second_login_panel2;
    private JLabel email;
    private JTextField textField1;
    private JLabel password;
    private JCheckBox checkBox1;
    private JButton loginBtn;
    private JLabel loginForm;
    private JTextField passwordF;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
