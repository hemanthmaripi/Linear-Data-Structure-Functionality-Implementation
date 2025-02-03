package SwingProject;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Queue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dataTypeField;
	private JTextField insertValue;
	private JTextField sizeField;
	private int size;
	private String dataType;
	private Object queue;
	private int index = 0;
	private int point;
	
	

	/**
	 * Launch the application.
	 */
	
	private void clearForm() {
		sizeField.setText("");
		insertValue.setText("");
		dataTypeField.setText("");
	}
	
	private void create() {
		try {
			size = Integer.parseInt(sizeField.getText());
			dataType = dataTypeField.getText().trim();
			
			switch(dataType) {
			case "int" : queue = new int[size]; break;
			case "float" : queue = new float[size]; break;
			case "String" : queue = new String[size]; break;
			case "double" : queue = new double[size]; break;
			default : JOptionPane.showMessageDialog(null, "Invalid Data Type! please enter int, float, double or String");
			return;
			}
			clearForm();
			JOptionPane.showMessageDialog(null, "Queue created successfully");
		}
		catch(Exception e) {
			clearForm();
			JOptionPane.showMessageDialog(null, "Invalid size input please enter an integer!");
		}
	}
	
	private void enqueue() {
		try {
			if(index<size) {
				if(queue==null) {
					clearForm();
					JOptionPane.showMessageDialog(null, "No Queue present here!");
					return;
				}
				Object value = parseValue(insertValue.getText().trim());
				Array.set(queue, index, value);
				index++;
				point++;
				JOptionPane.showMessageDialog(null, "Element ENQUEUED succesfully!");
				clearForm();
			}
			else {
				if(queue==null) {
					clearForm();
					JOptionPane.showMessageDialog(null, "No Queue present here!");
					return;
				}
				clearForm();
				JOptionPane.showMessageDialog(null, "Queue is full!");				
			}
			
		}
		catch(Exception e) {
			clearForm();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private Object parseValue(String text) throws Exception{
		switch(dataType) {
		case "int" : return Integer.parseInt(text);
		case "float" : return Float.parseFloat(text);
		case "double" : return Double.parseDouble(text);
		case "String" : return text;
		default : 
			JOptionPane.showMessageDialog(null, "Unsupported Data Type");
		}
		throw new Exception("Unsupported Format");
	}
	
	private void dequeue() {
		try {
			if(index==0) {
				if(queue==null) {
					JOptionPane.showMessageDialog(null, "Queue empty!");
					clearForm();
					return;
				}
				JOptionPane.showMessageDialog(null, "No Queue present here!");
				clearForm();
				return;
			}
			System.arraycopy(queue, 1, queue, 0, --index);
			point--;
			JOptionPane.showMessageDialog(null, "Element DEQUEUED successfully");
			clearForm();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			clearForm();
		}
	}
	
	
	
	private String display() {
		if(queue==null) {
			return "No Queue present here!";
		}
		StringBuilder sb = new StringBuilder("Queue: | ");
		StringBuilder s = new StringBuilder();
		for(int i=0;i<index;i++) {
			s.append(Array.get(queue, i)).append(" | ");
		}
		if(s.isEmpty()) {
			System.out.println(s);
			return "Queue is Empty";
		}
		else {
		return sb.append(s).toString();
		}
	}

	
	private void reset() {
		try {
			 queue = null;      // Clear the queue reference
		        index = 0;         // Reset index to 0
		        point = -1;      // Reset pointer to -1
		        size = 0;          // Optionally reset size (if needed)
		        dataType = null;   // Reset data type (if you want a fresh start)
			JOptionPane.showMessageDialog(null, "Reset Done");
			clearForm();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			clearForm();
		}
	}
	/**
	 * Create the frame.
	 */
	public Queue() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 150, 512, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToQueue_1 = new JLabel("Welcome to Queue!");
		lblWelcomeToQueue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToQueue_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeToQueue_1.setBounds(112, 11, 245, 31);
		contentPane.add(lblWelcomeToQueue_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Enter Data Type:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(243, 106, 133, 20);
		contentPane.add(lblNewLabel_1_1_3);
		
		dataTypeField = new JTextField();
		dataTypeField.setColumns(10);
		dataTypeField.setBounds(379, 108, 46, 20);
		contentPane.add(dataTypeField);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		createButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		createButton.setBackground(SystemColor.textHighlight);
		createButton.setBounds(188, 137, 89, 23);
		contentPane.add(createButton);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Enter Value:");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3_1.setBounds(10, 190, 98, 20);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		insertValue = new JTextField();
		insertValue.setColumns(10);
		insertValue.setBounds(109, 192, 98, 20);
		contentPane.add(insertValue);
		
		JButton enqueueButton = new JButton("Enqueue");
		enqueueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enqueue();
			}
		});
		enqueueButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		enqueueButton.setBackground(SystemColor.activeCaptionBorder);
		enqueueButton.setBounds(219, 189, 110, 23);
		contentPane.add(enqueueButton);
		
		JButton dequeueButton = new JButton("Dequeue");
		dequeueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dequeue();
			}
		});
		dequeueButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		dequeueButton.setBackground(SystemColor.activeCaptionBorder);
		dequeueButton.setBounds(338, 189, 110, 23);
		contentPane.add(dequeueButton);
		
		JLabel queueDisplayLabel = new JLabel();
		queueDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueDisplayLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		queueDisplayLabel.setBackground(Color.DARK_GRAY);
		queueDisplayLabel.setBounds(46, 283, 391, 104);
		contentPane.add(queueDisplayLabel);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queueDisplayLabel.setText(display());
			}
		});
		btnDisplay.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnDisplay.setBackground(SystemColor.activeCaptionBorder);
		btnDisplay.setBounds(188, 249, 90, 23);
		contentPane.add(btnDisplay);
		
		JButton btnHome = new JButton("More About Queue");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnHome.setBackground(SystemColor.activeCaptionBorder);
		btnHome.setBounds(10, 420, 173, 23);
		contentPane.add(btnHome);
		
		JButton btnPush_1_1 = new JButton("Home");
		btnPush_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnPush_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnPush_1_1.setBackground(SystemColor.activeCaptionBorder);
		btnPush_1_1.setBounds(373, 420, 89, 23);
		contentPane.add(btnPush_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the size of Queue:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 106, 197, 20);
		contentPane.add(lblNewLabel_1);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(197, 108, 46, 20);
		contentPane.add(sizeField);
		
		
		
		JButton btnPush_1_1_1 = new JButton("Reset");
		btnPush_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnPush_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnPush_1_1_1.setBackground(SystemColor.activeCaptionBorder);
		btnPush_1_1_1.setBounds(217, 422, 89, 23);
		contentPane.add(btnPush_1_1_1);
		
		
	}
}
