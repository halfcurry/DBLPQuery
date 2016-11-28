import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Query2Panel extends JPanel{

	private JFrame frame_used;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query2Panel window = new Query2Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Query2Panel(JFrame frame) {
		initialize(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		frame_used = frame;
		setBackground(new Color(220, 220, 220));
		setSize(750, 540);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DBLP Query Engine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 0, 724, 82);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(46, 107, 272, -8);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(10, 80, 724, 2);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(20, 91, 208, 409);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblQuery = new JLabel("Query2");
		lblQuery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuery.setBounds(75, 40, 56, 14);
		panel.add(lblQuery);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame_used.getContentPane().removeAll();
				frame_used.getContentPane().add(new MainPanel(frame_used));
				frame_used.getContentPane().revalidate();
				frame_used.getContentPane().repaint();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnBack.setBounds(61, 375, 89, 23);
		panel.add(btnBack);
		
		JLabel lblNoOfPublications = new JLabel("No. of publications");
		lblNoOfPublications.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNoOfPublications.setBounds(10, 117, 98, 14);
		panel.add(lblNoOfPublications);
		
		textField = new JTextField();
		textField.setBounds(112, 114, 65, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(20, 189, 79, 23);
		panel.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(112, 189, 79, 23);
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(238, 91, 496, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Author name"
			}
		));
		table.setForeground(new Color(0, 0, 0));
		table.setBounds(10, 11, 476, 353);
		panel_1.add(table);
		
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNext.setBackground(new Color(0, 0, 0));
		btnNext.setBounds(397, 375, 89, 23);
		panel_1.add(btnNext);
	}

}
