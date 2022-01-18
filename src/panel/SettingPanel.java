package panel;

import net.miginfocom.swing.MigLayout;
import panel.panelOfSetting.*;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {
    public static SettingPanel instance = new SettingPanel();

    public SettingPanel() {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        MigLayout migLayoutPanel = new MigLayout("insets 5 5 5 5", "[]", "[][][][]15[]17[]");
        this.setLayout(migLayoutPanel);

        this.add(NumberPanel.instance, "span");
        this.add(ExtraNumberPanel.instance, "span");
        this.add(PhonePanel.instance, "span");
        this.add(DatePanel.instance, "span");
        this.add(ExtraPanel.instance, "span");
        this.add(TextPanel.instance, "span");
    }
}
