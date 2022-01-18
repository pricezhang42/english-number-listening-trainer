package listener;

import panel.panelOfSetting.GeneratedNumPanel;
import panel.panelOfSetting.TextPanel;
import util.ColorUtil;
import util.NumberClass;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyDocumentListener implements DocumentListener {

    public static MyDocumentListener instance = new MyDocumentListener();

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateShowPanel();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateShowPanel();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateShowPanel();
    }

    private void updateShowPanel() {
        String str = TextPanel.instance.textArea.getText().trim();
        String[] arr = str.split("\\s+");
        for (JLabel l : GeneratedNumPanel.instance.labels) {
            l.setBackground(UIManager.getColor("Label.background"));
        }

        if (arr[0].equals("")) {
            return;
        }

        for(int i = 0; i < 10; i++){
            if (i >= arr.length) {
                break;
            }
            if (arr[i].equals(NumberClass.numbers[i])) {
                GeneratedNumPanel.instance.labels[i].setBackground(ColorUtil.rightColor);
            } else {
                GeneratedNumPanel.instance.labels[i].setBackground(ColorUtil.falseColor);
            }
        }
    }
}
