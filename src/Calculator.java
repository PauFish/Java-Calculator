import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10]; //10 numbers buttons 0-9
	
	//all the other buttons 
	JButton[] functionButtons = new JButton[9]; 
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	
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
		delButton= new JButton("Del");
		clrButton= new JButton("Clr");
		negButton= new JButton("(-)");
		
		
		//add buttons to array
		functionButtons[0]= addButton;
		functionButtons[1]= subButton;
		functionButtons[2]= mulButton;
		functionButtons[3]= divButton;
		functionButtons[4]= decButton;
		functionButtons[5]= equButton;
		functionButtons[6]= delButton;
		functionButtons[7]= clrButton;
		functionButtons[8]= negButton;
		
		//iterate function buttons, 
		for(int i=0;i<9;i++) {
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
		
		//delete & control buttons & negative
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel = new JPanel(); //Instantiate
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10)); //rows and columns + space 10 pixels
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
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator(); //instance calculator class
	}

	//make the buttons work
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				//when you press a button will aper inside the text field
				textfield.setText(textfield.getText().concat(String.valueOf(i))); 
			}
		}
		
		//adds a .  in the text field 
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));  
		}
		
		
		// + action
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator= '+'; //Assign operator, a character
			textfield.setText("");  //clear text field
				}
				// + action
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator= '-'; //Assign operator, a character
			textfield.setText("");  //clear text field
			}	
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator= '*'; //Assign operator, a character
			textfield.setText("");  //clear text field
			}	
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator= '/'; //Assign operator, a character
			textfield.setText("");  //clear text field
			}
		
		// math
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;	
			case'*':
				result = num1 * num2;
				break;	
			case'/':
				result = num1 / num2;
				break;	
				
			}
			//update text field
			textfield.setText(String.valueOf(result));
			num1=result; //to continue to reuse number
			
		}
		//clear button
		if(e.getSource() == clrButton) {
			textfield.setText("");  //clear text field
			}	
		//delete button
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++){ //deletes the last number to the left
				textfield.setText(textfield.getText()+string.charAt(i));
			}
			}
		
		// '-' math -9, -515.005
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			
			
			}
	}
	
	
}