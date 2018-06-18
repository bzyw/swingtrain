package org.bzyw.debugtool;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by bzyw on 2018/6/18.
 */
public class Frame {
	private JFrame frame = new JFrame("调试工具");
	/**
	 * 卡片容器
	 */
	private JPanel cardPanel = new JPanel();
	/**
	 * 选择容器
	 */
	private JPanel panel = new JPanel();

	private JFileChooser fileChooser = new JFileChooser();
	JTextArea services = new JTextArea("D:");
	JTextField textField3 = new JTextField("debug.identifier");

	/**
	 * 卡片布局器
	 */
	private CardLayout cardLayout = new CardLayout();
	/**
	 * 按钮容器
	 */
	private JPanel buttonPanel = new JPanel();

	/**
	 * 下一步按钮
	 */
	JButton next = new JButton("下一步");

	JTextArea textArea = new JTextArea();

	private void initCardPanel() {
		Box box1 = Box.createHorizontalBox();
		Box box2 = Box.createHorizontalBox();
		Box bigBox = Box.createVerticalBox();
		bigBox.add(box1);
		bigBox.add(box2);
		panel.add(bigBox);
		JLabel serviceLabel = new JLabel("选择微服务");
		serviceLabel.setSize(40, 20);
		box1.add(serviceLabel);
		services.setSize(120, 60);
		box1.add(new JScrollPane(services));
		JButton buttonSelect = new JButton("..");
		buttonSelect.setSize(20, 20);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		buttonSelect.addActionListener(e -> {
			if (e.getSource().equals(buttonSelect)) {
				fileChooser.showOpenDialog(panel);
				File[] files = fileChooser.getSelectedFiles();
				StringBuilder serviceName = new StringBuilder();
				for (File file : files) {
					try {
						serviceName.append(file.getCanonicalPath() + "\n");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				services.setText(serviceName.toString());
				panel.updateUI();
			}
		});
		box1.add(buttonSelect);
		JLabel debugLabel = new JLabel("debug.identifier:");
		box2.add(debugLabel);
		box2.add(textField3);
		cardPanel.setLayout(cardLayout);
		cardPanel.add("选择", panel);
		cardPanel.add("结果", textArea);
	}

	private void initButtonPanel() {
		next.addActionListener(e -> {
			if (next.equals(e.getSource())) {
				cardLayout.next(cardPanel);
				textArea.setText(services.getText());
			}
		});
		buttonPanel.add(next);
	}

	private void init() {
		initCardPanel();
		initButtonPanel();
		frame.add(cardPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Frame f = new Frame();
		f.init();
	}
}
