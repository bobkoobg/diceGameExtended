
package dicegameextended;

public class Stats
{
    public int zar1, zar2;
Dice vurti = new Dice();
    public void Turnz(int zar1, int zar2)
    {
        this.zar1 = vurti.zar1;
        this.zar2 = vurti.zar2;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Dice one: " + zar1 + ", "
                + "Dice two: " + zar2 + ".";
    }
    
        public int getZar1()
    {
        return zar1;
    }

    public void setZar1(int zar1)
    {
        this.zar1 = zar1;
    }

    public int getZar2()
    {
        return zar2;
    }

    public void setZar2(int zar2)
    {
        this.zar2 = zar2;
    }
}
