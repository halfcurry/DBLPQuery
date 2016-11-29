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
	private JTextField name;
	private JTextField sinceYear;
	private JTextField year1;
	private JTextField year2;
	private query1Parameters parameters;
	private ArrayList<Integer> arr; //for test purposes
	private int count = 0; //maintains number of elements displayed in table
	

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
		
		arr = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++)
		{
			arr.add(i);
		}
		
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
		
		JComboBox searchByBox = new JComboBox();
		searchByBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchByBox.setModel(new DefaultComboBoxModel(new String[] {"Search by", "Author name", "Title tags"}));
		searchByBox.setBounds(52, 88, 98, 20);
		panel.add(searchByBox);
		
		JLabel lblNametitleTags = new JLabel("Name/Title tags");
		lblNametitleTags.setBounds(10, 135, 89, 14);
		panel.add(lblNametitleTags);
		
		name = new JTextField();
		name.setBounds(97, 132, 101, 20);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Since Year");
		lblNewLabel_1.setBounds(10, 178, 65, 14);
		panel.add(lblNewLabel_1);
		
		sinceYear = new JTextField();
		sinceYear.setText("YYYY");
		sinceYear.setBounds(97, 175, 34, 20);
		panel.add(sinceYear);
		sinceYear.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Custom Range");
		lblNewLabel_2.setBounds(10, 220, 89, 14);
		panel.add(lblNewLabel_2);
		
		year1 = new JTextField();
		year1.setText("YYYY");
		year1.setBounds(97, 217, 34, 20);
		panel.add(year1);
		year1.setColumns(10);
		
		year2 = new JTextField();
		year2.setText("YYYY");
		year2.setBounds(145, 217, 34, 20);
		panel.add(year2);
		year2.setColumns(10);
		
		JCheckBox byYear = new JCheckBox("Sort by Year");
		byYear.setBounds(10, 259, 97, 23);
		panel.add(byYear);
		
		JCheckBox byRelevance = new JCheckBox("Sort by Relevance");
		byRelevance.setBounds(10, 300, 128, 23);
		panel.add(byRelevance);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame_used.getContentPane().removeAll();
				frame_used.getContentPane().add(new MainPanel(frame_used));
				frame_used.getContentPane().revalidate();
				frame_used.getContentPane().repaint();
			}
		});
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setBackground(Color.BLACK);
		buttonBack.setFont(new Font("Calibri", Font.PLAIN, 14));
		buttonBack.setBounds(61, 375, 89, 23);
		panel.add(buttonBack);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sBy = (String) searchByBox.getSelectedItem();
				boolean sByName = true;
				if (sBy.equals("Author name"))
				{
					sByName = true;
				}
				if (sBy.equals("Title tags"))
				{
					sByName = false;
				}
				if (sBy.equals("Search by"))
				{
					JOptionPane.showMessageDialog(frame_used, "Please search by Author name or Title tags");
					return;
				}
				
				String name_used = name.getText();
				if (name_used.equals(""))
				{
					JOptionPane.showMessageDialog(frame_used, "Please enter Name/Title tag");
					return;
				}
				String syear = sinceYear.getText();
				String y1 = year1.getText();
				String y2 = year2.getText();
				
				if ((syear.equals("YYYY")) && (y1.equals("YYYY") || y2.equals("YYYY")))
				{
					JOptionPane.showMessageDialog(frame_used, "Please enter the years in 'Since Year' or 'Custom Range' fields");
					return;
				}
				else
				{
					if (!syear.equals("YYYY"))
					{
						try
						{
							int syint = Integer.parseInt(syear);
							//is an integer
						}
						catch(NumberFormatException exc)
						{
							JOptionPane.showMessageDialog(frame_used, "Please enter the year as an integer");
							return;
						}
					}
					else
					{
						try
						{
							int y1int = Integer.parseInt(y1);
							int y2int = Integer.parseInt(y2);
							//are integers
						}
						catch(NumberFormatException exc)
						{
							JOptionPane.showMessageDialog(frame_used, "Please write the years in 'Since Year' or 'Custom Range' fields");
							return;
						}
					}
				}
				
				boolean sByYear;
				if ((!byYear.isSelected()) && (!byRelevance.isSelected()))
				{
					JOptionPane.showMessageDialog(frame_used, "Please select one of the sort by options");
					return;
				}
				if (byYear.isSelected())
					sByYear = true;
				else
					sByYear = false;
				
				if (syear.equals("YYYY"))
					parameters = new query1Parameters(sByName, name_used, Integer.parseInt(y1), Integer.parseInt(y2));
				else
					parameters = new query1Parameters(sByName, name_used, Integer.parseInt(syear), 2016);
				
				for (int i = 1; i <= 19; i++)
				{
					/*table.getModel().setValueAt(i, i, 0);
					table.getModel().setValueAt("Author" + (i), i, 1);
					table.getModel().setValueAt("Title" + (i), i, 2);
					table.getModel().setValueAt(i, i, 3);
					table.getModel().setValueAt(1889 + (i), i, 4);
					table.getModel().setValueAt("Volume" + (i), i, 5);
					table.getModel().setValueAt("Book Title" + (i), i, 6);
					table.getModel().setValueAt("url" + (i), i, 7);*/
					
					int num = arr.get(i-1);
					table.getModel().setValueAt(num, i, 0);
					++count;
				}
			}
		});
		buttonSearch.setBounds(10, 341, 78, 23);
		panel.add(buttonSearch);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchByBox.setSelectedItem("Search by");
				name.setText("");
				sinceYear.setText("YYYY");
				year1.setText("YYYY");
				year2.setText("YYYY");
				byYear.setSelected(false);
				byRelevance.setSelected(false);
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"SNo", "Authors", "Title", "Pages", "Year", "Volume", "Book Title", "url"},
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
				
			}
		});
		buttonReset.setBounds(114, 341, 84, 23);
		panel.add(buttonReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(238, 91, 496, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"SNo", "Authors", "Title", "Pages", "Year", "Volume", "Book Title", "url"},
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
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		panel_1.add(table);
		
		JButton buttonNext = new JButton("Next");
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"SNo", "Authors", "Title", "Pages", "Year", "Volume", "Book Title", "url"},
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
				
				int temp = count;
				int numLeft = arr.size() - count;
				int num;
				if (numLeft == 0)
				{
					JOptionPane.showMessageDialog(frame_used, "All results have been displayed");
					return;
				}
				if ((numLeft != 0) && (numLeft <= 19))
				{
					for (int i = temp; i < arr.size(); i++)
					{
						num = arr.get(i);
						table.getModel().setValueAt(num, (i%19)+1, 0);
						++count;
					}
				}
				if ((numLeft != 0) && (numLeft > 19))
				{
					for (int i = temp; i <= (temp + 18); i++)
					{
						num = arr.get(i);
						table.getModel().setValueAt(num, (i%19)+1, 0);
						++count;
					}
				}
			}
		});
		buttonNext.setForeground(new Color(255, 255, 255));
		buttonNext.setFont(new Font("Calibri", Font.PLAIN, 14));
		buttonNext.setBackground(new Color(0, 0, 0));
		buttonNext.setBounds(397, 375, 89, 23);
		panel_1.add(buttonNext);
		
		//result test
		/*ArrayList<ResultTest> results = new ArrayList<>();
		
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
		results.add(obj1);*/
		
		
		
	}
}
