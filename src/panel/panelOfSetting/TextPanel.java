package panel.panelOfSetting;

import listener.MyDocumentListener;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    public static TextPanel instance = new TextPanel();

    public JTextArea textArea = new JTextArea("1 2 3 4 5 6 7 8 9 10",6,26);

    public TextPanel() {
        textArea.setLineWrap(true);    //设置文本域中的文本为自动换行
        textArea.setForeground(Color.BLACK);    //设置组件的背景色
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));    //修改字体样式
//        jta.setBackground(Color.YELLOW);    //设置按钮背景色
        JScrollPane jsp = new JScrollPane(textArea);    //将文本域放入滚动窗口
        Dimension size = textArea.getPreferredSize();    //获得文本域的首选大小
        jsp.setSize(size);
        this.add(jsp);    //将JScrollPane添加到JPanel容器中

        textArea.getDocument().addDocumentListener(MyDocumentListener.instance);
    }
}
