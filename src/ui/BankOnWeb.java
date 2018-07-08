package ui;

import card.*;
import client.Client;
import credit.Credit;
import debit.Debit;
import webbanking.Bill;
import webbanking.Currency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Tsveta Getova
 */
public class BankOnWeb extends JFrame {
    Client client;
    public BankOnWeb(Client client) {
        this.client = client;
        initComponents();
    }

    private void playBtnMouseClicked(MouseEvent e) {
        if (billComboBox.getClass().getName().toString().equals("Bill")){
            client.payCredit((Credit) creditComboBox.getSelectedItem(), (Bill)billComboBox.getSelectedItem());
        }
        else {
            client.payCredit((Credit) creditComboBox.getSelectedItem(), (Card) billComboBox.getSelectedItem());
        }
    }

    private void injectDebitBtn2MouseClicked(MouseEvent e) {
        if (billComboBox2.getClass().getName().equals("Bill")){
            client.injectMoneyInDebit((Debit)debitComboBox2.getSelectedItem(), (Bill)billComboBox2.getSelectedItem(), Double.parseDouble(debitAmount.getText()));
        }
        else {
            client.injectMoneyInDebit((Debit)debitComboBox2.getSelectedItem(), (Card) billComboBox2.getSelectedItem(), Double.parseDouble(debitAmount.getText()));
        }
    }

    private void withdrawDebitBtnMouseClicked(MouseEvent e) throws NotEnoughMoneyInCardException {
        if (withdrawBillComboBox.getClass().getName().equals("Bill")){
            client.withdrawMoneyFromDebit((Debit)withdrawDebitComboBox.getSelectedItem(), (Bill)withdrawBillComboBox.getSelectedItem(), Double.parseDouble(withdrawAmount.getText()));
        }
        else {
            client.withdrawMoneyFromDebit((Debit)withdrawDebitComboBox.getSelectedItem(), (Card)withdrawBillComboBox.getSelectedItem(), Double.parseDouble(withdrawAmount.getText()));
        }
    }

    private void applyingDebitBtnMouseClicked(MouseEvent e) {
        client.applyingForAIndefiniteDebit(Double.parseDouble(applyingDebitBalans.getText()));
    }

    private void applyingForATermDebitBtnMouseClicked(MouseEvent e) {
        client.applyingForATermDebit(Double.parseDouble(applyingTermDebitBalans.getText()), Integer.parseInt(applyingTime.getText()));
    }

    private void applyFortCardBtnMouseClicked(MouseEvent e) throws CardNumberFormatException {
        if (withdrawDebitComboBox2.getClass().getName().equals("CreditCardPaymentNetwork")){
            client.applyForCreditCard((CreditCardPaymentNetwork)withdrawDebitComboBox2.getSelectedItem(), Double.parseDouble(applyFortCardBalance.getText()), (Currency)billApplaingForCard.getSelectedItem(), (Bill)currencyApplaingForCard.getSelectedItem());
        }
        else {
            client.applyForDebitCard((DebitCardPaymentNetwork) withdrawDebitComboBox2.getSelectedItem(), Double.parseDouble(applyFortCardBalance.getText()), (Currency)billApplaingForCard.getSelectedItem(), (Bill)currencyApplaingForCard.getSelectedItem());
        }
    }

    private void applyingForAConsumerBtnMouseClicked(MouseEvent e) {
        client.applyingForAConsumerCredit((Client)guarantor.getSelectedItem(), Double.parseDouble(cunsumerBalance.getText()), Integer.parseInt(cunsumerTime.getText()));
    }

