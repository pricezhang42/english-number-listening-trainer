package panel;

import net.miginfocom.swing.MigLayout;
import panel.panelOfSetting.NumberPanel;

import javax.swing.*;
import java.awt.*;

public class SpeedPanel extends JPanel {
    public static SpeedPanel instance = new SpeedPanel();

    JSlider slider = new JSlider(0, 100);
    JRadioButton rbEnglish = new JRadioButton("English");
    JRadioButton rbFrench = new JRadioButton("French");
    JLabel lAuthor = new JLabel("Author: Price Zhang");
    JLabel lEmail = new JLabel("Email: wasdpyzlp@gmail.com");

    public SpeedPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

//        MigLayout migLayoutPanel = new MigLayout("insets 5 5 5 5", "[][]",
//                "[][]");
        MigLayout migLayoutPanel = new MigLayout("insets 10 12 5 5", "[]",
                "[]10[]");
        this.setLayout(migLayoutPanel);

        slider.setSize(50, 10);
        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
//        slider.setPaintTicks(true);
        slider.setFont(new Font("Times New Roman", Font.PLAIN, 10));

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbEnglish);
        bg.add(rbFrench);

//        this.add(slider, "span");
//        this.add(rbEnglish);
//        this.add(rbFrench);
        this.add(lAuthor, "span");
        this.add(lEmail, "span");
    }
}
