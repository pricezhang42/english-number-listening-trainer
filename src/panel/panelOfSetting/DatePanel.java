package panel.panelOfSetting;

import listener.ButtonListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class DatePanel extends JPanel {
    public static DatePanel instance = new DatePanel();

    public JButton bDate = new JButton("Random Date");
    JLabel lYears = new JLabel("Years");
    public JTextField tfYearsFrom = new JTextField("1800");
    JLabel lTo = new JLabel("-->");
    public JTextField tfYearsTo = new JTextField("2050");
    JCheckBox checkBox = new JCheckBox("Time", true);

    public DatePanel() {
        bDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        MigLayout migLayout = new MigLayout("", "[128!,grow]10[40!,grow]5[40!]7[20!,grow]5[40!," +
                "grow]15[60!]", "[]");
        this.setLayout(migLayout);

        checkBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        this.add(bDate, "growx");
        this.add(lYears, "growx");
        this.add(tfYearsFrom, "growx");
        this.add(lTo, "growx");
        this.add(tfYearsTo, "growx");
//        this.add(checkBox, "growx");

        bDate.addActionListener(ButtonListener.instance);
    }
}
