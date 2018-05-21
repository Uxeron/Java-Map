package com.uxeron.map;

import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Data extends JFrame implements ActionListener {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private Flag flag;

	public Data(Flag flag) {
		this.flag = flag;

		Point location = MouseInfo.getPointerInfo().getLocation();
		setLocation((int) location.getX(), (int) location.getY());

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		add(new JLabel("Šalis"));

		textField1 = new JTextField(flag.getCountry(), 15);
		add(textField1);

		add(new JLabel("Kodas"));

		textField2 = new JTextField(flag.getCode(), 15);
		add(textField2);

		add(new JLabel("Įmonės pavadinimas"));

		textField3 = new JTextField(flag.getBusinessName(),15);
		add(textField3);

		add(new JLabel("Papildoma informacija"));

		textField4 = new JTextField(flag.getAdditionalInfo(),15);
		add(textField4);

		JButton ok = new JButton("Gerai");
		ok.addActionListener(this);
		add(ok);

		setAlwaysOnTop(true);
		setUndecorated(true);
		setSize(200, 230);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		flag.setCountry(textField1.getText());
		flag.setCode(textField2.getText());
		flag.setBusinessName(textField3.getText());
		flag.setAdditionalInfo(textField4.getText());
		dispose();
	}

}
