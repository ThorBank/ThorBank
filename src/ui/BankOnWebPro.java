package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tsveta Getova
 */
public class BankOnWebPro extends JFrame {
    public BankOnWebPro() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        panel1 = new JPanel();
        panel2 = new JPanel();
        icon = new JLabel();
        ThorBankLabel = new JLabel();
        separator1 = new JSeparator();
        bankOnWebPro = new JLabel();
        separator2 = new JSeparator();
        menuBar1 = new JMenuBar();

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
                    javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                    Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(204, 0, 51));
                panel2.setLayout(null);

                //---- icon ----
                icon.setIcon(new ImageIcon(getClass().getResource("/resources/7234-256x256x32resize.png")));
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

                //---- bankOnWebPro ----
                bankOnWebPro.setText("Bank On Web Pro ");
                bankOnWebPro.setBackground(new Color(204, 0, 51));
                bankOnWebPro.setForeground(Color.white);
                bankOnWebPro.setHorizontalAlignment(SwingConstants.RIGHT);
                bankOnWebPro.setFont(new Font("FrankRuehl", Font.BOLD, 30));
                panel2.add(bankOnWebPro);
                bankOnWebPro.setBounds(460, 50, 265, 40);

                //---- separator2 ----
                separator2.setBackground(Color.white);
                separator2.setForeground(Color.white);
                separator2.setFont(new Font("FrankRuehl", Font.BOLD, 36));
                panel2.add(separator2);
                separator2.setBounds(480, 85, 240, 30);

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

            //======== menuBar1 ========
            {
                menuBar1.setBackground(new Color(228, 228, 228));
                menuBar1.setForeground(new Color(102, 102, 102));
            }
            panel1.add(menuBar1);
            menuBar1.setBounds(10, 120, 720, 60);

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
    private JLabel bankOnWebPro;
    private JSeparator separator2;
    private JMenuBar menuBar1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
