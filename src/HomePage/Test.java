package HomePage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Test {
	public static void main(String[] args) {
		
		ImageIcon img = new ImageIcon("logo.png"); //Image icon on the top
		
		Border border = BorderFactory.createLineBorder(Color.red); //Border to the application
		
		BufferedImage ogI = null;
		try {
			ogI = ImageIO.read(new File("logo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image resizedImage = ogI.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon imglabel = new ImageIcon(resizedImage);
		
		
		// All About Labels
		JLabel label = new JLabel();
		JLabel label1 = new JLabel();
		label.setText("Hi hello welcome"); //a text label
		//label.setIcon(imglabel);  //an image as a label
		label1.setText("Choose Your DS");
		//label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.red);
		label.setFont(new Font("MV Boli",Font.BOLD,20));
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		label.setIconTextGap(5);
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setBorder(border);
		//label.setVerticalAlignment(JLabel.TOP);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBounds(0, 0, 250,50);
		
		//All About Panels
		JPanel redpanel = new JPanel();
		redpanel.setBackground(Color.RED);
		redpanel.setBounds(0,0,100,100);
		redpanel.setAlignmentX(0);
		
		JButton button = new JButton();
		
		
		
		
		JFrame frame = new JFrame();	//JFrame created
		
		frame.setVisible(true);  //used visible the jframe
		frame.setSize(500,500);  //size of the frame
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Testing frame");	//title of the jframe
		frame.add(label);	//Adding the label(text and image)
		frame.add(label1);
		frame.setIconImage(img.getImage());		//setting the imageicon on the top
		//frame.add(redpanel);
		
	}
}
