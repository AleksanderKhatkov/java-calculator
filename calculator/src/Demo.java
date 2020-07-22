import javax.swing.*;


public class Demo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		
		Calculator calc = new Calculator();
		frame.add(calc);
		
		frame.setVisible(true);

	}

}
