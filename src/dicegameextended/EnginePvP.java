package dicegameextended;

import java.util.*;

public class EnginePvP
{

    Scanner scan = new Scanner(System.in);
    String Player1, Player2;
    public static int rounds = 1;
    double bankacc1 = 100, bankacc2 = 100, bet1, bet2, lostbets;
    int guess1, guess2, guess3, guess4;
    Dice vurti = new Dice();

    public void startArena()
    {
        System.out.println("Welcome to the Player vs Player Arena!");
        namePlayers();
    }

    public void namePlayers()
    {
        System.out.println("Name of Player1 :");
        Player1 = scan.nextLine();
        System.out.println("Name of Player2 :");
        Player2 = scan.nextLine();
        System.out.println("\nWelcome " + Player1 + " and " + Player2 + ".");
        startingBets();
    }

    public void startingBets()
    {
        vurti.RollingInTheDeep();

        System.out.println("\nRound: " + rounds);
        System.out.println("lostbets" + lostbets);
        System.out.println("\nThe total of the dice is: " + vurti.getZartotal());
        System.out.println(Player1 + ", how much do you want to bet?"
                + "\n\tYou have " + bankacc1 + " at the moment.");
        bet1 = scan.nextDouble();
        while (bet1 > bankacc1)
        {
            System.out.println("You cannot bet more thank you have in your bankaccount - " + bankacc1 + ".");
            bet1 = scan.nextDouble();
        }
        while (bet1 == 0)
        {
            System.out.println("Your bet cannot be '0'");
            bet1 = scan.nextDouble();
        }
        bankacc1 = bankacc1 - bet1;
        System.out.println(Player1 + ", your bet: " + bet1 + ". "
                + "\n\tYou have " + bankacc1 + " left in your bankaccout.");

        System.out.println("\n" + Player2 + ", how much do you want to bet?"
                + "\n\tYou have " + bankacc2 + " at the moment.");
        bet2 = scan.nextDouble();
        while (bet2 > bankacc2)
        {
            System.out.println("You cannot bet more thank you have in your bankaccount - " + bankacc2 + ".");
            bet2 = scan.nextDouble();
        }
        while (bet2 == 0)
        {
            System.out.println("Your bet cannot be '0'");
            bet2 = scan.nextDouble();
        }
        bankacc2 = bankacc2 - bet2;
        System.out.println(Player2 + ", your bet: " + bet2 + ". "
                + "\n\tYou have " + bankacc2 + " left in your bankaccout.");

        guessingDice();
    }

    public void guessingDice()
    {
        //System.out.println("Cheatingline :" + vurti.getZar1() + " + " + vurti.getZar2());

        System.out.println("\n" + Player1 + ", 1st die:");
        guess1 = scan.nextInt();
        System.out.println("\n" + Player1 + ", 2st die:");
        guess2 = scan.nextInt();
        System.out.println("\n" + Player2 + ", 1st die:");
        guess3 = scan.nextInt();
        System.out.println("\n" + Player2 + ", 2st die:");
        guess4 = scan.nextInt();

        System.out.println("True values: " + vurti.getZar1() + " and " + vurti.getZar2());
        results();
    }

    public void results()
    {

        if (guess1 == vurti.getZar1() && guess2 == vurti.getZar2()
                || guess2 == vurti.getZar1() && guess1 == vurti.getZar2())
        {
            player1wins();
        } else if (guess3 == vurti.getZar1() && guess4 == vurti.getZar2()
                || guess4 == vurti.getZar1() && guess3 == vurti.getZar2())
        {
            player2wins();
        } else
        {
            System.out.println("Nobody guessed anything.");
            lostbets += bet1 + bet2;
            System.out.println("lostbets" + lostbets);
        }
        Return();
    }

    public Double player1wins()
    {
        System.out.println(Player1 + " had guessed the value of the dice.");
        bankacc1 += bet1 + bet2 + lostbets;
        lostbets = 0;
        return bankacc1;
    }

    public Double player2wins()
    {
        System.out.println(Player2 + " had guessed the value of the dice");
        bankacc2 += bet1 + bet2 + lostbets;
        lostbets = 0;
        return bankacc2;
    }

    public void Return()
    {
        if (bankacc2 == 200 || bankacc1 == 0)
        {
            System.out.println(Player2 + ", you won.");
        } else if (bankacc1 == 200 || bankacc2 == 0)
        {
            System.out.println(Player1 + ", you won.");
        } else
        {
            rounds++;
            startingBets();
        }
    }
}
