
package dicegameextended;

import java.util.ArrayList;

public class Arraylist
{
    public ArrayList<EnginePvE> savehere = new ArrayList<>();
    
    public void saveni(EnginePvE saveturn)
    {
        savehere.add(saveturn);
    }
    
    public void printni()
    {
        for (int i = 0; i < savehere.size(); i++)
        {
            System.out.println(savehere.get(i).toString());
        }
    }
}
