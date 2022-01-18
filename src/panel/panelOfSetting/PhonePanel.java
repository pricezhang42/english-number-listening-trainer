package panel.panelOfSetting;

import listener.ButtonListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class PhonePanel extends JPanel {
    public static PhonePanel instance = new PhonePanel();

    public JButton bPhoneNum = new JButton("Phone Numbers");
    JLabel lDigits = new JLabel("Digits");
    JRadioButton rb1 = new JRadioButton("3");
    JRadioButton rb2 = new JRadioButton("4");
    JRadioButton rb3 = new JRadioButton("9");
    JRadioButton rb4 = new JRadioButton("11");
    public ButtonGroup bg;

    public PhonePanel() {
        bPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        rb3.setSelected(true);

        MigLayout migLayoutPhone = new MigLayout("", "[128!,grow]10[40!,grow]5[30!]5[30!," +
                "grow]5[30!,grow]5[30!,grow]", "[]");
        this.setLayout(migLayoutPhone);

        this.add(bPhoneNum, "growx");
        this.add(lDigits, "growx");
        this.add(rb1, "growx");
        this.add(rb2, "growx");
        this.add(rb3, "growx");
        this.add(rb4, "growx");

        bPhoneNum.addActionListener(ButtonListener.instance);
    }

}
