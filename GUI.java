package finalProject;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
	public GUI() {
		String[] buttons = {"1","2","3","+","*","4","5","6","-","**","7","8","9","/","backspace",".","0","=","%","CE"};
	    JPanel calculatorPanel = new JPanel();
	    calculatorPanel.setLayout(new GridLayout(4,5));
	    for(int i =0; i< buttons.length;i++) {
	    	calculatorPanel.add(new JButton(buttons[i]));
	    }
	    JPanel outputPanel = new JPanel();
	    outputPanel.setLayout(new GridLayout(2,1));
	    outputPanel.add(new JTextField());
	    outputPanel.add(new JTextField());
	    
	    JPanel mainContainer = new JPanel(new BorderLayout());
	    mainContainer.add(outputPanel, BorderLayout.NORTH);
	    mainContainer.add(calculatorPanel);
	    
	}
	public static void main(String[] args) {
		GUI frame = new GUI(); 
		frame.setTitle("Simple Calculator");
		frame.setSize(400, 400); 
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); 
	}
}
