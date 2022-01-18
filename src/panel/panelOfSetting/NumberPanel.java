package panel.panelOfSetting;

import listener.ButtonListener;
import net.miginfocom.swing.MigLayout;
import panel.SettingPanel;

import javax.swing.*;
import java.awt.*;

public class NumberPanel extends JPanel {
    public static NumberPanel instance = new NumberPanel();

    public JButton bGenerateNum = new JButton("Generate Numbers");
    public JRadioButton rbFixed = new JRadioButton("Fixed");
    JLabel lInteger = new JLabel("Integer");
    public JTextField tfInteger = new JTextField("1");
    JLabel lDecimal = new JLabel("Decimal");
    public JTextField tfDecimal = new JTextField("0");

    public NumberPanel() {
        MigLayout migLayoutNumber = new MigLayout("", "[128!,grow]5[50!]10[40!,grow]5[30!]7[45!," +
                "grow]5[30!,grow]", "[]");
        this.setLayout(migLayoutNumber);

        bGenerateNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        this.add(bGenerateNum, "growx");
        this.add(rbFixed, "growx");
        this.add(lInteger, "growx");
        this.add(tfInteger, "growx");
        this.add(lDecimal, "growx");
        this.add(tfDecimal, "growx");

        bGenerateNum.addActionListener(ButtonListener.instance);
    }
}
