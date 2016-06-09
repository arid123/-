
public class ModeMove
    implements Move
{

    public ModeMove(int i)
    {
        mode = i;
    }

    public int mode;
    public static final int QUIT = 0;
    public static final int READY = 1;
    public static final int DEMO = 2;
}