package org.bzyw.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by bzyw on 2018/6/11.
 */
public class ButtonTrain implements ActionListener {
    JFrame frame = new JFrame();
    private JButton copy = new JButton("copy");
    private JButton paste = new JButton("paste");
    private JButton cut = new JButton("cut");
    private JTextArea textArea = new JTextArea(10, 15);

    @Override
    public void actionPerformed(ActionEvent e) {
        if (copy.equals(e.getSource())) {
            textArea.copy();
        } else if (paste.equals(e.getSource())) {
            textArea.paste();
        } else if (cut.equals(e.getSource())) {
            textArea.cut();
        }
    }

    public ButtonTrain() {
        //Container container = frame.getContentPane();
        //container.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "退出系统", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        frame.setSize(400, 300);
        //frame.pack();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        int windowHeight = frame.getHeight();
        int windowWidth = frame.getWidth();
        frame.setLocation((screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);

        frame.setLayout(new BorderLayout());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.pink);
        JScrollPane scollPane = new JScrollPane(textArea);
        frame.add(scollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(copy);
        panel.add(paste);
        panel.add(cut);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ButtonTrain button = new ButtonTrain();
    }
}
