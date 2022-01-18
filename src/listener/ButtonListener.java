package listener;

import panel.ControlPanel;
import panel.ShowPanel;
import panel.panelOfSetting.*;
import util.NumberClass;
import util.SpeakUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Enumeration;
import java.util.TimerTask;
import java.util.Timer;

public class ButtonListener implements ActionListener {

    public static ButtonListener instance = new ButtonListener();

    PropertyChangeSupport listeners = new PropertyChangeSupport(this);
    public static boolean isFinished;

    public static SwingWorker sw;

    public ButtonListener() {
        listeners.addPropertyChangeListener(new PropertyChangeListener(){

            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("run");
                createWorkerAndSpeak();
            }});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();

        if (b == NumberPanel.instance.bGenerateNum) {
            if (NumberPanel.instance.rbFixed.isSelected()) {
                NumberPanel p = NumberPanel.instance;
                NumberClass.generateFixedNums(Integer.parseInt(p.tfInteger.getText()),
                        Integer.parseInt(p.tfDecimal.getText()));
            } else {
                ExtraNumberPanel p = ExtraNumberPanel.instance;
                NumberClass.generateRangedNums(Integer.parseInt(p.tfIntegerFrom.getText()),
                        Integer.parseInt(p.tfIntegerTo.getText()),
                        Integer.parseInt(p.tfDecimalFrom.getText()),
                        Integer.parseInt(p.tfDecimalTo.getText()));
            }
            GeneratedNumPanel.instance.update();
        }

        if (b == PhonePanel.instance.bPhoneNum) {
            Enumeration<AbstractButton> elements = PhonePanel.instance.bg.getElements();
            while (elements.hasMoreElements()) {
                AbstractButton ele = elements.nextElement();
                if (ele.isSelected()) {
                    NumberClass.generatePhoneNums(Integer.parseInt(ele.getText()));
                    break;
                }
            }
            GeneratedNumPanel.instance.update();
        }

        if (b == DatePanel.instance.bDate) {
            DatePanel p = DatePanel.instance;
            NumberClass.generateDates(Integer.parseInt(p.tfYearsFrom.getText()),
                    Integer.parseInt(p.tfYearsTo.getText()));
            GeneratedNumPanel.instance.update();
        }

        if (b == ExtraPanel.instance.bTime) {
            NumberClass.generateTime();
            GeneratedNumPanel.instance.update();
        }

        if (b == ExtraPanel.instance.bDayOfWeek) {
            NumberClass.generateDaysOfWeek();
            GeneratedNumPanel.instance.update();
        }

        if (b == ExtraPanel.instance.bMonths) {
            NumberClass.generateMonths();
            GeneratedNumPanel.instance.update();
        }

        if (b == ExtraPanel.instance.bDirections) {
            NumberClass.generateDirections();
            GeneratedNumPanel.instance.update();
        }

        if (b == ControlPanel.instance.bPause) {
            SpeakUtil.pause();
        }

        if (b == ControlPanel.instance.bResume) {
            SpeakUtil.resume();
        }

        if (b == ControlPanel.instance.bPlay) {
            isFinished = false;
//                listeners.firePropertyChange("isFinished", this.isFinished, true);
            Timer timer = new Timer();
            TimerTask task = new TimerTask(){
                @Override
                public void run() {
                    createWorkerAndSpeak();
                    ControlPanel.instance.bPlay.setEnabled(true);
                }
            };
            if (sw != null) {
                ControlPanel.instance.bPlay.setEnabled(false);
                SpeakUtil.stop();
                timer.schedule(task, 1000);
            } else {
                createWorkerAndSpeak();
            }

//            try {
//                // disable OK 按钮...
//                // 做耗时的工作
//                ControlPanel.instance.bPlay.setEnabled(false);
//                if (sw != null) {
//                    SpeakUtil.stop();
//                    Thread.sleep(1000);
//                }
//                createWorkerAndSpeak();
//            } catch (InterruptedException interruptedException) {
//                interruptedException.printStackTrace();
//            } finally {
//                SwingUtilities.invokeLater(new Runnable(){
//                    @Override
//                    public void run() {
//                        // enable OK 按钮...
//                        ControlPanel.instance.bPlay.setEnabled(true);
//                    }});
//            }

//                ControlPanel.instance.bPlay.setEnabled(false);
//                SpeakUtil.stop();
//                try {
//                    Thread.sleep(1000);
//                    ControlPanel.instance.bPlay.setEnabled(true);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
//                createWorkerAndSpeak();

        }

        if (b == ControlPanel.instance.bStop) {
            SpeakUtil.stop();
        }
    }

    public static void createWorkerAndSpeak() {
        sw = new SwingWorker() {

            @Override
            protected Object doInBackground() {
                SpeakUtil.speak();
                return null;
            }

            @Override
            protected void done() {
                System.out.println("finished");
                isFinished = true;
            }
        };
        sw.execute();
    }

    public static void createWorkerAndSpeak(int index) {
        sw = new SwingWorker() {

            @Override
            protected Object doInBackground() {
                SpeakUtil.speak(NumberClass.speakNumbers[index]);
                return null;
            }

            @Override
            protected void done() {
                System.out.println("finished");
                isFinished = true;
            }
        };
        sw.execute();
    }
}
