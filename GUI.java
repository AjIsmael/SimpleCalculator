package finalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import finalProject.Calculator;
public class GUI extends JFrame implements ActionListener{
	public static String[] buttons = {"1","2","3","+","*","4","5","6","-","**","7","8","9","/","backspace",".","0","=","%","CE"};
	public JTextField textField = new JTextField();
	public static int flag = 0;
	public GUI() {

	    JPanel calculatorPanel = new JPanel();
	    calculatorPanel.setLayout(new GridLayout(4,5));
	    for(int i =0; i< buttons.length;i++) {
	    	JButton button = new JButton(buttons[i] );
	    	button.addActionListener(this);
	    	calculatorPanel.add(button);
	    }
	    JPanel mainContainer = new JPanel(new BorderLayout());
	    mainContainer.add(textField);
	    mainContainer.add(calculatorPanel, BorderLayout.SOUTH);
	    add(mainContainer);

	}
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("Calculator");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
			 String action = e.getActionCommand();
			 for(int i = 0; i<buttons.length; i++){
				 if (action.equals(buttons[i])){
					 String firstState = textField.getText();
				
					 if(firstState.equals("Infinity")||firstState.equals("-Infinity")) {
						 firstState = ""; 
						 }
				 
					 if(buttons[i].equals("backspace")) {
						 firstState = firstState.substring(0, firstState.length() - 1);
						 textField.setText(firstState); 
					 }
					 else if(buttons[i].equals("CE")){
						 firstState = "";
						 textField.setText(firstState);
					 }
					 else if(buttons[i].equals("+")||buttons[i].equals("-")||buttons[i].equals("/")||buttons[i].equals("%")||buttons[i].equals("*")||buttons[i].equals("**")||buttons[i].equals("=")) {
						 
						 if(firstState.contains("+")||firstState.contains("-")||firstState.contains("*")||firstState.contains("/")||firstState.contains("**")||firstState.contains("%")) {
							 String sign = findArthemiticSign(firstState);
							 //need to consider negative number
							 if(firstState.indexOf(sign)==(firstState.length()-1)||firstState.charAt(firstState.length()-1)=='-') {
								 if(buttons[i].equals("-")) {
									 textField.setText(firstState + buttons[i]);
									 break;
								 }
								 firstState = firstState.substring(0, firstState.length() - 1);
								 textField.setText(firstState + buttons[i]);
								 break;
							 }
							 if(sign.equals("**")) {
								 if(firstState.indexOf(sign)==(firstState.length()-2)) {
									 firstState = firstState.substring(0, firstState.length() - 2);
									 textField.setText(firstState + buttons[i]);
									 break;
								 }
								 
							 }
							 String[] arguments= {"",""};
							 if(sign.equals("-")) {
								 if(flag == 0) {
									 int index = firstState.indexOf("-", 1);
									 arguments[0] = firstState.substring(0, index);
									 arguments[1] = firstState.substring(index+1);
								 } else {
									 textField.setText(firstState + buttons[i]);
								 }
							 }else {
							 arguments = firstState.split(Pattern.quote(sign));
							 }
							 double argument1 = Double.parseDouble(arguments[0]);
							 double argument2 = Double.parseDouble(arguments[1]);
							 double answer=0;
							 if(sign.equals("+")) {
								 answer = Calculator.addition(argument1, argument2);
							 } else if(sign.equals("-")) {
								 answer = Calculator.subtraction(argument1,argument2);
							 }else if(sign.equals("**")) {
								 answer = Calculator.power(argument1,argument2);
							 }else if(sign.equals("/")) {
								 answer = Calculator.division(argument1,argument2);
							 }else if(sign.equals("%")) {
								 answer = Calculator.modulus(argument1,argument2);
							 }else if(sign.equals("-")) {
								 answer = Calculator.subtraction(argument1,argument2);
							 } else {
								 answer = Calculator.multiplication(argument1,argument2);
							 }
							 String answerInString = String.format("%.2f", answer);
							 if (answerInString.equals("Infinity")||answerInString.equals("-Infinity")) {
								 textField.setText(answerInString);
							 }else {
								 if(buttons[i].equals("=")) {
									 textField.setText(answerInString);
									 flag = 1;
								 } else {
									 textField.setText(answerInString + buttons[i]);
									 flag=0;
								 }
							 }
						 }
						 else {
							 if(firstState.length()==0) {
								 textField.setText("0" +firstState+buttons[i]);
							 } else if (buttons[i].equals("=")) {
								 textField.setText(firstState);
								 flag=1;
							 }
							 else{
								 textField.setText(firstState+buttons[i]);
								 flag=0;
								
							 }
						 }
					 } 
					 
					 else {
						 if(flag==1) {
							textField.setText(buttons[i]);
							flag=0;
						 } else {
							 textField.setText(firstState+buttons[i]);
						 }
						 
					 }
				 }
			 }
	}
	public static String findArthemiticSign(String str) {
		String arthemiticSign;
		if (str.contains("+")) {
			arthemiticSign="+";
		} else if(str.contains("/")) {
			arthemiticSign="/";
		}else if(str.contains("**")) {
			arthemiticSign="**";
		}else if(str.contains("%")) {
			arthemiticSign="%";
		}else if(str.contains("*")) {
			arthemiticSign="*";
		}else {
			arthemiticSign="-";
		}
		return arthemiticSign;
	}
}
