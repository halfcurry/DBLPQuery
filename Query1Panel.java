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
	private query1 q1;
	private JTextField year1;
	private JTextField year2;
	private queryParameters parameters;
	private List<query1ResultRow> q1ResList; //for test purposes
	private int count = 0; //maintains number of elements displayed in table
	private JLabel resultshow;

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
		setBackground(new Color(220, 220, 220));
		setSize(750, 540);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DBLP Query Engine");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 40));
		lblNewLabel.setBounds(10, 0, 724, 82);
		add(lblNewLabel);
		
		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(238, 87, 496, 16);
		add(panel_2);
		
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
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(20, 91, 208, 409);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblQuery = new JLabel("Query1");
		lblQuery.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuery.setBounds(75, 40, 56, 14);
		panel.add(lblQuery);
		
		final JComboBox searchByBox = new JComboBox();
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
		
		final JCheckBox byYear = new JCheckBox("Sort by Year");
		byYear.setBounds(10, 259, 97, 23);
		panel.add(byYear);
		
		final JCheckBox byRelevance = new JCheckBox("Sort by Relevance");
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
				
				if( sByName ) byRelevance.setSelected(false);
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
				
				q1 = new query1();
				q1.execute(parameters);
				if( byYear.isSelected() ) q1.sortResultsByDate();
				else if( byRelevance.isSelected()) q1.sortResultsByRelevance();
				
				q1ResList = q1.getQuery1ResultRowList(); 
				
				resultshow = new JLabel("No. of results returned: " + q1ResList.size());
				resultshow.setHorizontalAlignment(SwingConstants.CENTER);
				resultshow.setFont(new Font("Tahoma", Font.BOLD, 15));
				resultshow.setBounds(75, 40, 56, 14);
				panel.add(resultshow);
				
				resultshow = new JLabel("No. of results returned: " + q1ResList.size());
				panel_2.add(resultshow);
				
				if( q1ResList.size() == 0 ){
					JOptionPane.showMessageDialog(frame_used, "No results to display!");
					return;
				}else{
					for (int i = 1; i <= 19; i++)
					{
						query1ResultRow q1rowtemp = q1ResList.get(i-1);
						table.getModel().setValueAt(i, i, 0); //
						table.getModel().setValueAt( q1rowtemp.getAuthors(), i, 1);
						table.getModel().setValueAt(q1rowtemp.getTitle(), i, 2);
						table.getModel().setValueAt(q1rowtemp.getPages(), i, 3);
						table.getModel().setValueAt(q1rowtemp.getYear(), i, 4);
						table.getModel().setValueAt( q1rowtemp.getVolume(), i, 5);
						table.getModel().setValueAt(q1rowtemp.getJournalTitle(), i, 6);
						table.getModel().setValueAt(q1rowtemp.getUrl(), i, 7);
						++count;
						
						
					}
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
				
				if( resultshow != null ){
					panel.remove(resultshow);
					resultshow = null;
				}
				
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
		panel_1.setBounds(238, 104, 496, 396);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
				int numLeft = q1ResList.size() - count;
				query1ResultRow arow;
				if (numLeft == 0)
				{
					JOptionPane.showMessageDialog(frame_used, "All results have been displayed");
					return;
				}
				if ((numLeft != 0) && (numLeft <= 19))
				{
					for (int i = temp; i < q1ResList.size(); i++)
					{
						arow = q1ResList.get(i);
						table.getModel().setValueAt(i, (i%19)+1, 0); //
						table.getModel().setValueAt( arow.getAuthors(), (i%19)+1, 1);
						table.getModel().setValueAt(arow.getTitle(), (i%19)+1, 2);
						table.getModel().setValueAt(arow.getPages(), (i%19)+1, 3);
						table.getModel().setValueAt(arow.getYear(), (i%19)+1, 4);
						table.getModel().setValueAt( arow.getVolume(), (i%19)+1, 5);
						table.getModel().setValueAt(arow.getJournalTitle(), (i%19)+1, 6);
						table.getModel().setValueAt(arow.getUrl(), (i%19)+1, 7);
						++count;
					}
				}
				if ((numLeft != 0) && (numLeft > 19))
				{
					for (int i = temp; i <= (temp + 18); i++)
					{
						arow = q1ResList.get(i);
						table.getModel().setValueAt(i, (i%19)+1, 0); //
						table.getModel().setValueAt( arow.getAuthors(), (i%19)+1, 1);
						table.getModel().setValueAt(arow.getTitle(), (i%19)+1, 2);
						table.getModel().setValueAt(arow.getPages(), (i%19)+1, 3);
						table.getModel().setValueAt(arow.getYear(), (i%19)+1, 4);
						table.getModel().setValueAt( arow.getVolume(), (i%19)+1, 5);
						table.getModel().setValueAt(arow.getJournalTitle(), (i%19)+1, 6);
						table.getModel().setValueAt(arow.getUrl(), (i%19)+1, 7);
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
		
	}
}
