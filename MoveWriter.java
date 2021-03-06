

import java.io.*;
import java.net.Socket;

public class MoveWriter extends Thread
{

    public MoveWriter(Socket socket)
    {
        hasMove = false;
        System.err.println("MoveWriter:");
        if(Stratego.isVerbose())
            Stratego.traceIn("MoveWriter", "constructor");
        try
        {
            output = new ObjectOutputStream(socket.getOutputStream());
        }
        catch(IOException ioexception)
        {
            System.err.println("ERROR opening write socket: " + ioexception);
            System.exit(1);
        }
        start();
        if(Stratego.isVerbose())
            Stratego.traceOut("MoveWriter", "constructor");
    }

    public void run()
    {
        do
            writeMove();
        while(true);
    }

    public synchronized void setMove(Move move1)
    {
        if(Stratego.isVerbose())
            Stratego.traceIn("MoveWriter", "setMove");
        try
        {
            while(hasMove) 
                wait();
        }
        catch(InterruptedException interruptedexception) { }
        hasMove = true;
        move = move1;
        notifyAll();
        if(Stratego.isVerbose())
            Stratego.traceOut("MoveWriter", "setMove");
    }

    public synchronized void writeMove()
    {
        if(Stratego.isVerbose())
            Stratego.traceIn("MoveWriter", "writeMove");
        try
        {
            while(!hasMove) 
                wait();
            output.writeObject(move);
        }
        catch(IOException ioexception)
        {
            System.err.println("ERROR writing move: " + ioexception);
            System.exit(1);
        }
        catch(InterruptedException interruptedexception) { }
        if(Stratego.isVerbose())
            Stratego.traceOut("MoveWriter", "writeMove");
        hasMove = false;
        notifyAll();
    }

    private Move move;
    private boolean hasMove;
    private ObjectOutputStream output;
}