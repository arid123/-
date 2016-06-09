

import java.awt.*;
import java.io.PrintStream;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Space extends JPanel
{

    public Space(int i, int j, int k)
    {
        token = null;
        displayToken = true;
        row = i;
        col = j;
        playerNumber = k;
        setPreferredSize(new Dimension(Stratego.getWidth(), Stratego.getHeight()));
        setBackground(Color.
        LIGHT_GRAY);
    }

    public void setToken(Token token1)
    {
        token = token1;
    }

    public Token rmToken()
    {
        if(Stratego.isVerbose())
            Stratego.trace("Space", "rmToken");
        Token token1 = token;
        token = null;
        return token1;
    }

    public Token getToken()
    {
        if(Stratego.isVerbose())
            Stratego.trace("Space", "getToken");
        return token;
    }

    public void setDisplayToken(boolean flag)
    {
        if(Stratego.isVerbose())
            Stratego.trace("Space", "setDisplayToken");
        displayToken = flag;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(0, 0, Stratego.getWidth(), Stratego.getHeight());
        if(token != null && displayToken)
            token.draw(g, this, playerNumber);
    }

    private Token token;
    private boolean displayToken;
    private int playerNumber;
    public final int row;
    public final int col;

    static 
    {
        System.err.println("Space: 0");
    }
}