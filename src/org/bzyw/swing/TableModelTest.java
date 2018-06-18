package org.bzyw.swing;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * Created by bzyw on 2018/6/18.
 */
public class TableModelTest {
    private JFrame frame = new JFrame("TableModel2");
    private JTable table = null;
    private MyTableModel myTableModel = new MyTableModel();

    private void init() {
        table = new JTable(myTableModel);
        table.getColumnModel().getColumn(0)
                .setCellEditor(new DefaultCellEditor(new JCheckBox()));
        frame.add(new JScrollPane(table));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel {
        @Override
        public int getRowCount() {
            return 3;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex > 0) {
                return "value[" + rowIndex + "," + columnIndex + "]";
            } else {
                return false;
            }
        }
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    public static void main(String[] args) {
        TableModelTest modelTest = new TableModelTest();
        modelTest.init();
    }
}
