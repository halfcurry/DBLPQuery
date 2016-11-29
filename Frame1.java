import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Frame1 implements Runnable{

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	
	public void run(){
		try {
			Frame1 window = new Frame1();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(true);
		//frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setSize(750, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DBLP Query Engine by: Ajay Balasubramanian and Aditya Adhikary");
		//frame.getContentPane().setLayout(null);
		frame.add(new MainPanel(frame));
	}
	
}
