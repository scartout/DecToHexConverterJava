package pl.scartout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SimpleJButton {
	SimpleJButton(){    
		JFrame f=new JFrame("Audio calculator");
					//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(270, 50, 140, 30);    
					//enter name label
		JLabel label2 = new JLabel();		
		label2.setText("Result is automatically be copied to clipboard");
		label2.setBounds(10, 0, 430, 50);
					//empty label which will show event after button clicked
		JLabel label = new JLabel();		
		label.setText("Enter stop number:");
		label.setBounds(10, 10, 150, 100);
					//empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 70, 450, 100);
					//textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(130, 50, 130, 30);
					//add to frame
		f.add(label2);
		f.add(label1);
		f.add(textfield);
		f.add(label);
		f.add(b);    
		f.setSize(470,300);    
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		b.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Calculator calculator = new Calculator();
				try{
					int num = Integer.parseInt(textfield.getText());
					label1.setText(calculator.count(num));
				}catch(InputMismatchException e) {
					label1.setText("Input must be an integer!");
			    }catch(IllegalArgumentException e2) {
			    	label1.setText("Value must be an integer greater or equal 0 and less than or equal 999999999");
			    }
								
			}          
	      });
		}         

 }