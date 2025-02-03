package SwingProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(425, 150, 512, 493);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(UIManager.getBorder("CheckBox.border"));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("CHOOSE YOUR DS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 11, 274, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Stack");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackFrame s = new StackFrame();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_1.setBounds(248, 111, 185, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnQueue = new JButton("Queue");
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Queue q = new Queue();
				q.setVisible(true);
				dispose();
			}
		});
		btnQueue.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnQueue.setBounds(39, 235, 185, 31);
		contentPane.add(btnQueue);
		
		JButton btnNewButton_1_1 = new JButton("DE Queue");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DEque dq = new DEque();
				dq.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(248, 235, 185, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Linked List");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedListFrame ll = new LinkedListFrame();
				ll.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_1_1_1.setBounds(127, 329, 185, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Array");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayFrame a = new ArrayFrame();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(39, 111, 185, 31);
		contentPane.add(btnNewButton_1_2);
		
		//setMinimumSize(new Dimension(512, 493));
		//pack();
	}
}
