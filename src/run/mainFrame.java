package run;

import panel.*;

import javax.swing.*;

public class mainFrame {
    private static int widthOfPanel1 = 200;
    private static int heightOfPanel1 = 395;
    private static int widthOfPanel2 = 400;
    private static int heightOfPanel2 = 65;
    private static int gap = 15;
//    private double rateHor = 0.3;
//    private double rateVer = 0.7;

    public static void main(String[] args) {
        int frameWidth = widthOfPanel1 + widthOfPanel2 + 4 * gap;
        int frameHeight = heightOfPanel1 + heightOfPanel2 + 5 * gap;
        JFrame f = new JFrame();
        f.setSize(frameWidth, frameHeight);
        f.setTitle("Number Listening Trainer");
//        f.setLayout(new BorderLayout());
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ShowPanel.instance.setBounds(gap, gap, widthOfPanel1, heightOfPanel1);
        SettingPanel.instance.setBounds(widthOfPanel1 + 2 * gap, gap, widthOfPanel2,
                heightOfPanel1);
        SpeedPanel.instance.setBounds(gap, heightOfPanel1 + 2 * gap, widthOfPanel1, heightOfPanel2);
        ControlPanel.instance.setBounds(widthOfPanel1 + 2 * gap, heightOfPanel1 + 2 * gap,
                widthOfPanel2, heightOfPanel2);

        f.add(ShowPanel.instance);
        f.add(SettingPanel.instance);
        f.add(SpeedPanel.instance);
        f.add(ControlPanel.instance);

        f.setVisible(true);
    }
}
