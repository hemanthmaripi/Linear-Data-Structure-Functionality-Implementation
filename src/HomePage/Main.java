package HomePage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main{


	public static void main(String[] args) {

		JFrame frame = new JFrame("Button Example");
		frame.setSize(370, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Linear DS Functionality");
		frame.setResizable(false);
		
		JLabel heading = new JLabel();
		heading.setText("Hii Choose Your DS");
		heading.setBounds(90, 10, 145, 50);
		heading.setFont(new Font("MV Boli",Font.BOLD,15));
		//heading.setHorizontalAlignment(JLabel.CENTER);
		//heading.setVerticalAlignment(JLabel.TOP);
		
		JButton array = new JButton("Array");
		array.setBounds(40, 95, 100, 30);
		array.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ArrayFrame().call();
				frame.dispose();
			}
		});
		JButton stack = new JButton("Stack");
		stack.setBounds(190, 95, 100, 30);
		stack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton queue = new JButton("Queue");
		queue.setBounds(40, 170, 100, 30);
		queue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JButton circularQueue = new JButton("Array");
		circularQueue.setBounds(190, 170, 100, 30);
		circularQueue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.add(heading);
		frame.add(array);
		frame.add(stack);
		frame.add(queue);
		frame.add(circularQueue);
		
		frame.setVisible(true);





	}



}