    private void applyingForAHousingCreditBtnMouseClicked(MouseEvent e) {
        client.applyingForAHousingCredit(Double.parseDouble(housingCreditBalans.getText()), Integer.parseInt(houseTime.getText()));
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        panel1 = new JPanel();
        payCreditLabel = new JLabel();
        creditComboBox = new JComboBox();
        billComboBox = new JComboBox();
        playBtn = new JButton();
        injectMoneyInDebitLabel = new JLabel();
        debitComboBox2 = new JComboBox();
        billComboBox2 = new JComboBox();
        debitAmount = new JTextArea();
        injectDebitBtn2 = new JButton();
        withdrawMoneyFromDebit = new JLabel();
        withdrawDebitComboBox = new JComboBox();
        withdrawBillComboBox = new JComboBox();
        withdrawAmount = new JTextArea();
        withdrawDebitBtn = new JButton();
        applyingDebit = new JLabel();
        applyingDebitBalans = new JTextArea();
        applyingDebitBtn = new JButton();
        applyingForATermDebit = new JLabel();
        applyingTermDebitBalans = new JTextArea();
        applyingTime = new JTextArea();
        applyingForATermDebitBtn = new JButton();
        applyFortCard = new JLabel();
        withdrawDebitComboBox2 = new JComboBox();
        applyFortCardBalance = new JTextArea();
        currencyApplaingForCard = new JComboBox();
        billApplaingForCard = new JComboBox();
        applyFortCardBtn = new JButton();
        label2 = new JLabel();
        cunsumerBalance = new JTextArea();
        cunsumerTime = new JTextArea();
        applyingForAConsumerBtn = new JButton();
        applyingForAHousingCredit = new JLabel();
        housingCreditBalans = new JTextArea();
        houseTime = new JTextArea();
        applyingForAHousingCreditBtn = new JButton();
        guarantor = new JComboBox();
        panel2 = new JPanel();
        icon = new JLabel();
        ThorBankLabel = new JLabel();
        separator1 = new JSeparator();
        bankOnWeb = new JLabel();
        separator2 = new JSeparator();

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

            //---- payCreditLabel ----
            payCreditLabel.setText("payCredit");
            panel1.add(payCreditLabel);
            payCreditLabel.setBounds(45, 155, 185, 30);
            panel1.add(creditComboBox);
            creditComboBox.setBounds(200, 155, 130, creditComboBox.getPreferredSize().height);
            panel1.add(billComboBox);
            billComboBox.setBounds(370, 155, 125, billComboBox.getPreferredSize().height);

            //---- playBtn ----
            playBtn.setText("PLAY");
            playBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    playBtnMouseClicked(e);
                }
            });
            panel1.add(playBtn);
            playBtn.setBounds(710, 155, 100, playBtn.getPreferredSize().height);

            //---- injectMoneyInDebitLabel ----
            injectMoneyInDebitLabel.setText("injectMoneyInDebit");
            panel1.add(injectMoneyInDebitLabel);
            injectMoneyInDebitLabel.setBounds(20, 190, 135, 30);
            panel1.add(debitComboBox2);
            debitComboBox2.setBounds(200, 195, 130, 30);
            panel1.add(billComboBox2);
            billComboBox2.setBounds(365, 195, 125, 30);
            panel1.add(debitAmount);
            debitAmount.setBounds(535, 195, 113, 28);

            //---- injectDebitBtn2 ----
            injectDebitBtn2.setText("PLAY");
            injectDebitBtn2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    injectDebitBtn2MouseClicked(e);
                }
            });
            panel1.add(injectDebitBtn2);
            injectDebitBtn2.setBounds(710, 195, 100, 30);

            //---- withdrawMoneyFromDebit ----
            withdrawMoneyFromDebit.setText("withdrawMoneyFromDebit");
            panel1.add(withdrawMoneyFromDebit);
            withdrawMoneyFromDebit.setBounds(20, 245, 162, 30);
            panel1.add(withdrawDebitComboBox);
            withdrawDebitComboBox.setBounds(205, 245, 130, 30);
            panel1.add(withdrawBillComboBox);
            withdrawBillComboBox.setBounds(370, 245, 125, 30);
            panel1.add(withdrawAmount);
            withdrawAmount.setBounds(540, 245, 113, 28);

            //---- withdrawDebitBtn ----
            withdrawDebitBtn.setText("PLAY");
            withdrawDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        withdrawDebitBtnMouseClicked(e);
                    } catch (NotEnoughMoneyInCardException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(withdrawDebitBtn);
            withdrawDebitBtn.setBounds(705, 245, 100, 30);

            //---- applyingDebit ----
            applyingDebit.setText("applyingForAIndefiniteDebit");
            panel1.add(applyingDebit);
            applyingDebit.setBounds(20, 295, 165, 29);
            panel1.add(applyingDebitBalans);
            applyingDebitBalans.setBounds(205, 295, 113, 28);

            //---- applyingDebitBtn ----
            applyingDebitBtn.setText("PLAY");
            applyingDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingDebitBtnMouseClicked(e);
                }
            });
            panel1.add(applyingDebitBtn);
            applyingDebitBtn.setBounds(710, 290, 100, 30);

            //---- applyingForATermDebit ----
            applyingForATermDebit.setText("applyingForATermDebit");
            panel1.add(applyingForATermDebit);
            applyingForATermDebit.setBounds(20, 345, 145, 30);
            panel1.add(applyingTermDebitBalans);
            applyingTermDebitBalans.setBounds(205, 340, 113, 28);
            panel1.add(applyingTime);
            applyingTime.setBounds(380, 340, 113, 28);

            //---- applyingForATermDebitBtn ----
            applyingForATermDebitBtn.setText("PLAY");
            applyingForATermDebitBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForATermDebitBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForATermDebitBtn);
            applyingForATermDebitBtn.setBounds(710, 330, 100, 30);

            //---- applyFortCard ----
            applyFortCard.setText(" applyFortCard");
            panel1.add(applyFortCard);
            applyFortCard.setBounds(30, 405, 130, 25);
            panel1.add(withdrawDebitComboBox2);
            withdrawDebitComboBox2.setBounds(200, 400, 130, 30);
            panel1.add(applyFortCardBalance);
            applyFortCardBalance.setBounds(340, 400, 113, 28);
            panel1.add(currencyApplaingForCard);
            currencyApplaingForCard.setBounds(590, 400, 125, 30);
            panel1.add(billApplaingForCard);
            billApplaingForCard.setBounds(465, 400, 125, 30);

            //---- applyFortCardBtn ----
            applyFortCardBtn.setText("PLAY");
            applyFortCardBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        applyFortCardBtnMouseClicked(e);
                    } catch (CardNumberFormatException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel1.add(applyFortCardBtn);
            applyFortCardBtn.setBounds(720, 400, 100, 30);

            //---- label2 ----
            label2.setText("applyingForAConsumerCredit");
            panel1.add(label2);
            label2.setBounds(25, 450, 155, 25);
            panel1.add(cunsumerBalance);
            cunsumerBalance.setBounds(340, 450, 113, 28);
            panel1.add(cunsumerTime);
            cunsumerTime.setBounds(475, 450, 113, 28);

            //---- applyingForAConsumerBtn ----
            applyingForAConsumerBtn.setText("PLAY");
            applyingForAConsumerBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForAConsumerBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForAConsumerBtn);
            applyingForAConsumerBtn.setBounds(715, 450, 100, 30);

            //---- applyingForAHousingCredit ----
            applyingForAHousingCredit.setText("applyingForAHousingCredit");
            panel1.add(applyingForAHousingCredit);
            applyingForAHousingCredit.setBounds(25, 500, 155, 29);
            panel1.add(housingCreditBalans);
            housingCreditBalans.setBounds(210, 495, 113, 28);
            panel1.add(houseTime);
            houseTime.setBounds(345, 495, 113, 28);

            //---- applyingForAHousingCreditBtn ----
            applyingForAHousingCreditBtn.setText("PLAY");
            applyingForAHousingCreditBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applyingForAHousingCreditBtnMouseClicked(e);
                }
            });
            panel1.add(applyingForAHousingCreditBtn);
            applyingForAHousingCreditBtn.setBounds(715, 495, 100, 30);
            panel1.add(guarantor);
            guarantor.setBounds(190, 440, 130, 30);

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
        panel1.setBounds(-10, -30, 860, 715);

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

            //---- bankOnWeb ----
            bankOnWeb.setText("Bank On Web ");
            bankOnWeb.setBackground(new Color(204, 0, 51));
            bankOnWeb.setForeground(Color.white);
            bankOnWeb.setHorizontalAlignment(SwingConstants.RIGHT);
            bankOnWeb.setFont(new Font("FrankRuehl", Font.BOLD, 30));
            panel2.add(bankOnWeb);
            bankOnWeb.setBounds(460, 50, 265, 40);

            //---- separator2 ----
            separator2.setBackground(Color.white);
            separator2.setForeground(Color.white);
            separator2.setFont(new Font("FrankRuehl", Font.BOLD, 36));
            panel2.add(separator2);
            separator2.setBounds(535, 85, 185, 30);

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
        contentPane.add(panel2);
        panel2.setBounds(-10, -30, 735, 120);

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
    private JLabel payCreditLabel;
    private JComboBox creditComboBox;
    private JComboBox billComboBox;
    private JButton playBtn;
    private JLabel injectMoneyInDebitLabel;
    private JComboBox debitComboBox2;
    private JComboBox billComboBox2;
    private JTextArea debitAmount;
    private JButton injectDebitBtn2;
    private JLabel withdrawMoneyFromDebit;
    private JComboBox withdrawDebitComboBox;
    private JComboBox withdrawBillComboBox;
    private JTextArea withdrawAmount;
    private JButton withdrawDebitBtn;
    private JLabel applyingDebit;
    private JTextArea applyingDebitBalans;
    private JButton applyingDebitBtn;
    private JLabel applyingForATermDebit;
    private JTextArea applyingTermDebitBalans;
    private JTextArea applyingTime;
    private JButton applyingForATermDebitBtn;
    private JLabel applyFortCard;
    private JComboBox withdrawDebitComboBox2;
    private JTextArea applyFortCardBalance;
    private JComboBox currencyApplaingForCard;
    private JComboBox billApplaingForCard;
    private JButton applyFortCardBtn;
    private JLabel label2;
    private JTextArea cunsumerBalance;
    private JTextArea cunsumerTime;
    private JButton applyingForAConsumerBtn;
    private JLabel applyingForAHousingCredit;
    private JTextArea housingCreditBalans;
    private JTextArea houseTime;
    private JButton applyingForAHousingCreditBtn;
    private JComboBox guarantor;
    private JPanel panel2;
    private JLabel icon;
    private JLabel ThorBankLabel;
    private JSeparator separator1;
    private JLabel bankOnWeb;
    private JSeparator separator2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
