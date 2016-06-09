


public class TokenMove
    implements Move
{

    public TokenMove(int i, int j, int k, int l)
    {
        row0 = i;
        col0 = j;
        row1 = k;
        col1 = l;
    }

    public int row0;
    public int col0;
    public int row1;
    public int col1;
}