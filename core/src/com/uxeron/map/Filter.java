package com.uxeron.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Filter extends JFrame implements ActionListener {
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	public Filter() {
		setLocation(0, 0);

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		add(new JLabel(" - - - - - FILTRAVIMAS - - - - - "));

		add(new JLabel("Šalis"));

		textField1 = new JTextField(15);
		add(textField1);

		add(new JLabel("Kodas"));

		textField2 = new JTextField(15);
		add(textField2);

		add(new JLabel("Įmonės pavadinimas"));

		textField3 = new JTextField(15);
		add(textField3);

		add(new JLabel("Papildoma informacija"));

		textField4 = new JTextField(15);
		add(textField4);

		JButton clear = new JButton("Išvalyti");
		clear.addActionListener(this);
		add(clear);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(200, 280);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		textField1.setText("");
		textField2.setText("");
		textField3.setText("");
		textField4.setText("");
	}

	public String getCountry() {
		return textField1.getText();
	}


	public String getCode() {
		return textField2.getText();
	}


	public String getBusinessName() {
		return textField3.getText();
	}


	public String getAdditionalInfo() {
		return textField4.getText();
	}
}
