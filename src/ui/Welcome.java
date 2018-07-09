package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tsveta Getova
 */
public class Welcome extends JFrame {
    /**
     * Creates new form Welcome Form
     */
    public Welcome() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Tsveta Getova
        welcomePanel = new JPanel();
        icon = new JLabel();
        ThorBank = new JLabel();
        separator1 = new JSeparator();
        label1 = new JLabel();
        loading = new JLabel();
        num_loading = new JLabel();

        //======== this ========
        setBackground(new Color(204, 0, 51));
        setForeground(Color.black);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== welcomePanel ========
        {
            welcomePanel.setBackground(new Color(206, 28, 51));

            // JFormDesigner evaluation mark
            welcomePanel.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), welcomePanel.getBorder())); welcomePanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            welcomePanel.setLayout(null);

            //---- icon ----
            icon.setIcon(new ImageIcon("D:\\Telerik\\Telerik\\SwingUi\\demoUi\\src\\resources\\7234-256x256x32.png"));
            welcomePanel.add(icon);
            icon.setBounds(new Rectangle(new Point(100, 80), icon.getPreferredSize()));

            //---- ThorBank ----
            ThorBank.setText("Thor Bank");
            ThorBank.setFont(new Font("FrankRuehl", Font.BOLD, 48));
            ThorBank.setForeground(Color.lightGray);
            ThorBank.setBackground(new Color(51, 51, 55));
            welcomePanel.add(ThorBank);
            ThorBank.setBounds(new Rectangle(new Point(405, 120), ThorBank.getPreferredSize()));

            //---- separator1 ----
            separator1.setBackground(new Color(51, 51, 55));
            separator1.setForeground(Color.white);
            welcomePanel.add(separator1);
            separator1.setBounds(395, 175, 240, 10);

            //---- label1 ----
            label1.setText("Thor Bank some text ...");
            label1.setFont(new Font("FrankRuehl", Font.BOLD, 22));
            label1.setBackground(new Color(51, 51, 55));
            label1.setForeground(Color.lightGray);
            welcomePanel.add(label1);
            label1.setBounds(new Rectangle(new Point(400, 195), label1.getPreferredSize()));

            //---- loading ----
            loading.setText("Loading...");
            loading.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
            loading.setForeground(Color.lightGray);
            welcomePanel.add(loading);
            loading.setBounds(345, 375, 80, 20);

            //---- num_loading ----
            num_loading.setText("99%");
            num_loading.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
            num_loading.setForeground(Color.lightGray);
            welcomePanel.add(num_loading);
            num_loading.setBounds(430, 375, 80, 20);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < welcomePanel.getComponentCount(); i++) {
                    Rectangle bounds = welcomePanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = welcomePanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                welcomePanel.setMinimumSize(preferredSize);
                welcomePanel.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(welcomePanel);
        welcomePanel.setBounds(-5, -30, 800, 510);

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
    private JPanel welcomePanel;
    private JLabel icon;
    private JLabel ThorBank;
    private JSeparator separator1;
    private JLabel label1;
    private JLabel loading;
    public JLabel num_loading;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
