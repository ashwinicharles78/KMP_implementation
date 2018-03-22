import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class GUI_implementation extends JFrame
{
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	JTextField jt = new JTextField(30);
	JButton jb = new JButton("CHECK");
	
	public GUI_implementation()
	{
		setTitle("ENTER PATTERN");
		setVisible(true);
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jp.add(jt);
		
		jt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = jt.getText();
				kmp km = new kmp();
				km.KMPSearch(input);
				String s = "Found at index : " + km.rat;
				jl.setText(s);
			}
		});
		
		jp.add(jb);
		
		jb.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)	
			{
				String input = jt.getText();
				kmp km = new kmp();
				km.KMPSearch(input);
				String s = "Found at index : " + km.rat;
				jl.setText(s);
			}
		});
		
		jp.add(jl);		
		add(jp);
	}
}

public class main_class {
	public static void main(String[] args) {
		GUI_implementation gi = new GUI_implementation();
	}
}