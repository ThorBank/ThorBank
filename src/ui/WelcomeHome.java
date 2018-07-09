/*
 * Created by JFormDesigner on Sun Jul 08 14:08:52 EEST 2018
 */

package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Tsveta Getova
 */
public class WelcomeHome extends JFrame {
    public WelcomeHome() {
        initComponents();
    }

    private void registerBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void loginMouseClicked(MouseEvent e) {
        WelcomeHome.super.dispose();
        new Login().setVisible(true);
    }

    private void registerMouseClicked(MouseEvent e) {
        WelcomeHome.super.dispose();
        new Register().setVisible(true);
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
        login = new JButton();
        register = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setName("1\n2\n3\n4\n5");
            panel1.setBorder(null);

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
                icon.setBounds(25, 35, 80, 80);

                //---- ThorBankLabel ----
                ThorBankLabel.setText("Thor Bank");
                ThorBankLabel.setForeground(Color.white);
                ThorBankLabel.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                ThorBankLabel.setRequestFocusEnabled(false);
                ThorBankLabel.setHorizontalAlignment(SwingConstants.LEFT);
                panel2.add(ThorBankLabel);
                ThorBankLabel.setBounds(115, 45, 185, 55);

                //---- separator1 ----
                separator1.setBackground(Color.white);
                separator1.setForeground(Color.white);
                separator1.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator1);
                separator1.setBounds(115, 85, 140, 25);

                //---- home ----
                home.setText("Home Page  ");
                home.setBackground(new Color(204, 0, 51));
                home.setForeground(Color.white);
                home.setHorizontalAlignment(SwingConstants.RIGHT);
                home.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                panel2.add(home);
                home.setBounds(500, 50, 225, 40);

                //---- separator2 ----
                separator2.setBackground(Color.white);
                separator2.setForeground(Color.white);
                separator2.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator2);
                separator2.setBounds(560, 85, 155, 30);

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

            //---- login ----
            login.setText("LOGIN");
            login.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            login.setBackground(new Color(102, 102, 102));
            login.setBorder(null);
            login.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginMouseClicked(e);
                }
            });
            panel1.add(login);
            login.setBounds(90, 390, 145, 70);

            //---- register ----
            register.setText("REGISTER");
            register.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
            register.setBackground(new Color(102, 102, 102));
            register.setBorder(null);
            register.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    registerMouseClicked(e);
                }
            });
            panel1.add(register);
            register.setBounds(480, 385, 145, 70);

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
    private JButton login;
    private JButton register;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
