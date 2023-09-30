import java.awt.*;
import java.awt.event.FocusListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class H2_110916042{
	static JFrame F = new JFrame("Calculator");
	static JTextField display;
	static JPanel content;
	static JButton numbers[];
	static JButton plus;
	static JButton minus;
	static JButton divided;
	static JButton multiplied;
	static JButton point;
	static JButton clear;
	static JButton equal;
	static JPanel pl;
	
	public static void Calculator() {
		//砞﹚ゅ块
		content= new JPanel();
		display = new JTextField(20);
		content.add("North", display);
		
		//panelButton
		GridLayout gl =new GridLayout(5,5,15,10);
		pl = new JPanel();
		pl.setLayout(gl);
		
		//计秙
		numbers = new JButton[10];
		for(int i = 0 ; i < 10 ; i++) {
			numbers[i] = new JButton(String.valueOf(i));
		}
		
		//才腹秙
		plus = new JButton("+");
		minus = new JButton("-");
		divided = new JButton("/");
		multiplied = new JButton("*");
		clear = new JButton("C");
		point = new JButton(".");
		equal = new JButton("=");
		
		//穝糤Button秈pl
		pl.add(numbers[7]);
		pl.add(numbers[8]);
		pl.add(numbers[9]);
		pl.add(divided);
		pl.add(numbers[4]);
		pl.add(numbers[5]);
		pl.add(numbers[6]);
		pl.add(multiplied);
		pl.add(numbers[1]);
		pl.add(numbers[2]);
		pl.add(numbers[3]);
		pl.add(minus);
		pl.add(numbers[0]);
		pl.add(point);
		pl.add(equal);
		pl.add(plus);
		pl.add(clear);
		
		//盢ButtonactionListener
		Listener Mylistener = new Listener();
		
		for(int i = 0 ; i < 10 ; i++) {
			numbers[i].addActionListener(Mylistener);
		}
		clear.addActionListener(Mylistener);
		plus.addActionListener(Mylistener);
		minus.addActionListener(Mylistener);
		divided.addActionListener(Mylistener);
		multiplied.addActionListener(Mylistener);
		point.addActionListener(Mylistener);
		equal.addActionListener(Mylistener);
		
		//北狾
		content.add("Center" , pl);
		F.setSize(300,300);
		F.setContentPane(content);
		F.setVisible(true);
	}
	
	static class Listener implements ActionListener{
		//operator玡计
		String front = "",back ="";
		int j ; //魁operator竚
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clear) {
				display.setText(" ");
			}
			else if(e.getSource() == numbers[0]){
				String num = display.getText();
				num = num + "0";
				display.setText(num);
			}
			else if(e.getSource() == numbers[1]){
				String num = display.getText();
				num = num + "1";
				display.setText(num);
			}
			else if(e.getSource() == numbers[2]){
				String num = display.getText();
				num = num + "2";
				display.setText(num);
			}
			else if(e.getSource() == numbers[3]){
				String num = display.getText();
				num = num + "3";
				display.setText(num);
			}
			else if(e.getSource() == numbers[4]){
				String num = display.getText();
				num = num + "4";
				display.setText(num);
			}
			else if(e.getSource() == numbers[5]){
				String num = display.getText();
				num = num + "5";
				display.setText(num);
			}
			else if(e.getSource() == numbers[6]){
				String num = display.getText();
				num = num + "6";
				display.setText(num);
			}
			else if(e.getSource() == numbers[7]){
				String num = display.getText();
				num = num + "7";
				display.setText(num);
			}
			else if(e.getSource() == numbers[8]){
				String num = display.getText();
				num = num + "8";
				display.setText(num);
			}
			else if(e.getSource() == numbers[9]){
				String num = display.getText();
				num = num + "9";
				display.setText(num);
			}
			else if(e.getSource() == plus){
				String num = display.getText();
				num = num + "+";
				display.setText(num);
			}
			else if(e.getSource() == minus){
				String num = display.getText();
				num = num + "-";
				display.setText(num);
			}
			else if(e.getSource() == divided){
				String num = display.getText();
				num = num + "/";
				display.setText(num);
			}
			else if(e.getSource() == multiplied){
				String num = display.getText();
				num = num + "*";
				display.setText(num);
			}
			else if(e.getSource() == point){
				String num = display.getText();
				num = num + ".";
				display.setText(num);
			}
			else if(e.getSource() == equal){
				String num = display.getText();
				char[] total = num.toCharArray();
				char operator = 0;
				
				for(int i = 0 ; i < total.length ; i++) {
					if(total[i] == '+' || total[i] == '-' ||total[i] == '*' || total[i] == '/') {
						operator = total[i];
						j = i+1;
						break;
					}
					else {
						front = front + String.valueOf(total[i]);  //operator玡计
					}
				}
				
				for( ; j < total.length ; j++) {
					back = back + String.valueOf(total[j]); //operator计
				}
				
//				for( ++i;i < total.length;i ++)
//					back += String.valueOf(total[i]);
				
				double[]a = new double[2];
				//盢玡ㄢ﹃锣Θdouble
				a[0] = Double.parseDouble(front); 
				a[1] = Double.parseDouble(back);
				
				double sum = 0.0;
				if(operator == '+')
					sum = a[0] + a[1];
				else if(operator == '-')
					sum = a[0] - a[1];
				else if(operator == '*')
					sum = a[0] * a[1];
				else if(operator == '/' && a[1] != 0)
					sum = a[0] / a[1];
					
				num = num + " = " + String.valueOf(sum);
				display.setText(num);
				
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Calculator();   
	}
}
