package ui;

import client.BankOnWebAlreadyExistsException;
import client.BusinessClient;
import client.Client;
import client.IndividualClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

/**
 * @author Tsveta Getova
 */
public class Home extends JFrame {
    private Client client;
    public Home(Client client) {
        this.client = client;
        initComponents();
        firstName.setText(client.getFirstName());
        lastName.setText(client.getLastName());
        email.setText(client.getEmail());
        birth.setText(client.getDateofBirth().get(Calendar.YEAR) + ":" + client.getDateofBirth().get(Calendar.MONTH) + ":" + client.getDateofBirth().get(Calendar.DAY_OF_MONTH));
        if (client instanceof IndividualClient){
            if (client.getBankOnWeb() == null){
                bankOnWebUpdate.setText("Create BankOnWeb");
                bankOnWeb.setVisible(false);
            }
            else if (client.getBankOnWebPro() == null){
                bankOnWebUpdate.setText("Update BankOnWebPro");
                bankOnWeb.setText("BankOnWebPro");
            }
            else {
                bankOnWebUpdate.setVisible(false);
                bankOnWeb.setText("BankOnWeb");
            }
        }
        else {
            if (((BusinessClient)client).getFactorConnect() == null){
                bankOnWebUpdate.setText("Create Factor Connect");
                bankOnWeb.setVisible(false);
            }
            else {
                bankOnWebUpdate.setVisible(false);
                bankOnWeb.setText("Factor Connect");
            }
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void bankOnWebUpdateMouseClicked(MouseEvent e) throws BankOnWebAlreadyExistsException {
        if (client instanceof IndividualClient){
            if (client.getBankOnWeb() == null){
                bankOnWebUpdate.setText("Update BankOnWeb");
                client.createBankOnWeb();
                bankOnWeb.setText("BankOnWeb");
                bankOnWeb.setVisible(true);
            }
            else if (client.getBankOnWebPro() == null){
                bankOnWebUpdate.setVisible(false);
                client.createBankOnWebPro();
                bankOnWeb.setText("BankOnWebPro");
            }
        }
        else {
            if (((BusinessClient)client).getFactorConnect() == null) {
                bankOnWebUpdate.setVisible(false);
                bankOnWeb.setText("Factor Connect");
            }
        }
    }

    private void bankOnWebMouseClicked(MouseEvent e) {
        if (bankOnWeb.getText().equals("BankOnWeb")){
            Home.super.dispose();
            new BankOnWeb(client).setVisible(true);
        }
        else if (bankOnWeb.getText().equals("BankOnWebPro")) {
            Home.super.dispose();
            new BankOnWebPro(client).setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        panel1 = new JPanel();
        panel2 = new JPanel();
        icon = new JLabel();
        ThorBankLabel = new JLabel();
        separator1 = new JSeparator();
        home = new JLabel();
        separator2 = new JSeparator();
        firstName = new JLabel();
        lastName = new JLabel();
        email = new JLabel();
        birth = new JLabel();
        bankOnWebUpdate = new JButton();
        bankOnWeb = new JButton();

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

                //---- icon ----
                icon.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\7234-256x256x32resize.png"));
                panel2.add(icon);
                icon.setBounds(15, 35, 80, 80);

                //---- ThorBankLabel ----
                ThorBankLabel.setText("Thor Bank");
                ThorBankLabel.setForeground(Color.white);
                ThorBankLabel.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                ThorBankLabel.setRequestFocusEnabled(false);
                ThorBankLabel.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(ThorBankLabel);
                ThorBankLabel.setBounds(105, 45, 185, 55);

                //---- separator1 ----
                separator1.setBackground(Color.white);
                separator1.setForeground(Color.white);
                separator1.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator1);
                separator1.setBounds(105, 85, 140, 25);

                //---- home ----
                home.setText("Home Page  ");
                home.setBackground(new Color(204, 0, 51));
                home.setForeground(Color.white);
                home.setHorizontalAlignment(SwingConstants.RIGHT);
                home.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                panel2.add(home);
                home.setBounds(505, 50, 225, 40);

                //---- separator2 ----
                separator2.setBackground(Color.white);
                separator2.setForeground(Color.white);
                separator2.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator2);
                separator2.setBounds(565, 85, 155, 30);

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
            panel1.add(firstName);
            firstName.setBounds(45, 210, 160, 30);
            panel1.add(lastName);
            lastName.setBounds(45, 240, 160, 30);
            panel1.add(email);
            email.setBounds(45, 270, 160, 30);
            panel1.add(birth);
            birth.setBounds(45, 300, 160, 30);

            //---- bankOnWebUpdate ----
            bankOnWebUpdate.setText("Create BankOnWeb");
            bankOnWebUpdate.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            bankOnWebUpdate.setBackground(new Color(102, 102, 102));
            bankOnWebUpdate.setBorder(null);
            bankOnWebUpdate.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        bankOnWebUpdateMouseClicked(e);
                    } catch (BankOnWebAlreadyExistsException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(bankOnWebUpdate);
            bankOnWebUpdate.setBounds(535, 240, 170, 55);

            //---- bankOnWeb ----
            bankOnWeb.setText("Create BankOnWeb");
            bankOnWeb.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            bankOnWeb.setBackground(new Color(102, 102, 102));
            bankOnWeb.setBorder(null);
            bankOnWeb.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bankOnWebMouseClicked(e);
                }
            });
            panel1.add(bankOnWeb);
            bankOnWeb.setBounds(535, 310, 170, 55);

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
        panel1.setBounds(-10, -30, 735, 515);

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
    private JLabel icon;
    private JLabel ThorBankLabel;
    private JSeparator separator1;
    private JLabel home;
    private JSeparator separator2;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private JLabel birth;
    private JButton bankOnWebUpdate;
    private JButton bankOnWeb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
