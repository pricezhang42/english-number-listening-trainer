package panel.panelOfSetting;

import listener.ButtonListener;
import net.miginfocom.swing.MigLayout;
import panel.SettingPanel;

import javax.swing.*;
import java.awt.*;

public class ExtraNumberPanel extends JPanel {
    public static ExtraNumberPanel instance = new ExtraNumberPanel();

    JLabel lBlank = new JLabel("");
    JRadioButton rbRange = new JRadioButton("Ranged");
    JLabel lInteger = new JLabel("Int");
    public JTextField tfIntegerFrom = new JTextField("1");
    JLabel lToInt = new JLabel("->");
    public JTextField tfIntegerTo = new JTextField("3");
    JLabel lDecimal = new JLabel("Dec");
    public JTextField tfDecimalFrom = new JTextField("1");
    JLabel lToDec = new JLabel("->");
    public JTextField tfDecimalTo = new JTextField("3");

    public ExtraNumberPanel() {
        MigLayout migLayoutNumber = new MigLayout("", "[128!,grow]5[60!]15[15!," +
                "grow][20!][10!][20!][20!," +
                "grow][20!][10!][20!]", "[]");
        this.setLayout(migLayoutNumber);

        ButtonGroup bg = new ButtonGroup();
        bg.add(NumberPanel.instance.rbFixed);
        bg.add(rbRange);
        NumberPanel.instance.rbFixed.setSelected(true);

        this.add(lBlank, "growx");
        this.add(rbRange, "growx");
        this.add(lInteger, "growx");
        this.add(tfIntegerFrom, "growx");
        this.add(lToInt, "growx");
        this.add(tfIntegerTo, "growx");
        this.add(lDecimal, "growx");
        this.add(tfDecimalFrom, "growx");
        this.add(lToDec, "growx");
        this.add(tfDecimalTo, "growx");
    }
}
