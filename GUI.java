package finalProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{
	public static String[] buttons = {"1","2","3","+","*","4","5","6","-","**","7","8","9","/","backspace",".","0","=","%","CE"};
	public JTextField textField = new JTextField();
	public GUI() {

	    JPanel calculatorPanel = new JPanel();
	    calculatorPanel.setLayout(new GridLayout(4,5));
	    for(int i =0; i< buttons.length;i++) {
	    	calculatorPanel.add(new JButton(buttons[i]));
	    }
	    JPanel mainContainer = new JPanel(new BorderLayout());
	    mainContainer.add(textField);
	    mainContainer.add(calculatorPanel, BorderLayout.SOUTH);
	    add(mainContainer);

	}
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("Simple Calculator");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
			 String action = e.getActionCommand();
			 for(int i = 0, i<buttons.length; i++){
				 if (action.equals(buttons[i])){

				 }
			 }
}
