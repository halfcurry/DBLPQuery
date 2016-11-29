import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.*;


public class Query2Panel extends JPanel{

	private JFrame frame_used;
	private JTable table;
	private JTextField nPub;
	private query2 q2;
	private query2Parameters parameters;
	private List<query2ResultRow> q2ResList; //for test purposes
	private int count = 0; //maintains number of elements displayed in table
	private JLabel resultshow;

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
		
		nPub = new JTextField();
		nPub.setBounds(112, 114, 65, 20);
		panel.add(nPub);
		nPub.setColumns(10);
		
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String np = nPub.getText();
				if (np.equals(""))
				{
					JOptionPane.showMessageDialog(frame_used, "Please enter the number of publications");
					return;
				}
				
				int numPub;
				try
				{
					numPub = Integer.parseInt(np);
					//is an int
				}
				catch(NumberFormatException exc)
				{
					JOptionPane.showMessageDialog(frame_used, "Please enter the number of publications as an integer");
					return;
				}
				
				parameters = new query2Parameters(numPub);
				
				q2 = new query2();
				q2.execute(parameters);
				
				q2ResList = q2.getQuery2ResultRowList(); 
				
				resultshow = new JLabel("No. of results returned: " + q2ResList.size());
				resultshow.setHorizontalAlignment(SwingConstants.CENTER);
				resultshow.setFont(new Font("Tahoma", Font.BOLD, 15));
				resultshow.setBounds(75, 40, 56, 14);
				panel.add(resultshow);
				
				if( q2ResList.size() == 0 ){
					JOptionPane.showMessageDialog(frame_used, "No results to display!");
					return;
				}else{
					for (int i = 1; i <= 19; i++)
					{
						query2ResultRow q2rowtemp = q2ResList.get(i-1);
						table.getModel().setValueAt(i, i, 0); //
						table.getModel().setValueAt( q2rowtemp.getAuthorName(), i, 1);
						++count;
					}
				}
			}
		});
		buttonSearch.setBounds(20, 189, 79, 23);
		panel.add(buttonSearch);
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nPub.setText("");
				
				if( resultshow != null ){
					panel.remove(resultshow);
					resultshow = null;
				}
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Author name"},
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
			}
		});
		buttonReset.setBounds(112, 189, 79, 23);
		panel.add(buttonReset);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(238, 107, 496, 393);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Author name"},
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
		table.setBounds(10, 11, 476, 345);
		panel_1.add(table);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Author name"},
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
				
				int temp = count;
				int numLeft = q2ResList.size() - count;
				query2ResultRow q2Rowtemp;
				if (numLeft == 0)
				{
					JOptionPane.showMessageDialog(frame_used, "All results have been displayed");
					return;
				}
				if ((numLeft != 0) && (numLeft <= 19))
				{
					for (int i = temp; i < q2ResList.size(); i++)
					{
						q2Rowtemp = q2ResList.get(i);
						table.getModel().setValueAt(i, (i%19)+1, 0);
						table.getModel().setValueAt(q2Rowtemp.getAuthorName(), (i%19)+1, 0);
						++count;
					}
				}
				if ((numLeft != 0) && (numLeft > 19))
				{
					for (int i = temp; i <= (temp + 18); i++)
					{
						q2Rowtemp = q2ResList.get(i);
						table.getModel().setValueAt(i, (i%19)+1, 0);
						table.getModel().setValueAt(q2Rowtemp.getAuthorName(), (i%19)+1, 0);
						++count;
					}
				}
			}
		});
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNext.setBackground(new Color(0, 0, 0));
		btnNext.setBounds(397, 363, 89, 19);
		panel_1.add(btnNext);
	}

}
