package listener;

import panel.ShowPanel;
import panel.panelOfSetting.GeneratedNumPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxListener implements ActionListener {

    public static CheckBoxListener instance = new CheckBoxListener();

    @Override
    public void actionPerformed(ActionEvent e) {
        GeneratedNumPanel.instance.setVisible(ShowPanel.instance.checkBox.isSelected());
    }
}
