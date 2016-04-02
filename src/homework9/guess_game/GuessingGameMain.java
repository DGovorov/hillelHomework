package homework9.guess_game;

import java.util.Scanner;

/**
 * Created by Dim on 26.03.2016.
 */
public class GuessingGameMain {
    public static void main(String[] args) {

        humanGuessComputersNumber();

        computerGuessHumansNumber();
    }

    private static void humanGuessComputersNumber() {
        int gameLowerNumber = 0;
        int gameUpperNumber = 100;

        GuessTheNumber game = new GuessTheNumber(gameLowerNumber, gameUpperNumber);
        guessManually(game);
    }

    private static void computerGuessHumansNumber() {
        Scanner scanner = new Scanner(System.in);
        int gameLowerNumber;
        int gameUpperNumber;
        int number;

        System.out.println("HELLO THERE! LET'S PLAY A GAME \"GUESS THE NUMBER\", YOU CAN INPUT YOUR NUMBER TO GUESS!");
        System.out.println("But first, there is a little formality, you have to determine lower and upper limits");
        System.out.println("INPUT LOWER");
        gameLowerNumber = scanner.nextInt();
        System.out.println("INPUT UPPER");
        gameUpperNumber = scanner.nextInt();
        System.out.print("YOUR NUMBER: ");
        number = scanner.nextInt();

        GuessTheNumber game = new GuessTheNumber(gameLowerNumber, gameUpperNumber, number);
        guessAutomatically(gameLowerNumber, gameUpperNumber, game);
    }

    private static void guessAutomatically(int gameLowerNumber, int gameUpperNumber, GuessTheNumber game) {
        System.out.println();
        System.out.println("===CPU PLAYER===");
        GuessingGamer gamer = new GuessingGamer(game);
        gamer.start(gameLowerNumber, gameUpperNumber);
        System.out.println();
    }

    private static void guessManually(GuessTheNumber game) {
        System.out.println();
        System.out.println("===PROGRAMMER PLAYER===");
        Scanner s = new Scanner(System.in);
        int num;
        do {
            num = s.nextInt();
            game.guessing(num);
        } while (!game.gameOver());
        System.out.println();
    }
}
