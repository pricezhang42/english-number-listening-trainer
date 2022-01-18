package listener;

import panel.ControlPanel;
import panel.panelOfSetting.GeneratedNumPanel;
import panel.panelOfSetting.NumberPanel;
import util.ColorUtil;
import util.NumberClass;
import util.SpeakUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class NumberPanelListener  implements MouseListener {

    public static NumberPanelListener instance = new NumberPanelListener();

    private static Color oriColor;

    @Override
    public void mouseReleased(MouseEvent e) {

        JLabel l = (JLabel)e.getSource();

        if (l == GeneratedNumPanel.instance.lFirst) {
            java.util.Timer timer = new Timer();
            TimerTask task = new TimerTask(){
                @Override
                public void run() {
                    ButtonListener.createWorkerAndSpeak(0);
                    GeneratedNumPanel.instance.lFirst.setEnabled(true);
                }
            };
            GeneratedNumPanel.instance.lFirst.setBackground(ColorUtil.enterColor);
            GeneratedNumPanel.instance.lFirst.setEnabled(false);
            SpeakUtil.stop();
            timer.schedule(task, 1000);

//            SpeakUtil.speak(NumberClass.speakNumbers[0]);
//            GeneratedNumPanel.instance.lFirst.setBackground(oriColor);
        }
    }
    public void mousePressed(MouseEvent e) {

        JLabel l = (JLabel)e.getSource();

        if (l == GeneratedNumPanel.instance.lFirst) {
            GeneratedNumPanel.instance.lFirst.setBackground(ColorUtil.pressColor);
        }
    }
    public void mouseExited(MouseEvent e) {

        JLabel l = (JLabel)e.getSource();

        if (l == GeneratedNumPanel.instance.lFirst) {
            GeneratedNumPanel.instance.lFirst.setBackground(oriColor);
        }
    }
    public void mouseEntered(MouseEvent e) {

        JLabel l = (JLabel)e.getSource();

        if (l == GeneratedNumPanel.instance.lFirst) {
            oriColor = GeneratedNumPanel.instance.lFirst.getBackground();
            GeneratedNumPanel.instance.lFirst.setBackground(ColorUtil.enterColor);
        }

    }
    public void mouseClicked(MouseEvent e) {

    }
}

