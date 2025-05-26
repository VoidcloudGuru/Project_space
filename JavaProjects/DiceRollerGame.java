import java.util.Random;
import java.util.Scanner;

public class DiceRollerGame {

    public static void main(String[] args) {
        // Java dice roller game
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int numOfDice;
        int total = 0;

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(" ");
        System.out.println("     DICE ROLLER GAME");

        System.out.print("Enter the number of dice to roll: ");
        numOfDice = scan.nextInt();

        if (numOfDice > 0) {

            for (int i = 0; i < numOfDice; i++) {
                int roll = random.nextInt(1, 7);// to roll random numbers from 1-6
                printDie(roll);
                System.out.println("You rolled: " + roll);
                total += roll;
            }
            System.out.println("The total is: " + total);

        } else {
            System.out.println("Number of dice must be greater than zero.");
        }

        System.out.println(" ");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        scan.close();
    }

    // METHOD FOR DISPLAYING THE ASCII ART OF THE DICE ROLLED
    static void printDie(int roll) {
        // multiline string
        String dice1 = """
                  -------
                 |       |
                 |   ●   |
                 |       |
                  -------
                """;

        String dice2 = """
                  -------
                 |  ●    |
                 |       |
                 |     ● |
                  -------
                """;

        String dice3 = """
                  -------
                 | ●     |
                 |   ●   |
                 |     ● |
                  -------
                """;

        String dice4 = """
                  -------
                 | ●   ● |
                 |       |
                 | ●   ● |
                  -------
                """;

        String dice5 = """
                  -------
                 | ●   ● |
                 |   ●   |
                 | ●   ● |
                  -------
                """;

        String dice6 = """
                  -------
                 | ●   ● |
                 | ●   ● |
                 | ●   ● |
                  -------
                """;

        // switch statement for displaying each dice one at a time
        switch (roll) {
            case 1:
                System.out.println(dice1);

                break;

            case 2:
                System.out.println(dice2);

                break;

            case 3:
                System.out.println(dice3);

                break;

            case 4:
                System.out.println(dice4);

                break;

            case 5:
                System.out.println(dice5);

                break;

            case 6:
                System.out.println(dice6);

                break;

            default:
                System.out.println("Invalid roll");
                break;
        }

    }
}