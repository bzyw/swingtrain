package org.bzyw.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by bzyw on 2018/6/18.
 */
public class JTableTest {
    private JFrame frame = new JFrame("JTable");
    private JTable table = null;
    Object[] columnNames = {"Type", "Company", "Shares", "Price", "Boolean"};
    Object[][] data = {
            {"Buy", "IBM", new Integer(1000), new Double(80.50), false},
            {"Sell", "MicroSoft", new Integer(2000), new Double(6.25), true},
            {"Sell", "Apple", new Integer(3000), new Double(7.35), true},
            {"Buy", "Nortel", new Integer(4000), new Double(20.00), false}
    };

    public void init() {
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {
            private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Double.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(frame, "是否退出系统？", "退出系统", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        JTableTest tableTest = new JTableTest();
        tableTest.init();
    }
}
