package dicegameextended;

import java.util.*;

public class Instructions
{

    public void teachMe()
    {
        Scanner scan = new Scanner(System.in);

        int goback;

        System.out.println("\n2 Game modes - PvE where 1 Player should bet and guess"
                + "\nthe value of the dice and PvE where 2 Players have to"
                + "\nbet and the dice, but the main thing here is that they"
                + "\nare winning their 'money' from each other."
                + "\n\nRates for PVE "
                + "\n1.2x your bet if the value is 2, 3, 11 or 12 "
                + "\n1.5x your bet if the value is 4, 5, 9 or 10;"
                + "\n2x your bet if the value is 6, 7 or 8."
                + "\nGood Luck.");
        System.out.println("Press any number to go back to the Main Menu.");
        goback = scan.nextInt();
        Menu startGame = new Menu();
        startGame.main();
    }
}
