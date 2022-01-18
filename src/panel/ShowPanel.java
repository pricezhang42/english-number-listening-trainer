package panel;

import listener.ButtonListener;
import listener.CheckBoxListener;
import net.miginfocom.swing.MigLayout;
import panel.panelOfSetting.ExtraNumberPanel;
import panel.panelOfSetting.GeneratedNumPanel;
import panel.panelOfSetting.NumberPanel;
import panel.panelOfSetting.PhonePanel;

import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JPanel {
    public static ShowPanel instance = new ShowPanel();

    public JCheckBox checkBox = new JCheckBox("Visible", true);

    public ShowPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        MigLayout migLayoutPanel = new MigLayout("insets 10 10 10 10", "[]",
                "[][]");
        this.setLayout(migLayoutPanel);

        checkBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));

        this.add(GeneratedNumPanel.instance, "span");
        this.add(checkBox, "span");

        checkBox.addActionListener(CheckBoxListener.instance);
    }
}
