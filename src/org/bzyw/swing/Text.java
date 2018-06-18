package org.bzyw.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bzyw on 2018/6/11.
 */
public class Text extends JFrame implements ActionListener {
    JButton jb1 = new JButton("复制");
    JButton jb2 = new JButton("粘贴");
    JButton jb3 = new JButton("剪切");
    JPanel jpanel = new JPanel();
    JTextArea jta = new JTextArea("Hello", 100, 150);
    JScrollPane jscrollPane = new JScrollPane();

    public Text() {
        //Container container = this.getContentPane();
        //container.setLayout(new BorderLayout());

        setLayout(new FlowLayout());
        jta.setTabSize(40);
        jta.setLineWrap(true);// 激活自动换行功能
        jta.setWrapStyleWord(true);// 激活断行不断字功能
        jta.setBackground(Color.pink);
        jta.setVisible(true);
        //jscrollPane.add(jta);
        add(jta);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jpanel.add(jb1);
        jpanel.add(jb2);
        jpanel.add(jb3);
        add(jpanel);

        //container.add(jscrollPane, BorderLayout.CENTER);
        //container.add(jpanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocation(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            jta.copy();
        } else if (e.getSource() == jb2) {
            jta.paste();
        } else if (e.getSource() == jb3) {
            jta.cut();
        }
    }

    public static void main(String[] args) {
        Text text = new Text();
    }
}
