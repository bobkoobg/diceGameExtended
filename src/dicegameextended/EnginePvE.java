package dicegameextended;

import java.util.*; //calls EVERYTHING <3

public class EnginePvE
{

    Scanner scan = new Scanner(System.in);
    
    double bankacc = 100, bet, winrate;
    public static int rounds = 1; //should be public, don't know why.
    int guess1, guess2;
    Dice vurti = new Dice(); //In this way I call it.
    //Stats statsme = new Stats();
    
    //private static Arraylist stats = new Arraylist(); 

    public void startPlay()
    {
        System.out.println("Welcome to the Player vs Environment Battleground!");
        startingBets(); //In this way I call the next public void.
    }

    public void startingBets()
    {
        vurti.RollingInTheDeep(); //In this way I roll it.
        //vurti.zar1 = statsme.zar1;
        //vurti.zar2 = statsme.zar2;
        
        System.out.println("\nRound: " + rounds);
        System.out.println("\nThe total of the dice is: " + vurti.getZartotal());
        System.out.println("How much do you want to bet?"
                + "\n\tYou have " + bankacc + " at the moment.");
        bet = scan.nextDouble();
        while (bet > bankacc) //should be BEFORE calculations.
        {
            System.out.println("You cannot bet more thank you have in your bankaccount - " + bankacc + ".");
            bet = scan.nextDouble();
        }
        bankacc = bankacc - bet;
        System.out.println("Your bet: " + bet + ". "
                + "\n\tYou have " + bankacc + " left in your bankaccout.");
        guessingDice();
    }

    public void guessingDice()
    {
        System.out.println("Cheatingline :" + vurti.getZar1() + " + " + vurti.getZar2());
        System.out.println("\n1st die:");
        guess1 = scan.nextInt();
        System.out.println("2nd die:");
        guess2 = scan.nextInt();
        System.out.println("True values: " + vurti.getZar1() + " and " + vurti.getZar2());
        results();
    }

    public void results() //says if you are right or wrong.
    {
        if (guess1 == vurti.getZar1() && guess2 == vurti.getZar2()
                || guess2 == vurti.getZar1() && guess1 == vurti.getZar2())
        {
            gimmeMyMONEYYY(); //responds for the profits.
            System.out.println("your bank account: " + bankacc + ",");
        } else if (guess1 == vurti.getZar1() || guess1 == vurti.getZar2()
                && guess2 == vurti.getZar1() || guess2 == vurti.getZar2())
        {
            haveFaith(); //I added this part, I am just having fun :)
            System.out.println("your bank account: " + bankacc + ",");
        } else
        {
            System.out.println("your bank account " + bankacc + ",");
        }
        Return();
    }

    public Double gimmeMyMONEYYY() //epic names, i know.
    {
        System.out.println("You guessed it.");
        if (vurti.getZartotal() == 2 || vurti.getZartotal() == 3
                || vurti.getZartotal() == 11 || vurti.getZartotal() == 12)
        {
            System.out.println("1.2");
            winrate = 1.2;
            bankacc += bet * winrate; //+= makes the following: BANK+(BET * WINRATE)
            //and replaces bankacc=100 with the new value.
        } else if (vurti.getZartotal() == 4 || vurti.getZartotal() == 5
                || vurti.getZartotal() == 9 || vurti.getZartotal() == 10)
        {
            System.out.println("1.5");
            winrate = 1.5;
            bankacc += bet * winrate;
        } else if (vurti.getZartotal() == 6 || vurti.getZartotal() == 7
                || vurti.getZartotal() == 8)
        {
            System.out.println("2.0");
            winrate = 2.0;
            bankacc += bet * winrate;
        }
        return bankacc;
    }

    public Double haveFaith() //I added this part, I am just having fun :)
    {
        System.out.println("You guessed 1 of the dice. You win 50% of your bet.");
        bankacc += bet / 2;
        return bankacc;
    }

    public void Return()
    {
        if (bankacc == 0)
        {
            System.out.println("You lost the game, buddy.");
            //stats.printni();
        } else if (bankacc >= 300)
        {
            System.out.println("You won, buddy");
            //stats.printni();
        } else
        {
            rounds++;
            //stats.saveni(statsme);
            startingBets();
        }
    }
}
