

import java.awt.*;
import java.io.PrintStream;
import javax.swing.JPanel;

public class Token
    implements Runnable
{

    public Token(int i, int j)
    {
        display = false;
        rank = i;
        playerNumber = j;
    }

    public String toString()
    {
        if(Stratego.isVerbose())
            Stratego.trace("Token", "toString");
        return tokenName[rank];
    }

    public int getRank()
    {
        if(Stratego.isVerbose())
            Stratego.trace("Token", "getRank");
        return rank;
    }

    public int getPlayerNumber()
    {
        if(Stratego.isVerbose())
            Stratego.trace("Token", "getPlayerNumber");
        return playerNumber;
    }

    public void run()
    {
        if(Stratego.isVerbose())
            Stratego.traceIn("Token", "run");
        try
        {
            Thread.sleep(10000L);
        }
        catch(InterruptedException interruptedexception)
        {
            System.err.println("Token timer error");
        }
        display = false;
        location.repaint();
        if(Stratego.isVerbose())
            Stratego.traceOut("Token", "run");
    }

    public void expose(Space space)
    {
        if(Stratego.isVerbose())
            Stratego.traceIn("Token", "expose");
        display = true;
        location = space;
        Thread thread = new Thread(this);
        thread.start();
        if(Stratego.isVerbose())
            Stratego.traceOut("Token", "expose");
    }

    public void draw(Graphics g, JPanel jpanel, int i)
    {
        g.setColor(tokenColor[playerNumber]);
        g.fill3DRect(5, 5, Stratego.getWidth() - 10, Stratego.getHeight() - 10, true);
        if(playerNumber == i || display || !Stratego.isNetworked())
        {
            if(pictures[rank] != null)
            {
                int j = pictures[rank].getWidth(jpanel);
                g.drawImage(pictures[rank], (Stratego.getWidth() - j) / 2, 5, tokenColor[playerNumber], jpanel);
            }
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Font font = g.getFont();
            float f = font.getSize2D();
            Font font1 = font.deriveFont((f * (float)dimension.width) / 1100F);
            g.setFont(font1);
            g.setColor(Color.black);
            FontMetrics fontmetrics = g.getFontMetrics();
            int k = fontmetrics.stringWidth(tokenName[rank]);
            if(playerNumber == 1)
                g.setColor(Color.black);
            else
            if(playerNumber == 2)
                g.setColor(Color.white);
            g.drawString(tokenName[rank], (Stratego.getWidth() - k) / 2, Stratego.getHeight() - 5);
        }
    }

    private int rank;
    private int playerNumber;
    private boolean display;
    private Space location;
    private static final Image pictures[];
    private static final Color tokenColor[];
    public static final int FLAG = 0;
    public static final int MARSHAL = 1;
    public static final int GENERAL = 2;
    public static final int COLONEL = 3;
    public static final int LIEUTENANT = 6;
    public static final int SERGEANT = 7;
    public static final int MINER = 8;
    public static final int SPY = 10;
    public static final int BOMB = 11;
    public static final int LAKE = 12;
    public static final int tokenTypes[] = {
        0, 1, 2, 2, 2, 2,
        3, 3, 3, 3, 6, 6,
        6, 7, 7, 7, 8, 8,
        10, 11, 11, 11, 11, 11
    };
    public static  String tokenName[] = {
        "Flag", "Marshal", "General", "Colonel", "Major", "Captain", "Lieutenant", "Sergeant", "Miner", "Scout", 
        "Spy", "Bomb", ""
    };

    static 
    {
        pictures = new Image[13];
        tokenColor = (new Color[] {
            Color.cyan, Color.red, Color.blue
        });
        System.err.println("Token");
        

    }
}