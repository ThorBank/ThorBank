/*
 * Created by JFormDesigner on Mon Jul 09 12:43:29 EEST 2018
 */

package ui;

import client.Client;
import webbanking.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Tsveta Getova
 */
public class BankOnWebPro extends JFrame {
    private Client client;
    public BankOnWebPro(Client client) {
        this.client = client;
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BGN, EUR, USD, AUD, NOK
        applyingForABillCurrency.addItem(Currency.AUD);
        applyingForABillCurrency.addItem(Currency.BGN);
        applyingForABillCurrency.addItem(Currency.EUR);
        applyingForABillCurrency.addItem(Currency.NOK);
        applyingForABillCurrency.addItem(Currency.USD);
    }

    private void applyingForABillBtnMouseClicked(MouseEvent e) {
        client.applyForAbill((Currency)applyingForABillCurrency.getSelectedItem(), Double.parseDouble(applyingForABillBalance.getText()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        panel1 = new JPanel();
        panel3 = new JPanel();
        icon2 = new JLabel();
        ThorBankLabel2 = new JLabel();
        separator3 = new JSeparator();
        bankOnWebPro = new JLabel();
        separator4 = new JSeparator();
        payCreditLable = new JLabel();
        injectMoneyInDebitLable = new JLabel();
        withdrawMoneyFromDebit = new JLabel();
        applyingForAIndefiniteDebit = new JLabel();
        applyingForATermDebit = new JLabel();
        applyingForAConsumerCredit = new JLabel();
        applyingForAHousingCredit = new JLabel();
        applyForCreditCard = new JLabel();
        applyingForADebitCard = new JLabel();
        applyingForABill = new JLabel();
        applyingForABillCurrency = new JComboBox();
        applyingForABillBalance = new JTextField();
        applyingForABillBtn = new JButton();

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

            //======== panel3 ========
            {
                panel3.setBackground(new Color(204, 0, 51));
                panel3.setLayout(null);

                //---- icon2 ----
                icon2.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\7234-256x256x32resize.png"));
                panel3.add(icon2);
                icon2.setBounds(15, 20, 80, 80);

                //---- ThorBankLabel2 ----
                ThorBankLabel2.setText("Thor Bank");
                ThorBankLabel2.setForeground(Color.white);
                ThorBankLabel2.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                ThorBankLabel2.setRequestFocusEnabled(false);
                ThorBankLabel2.setHorizontalAlignment(SwingConstants.LEFT);
                panel3.add(ThorBankLabel2);
                ThorBankLabel2.setBounds(105, 35, 185, 55);

                //---- separator3 ----
                separator3.setBackground(Color.white);
                separator3.setForeground(Color.white);
                separator3.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel3.add(separator3);
                separator3.setBounds(105, 75, 140, 30);

                //---- bankOnWebPro ----
                bankOnWebPro.setText("Bank On Web");
                bankOnWebPro.setBackground(new Color(204, 0, 51));
                bankOnWebPro.setForeground(Color.white);
                bankOnWebPro.setHorizontalAlignment(SwingConstants.RIGHT);
                bankOnWebPro.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                panel3.add(bankOnWebPro);
                bankOnWebPro.setBounds(565, 45, 265, 40);

                //---- separator4 ----
                separator4.setBackground(Color.white);
                separator4.setForeground(Color.white);
                separator4.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel3.add(separator4);
                separator4.setBounds(645, 80, 190, 30);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(0, 0, 845, 120);

            //---- payCreditLable ----
            payCreditLable.setText("Pay Credit");
            panel1.add(payCreditLable);
            payCreditLable.setBounds(20, 145, 115, 40);

            //---- injectMoneyInDebitLable ----
            injectMoneyInDebitLable.setText("Inject Money In Debit");
            panel1.add(injectMoneyInDebitLable);
            injectMoneyInDebitLable.setBounds(new Rectangle(new Point(20, 230), injectMoneyInDebitLable.getPreferredSize()));

            //---- withdrawMoneyFromDebit ----
            withdrawMoneyFromDebit.setText("withdrawMoneyFromDebit");
            panel1.add(withdrawMoneyFromDebit);
            withdrawMoneyFromDebit.setBounds(new Rectangle(new Point(20, 285), withdrawMoneyFromDebit.getPreferredSize()));

            //---- applyingForAIndefiniteDebit ----
            applyingForAIndefiniteDebit.setText("applyingForAIndefiniteDebit");
            panel1.add(applyingForAIndefiniteDebit);
            applyingForAIndefiniteDebit.setBounds(new Rectangle(new Point(15, 330), applyingForAIndefiniteDebit.getPreferredSize()));

            //---- applyingForATermDebit ----
            applyingForATermDebit.setText("applyingForATermDebit");
            panel1.add(applyingForATermDebit);
            applyingForATermDebit.setBounds(new Rectangle(new Point(25, 380), applyingForATermDebit.getPreferredSize()));

            //---- applyingForAConsumerCredit ----
            applyingForAConsumerCredit.setText("applyingForAConsumerCredit");
            panel1.add(applyingForAConsumerCredit);
            applyingForAConsumerCredit.setBounds(new Rectangle(new Point(20, 430), applyingForAConsumerCredit.getPreferredSize()));

            //---- applyingForAHousingCredit ----
            applyingForAHousingCredit.setText("applyingForAHousingCredit");
            panel1.add(applyingForAHousingCredit);
            applyingForAHousingCredit.setBounds(new Rectangle(new Point(20, 480), applyingForAHousingCredit.getPreferredSize()));

            //---- applyForCreditCard ----
            applyForCreditCard.setText("applyForCreditCard");
            panel1.add(applyForCreditCard);
            applyForCreditCard.setBounds(new Rectangle(new Point(30, 530), applyForCreditCard.getPreferredSize()));

            //---- applyingForADebitCard ----
            applyingForADebitCard.setText("applyingForADebitCard");
            panel1.add(applyingForADebitCard);
            applyingForADebitCard.setBounds(new Rectangle(new Point(25, 590), applyingForADebitCard.getPreferredSize()));

            //---- applyingForABill ----
            applyingForABill.setText("applyingForABill");
            panel1.add(applyingForABill);
            applyingForABill.setBounds(new Rectangle(new Point(35, 650), applyingForABill.getPreferredSize()));
            panel1.add(applyingForABillCurrency);
            applyingForABillCurrency.setBounds(165, 655, 165, applyingForABillCurrency.getPreferredSize().height);
            panel1.add(applyingForABillBalance);
            applyingForABillBalance.setBounds(375, 655, 160, applyingForABillBalance.getPreferredSize().height);

            //---- applyingForABillBtn ----
            applyingForABillBtn.setText("CREATE");
            applyingForABillBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForABillBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForABillBtn);
            applyingForABillBtn.setBounds(new Rectangle(new Point(690, 665), applyingForABillBtn.getPreferredSize()));

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
        panel1.setBounds(-5, -5, 860, 715);

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
    private JPanel panel3;
    private JLabel icon2;
    private JLabel ThorBankLabel2;
    private JSeparator separator3;
    private JLabel bankOnWebPro;
    private JSeparator separator4;
    private JLabel payCreditLable;
    private JLabel injectMoneyInDebitLable;
    private JLabel withdrawMoneyFromDebit;
    private JLabel applyingForAIndefiniteDebit;
    private JLabel applyingForATermDebit;
    private JLabel applyingForAConsumerCredit;
    private JLabel applyingForAHousingCredit;
    private JLabel applyForCreditCard;
    private JLabel applyingForADebitCard;
    private JLabel applyingForABill;
    private JComboBox applyingForABillCurrency;
    private JTextField applyingForABillBalance;
    private JButton applyingForABillBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
