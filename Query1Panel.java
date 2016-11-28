import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;


public class Query1Panel extends JPanel{

	private JFrame frame_used;
	private JTable table;
	private JTextField textField;
	private JTextField txtYyyy;
	private JTextField txtYyyy_1;
	private JTextField txtYyyy_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Query1Panel window = new Query1Panel();
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
	public Query1Panel(JFrame frame) {
		initialize(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		frame_used = frame;
		//frame = new JFrame();
		//frame.setSize(750, 540);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblQuery = new JLabel("Query1");
		lblQuery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuery.setBounds(75, 40, 56, 14);
		panel.add(lblQuery);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Search by", "Author name", "Title tags"}));
		comboBox.setBounds(52, 88, 98, 20);
		panel.add(comboBox);
		
		JLabel lblNametitleTags = new JLabel("Name/Title tags");
		lblNametitleTags.setBounds(10, 135, 89, 14);
		panel.add(lblNametitleTags);
		
		textField = new JTextField();
		textField.setBounds(97, 132, 101, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Since Year");
		lblNewLabel_1.setBounds(10, 178, 65, 14);
		panel.add(lblNewLabel_1);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		txtYyyy.setBounds(97, 175, 34, 20);
		panel.add(txtYyyy);
		txtYyyy.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Custom Range");
		lblNewLabel_2.setBounds(10, 220, 89, 14);
		panel.add(lblNewLabel_2);
		
		txtYyyy_1 = new JTextField();
		txtYyyy_1.setText("YYYY");
		txtYyyy_1.setBounds(97, 217, 34, 20);
		panel.add(txtYyyy_1);
		txtYyyy_1.setColumns(10);
		
		txtYyyy_2 = new JTextField();
		txtYyyy_2.setText("YYYY");
		txtYyyy_2.setBounds(145, 217, 34, 20);
		panel.add(txtYyyy_2);
		txtYyyy_2.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sort by Year");
		chckbxNewCheckBox.setBounds(10, 259, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Sort by Relevance");
		chckbxNewCheckBox_1.setBounds(10, 300, 128, 23);
		panel.add(chckbxNewCheckBox_1);
		
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
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(10, 341, 78, 23);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(114, 341, 84, 23);
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(238, 91, 496, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"SNo", "Authors", "Title", "Pages", "Year", "Volume", "Book Title", "url"
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
		
		//result test
		ArrayList<ResultTest> results = new ArrayList<>();
		
		ResultTest obj1 = new ResultTest();
		obj1.sno = 1;
		ArrayList<String> a = new ArrayList<>();
		a.add("Peter");
		a.add("Parker");
		a.add("Tony");
		a.add("Stark");
		obj1.authors = a;
		obj1.title = "Marvel";
		obj1.journal = "Civil War";
		obj1.pages = "100";
		obj1.url = "www.marvel.com";
		obj1.volume = "2";
		obj1.year = "1991";
		results.add(obj1);
		
		
	}
}
