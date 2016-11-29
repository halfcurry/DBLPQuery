

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

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */

public class Frame1 implements Runnable{

	/**
	 * Generic Frame for the GUi
	 */
	private JFrame frame;
	JPanel parsing;
	
	public void run(){
		try {
			Frame1 window = new Frame1();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		//frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setSize(750, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DBLP Query Engine by: Ajay Balasubramanian and Aditya Adhikary");
		//frame.getContentPane().setLayout(null);
		JPanel parsing = new JPanel();
		JLabel parsinglabel = new JLabel( "Parsing ...");
		parsing.add(parsinglabel);
		frame.add( parsing );
		
		frame.setEnabled(true);
		frame.remove(parsing);
		frame.add(new MainPanel(frame));
	}
}
