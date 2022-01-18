package panel;

import listener.ButtonListener;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public static ControlPanel instance = new ControlPanel();

    public JButton bPlay = new JButton("Play");
    public JButton bPause = new JButton("Pause");
    public JButton bResume = new JButton("Resume");
    public JButton bStop = new JButton("Stop");

    public ControlPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        MigLayout migLayout = new MigLayout("","60[110!]50[110!]40","grow");
//        MigLayout migLayout = new MigLayout("","15[80!]15[80!]15[80!]15[80!]15","grow");
        this.setLayout(migLayout);

//        bPlay.setFont(new Font("Times New Roman", Font.BOLD, 15));
//        bStop.setFont(new Font("Times New Roman", Font.BOLD, 15));
//        bPause.setFont(new Font("Times New Roman", Font.BOLD, 15));
//        bResume.setFont(new Font("Times New Roman", Font.BOLD, 15));

//        this.add(bPlay, "growx, h 40!");
//        this.add(bPause, "growx, h 40!");
//        this.add(bResume, "growx, h 40!");
//        this.add(bStop, "growx, h 40!");

        this.add(bPlay, "growx, h 40!");
        this.add(bStop, "growx, h 40!");

        bPlay.addActionListener(ButtonListener.instance);
//        bPause.addActionListener(ButtonListener.instance);
//        bResume.addActionListener(ButtonListener.instance);
        bStop.addActionListener(ButtonListener.instance);
    }
}
