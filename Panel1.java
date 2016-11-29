import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Aditya Adhikary
 * @author Ajay Balasubramanian
 *
 */
public class Panel1 extends JPanel
{
	private JButton next;
	private JButton exit;
	private JFrame frame_used;

	public Panel1(JFrame frame)
	{
		//main panel
		frame_used = frame;
		setBackground(Color.GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel("DBLP Query Engine");
		Font f = new Font("Candara", Font.BOLD, 45);
		label1.setFont(f);
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createVerticalStrut(50));
		add(label1);
		add(Box.createVerticalStrut(50));

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GRAY);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

		JPanel left = new JPanel();
		left.setBackground(Color.GRAY);
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.add(Box.createVerticalStrut(20));
		left.add(new JTextField("Query"));	
		
	}
}