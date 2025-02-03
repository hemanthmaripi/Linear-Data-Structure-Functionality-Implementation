package SwingProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LinkedListFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField insertValue;
	
	
	private LinkedList<String> dq = null;
	private JTextField index;
	
	
	/**
	 * Launch the application.
	 */
	private void clearForm() {
		insertValue.setText("");
		index.setText("");
	}
	
	
	private void create() {
		try {
		dq = new LinkedList<String>();
		clearForm();
		JOptionPane.showMessageDialog(null, "DEque created successfully");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Something Went Wrong please try again!");
		}
	}
	
	
	private void addFirst() {
		try {
		dq.addFirst(insertValue.getText());
		clearForm();
		JOptionPane.showMessageDialog(null, "Element added first successfully!");
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
		}
	}
	
	private void addLast() {
		try {
			dq.addLast(insertValue.getText());
			clearForm();
			JOptionPane.showMessageDialog(null, "Element added Last successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
			}
	}
	
	private void removeLast() {
		try {
			dq.removeLast();
			clearForm();
			JOptionPane.showMessageDialog(null, "Last Element Removed successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
			}
	}
	
	public void removeFirst() {
		try {
			dq.removeFirst();
			clearForm();
			JOptionPane.showMessageDialog(null, "First Element removed successfully!");
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Something Went Wrong Please try again!");
			}
	}
	
	public String display() {
		try {
			
			if(dq==null||dq.isEmpty()) {
				clearForm();
				return "Nothing Here To Show It is Empty!";
			}
			
			Iterator<String> itr = dq.iterator();
			StringBuilder sb = new StringBuilder();
			sb.append("| ");
			while(itr.hasNext()) {
				sb.append(itr.next()).append(" | ");
			}
			clearForm();
			return sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something Went wrong");
			return"Something Went Wrong!";
		}
	}
	/**
	 * Create the frame.
	 */
	public LinkedListFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 150, 512, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToQueue_1 = new JLabel("Welcome to LinkedList");
		lblWelcomeToQueue_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToQueue_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeToQueue_1.setBounds(30, 11, 439, 31);
		contentPane.add(lblWelcomeToQueue_1);
		
		JButton createFixedButton = new JButton("Create");
		createFixedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		createFixedButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		createFixedButton.setBackground(SystemColor.textHighlight);
		createFixedButton.setBounds(198, 89, 89, 23);
		contentPane.add(createFixedButton);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Enter Value:");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3_1.setBounds(10, 121, 98, 20);
		contentPane.add(lblNewLabel_1_1_3_1);
		
		insertValue = new JTextField();
		insertValue.setColumns(10);
		insertValue.setBounds(129, 123, 110, 20);
		contentPane.add(insertValue);
		
		JButton addFirst = new JButton("Add First");
		addFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFirst();
			}
		});
		addFirst.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		addFirst.setBackground(SystemColor.activeCaptionBorder);
		addFirst.setBounds(376, 120, 110, 23);
		contentPane.add(addFirst);
		
		JButton addLast = new JButton("Add Last");
		addLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLast();
			}
		});
		addLast.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		addLast.setBackground(SystemColor.activeCaptionBorder);
		addLast.setBounds(256, 118, 110, 23);
		contentPane.add(addLast);
		
		JLabel queueDisplayLabel = new JLabel();
		queueDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		queueDisplayLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		queueDisplayLabel.setBackground(Color.DARK_GRAY);
		queueDisplayLabel.setBounds(50, 294, 391, 104);
		contentPane.add(queueDisplayLabel);
		
		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queueDisplayLabel.setText(display());
			}
		});
		displayButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		displayButton.setBackground(SystemColor.activeCaptionBorder);
		displayButton.setBounds(197, 260, 98, 23);
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
		
		JButton removeFirst = new JButton("Remove First");
		removeFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFirst();
			}
		});
		removeFirst.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		removeFirst.setBackground(SystemColor.activeCaptionBorder);
		removeFirst.setBounds(129, 154, 110, 23);
		contentPane.add(removeFirst);
		
		JButton removeLast = new JButton("Remove Last");
		removeLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeLast();
			}
		});
		removeLast.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		removeLast.setBackground(SystemColor.activeCaptionBorder);
		removeLast.setBounds(256, 152, 110, 23);
		contentPane.add(removeLast);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Enter Index:");
		lblNewLabel_1_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3_1_1.setBounds(80, 188, 98, 20);
		contentPane.add(lblNewLabel_1_1_3_1_1);
		
		index = new JTextField();
		index.setColumns(10);
		index.setBounds(181, 188, 54, 20);
		contentPane.add(index);
		
		JButton btnAddAtIndex = new JButton("Add At Index");
		btnAddAtIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				dq.add(Integer.parseInt(index.getText()), insertValue.getText()); 
				JOptionPane.showMessageDialog(null, "Element Added At Given Index");
				}
				catch(Exception h) {
					JOptionPane.showMessageDialog(null, "Something Went Wrong");
				}
			}
		});
		btnAddAtIndex.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddAtIndex.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnAddAtIndex.setBackground(SystemColor.activeCaptionBorder);
		btnAddAtIndex.setBounds(256, 185, 115, 23);
		contentPane.add(btnAddAtIndex);
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dq.clear();
					JOptionPane.showMessageDialog(null, "List Emptied!");
				}
				catch(Exception k) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		btnRemoveAll.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		btnRemoveAll.setBackground(SystemColor.activeCaptionBorder);
		btnRemoveAll.setBounds(376, 152, 110, 23);
		contentPane.add(btnRemoveAll);
		
		JButton removeValueButton = new JButton("Remove Value");
		removeValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dq.remove(insertValue.getText());
					JOptionPane.showMessageDialog(null, "Element Removed");
				} catch(Exception x) {
					JOptionPane.showMessageDialog(null, "Element not exists");
				}
			}
		});
		removeValueButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		removeValueButton.setBackground(SystemColor.activeCaptionBorder);
		removeValueButton.setBounds(10, 152, 110, 23);
		contentPane.add(removeValueButton);
		
		

	}
}
