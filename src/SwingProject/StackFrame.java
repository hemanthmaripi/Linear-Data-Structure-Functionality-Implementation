package SwingProject;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;


public class StackFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dataTypeField;
	private JTextField insertField;
	private JTextField sizeField;
	private JLabel stackDisplayLabel;
	private Object stack;
	private int size;
	private int index = 0;
	private String dataType;
	private Object value;
	private int pointer=-1;
	
	

	/**
	 * Launch the application.
	 */
	
	private void clearForm() {
		sizeField.setText("");
		insertField.setText("");
		dataTypeField.setText("");
	}
	
	private void create() {
		try {
			size = Integer.parseInt(sizeField.getText());
			dataType = dataTypeField.getText().trim();
			
			switch(dataType) {
			case "int" : stack = new int[size]; break;
			case "float" : stack = new float[size]; break;
			case "String" : stack = new String[size]; break;
			case "double" : stack = new double[size]; break;
			default : JOptionPane.showMessageDialog(null, "Invalid Data Type! please enter int, float, double or String");
			
			return;
			}
			clearForm();
			JOptionPane.showMessageDialog(null, "Stack created successfully");
		}
		catch(Exception e) {
			clearForm();
			JOptionPane.showMessageDialog(null, "Invalid size input please enter an integer!");
		}
	}
	
	private void push() {
		try {
			if(index<size) {
				value = parseValue(insertField.getText().trim());
				Array.set(stack, index, value);
				index++;
				pointer++;
				JOptionPane.showMessageDialog(null, "Element PUSHED successfully!");
				clearForm();
			}
			else {
				clearForm();
				JOptionPane.showMessageDialog(null, "Stack is Full!");
			}
		}
		catch(Exception e) {
			clearForm();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void pop() {
		if(pointer<0&&index==0) {
			clearForm();
			JOptionPane.showMessageDialog(null, "Stack is Empty!");
		}
		else {
			switch(dataType) {
			case "String" : value=null;
			break;
			default: value=0;
			break;
			}
			Array.set(stack, pointer, value);
			index--;
			pointer--;
			clearForm();
			JOptionPane.showMessageDialog(null, "Element POPPED successfully");
		}
	}
	
	private String display() {
		try {
			if(pointer==-1) {
				return "Stack is empty";
			}
		switch(dataType) {
		case "int" : {
		int arr[] = (int[]) stack;
		StringBuilder sb = new StringBuilder();
		sb.append("Stack: | ");
		for (int i = 0; i <= pointer; i++) {
			sb.append(arr[i]).append(" | "); // Each element on a new line
		}
		String s = new String(sb);
		return s;
		}
		
		case "String" : {
			String arr[] = (String[]) stack;
			StringBuilder sb = new StringBuilder();
			sb.append("Array: ");
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(",  "); // Each element on a new line
			}
			String s = new String(sb);
			return s;
			}
		
		case "float" : {
			float arr[] = (float[])stack;
			StringBuilder sb = new StringBuilder();
			sb.append("Array: ");
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(",  "); // Each element on a new line
			}
			String s = new String(sb);
			return s;
		}
		
		case "double" : {
			double arr[] = (double[])stack;
			StringBuilder sb = new StringBuilder();
			sb.append("Array: ");
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(",  "); // Each element on a new line
			}
			String s = new String(sb);
			return s;
		}
		
		default: 
			JOptionPane.showMessageDialog(null, "Unsupported data type!");
			return "Nothing here!";
		} 
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "create as tack first");
			return "Idiot! Create Stack First...!";
			}
	}

		
	private Object parseValue(String text) throws Exception {
		switch(dataType ) {
		case "int" : return Integer.parseInt(text);
		case "float" : return Float.parseFloat(text);
		case "double" : return Double.parseDouble(text);
		case "String" : return text;
		default: JOptionPane.showMessageDialog(null, "Unsupported data type");
		}
		throw new Exception("Unsupported Format");
	}
	/**
	 * Create the frame.
	 */
	public StackFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 150, 512, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToQueue = new JLabel("Welcome to Stack!");
		lblWelcomeToQueue.setBounds(125, 10, 245, 31);
		lblWelcomeToQueue.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToQueue.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblWelcomeToQueue);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Enter Data Type:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(256, 108, 133, 20);
		contentPane.add(lblNewLabel_1_1_3);
		
		dataTypeField = new JTextField();
		dataTypeField.setColumns(10);
		dataTypeField.setBounds(385, 110, 46, 20);
		contentPane.add(dataTypeField);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		createButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		createButton.setBackground(SystemColor.activeCaptionBorder);
		createButton.setBounds(188, 149, 89, 23);
		contentPane.add(createButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Value:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 205, 102, 20);
		contentPane.add(lblNewLabel_1_1);
		
		insertField = new JTextField();
		insertField.setColumns(10);
		insertField.setBounds(115, 205, 73, 20);
		contentPane.add(insertField);
		
		JButton pushButton = new JButton("Push");
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				push();
			}
		});
		pushButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		pushButton.setBackground(SystemColor.activeCaptionBorder);
		pushButton.setBounds(229, 202, 89, 23);
		contentPane.add(pushButton);
		
		JButton popButton = new JButton("Pop");
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pop();
			}
		});
		popButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		popButton.setBackground(SystemColor.activeCaptionBorder);
		popButton.setBounds(351, 204, 89, 23);
		contentPane.add(popButton);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stackDisplayLabel.setText(display());
			}
		});
		displayButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		displayButton.setBackground(SystemColor.activeCaptionBorder);
		displayButton.setBounds(187, 265, 90, 23);
		contentPane.add(displayButton);
		
		stackDisplayLabel = new JLabel();
		stackDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stackDisplayLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		stackDisplayLabel.setBackground(Color.DARK_GRAY);
		stackDisplayLabel.setBounds(40, 299, 391, 104);
		contentPane.add(stackDisplayLabel);
		
		JButton moreButton = new JButton("More About Stack");
		moreButton.setHorizontalAlignment(SwingConstants.LEFT);
		moreButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		moreButton.setBackground(SystemColor.activeCaptionBorder);
		moreButton.setBounds(10, 420, 173, 23);
		contentPane.add(moreButton);
		
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		homeButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		homeButton.setBackground(SystemColor.activeCaptionBorder);
		homeButton.setBounds(397, 420, 89, 23);
		contentPane.add(homeButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the size of Stack:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(11, 108, 177, 20);
		contentPane.add(lblNewLabel_1);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(188, 110, 46, 20);
		contentPane.add(sizeField);
		
		JButton homeButton_1 = new JButton("Reset");
		homeButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					stack = null;
					JOptionPane.showMessageDialog(null, "Stack resetted");
				}
				catch(Exception b) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		homeButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		homeButton_1.setBackground(SystemColor.activeCaptionBorder);
		homeButton_1.setBounds(239, 420, 89, 23);
		contentPane.add(homeButton_1);
		
		
	}
}
