import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class Calculator extends JPanel implements ActionListener {
	private JTextField text;
	private JButton[] digitButtons = new JButton[10];
	private JButton butPlus, butMines, butMultiply, butDivide;
	private JButton butBackSpace, butClear, butCalculate;

	public Calculator() {
		super();
		initUI();
	}

	private void initUI() {
		text = new JTextField("");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBackground(Color.WHITE);
		text.setForeground(Color.GREEN);
		text.setEditable(false);

		this.setLayout(new GridLayout(4, 1, 10, 10));
		this.add(text);

		JPanel digitPanel = new JPanel();
		digitPanel.setLayout(new GridLayout(2, 5));
		for (int i = 0; i < digitButtons.length; ++i) {
			digitButtons[i] = new JButton("" + i);
			digitPanel.add(digitButtons[i]);
			digitButtons[i].addActionListener(this);
		}
		this.add(digitPanel);

		JPanel signPanel = new JPanel();
		signPanel.setLayout(new GridLayout(1, 4));

		butPlus = new JButton("+");
		signPanel.add(butPlus);
		butPlus.addActionListener(this);
		
		butMines = new JButton("-");
		signPanel.add(butMines);
		butMines.addActionListener(this);

		butMultiply = new JButton("*");
		signPanel.add(butMultiply);
		butMultiply.addActionListener(this);

		//!!! butDivide
		butDivide = new JButton("/");
		signPanel.add(butDivide);
		butDivide.addActionListener(this);


		this.add(signPanel);
		
		
		JPanel operationPanel = new JPanel();
		operationPanel.setLayout(new GridLayout(1, 3));
		
		butBackSpace = new JButton("BackSpace");
		operationPanel.add(butBackSpace);
		butBackSpace.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				text.setText(text.getText().substring(0,text.getText().length() -1));
			}
		});

		butClear = new JButton("Clear");
		operationPanel.add(butClear);
		butClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				text.setText("");
				
			}
		});
		
		butCalculate = new JButton("=");
		operationPanel.add(butCalculate);
		butCalculate.addActionListener(this);

		this.add(operationPanel);
	}
	
	private int operand1, operand2;
	private char sign;

	@Override
	public void actionPerformed(ActionEvent ae) {
		int ans = 0;
		String str = ((JButton) ae.getSource()).getText();
		switch(str) {
		case "+":
			sign = '+';
			break;
		case "-":
			sign = '-';
			break;
// *
		case "*":
				sign = '*';
			break;
// /
		case "/":
				sign = '/';
			break;
		case "=":
			String[] tmp = text.getText().split("[\\*\\+-\\/]");
			System.out.println("tmp=" + Arrays.toString(tmp));
			operand1 = Integer.valueOf(tmp[0]);
			operand2 = Integer.valueOf(tmp[1]);

			switch (sign) {
			case '+':
				ans = operand1 + operand2;
				break;
			case '-':
				ans = operand1 - operand2;
				break;
// *
			case '*':
			    ans = operand1 * operand2;
				break;
// :
			case '/':
				ans = operand1 / operand2;
				break;
			}
			break;

		}
		
		text.setText(text.getText() + str);
		if (str.equals("=")) {
			text.setText(text.getText() + ans);
		}
	}
}
