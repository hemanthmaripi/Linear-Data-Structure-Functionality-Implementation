package SwingProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DEque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insertValue;
	private JTextField sizeField;
	private int size;
	
	private ArrayDeque<String> dq = null;
	
	
	/**
	 * Launch the application.
	 */
	
	private void clearFields() {
		sizeField.setText("");
		insertValue.setText("");
	}
	
	
	private void createFixed() {
		try {
		size = Integer.parseInt(sizeField.getText());
		dq = new ArrayDeque<String>(size);
		JOptionPane.showMessageDialog(null, "DEque created successfully");
		clearFields();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Something Went Wrong please try again!");
			clearFields();
		}
	}
	
	
	private void createDynamic() {
		try {
		dq = new ArrayDeque<String>();
		clearFields();
		JOptionPane.showMessageDialog(null, "DEque created successfully");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Something Went Wrong please try again!");
			clearFields();
		}
	}
	
	private void addFirst() {
		try {
		dq.addFirst(insertValue.getText());
		clearFields();
		JOptionPane.showMessageDialog(null, "Element added first successfully!");
		} catch(Exception e) {
			clearFields();
			JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
		}
	}
	
	private void addLast() {
		try {
			dq.addLast(insertValue.getText());
			clearFields();
			JOptionPane.showMessageDialog(null, "Element added first successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
				clearFields();
			}
	}
	
	private void removeLast() {
		try {
			dq.removeLast();
			clearFields();
			JOptionPane.showMessageDialog(null, "Last Element Removed successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
				clearFields();
			}
	}
	
	public void removeFirst() {
		try {
			dq.removeLast();
			clearFields();
			JOptionPane.showMessageDialog(null, "Element added first successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
				clearFields();
			}
	}
	
	public String display() {
		try {
			
			if(dq==null||dq.isEmpty()) {
				clearFields();
				return "Nothing Here To Show It is Empty!";
			}
			
			Iterator<String> itr = dq.iterator();
			StringBuilder sb = new StringBuilder();
			sb.append("| ");
			while(itr.hasNext()) {
				sb.append(itr.next()).append(" | ");
			}
			clearFields();
			return sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
			clearFields();
			JOptionPane.showMessageDialog(null, "Something Went wrong");
			return"Something Went Wrong!";
		}
	}
	/**
	 * Create the frame.
	 */
	public DEque() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 150, 512, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToQueue_1 = new JLabel("Welcome to Doubly Ended Queue!");
		lblWelcomeToQueue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToQueue_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeToQueue_1.setBounds(30, 11, 439, 31);
		contentPane.add(lblWelcomeToQueue_1);
		
		JButton createFixedButton = new JButton("Create");
		createFixedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createFixed();
			}
		});
		createFixedButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		createFixedButton.setBackground(SystemColor.textHighlight);
		createFixedButton.setBounds(232, 93, 89, 23);
		contentPane.add(createFixedButton);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Enter Value:");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3_1.setBounds(90, 151, 98, 20);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		insertValue = new JTextField();
		insertValue.setColumns(10);
		insertValue.setBounds(198, 153, 98, 20);
		contentPane.add(insertValue);
		
		JButton addFirst = new JButton("Add First");
		addFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFirst();
			}
		});
		addFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		addFirst.setBackground(SystemColor.activeCaptionBorder);
		addFirst.setBounds(20, 189, 110, 23);
		contentPane.add(addFirst);
		
		JButton addLast = new JButton("Add Last");
		addLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLast();
			}
		});
		addLast.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		addLast.setBackground(SystemColor.activeCaptionBorder);
		addLast.setBounds(140, 189, 110, 23);
		contentPane.add(addLast);
		
		JLabel queueDisplayLabel = new JLabel();
		queueDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueDisplayLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		queueDisplayLabel.setBackground(Color.DARK_GRAY);
		queueDisplayLabel.setBounds(57, 283, 391, 104);
		contentPane.add(queueDisplayLabel);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queueDisplayLabel.setText(display());
			}
		});
		displayButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		displayButton.setBackground(SystemColor.activeCaptionBorder);
		displayButton.setBounds(188, 249, 98, 23);
		contentPane.add(displayButton);
		
		JButton detailsButton = new JButton("More About Queue");
		detailsButton.setHorizontalAlignment(SwingConstants.LEFT);
		detailsButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		detailsButton.setBackground(SystemColor.activeCaptionBorder);
		detailsButton.setBounds(10, 420, 179, 23);
		contentPane.add(detailsButton);
		
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
		homeButton.setBounds(373, 420, 89, 23);
		contentPane.add(homeButton);
		
		sizeField = new JTextField();
		sizeField.setColumns(10);
		sizeField.setBounds(176, 96, 46, 20);
		contentPane.add(sizeField);
		
		
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dq=null;
				JOptionPane.showMessageDialog(null, "DE queue Reset done!");
			}
		});
		resetButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		resetButton.setBackground(SystemColor.activeCaptionBorder);
		resetButton.setBounds(232, 420, 89, 23);
		contentPane.add(resetButton);
		
		JButton dynamicCreateButton = new JButton("<html><center>Click here to<br>Dynamic DEQUE</center></html>");
		dynamicCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createDynamic();
			}
		});
		dynamicCreateButton.setVerticalAlignment(SwingConstants.TOP);
		dynamicCreateButton.setFont(new Font("Segoe UI Black", Font.BOLD, 10));
		dynamicCreateButton.setBackground(SystemColor.textHighlight);
		dynamicCreateButton.setBounds(342, 85, 123, 31);
		contentPane.add(dynamicCreateButton);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Enter size to create<br>dynamic DE que</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 88, 177, 42);
		contentPane.add(lblNewLabel_1);
		
		JButton removeFirst = new JButton("Remove First");
		removeFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFirst();
			}
		});
		removeFirst.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		removeFirst.setBackground(SystemColor.activeCaptionBorder);
		removeFirst.setBounds(260, 191, 110, 23);
		contentPane.add(removeFirst);
		
		JButton removeLast = new JButton("Remove Last");
		removeLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeLast();
			}
		});
		removeLast.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		removeLast.setBackground(SystemColor.activeCaptionBorder);
		removeLast.setBounds(376, 191, 110, 23);
		contentPane.add(removeLast);
		
		

	}
}
