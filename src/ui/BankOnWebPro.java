/*
 * Created by JFormDesigner on Mon Jul 09 12:43:29 EEST 2018
 */

package ui;

import card.CardNumberFormatException;
import card.CreditCardPaymentNetwork;
import card.DebitCardPaymentNetwork;
import card.NotEnoughMoneyInCardException;
import client.Client;
import db.GringottsBankDB;
import debit.Debit;
import webbanking.Bill;
import webbanking.Currency;

import javax.swing.*;
import javax.swing.border.MatteBorder;
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
        applyingForADebitCardPaymentNetwork.addItem(DebitCardPaymentNetwork.MAESTRO);
        applyingForADebitCardPaymentNetwork.addItem(DebitCardPaymentNetwork.MASTER_CARD);
        applyingForADebitCardPaymentNetwork.addItem(DebitCardPaymentNetwork.STAR);
        applyingForADebitCardPaymentNetwork.addItem(DebitCardPaymentNetwork.VISA);
        applyingForADebitCardCurrency.addItem(Currency.AUD);
        applyingForADebitCardCurrency.addItem(Currency.BGN);
        applyingForADebitCardCurrency.addItem(Currency.EUR);
        applyingForADebitCardCurrency.addItem(Currency.NOK);
        applyingForADebitCardCurrency.addItem(Currency.USD);
        for (int i = 0; i < client.getBillList().size(); i++){
            applyingForADebitCardBill.addItem(client.getBillList().get(i));
            injectMoneyInDebitBill.addItem(client.getBillList().get(i));
        }
        applyForCreditCardPaymentNetwork.addItem(CreditCardPaymentNetwork.MASTER_CARD);
        applyForCreditCardPaymentNetwork.addItem(CreditCardPaymentNetwork.VISA);
        applyForCreditCardPaymentNetwork.addItem(CreditCardPaymentNetwork.AMERICAN_EXPRESS);
        applyForCreditCardPaymentNetwork.addItem(CreditCardPaymentNetwork.DISCOVER);
        applyForCreditCardPaymentNetwork.addItem(CreditCardPaymentNetwork.UNION_PAY);
        applyForCreditCardCurrency.addItem(Currency.AUD);
        applyForCreditCardCurrency.addItem(Currency.BGN);
        applyForCreditCardCurrency.addItem(Currency.EUR);
        applyForCreditCardCurrency.addItem(Currency.NOK);
        applyForCreditCardCurrency.addItem(Currency.USD);
        for (int i = 0; i < GringottsBankDB.getInstance().getClientList().size(); i++){
            applyingForAConsumerCreditGuarantor.addItem(GringottsBankDB.getInstance().getClientList().get(i));
        }
        for (int i = 0; i < client.getDebitList().size(); i++){
            withdrawMoneyFromDebitDebit.addItem(client.getDebitList().get(i));
        }
        for (int i = 0; i < client.getDebitList().size(); i++){
            injectMoneyInDebitDebit.addItem(client.getDebitList().get(i));
        }
    }

    private void applyingForABillBtnMouseClicked(MouseEvent e) {
        client.applyForAbill((Currency)applyingForABillCurrency.getSelectedItem(), Double.parseDouble(applyingForABillBalance.getText()));
        applyingForADebitCardBill.removeAllItems();
        withdrawMoneyFromDebitBill.removeAllItems();
        injectMoneyInDebitBill.removeAllItems();
        for (int i = 0; i < client.getBillList().size(); i++){
            applyingForADebitCardBill.addItem(client.getBillList().get(i));
            withdrawMoneyFromDebitBill.addItem(client.getBillList().get(i));
            injectMoneyInDebitBill.addItem(client.getBillList().get(i));
        }

    }

    private void applyingForADebitCardBtnMouseClicked(MouseEvent e) throws CardNumberFormatException {
        client.applyForDebitCard((DebitCardPaymentNetwork)applyingForADebitCardPaymentNetwork.getSelectedItem(), Double.parseDouble(applyingForADebitCardBalance.getText()), (Currency)applyingForADebitCardCurrency.getSelectedItem(), (Bill)applyingForADebitCardBill.getSelectedItem());
        System.out.println(client.getCardList().size());

    }

    private void applyForCreditCardBtnMouseClicked(MouseEvent e) throws CardNumberFormatException {
        client.applyForCreditCard((CreditCardPaymentNetwork)applyForCreditCardPaymentNetwork.getSelectedItem(), Double.parseDouble(applyForCreditCardBalance.getText()), (Currency)applyForCreditCardCurrency.getSelectedItem());
        System.out.println(client.getCardList().size());
    }

    private void applyingForAHousingCreditBtnMouseClicked(MouseEvent e) {
        client.applyingForAHousingCredit(Double.parseDouble(applyingForAHousingCreditBalance.getText()), Integer.parseInt(applyingForAHousingCreditPeriodInMonths.getText()));
        System.out.println(client.getCreditList().size());
    }

    private void applyingForAConsumerCreditBtnMouseClicked(MouseEvent e) {
        client.applyingForAConsumerCredit((Client)applyingForAConsumerCreditGuarantor.getSelectedItem(), Double.parseDouble(applyingForAConsumerCreditBalance.getText()), Integer.parseInt(applyingForAConsumerCreditPeriodInMonths.getText()));
        System.out.println(client.getCreditList().size());
    }

    private void applyingForATermDebitBtnMouseClicked(MouseEvent e) {
        client.applyingForATermDebit(Double.parseDouble(applyingForATermDebitBalance.getText()), Integer.parseInt(applyingForATermDebitTimeInMOnths.getText()));
        System.out.println(client.getDebitList().size());
        withdrawMoneyFromDebitDebit.removeAllItems();
        injectMoneyInDebitDebit.removeAllItems();
        for (int i = 0; i < client.getDebitList().size(); i++){
            withdrawMoneyFromDebitDebit.addItem(client.getDebitList().get(i));
            injectMoneyInDebitDebit.addItem(client.getDebitList().get(i));
        }
    }

    private void applyingForAIndefiniteDebitBtnMouseClicked(MouseEvent e) {
        client.applyingForAIndefiniteDebit(Double.parseDouble(applyingForAIndefiniteDebitBalance.getText()));
        withdrawMoneyFromDebitDebit.removeAllItems();
        injectMoneyInDebitDebit.removeAllItems();
        for (int i = 0; i < client.getDebitList().size(); i++){
            withdrawMoneyFromDebitDebit.addItem(client.getDebitList().get(i));
            injectMoneyInDebitDebit.addItem(client.getDebitList().get(i));
        }
    }

    private void withdrawMoneyFromDebitBtnMouseClicked(MouseEvent e) throws NotEnoughMoneyInCardException {
        client.withdrawMoneyFromDebit((Debit)withdrawMoneyFromDebitDebit.getSelectedItem(), (Bill)withdrawMoneyFromDebitBill.getSelectedItem(), Double.parseDouble(withdrawMoneyFromDebitAmount.getText()));
        //System.out.println(client.getDebitList().size());
    }

    private void injectMoneyInDebitBtnMouseClicked(MouseEvent e) {
        client.injectMoneyInDebit((Debit)injectMoneyInDebitDebit.getSelectedItem(), (Bill)injectMoneyInDebitBill.getSelectedItem(), Double.parseDouble(injectMoneyInDebitAmount.getText()));
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
        applyingForADebitCardPaymentNetwork = new JComboBox();
        applyingForADebitCardBalance = new JTextField();
        applyingForADebitCardCurrency = new JComboBox();
        applyingForADebitCardBill = new JComboBox();
        applyingForADebitCardBtn = new JButton();
        applyForCreditCardPaymentNetwork = new JComboBox();
        applyForCreditCardBalance = new JTextField();
        applyForCreditCardCurrency = new JComboBox();
        applyForCreditCardBtn = new JButton();
        applyingForAHousingCreditBalance = new JTextField();
        applyingForAHousingCreditPeriodInMonths = new JTextField();
        applyingForAHousingCreditBtn = new JButton();
        applyingForAConsumerCreditGuarantor = new JComboBox();
        applyingForAConsumerCreditBalance = new JTextField();
        applyingForAConsumerCreditPeriodInMonths = new JTextField();
        applyingForAConsumerCreditBtn = new JButton();
        applyingForATermDebitBalance = new JTextField();
        applyingForATermDebitTimeInMOnths = new JTextField();
        applyingForATermDebitBtn = new JButton();
        applyingForAIndefiniteDebitBalance = new JTextField();
        applyingForAIndefiniteDebitBtn = new JButton();
        withdrawMoneyFromDebitDebit = new JComboBox();
        withdrawMoneyFromDebitBill = new JComboBox();
        withdrawMoneyFromDebitAmount = new JTextField();
        withdrawMoneyFromDebitBtn = new JButton();
        injectMoneyInDebitDebit = new JComboBox();
        injectMoneyInDebitBill = new JComboBox();
        injectMoneyInDebitAmount = new JTextField();
        injectMoneyInDebitBtn = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setName("1\n2\n3\n4\n5");
            panel1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));

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
            payCreditLable.setBounds(35, 150, 115, 40);

            //---- injectMoneyInDebitLable ----
            injectMoneyInDebitLable.setText("Inject Money In Debit");
            panel1.add(injectMoneyInDebitLable);
            injectMoneyInDebitLable.setBounds(new Rectangle(new Point(25, 225), injectMoneyInDebitLable.getPreferredSize()));

            //---- withdrawMoneyFromDebit ----
            withdrawMoneyFromDebit.setText("Withdraw Money From Debit");
            panel1.add(withdrawMoneyFromDebit);
            withdrawMoneyFromDebit.setBounds(new Rectangle(new Point(20, 275), withdrawMoneyFromDebit.getPreferredSize()));

            //---- applyingForAIndefiniteDebit ----
            applyingForAIndefiniteDebit.setText("Apply For an IndefiniteDebit");
            panel1.add(applyingForAIndefiniteDebit);
            applyingForAIndefiniteDebit.setBounds(new Rectangle(new Point(15, 335), applyingForAIndefiniteDebit.getPreferredSize()));

            //---- applyingForATermDebit ----
            applyingForATermDebit.setText("Apply For an Term Debit");
            panel1.add(applyingForATermDebit);
            applyingForATermDebit.setBounds(new Rectangle(new Point(25, 385), applyingForATermDebit.getPreferredSize()));

            //---- applyingForAConsumerCredit ----
            applyingForAConsumerCredit.setText("Apply For A Consumer Credit");
            panel1.add(applyingForAConsumerCredit);
            applyingForAConsumerCredit.setBounds(new Rectangle(new Point(20, 440), applyingForAConsumerCredit.getPreferredSize()));

            //---- applyingForAHousingCredit ----
            applyingForAHousingCredit.setText("Apply For A Housing Credit");
            panel1.add(applyingForAHousingCredit);
            applyingForAHousingCredit.setBounds(new Rectangle(new Point(25, 490), applyingForAHousingCredit.getPreferredSize()));

            //---- applyForCreditCard ----
            applyForCreditCard.setText("Apply For Credit Card");
            panel1.add(applyForCreditCard);
            applyForCreditCard.setBounds(new Rectangle(new Point(40, 545), applyForCreditCard.getPreferredSize()));

            //---- applyingForADebitCard ----
            applyingForADebitCard.setText("Applying For A Debit Card");
            panel1.add(applyingForADebitCard);
            applyingForADebitCard.setBounds(new Rectangle(new Point(30, 600), applyingForADebitCard.getPreferredSize()));

            //---- applyingForABill ----
            applyingForABill.setText("Apply For A Bill");
            panel1.add(applyingForABill);
            applyingForABill.setBounds(new Rectangle(new Point(45, 640), applyingForABill.getPreferredSize()));

            //---- applyingForABillCurrency ----
            applyingForABillCurrency.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForABillCurrency.setBackground(Color.white);
            panel1.add(applyingForABillCurrency);
            applyingForABillCurrency.setBounds(190, 630, 165, applyingForABillCurrency.getPreferredSize().height);

            //---- applyingForABillBalance ----
            applyingForABillBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForABillBalance.setBackground(Color.white);
            panel1.add(applyingForABillBalance);
            applyingForABillBalance.setBounds(370, 630, 170, 30);

            //---- applyingForABillBtn ----
            applyingForABillBtn.setText("APPLY");
            applyingForABillBtn.setBackground(new Color(102, 102, 102));
            applyingForABillBtn.setBorder(null);
            applyingForABillBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForABillBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForABillBtn);
            applyingForABillBtn.setBounds(730, 630, 110, applyingForABillBtn.getPreferredSize().height);

            //---- applyingForADebitCardPaymentNetwork ----
            applyingForADebitCardPaymentNetwork.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForADebitCardPaymentNetwork.setBackground(Color.white);
            panel1.add(applyingForADebitCardPaymentNetwork);
            applyingForADebitCardPaymentNetwork.setBounds(195, 585, 125, applyingForADebitCardPaymentNetwork.getPreferredSize().height);

            //---- applyingForADebitCardBalance ----
            applyingForADebitCardBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForADebitCardBalance.setBackground(Color.white);
            panel1.add(applyingForADebitCardBalance);
            applyingForADebitCardBalance.setBounds(330, 585, 115, 30);

            //---- applyingForADebitCardCurrency ----
            applyingForADebitCardCurrency.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForADebitCardCurrency.setBackground(Color.white);
            panel1.add(applyingForADebitCardCurrency);
            applyingForADebitCardCurrency.setBounds(455, 585, 115, applyingForADebitCardCurrency.getPreferredSize().height);

            //---- applyingForADebitCardBill ----
            applyingForADebitCardBill.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForADebitCardBill.setBackground(Color.white);
            panel1.add(applyingForADebitCardBill);
            applyingForADebitCardBill.setBounds(575, 585, 140, applyingForADebitCardBill.getPreferredSize().height);

            //---- applyingForADebitCardBtn ----
            applyingForADebitCardBtn.setText("APPLY");
            applyingForADebitCardBtn.setBackground(new Color(102, 102, 102));
            applyingForADebitCardBtn.setBorder(null);
            applyingForADebitCardBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        applyingForADebitCardBtnMouseClicked(e);
                    } catch (CardNumberFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(applyingForADebitCardBtn);
            applyingForADebitCardBtn.setBounds(730, 585, 110, applyingForADebitCardBtn.getPreferredSize().height);

            //---- applyForCreditCardPaymentNetwork ----
            applyForCreditCardPaymentNetwork.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyForCreditCardPaymentNetwork.setBackground(Color.white);
            panel1.add(applyForCreditCardPaymentNetwork);
            applyForCreditCardPaymentNetwork.setBounds(190, 535, 145, applyForCreditCardPaymentNetwork.getPreferredSize().height);

            //---- applyForCreditCardBalance ----
            applyForCreditCardBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyForCreditCardBalance.setBackground(Color.white);
            panel1.add(applyForCreditCardBalance);
            applyForCreditCardBalance.setBounds(365, 535, 175, applyForCreditCardBalance.getPreferredSize().height);

            //---- applyForCreditCardCurrency ----
            applyForCreditCardCurrency.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyForCreditCardCurrency.setBackground(Color.white);
            panel1.add(applyForCreditCardCurrency);
            applyForCreditCardCurrency.setBounds(575, 535, 135, applyForCreditCardCurrency.getPreferredSize().height);

            //---- applyForCreditCardBtn ----
            applyForCreditCardBtn.setText("APPLY");
            applyForCreditCardBtn.setBackground(new Color(102, 102, 102));
            applyForCreditCardBtn.setBorder(null);
            applyForCreditCardBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        applyForCreditCardBtnMouseClicked(e);
                    } catch (CardNumberFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(applyForCreditCardBtn);
            applyForCreditCardBtn.setBounds(730, 535, 110, applyForCreditCardBtn.getPreferredSize().height);

            //---- applyingForAHousingCreditBalance ----
            applyingForAHousingCreditBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAHousingCreditBalance.setBackground(Color.white);
            panel1.add(applyingForAHousingCreditBalance);
            applyingForAHousingCreditBalance.setBounds(185, 480, 150, applyingForAHousingCreditBalance.getPreferredSize().height);

            //---- applyingForAHousingCreditPeriodInMonths ----
            applyingForAHousingCreditPeriodInMonths.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAHousingCreditPeriodInMonths.setBackground(Color.white);
            panel1.add(applyingForAHousingCreditPeriodInMonths);
            applyingForAHousingCreditPeriodInMonths.setBounds(365, 480, 175, applyingForAHousingCreditPeriodInMonths.getPreferredSize().height);

            //---- applyingForAHousingCreditBtn ----
            applyingForAHousingCreditBtn.setText("APPLY");
            applyingForAHousingCreditBtn.setBackground(new Color(102, 102, 102));
            applyingForAHousingCreditBtn.setBorder(null);
            applyingForAHousingCreditBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForAHousingCreditBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForAHousingCreditBtn);
            applyingForAHousingCreditBtn.setBounds(730, 485, 110, applyingForAHousingCreditBtn.getPreferredSize().height);

            //---- applyingForAConsumerCreditGuarantor ----
            applyingForAConsumerCreditGuarantor.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAConsumerCreditGuarantor.setBackground(Color.white);
            panel1.add(applyingForAConsumerCreditGuarantor);
            applyingForAConsumerCreditGuarantor.setBounds(185, 430, 150, applyingForAConsumerCreditGuarantor.getPreferredSize().height);

            //---- applyingForAConsumerCreditBalance ----
            applyingForAConsumerCreditBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAConsumerCreditBalance.setBackground(Color.white);
            panel1.add(applyingForAConsumerCreditBalance);
            applyingForAConsumerCreditBalance.setBounds(365, 430, 175, applyingForAConsumerCreditBalance.getPreferredSize().height);

            //---- applyingForAConsumerCreditPeriodInMonths ----
            applyingForAConsumerCreditPeriodInMonths.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAConsumerCreditPeriodInMonths.setBackground(Color.white);
            panel1.add(applyingForAConsumerCreditPeriodInMonths);
            applyingForAConsumerCreditPeriodInMonths.setBounds(560, 430, 145, applyingForAConsumerCreditPeriodInMonths.getPreferredSize().height);

            //---- applyingForAConsumerCreditBtn ----
            applyingForAConsumerCreditBtn.setText("APPLY");
            applyingForAConsumerCreditBtn.setBackground(new Color(102, 102, 102));
            applyingForAConsumerCreditBtn.setBorder(null);
            applyingForAConsumerCreditBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForAConsumerCreditBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForAConsumerCreditBtn);
            applyingForAConsumerCreditBtn.setBounds(730, 430, 110, 30);

            //---- applyingForATermDebitBalance ----
            applyingForATermDebitBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForATermDebitBalance.setBackground(Color.white);
            panel1.add(applyingForATermDebitBalance);
            applyingForATermDebitBalance.setBounds(185, 375, 145, applyingForATermDebitBalance.getPreferredSize().height);

            //---- applyingForATermDebitTimeInMOnths ----
            applyingForATermDebitTimeInMOnths.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForATermDebitTimeInMOnths.setBackground(Color.white);
            panel1.add(applyingForATermDebitTimeInMOnths);
            applyingForATermDebitTimeInMOnths.setBounds(365, 375, 170, applyingForATermDebitTimeInMOnths.getPreferredSize().height);

            //---- applyingForATermDebitBtn ----
            applyingForATermDebitBtn.setText("APPLY");
            applyingForATermDebitBtn.setBackground(new Color(102, 102, 102));
            applyingForATermDebitBtn.setBorder(null);
            applyingForATermDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForATermDebitBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForATermDebitBtn);
            applyingForATermDebitBtn.setBounds(730, 370, 110, applyingForATermDebitBtn.getPreferredSize().height);

            //---- applyingForAIndefiniteDebitBalance ----
            applyingForAIndefiniteDebitBalance.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            applyingForAIndefiniteDebitBalance.setBackground(Color.white);
            panel1.add(applyingForAIndefiniteDebitBalance);
            applyingForAIndefiniteDebitBalance.setBounds(185, 325, 145, applyingForAIndefiniteDebitBalance.getPreferredSize().height);

            //---- applyingForAIndefiniteDebitBtn ----
            applyingForAIndefiniteDebitBtn.setText("APPLY");
            applyingForAIndefiniteDebitBtn.setBackground(new Color(102, 102, 102));
            applyingForAIndefiniteDebitBtn.setBorder(null);
            applyingForAIndefiniteDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForAIndefiniteDebitBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForAIndefiniteDebitBtn);
            applyingForAIndefiniteDebitBtn.setBounds(730, 320, 110, applyingForAIndefiniteDebitBtn.getPreferredSize().height);

            //---- withdrawMoneyFromDebitDebit ----
            withdrawMoneyFromDebitDebit.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            withdrawMoneyFromDebitDebit.setBackground(Color.white);
            panel1.add(withdrawMoneyFromDebitDebit);
            withdrawMoneyFromDebitDebit.setBounds(185, 270, 150, withdrawMoneyFromDebitDebit.getPreferredSize().height);

            //---- withdrawMoneyFromDebitBill ----
            withdrawMoneyFromDebitBill.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            withdrawMoneyFromDebitBill.setBackground(Color.white);
            panel1.add(withdrawMoneyFromDebitBill);
            withdrawMoneyFromDebitBill.setBounds(370, 270, 165, withdrawMoneyFromDebitBill.getPreferredSize().height);

            //---- withdrawMoneyFromDebitAmount ----
            withdrawMoneyFromDebitAmount.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            withdrawMoneyFromDebitAmount.setBackground(Color.white);
            panel1.add(withdrawMoneyFromDebitAmount);
            withdrawMoneyFromDebitAmount.setBounds(555, 270, 155, withdrawMoneyFromDebitAmount.getPreferredSize().height);

            //---- withdrawMoneyFromDebitBtn ----
            withdrawMoneyFromDebitBtn.setText("WITHDRAW");
            withdrawMoneyFromDebitBtn.setBackground(new Color(102, 102, 102));
            withdrawMoneyFromDebitBtn.setBorder(null);
            withdrawMoneyFromDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        withdrawMoneyFromDebitBtnMouseClicked(e);
                    } catch (NotEnoughMoneyInCardException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(withdrawMoneyFromDebitBtn);
            withdrawMoneyFromDebitBtn.setBounds(730, 270, 110, 30);

            //---- injectMoneyInDebitDebit ----
            injectMoneyInDebitDebit.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            injectMoneyInDebitDebit.setBackground(Color.white);
            panel1.add(injectMoneyInDebitDebit);
            injectMoneyInDebitDebit.setBounds(185, 220, 150, injectMoneyInDebitDebit.getPreferredSize().height);

            //---- injectMoneyInDebitBill ----
            injectMoneyInDebitBill.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            injectMoneyInDebitBill.setBackground(Color.white);
            panel1.add(injectMoneyInDebitBill);
            injectMoneyInDebitBill.setBounds(370, 220, 165, injectMoneyInDebitBill.getPreferredSize().height);

            //---- injectMoneyInDebitAmount ----
            injectMoneyInDebitAmount.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 0, 51)));
            injectMoneyInDebitAmount.setBackground(Color.white);
            panel1.add(injectMoneyInDebitAmount);
            injectMoneyInDebitAmount.setBounds(555, 220, 155, injectMoneyInDebitAmount.getPreferredSize().height);

            //---- injectMoneyInDebitBtn ----
            injectMoneyInDebitBtn.setText("INJECT");
            injectMoneyInDebitBtn.setBackground(new Color(102, 102, 102));
            injectMoneyInDebitBtn.setBorder(null);
            injectMoneyInDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    injectMoneyInDebitBtnMouseClicked(e);
                }
            });
            panel1.add(injectMoneyInDebitBtn);
            injectMoneyInDebitBtn.setBounds(730, 220, 110, injectMoneyInDebitBtn.getPreferredSize().height);

            //---- label1 ----
            label1.setText("AMOUNT");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(590, 200), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("AMOUNT");
            panel1.add(label2);
            label2.setBounds(605, 250, 51, 14);

            //---- label3 ----
            label3.setText("AMOUNT");
            panel1.add(label3);
            label3.setBounds(215, 310, 51, 14);

            //---- label4 ----
            label4.setText("AMOUNT");
            panel1.add(label4);
            label4.setBounds(205, 355, 51, 14);

            //---- label5 ----
            label5.setText("TIME IN MONTHS");
            panel1.add(label5);
            label5.setBounds(405, 350, 120, 14);

            //---- label6 ----
            label6.setText("BALANCE");
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(235, 465), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("PERIOD IN MONTHS");
            panel1.add(label7);
            label7.setBounds(405, 460, 130, 14);

            //---- label8 ----
            label8.setText("AMOUNT");
            panel1.add(label8);
            label8.setBounds(400, 515, 85, 14);

            //---- label9 ----
            label9.setText("AMOUNT");
            panel1.add(label9);
            label9.setBounds(350, 565, 85, 14);

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
    private JComboBox applyingForADebitCardPaymentNetwork;
    private JTextField applyingForADebitCardBalance;
    private JComboBox applyingForADebitCardCurrency;
    private JComboBox applyingForADebitCardBill;
    private JButton applyingForADebitCardBtn;
    private JComboBox applyForCreditCardPaymentNetwork;
    private JTextField applyForCreditCardBalance;
    private JComboBox applyForCreditCardCurrency;
    private JButton applyForCreditCardBtn;
    private JTextField applyingForAHousingCreditBalance;
    private JTextField applyingForAHousingCreditPeriodInMonths;
    private JButton applyingForAHousingCreditBtn;
    private JComboBox applyingForAConsumerCreditGuarantor;
    private JTextField applyingForAConsumerCreditBalance;
    private JTextField applyingForAConsumerCreditPeriodInMonths;
    private JButton applyingForAConsumerCreditBtn;
    private JTextField applyingForATermDebitBalance;
    private JTextField applyingForATermDebitTimeInMOnths;
    private JButton applyingForATermDebitBtn;
    private JTextField applyingForAIndefiniteDebitBalance;
    private JButton applyingForAIndefiniteDebitBtn;
    private JComboBox withdrawMoneyFromDebitDebit;
    private JComboBox withdrawMoneyFromDebitBill;
    private JTextField withdrawMoneyFromDebitAmount;
    private JButton withdrawMoneyFromDebitBtn;
    private JComboBox injectMoneyInDebitDebit;
    private JComboBox injectMoneyInDebitBill;
    private JTextField injectMoneyInDebitAmount;
    private JButton injectMoneyInDebitBtn;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
