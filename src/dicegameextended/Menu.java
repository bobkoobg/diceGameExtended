package dicegameextended;

import java.util.*;

public class Menu
{

    Scanner scan = new Scanner(System.in);
    String name;
    int choice, startingmenu = 0;

    public void name()
    {
        System.out.println("Please, fill in your name: (GameHost)");
        name = scan.nextLine();
        System.out.println("Welcome " + name + "!");
        main();
    }

    public void main()
    {
        System.out.println("What do you want to play?"
                + "\n\t1. PvE"
                + "\n\t2. PvP"
                + "\n\t3. Help");
        choice = scan.nextInt();
        while (startingmenu != 1)
        {
            if (choice == 1)
            {
                EnginePvE load = new EnginePvE();
                load.startPlay();
                startingmenu = 1;
            } else if (choice == 2)
            {
                EnginePvP load = new EnginePvP();
                load.startArena();
                startingmenu = 1;
            } else if (choice == 3)
            {
                Instructions load = new Instructions();
                load.teachMe();
                startingmenu = 1;
            } else
            {
                System.out.println("Wrong input, " + name + ","
                        + "\n\t1. PvE"
                        + "\n\t2. PvP"
                        + "\n\t3. Instructions");
                choice = scan.nextInt();
            }
        }
        System.out.println("\nThank you for playing my game," + name + "!");
    }
}
