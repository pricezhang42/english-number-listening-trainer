package listener;

import panel.panelOfSetting.GeneratedNumPanel;
import panel.panelOfSetting.TextPanel;
import util.ColorUtil;
import util.NumberClass;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class MyTextListener implements TextListener {
    @Override
    public void textValueChanged(TextEvent e) {
        String str = TextPanel.instance.textArea.getText();
        str = str.trim();
        String[] arr = str.split("\\s+");
        for(int i = 0; i < 10; i++){
            if (arr[i].equals(NumberClass.numbers[i])) {
                GeneratedNumPanel.instance.labels[i].setBackground(ColorUtil.rightColor);
            } else {
                GeneratedNumPanel.instance.labels[i].setBackground(ColorUtil.falseColor);
            }
        }
    }
}
