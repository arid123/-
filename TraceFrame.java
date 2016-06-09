

import java.awt.*;
import javax.swing.*;

public class TraceFrame extends JFrame
{

    public TraceFrame()
    {
   
        
        JFrame frame3 = new JFrame("Εμείς");
        JPanel panel3 = new JPanel();
       
        
        
        JLabel background=new JLabel(new ImageIcon("png/about1.png"));
	panel3.add(background);
			 	
	 	frame3.add(panel3);
        frame3.setSize(1200, 700);
        frame3.setLocationRelativeTo(null);   
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);
        
    }

    public void append(String s)
    {
        window.append(s + "\n");
    }

    private JTextArea window;
}