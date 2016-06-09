import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.PrintStream;
import java.net.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Stratego
{

    public static void main(String args[])
    {
        new Stratego(args);
    }

    public Stratego(String as[])
    {
        opponentIPAddress = "";
        
        setGameSize();
        if(as.length == 0)
        {
        
        JFrame frame = new JFrame("Αρχικό Μενού");
        
        JPanel panel = new JPanel();
        JLabel background=new JLabel(new ImageIcon("png/menu3.jpg"));
	panel.add(background);

	 	frame.add(panel);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
            
            String as1[] = {
                 "Έναρξη Παιχνιδιού", "Κανόνες Παιχνιδιού", "Εμείς", "Έξοδος"
            };
            int i = JOptionPane.showOptionDialog(null, "Αρχικό Μενού", "StrategoMini", 1, 1, null, as1, as1[0]);
            switch(i)
            {
            case 0: // '\0'
                
                networked = false;
                verbose = false;
                break;

            case -1: 
           

          case 1: // '\001'
          
          JFrame frame2 = new JFrame("Κανόνες Παιχνιδιού");
        JPanel pane2 = new JPanel();
        JLabel background2=new JLabel(new ImageIcon("png/rules1.png"));
	pane2.add(background2);
	
	 	frame2.add(pane2);
        frame2.setSize(1200, 700);
        frame2.setLocationRelativeTo(null);   
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setAlwaysOnTop( true );
        
	frame2.requestFocus();
	frame2.repaint();
	
	
	
	

            case 2: // '\002'
                networked = false;
                verbose = true;
                break;

            case 3: // '\003'
                 System.exit(0);

           
            }
            if(!networked && !verbose && helping)
            {
                
                
                Info();
            }
            if(networked && !helping)
                do
                {
                   
                } while(opponentIPAddress.equals(""));
        } else
        {
            opponentIPAddress = as[0];
        }
        if(verbose && !helping)
            trace = new TraceFrame();
        if(networked && !helping)
        {
            
        
            
            
        }
        if(!networked && !verbose && !helping)
            new Game(1, null);
    }

    private void setLayout(BorderLayout borderLayout) {
		
		
	}

	private void setContentPane(JLabel jLabel) {
	
		
	}

	private void Info() {
		
		
	}

	public void setGameSize()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        width = dimension.width / 18;
        height = dimension.height / 12;
    }

   

    public static int getWidth()
    {
        return width;
    }

    public static int getHeight()
    {
        return height;
    }

    public static boolean isNetworked()
    {
        return networked;
    }

    public static boolean isVerbose()
    {
        return verbose;
    }

    public static void trace(String s, String s1)
    {
        trace.append(indent + "Tracing  Class: " + s + ", Method: " + s1);
    }

    public static void trace(String s, String s1, String s2)
    {
        trace.append(indent + "Tracing  Class: " + s + ", Method: " + s1 + "; " + s2);
    }

    public static void traceIn(String s, String s1)
    {
        trace.append(indent + "BEGIN  Class: " + s + ", Method: " + s1);
        indent = indent + "   ";
    }

    public static void traceIn(String s, String s1, String s2)
    {
        trace.append(indent + "BEGIN  Class: " + s + ", Method: " + s1 + "; " + s2);
        indent = indent + "   ";
    }

    public static void traceOut(String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer(indent);
        indent = stringbuffer.substring(3);
        trace.append(indent + "EXIT  Class: " + s + ", Method: " + s1);
    }

    public static void traceOut(String s, String s1, String s2)
    {
        StringBuffer stringbuffer = new StringBuffer(indent);
        indent = stringbuffer.substring(3);
        trace.append(indent + "EXIT  Class: " + s + ", Method: " + s1 + "; " + s2);
    }
 
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int PLAY = 0;
    public static final int DEMO = 1;
    
    public static final int DEBUG = 3;
    
    public static final int QUIT = 4;
    private static boolean networked = true;
    private static boolean verbose = false;
    private static boolean helping = false;
    private static int width;
    private static int height;
    
    private String opponentIPAddress;
    private Socket readSocket;
    private Socket writeSocket;
    private static TraceFrame trace = null;
    private static String indent = "";
    

}