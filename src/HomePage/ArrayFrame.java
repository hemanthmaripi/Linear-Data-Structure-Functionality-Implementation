package HomePage;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ArrayFrame {
	class ArrayFunc{
		private void create(int size) {
			// TODO Auto-generated method stub
			int arr[] = new int[size];
		}
		
		
	}
	public void call(){
	MyFrame array = new MyFrame("Array Functionality");
	array.setLayout(null);
	
	JLabel name = new JLabel();
	name.setText("Array");
	name.setBounds(90, 10, 145, 50);
	name.setFont(new Font("MV Boli",Font.BOLD,15));
	
	JButton createarr = new JButton("Create");
	array.setBounds(40, 95, 100, 30);
	array.add(createarr);
	array.add(name);
	array.setVisible(true);
	}
}
