

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class MoveReader extends Thread
{

    public MoveReader(Game game1, Socket socket)
    {
        System.err.println("MoveReader: ");
        if(Stratego.isVerbose())
            Stratego.traceIn("MoveReader", "constructor");
        game = game1;
        try
        {
            input = new ObjectInputStream(socket.getInputStream());
        }
        catch(IOException ioexception)
        {
            System.err.println("ERROR opening read socket: " + ioexception);
            System.exit(1);
        }
        start();
        if(Stratego.isVerbose())
            Stratego.traceOut("MoveReader", "constructor");
    }

    public void run()
    {
        if(Stratego.isVerbose())
            Stratego.traceIn("MoveReader", "run");
        try
        {
            do
            {
                Move move = (Move)input.readObject();
                game.opponentMove(move);
            } while(true);
        }
        catch(OptionalDataException optionaldataexception)
        {
            System.err.println("ERROR reading move: " + optionaldataexception);
            System.exit(1);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            System.err.println("ERROR reading move: " + classnotfoundexception);
            System.exit(1);
        }
        catch(SocketException socketexception)
        {
            System.exit(0);
        }
        catch(IOException ioexception)
        {
            System.err.println("ERROR reading move: " + ioexception);
            System.exit(1);
        }
        if(Stratego.isVerbose())
            Stratego.traceOut("MoveReader", "run");
    }

    private Game game;
    private ObjectInputStream input;
}