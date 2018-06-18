package org.bzyw.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by bzyw on 2018/6/13.
 */
public class CardLayoutTest {
    JFrame frame = new JFrame("CardLayoutTest");
    String[] names = new String[]{"1", "2", "3", "4", "5"};
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel(new GridLayout());

    public void init() {
        CardLayout cardLayout = new CardLayout();
        panel.setLayout(cardLayout);
        for (String name : names) {
            panel.add(name, new JButton(name));
        }

        ActionListener listener = e -> {
            switch (e.getActionCommand()) {
                case "previous":
                    cardLayout.previous(panel);
                    break;
                case "next":
                    cardLayout.next(panel);
                    break;
                case "first":
                    cardLayout.first(panel);
                    break;
                case "last":
                    cardLayout.last(panel);
                    break;
            }
        };
        JButton previous = new JButton("previous");
        previous.addActionListener(listener);
        JButton next = new JButton("next");
        next.addActionListener(listener);
        JButton first = new JButton("first");
        first.addActionListener(listener);
        JButton last = new JButton("last");
        last.addActionListener(listener);
        panel2.add(first);
        panel2.add(previous);
        panel2.add(next);
        panel2.add(last);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CardLayoutTest().init();
    }
}
