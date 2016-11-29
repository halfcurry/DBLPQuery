import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public class MainPanel extends JPanel{
	
	/**
	 *Generic Panel which goes into the Frame
	 */

	private JFrame frame_used;
	private JTable table;
	private JComboBox queryBox;
	
	/**
	 * Create the application.
	 */
	public MainPanel(JFrame frame) {
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
		
		JLabel mainLabel = new JLabel("DBLP Query Engine");
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainLabel.setFont(new Font("Candara", Font.BOLD, 40));
		mainLabel.setBounds(10, 0, 724, 82);
		add(mainLabel);
		
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
		
		queryBox = new JComboBox();
		queryBox.setModel(new DefaultComboBoxModel(new String[] {"Queries", "Query1", "Query2"}));
		queryBox.setToolTipText("Query");
		queryBox.setFont(new Font("Calibri", Font.PLAIN, 14));
		queryBox.setBounds(46, 61, 116, 29);
		panel.add(queryBox);
		
		JButton buttonSelect = new JButton("Select");
		buttonSelect.setFont(new Font("Calibri", Font.PLAIN, 12));
		buttonSelect.setBounds(58, 125, 89, 23);
		buttonSelect.addActionListener(new SelectAction());
		panel.add(buttonSelect);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(238, 91, 496, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setForeground(new Color(0, 0, 0));
		table.setBounds(10, 11, 476, 353);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		panel_1.add(table);
		
		JButton buttonNext = new JButton("Next");
		buttonNext.setForeground(new Color(255, 255, 255));
		buttonNext.setFont(new Font("Calibri", Font.PLAIN, 14));
		buttonNext.setBackground(new Color(0, 0, 0));
		buttonNext.setBounds(397, 375, 89, 23);
		panel_1.add(buttonNext);
	}
	
	private class SelectAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String selectedQuery = (String)queryBox.getSelectedItem();
			if (selectedQuery.equals("Query1"))
			{
				frame_used.getContentPane().removeAll();
				frame_used.getContentPane().add(new Query1Panel(frame_used));
			}
			if (selectedQuery.equals("Query2"))
			{
				frame_used.getContentPane().removeAll();
				frame_used.getContentPane().add(new Query2Panel(frame_used));
			}
			if (selectedQuery.equals("Queries"))
			{
				JOptionPane.showMessageDialog(frame_used, "Please select Query1 or Query2");
			}
			frame_used.getContentPane().revalidate();
			frame_used.getContentPane().repaint();
		}
	}

}
