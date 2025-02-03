package SwingProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class ArrayFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel arrayDisplayingLabel;
	private JTextField sizeField;
	private JTextField insertValue;
	private JTextField insertPosition;
	private JTextField datType;
	private JTextField deletePosition;
	private Object array;
	private int size;
	private String dataType;
	private Object value;
	private int position;
	
	private void clearField() {
		sizeField.setText("");
		datType.setText("");
		insertValue.setText("");
		insertPosition.setText("");
		deletePosition.setText("");
	}

	private void create() {
		try {
			dataType = datType.getText().trim();
			size = Integer.parseInt(sizeField.getText().trim());
			switch (dataType) {
			case "int":
				array = new int[size];
				break;

			case "double":
				array = new double[size];
				break;

			case "String":
				array = new String[size];
				break;

			case "float":
				array = new float[size];
				break;

			default:
				JOptionPane.showMessageDialog(null, "Invalid Data type! Use int, double, float or String.");
				clearField();
				return;
			}
			JOptionPane.showMessageDialog(null, "Array Created Succesfully");
			clearField();
		}

		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid Size Input Please enter an integer");
			clearField();
		}
	}

	private void insert() throws Exception {
		try {
			position = Integer.parseInt(insertPosition.getText().trim());
			value = parseValue(insertValue.getText().trim());

			if (position < 0 || position >= size) {
				JOptionPane.showMessageDialog(null, "Invalid index!");
				clearField();
				return;
			}
			Array.set(array, position, value);
			clearField();
			JOptionPane.showMessageDialog(null, "Insertion Successfull");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error inserting value: " + e.getMessage());
			clearField();
		}
	}

	private Object parseValue(String text) throws Exception {
		switch (dataType) {
		case "int":
			return Integer.parseInt(text);
		case "float":
			return Float.parseFloat(text);
		case "double":
			return Double.parseDouble(text);
		case "String":
			return text;
		default:
			JOptionPane.showMessageDialog(null, "Unsupported datatype");
		}
		throw new Exception("Unsupported Format");
	}

	private void delete() {
		try {
			int position = Integer.parseInt(deletePosition.getText().trim());

			if (position < 0 || position >= size) {
				clearField();
				JOptionPane.showMessageDialog(null, "Invalis index!");
				return;
			}
			Array.set(array, position, dataType.equals("String") ? null : 0);
			JOptionPane.showMessageDialog(null, "Deletion Successfull");
			clearField();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error deleting value " + e.getMessage());
			clearField();
		}
	}

	private String display() {
		try {
			switch (dataType) {
			case "int": {
				int arr[] = (int[]) array;
				StringBuilder sb = new StringBuilder();
				sb.append("Array: | ");
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]).append(" | "); // Each element on a new line
				}
				String s = new String(sb);
				return s;
			}

			case "String": {
				String arr[] = (String[]) array;
				StringBuilder sb = new StringBuilder();
				sb.append("Array: ");
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]).append(",  "); // Each element on a new line
				}
				String s = new String(sb);
				return s;
			}

			case "float": {
				float arr[] = (float[]) array;
				StringBuilder sb = new StringBuilder();
				sb.append("Array: ");
				for (int i = 0; i < arr.length; i++) {
					sb.append(arr[i]).append(",  "); // Each element on a new line
				}
				String s = new String(sb);
				return s;
			}

			case "double": {
				double arr[] = (double[]) array;
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Create an araay first!");
			return "Idiot! Create Array First...!";
		}
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ArrayFrame() {
		// setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(425, 150, 512, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to Array!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(110, 11, 248, 64);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter the size of array:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 106, 177, 20);
		contentPane.add(lblNewLabel_1);

		sizeField = new JTextField();
		sizeField.setBounds(185, 108, 46, 20);
		contentPane.add(sizeField);
		sizeField.setColumns(10);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnNewButton.setBounds(185, 146, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Value:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 193, 102, 20);
		contentPane.add(lblNewLabel_1_1);

		insertValue = new JTextField();
		insertValue.setColumns(10);
		insertValue.setBounds(114, 195, 73, 20);
		contentPane.add(insertValue);

		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Position:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(240, 193, 118, 20);
		contentPane.add(lblNewLabel_1_1_1);

		insertPosition = new JTextField();
		insertPosition.setColumns(10);
		insertPosition.setBounds(381, 195, 41, 20);
		contentPane.add(insertPosition);

		JButton insertButton = new JButton("Insert");
		insertButton.setBackground(SystemColor.activeCaptionBorder);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insert();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Given input is not a type of " + dataType);
				}
			}
		});
		insertButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		insertButton.setBounds(185, 226, 89, 23);
		contentPane.add(insertButton);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Enter Position:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 262, 118, 20);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_3 = new JLabel("Enter Data Type:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(241, 106, 131, 20);
		contentPane.add(lblNewLabel_1_1_3);

		datType = new JTextField();
		datType.setColumns(10);
		datType.setBounds(376, 108, 46, 20);
		contentPane.add(datType);

		deletePosition = new JTextField();
		deletePosition.setColumns(10);
		deletePosition.setBounds(138, 264, 41, 20);
		contentPane.add(deletePosition);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		deleteButton.setBackground(SystemColor.activeCaptionBorder);
		deleteButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		deleteButton.setBounds(283, 261, 89, 23);
		contentPane.add(deleteButton);

		// Constructor setup for Display button
		JButton displayArrayButton = new JButton("Display");
		displayArrayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrayDisplayingLabel.setText(display()); // Update text instead of creating a new label
			}
		});
		displayArrayButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		displayArrayButton.setBackground(SystemColor.activeCaptionBorder);
		displayArrayButton.setBounds(184, 305, 90, 23);
		contentPane.add(displayArrayButton);

		// Initialize the display label in the constructor
		arrayDisplayingLabel = new JLabel();
		arrayDisplayingLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		arrayDisplayingLabel.setBackground(Color.DARK_GRAY);
		arrayDisplayingLabel.setBounds(72, 339, 325, 66);
		contentPane.add(arrayDisplayingLabel);

		JButton goToHomeButton = new JButton("Home");
		goToHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		goToHomeButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		goToHomeButton.setBackground(SystemColor.activeCaptionBorder);
		goToHomeButton.setBounds(381, 424, 89, 23);
		contentPane.add(goToHomeButton);
		
		JButton moreButton = new JButton("More About Array");
		moreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		moreButton.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		moreButton.setBackground(SystemColor.activeCaptionBorder);
		moreButton.setBounds(22, 426, 147, 23);
		contentPane.add(moreButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					array = null;
					JOptionPane.showMessageDialog(null, "Array resetted!");
				}
				catch(Exception i) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		btnReset.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnReset.setBackground(SystemColor.activeCaptionBorder);
		btnReset.setBounds(218, 424, 90, 23);
		contentPane.add(btnReset);

		// setMinimumSize(new Dimension(512, 493));
		// pack();
	}
}
