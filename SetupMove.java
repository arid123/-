


public class SetupMove extends TokenMove
{

    public SetupMove(int i, int j, int k, int l)
    {
        super(i, j, k, l);
        toTray = false;
    }

    public SetupMove(int i, int j, int k, int l, boolean flag)
    {
        super(i, j, k, l);
        toTray = false;
        toTray = flag;
    }

    public boolean toTray;
}