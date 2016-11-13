//Coded by Ajay Balasubramanian (2015008)
//This is the frame upon which the application runs 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends JFrame
{
	//Specifying properties
	private static final int DEFAULT_WIDTH = 950;
	private static final int DEFAULT_HEIGHT = 730;
	private JPanel panel = new JPanel();

	//Constructor
	public mainFrame()
	{
		setTitle("DBLP Query Engine by Ajay Balasubramanian (2015008) and Aditya Adhikary (2015007)");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	//method called to start application
	public void start(mainFrame obj)
	{
		Panel1 panel1 = new Panel1(obj);
		obj.setPanel(panel1);
		obj.add(obj.getPanel());
	}

	//getter and setter for panel
	public JPanel getPanel()
	{
		return panel;
	}

	public void setPanel(JPanel pnl)
	{
		panel = pnl;
	}

	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				mainFrame obj = new mainFrame();
				obj.start(obj);
			}
		});
	}
}