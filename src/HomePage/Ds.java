package HomePage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ds {
	public static void main(String[] args) {
		JFrame ds = new JFrame();
		ds.setSize(400,400);
		ds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ds.setLayout(null);
		JButton button = new JButton("Array");
		button.setBounds(80,70,140,30);
		 button.setPreferredSize(new Dimension(50, 40));
		ds.add(button);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Arra arr = new Arra();
				arr.newframe();
			}
		});
		
		ds.setVisible(true);
	}
}
