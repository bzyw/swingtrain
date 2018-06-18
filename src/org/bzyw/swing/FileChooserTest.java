package org.bzyw.swing;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by bzyw on 2018/6/14.
 */
public class FileChooserTest {
    JFrame frame = new JFrame("FileDialog");
    JFileChooser chooser1 = new JFileChooser(".");
    JButton buttonLoad = new JButton("打开文件");
    JButton buttonSave = new JButton("保存文件");

    public void init() {
        chooser1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser1.setMultiSelectionEnabled(true);

        buttonLoad.addActionListener(e -> {
            chooser1.showOpenDialog(frame);
            File[] files = chooser1.getSelectedFiles();
            for (File file : files) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttonSave.addActionListener(e -> {
            chooser1.showSaveDialog(frame);
            File[] files = chooser1.getSelectedFiles();
            for (File file : files) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(buttonLoad, BorderLayout.NORTH);
        frame.add(buttonSave, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FileChooserTest().init();
    }
}
