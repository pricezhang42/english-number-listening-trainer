package panel.panelOfSetting;

import listener.NumberPanelListener;
import net.miginfocom.swing.MigLayout;
import util.NumberClass;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GeneratedNumPanel extends JPanel {
    public static GeneratedNumPanel instance = new GeneratedNumPanel();

    public JLabel lFirst = new JLabel();
    public JLabel lSecond = new JLabel();
    public JLabel lThird = new JLabel();
    public JLabel lFourth = new JLabel();
    public JLabel lFifth = new JLabel();
    public JLabel lSixth = new JLabel();
    public JLabel lSeventh = new JLabel();
    public JLabel lEighth = new JLabel();
    public JLabel lNinth = new JLabel();
    public JLabel lTenth = new JLabel();

    public JLabel[] labels;

    public GeneratedNumPanel() {
        MigLayout migLayoutPanel = new MigLayout("", "[]",
                "[]10[]10[]10[]10[]10[]10[]10[]10[]10[]");
        this.setLayout(migLayoutPanel);

        labels = new JLabel[]{lFirst, lSecond, lThird, lFourth, lFifth, lSixth, lSeventh, lEighth,
                lNinth, lTenth};

        setFontAndSize();
        addAll();
        update();
    }

    private void setFontAndSize() {
        for (JLabel label : labels) {
            label.setOpaque(true);
//        lFirst.setBackground(new Color(255,200,0));
            label.setPreferredSize(new Dimension(200, 0));
//            label.setBorder(new LineBorder(Color.BLACK));
            label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        }
    }

    private void addAll() {
        for (JLabel label : labels) {
            this.add(label, "span");
            label.addMouseListener(NumberPanelListener.instance);
        }
    }

    public void update() {
        int i = 0;
        for (JLabel label : labels) {
            label.setText(NumberClass.numbers[i]);
            i++;
        }
    }
}
