package dicegameextended;

import java.util.*;

public class Dice
{

    Random dice = new Random();
    public int zar1, zar2, zartotal;

    public Dice()
    {
        RollingInTheDeep();
    }

    public void RollingInTheDeep()
    {
        zar1 = (dice.nextInt(6) + 1);
        zar2 = (dice.nextInt(6) + 1);
        zartotal = zar1 + zar2;
    }

    public int getZar1()
    {
        return zar1;
    }

    public int getZar2()
    {
        return zar2;
    }

    public int getZartotal()
    {
        return zartotal;
    }
}
