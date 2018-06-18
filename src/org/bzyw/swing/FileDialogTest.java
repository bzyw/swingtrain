package org.bzyw.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bzyw on 2018/6/14.
 */
public class FileDialogTest {
    JFrame frame = new JFrame("FileDialog");
    FileDialog dialogLoad = new FileDialog(frame, "选择文件", FileDialog.LOAD);
    FileDialog dialogSave = new FileDialog(frame, "保存文件", FileDialog.SAVE);
    JButton buttonLoad = new JButton("打开文件");
    JButton buttonSave = new JButton("保存文件");

    public void init() {
        buttonLoad.addActionListener(e -> {
            dialogLoad.setVisible(true);
            System.out.println(dialogLoad.getDirectory() + "," + dialogLoad.getFile());
        });
        buttonSave.addActionListener(e -> {
            dialogSave.setVisible(true);
            System.out.println(dialogSave.getDirectory() + "," + dialogSave.getFile());
        });
        frame.add(buttonLoad);
        frame.add(buttonSave, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FileDialogTest().init();
    }
}
