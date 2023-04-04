import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10]; //10 numbers buttons 0-9
	
	//all the other buttons 
	JButton[] functionButtons = new JButton[8]; 
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton;
	
	JPanel panel; //panel to hold of the buttons
	Font myFont = new Font ("Ink Free",Font.BOLD,30); // font style
	
	double num1=0,num2=0,result=0;
	char operator; ///*-+
	
	Calculator(){ //constructor
		
		frame = new JFrame("Calculator"); //inici the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the program
		frame.setSize(420,550); // calculator size
		frame.setLayout(null); 
		
		//tester
		textfield=new JTextField();
		textfield.setBounds(50, 25,300,50); 
		textfield.setFont(myFont);
		textfield.setEditable(false); // can't write inside the textfield
		
		//buttons related to functions
		addButton= new JButton("+");
		subButton= new JButton("-");
		mulButton= new JButton("*");
		divButton= new JButton("/");
		decButton= new JButton(".");
		equButton= new JButton("=");
		delButton= new JButton("Delete");
		clrButton= new JButton("Clear");
		
		//add buttons to array
		functionButtons[0]= addButton;
		functionButtons[1]= subButton;
		functionButtons[2]= mulButton;
		functionButtons[3]= divButton;
		functionButtons[4]= decButton;
		functionButtons[5]= equButton;
		functionButtons[6]= delButton;
		functionButtons[7]= clrButton;
		
		//iterate function buttons, 
		for(int i =0;i<8;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false); //Take out focus button
			
		}
		
		//iterate number buttons, 
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));	
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false); //Take out focus button
		}
		
		//delete & control buttons
		delButton.setBounds(50,430,145,50);
		clrButton.setBounds(205,430,145,50);
		
		panel = new JPanel(); //instanciate
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10)); //rows and colums + space 10 pixels
		panel.setBackground(Color.lightGray); //background numbers
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton); // +
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton); // -
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton); // *
		panel.add(decButton); // .
		panel.add(numberButtons[0]);
		panel.add(equButton); // =
		panel.add(divButton); // /
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator(); //instance calculator class
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}