package homework9.guess_game;

import java.util.Random;

/**
 * Created by Dim on 26.03.2016.
 */
public class GuessTheNumber {
    private int targetNumber;
    private boolean gameOver = true;

    public GuessTheNumber(int lowerNumber, int upperNumber) {
        System.out.println("NEW GAME STARTED!");
        System.out.println("Guess the number in '" + lowerNumber + "' - '" + upperNumber + "' range!");
        generateTarget(lowerNumber, upperNumber);
        gameOver = false;
    }

    public GuessTheNumber(int lowerNumber, int upperNumber, int targetNumber) {
        System.out.println("NEW GAME STARTED!");
        System.out.println("Guess the number in '" + lowerNumber + "' - '" + upperNumber + "' range!");
        this.targetNumber = targetNumber;
        gameOver = false;
    }

    private void generateTarget(int lowerNumber, int upperNumber) {
        Random r = new Random();
        targetNumber = r.nextInt((upperNumber - lowerNumber) + 1) + lowerNumber;
    }

    public int guessing(int num) {
        if (num == targetNumber) {
            System.out.println(targetNumber + "! CONGRATULATIONS! YOU WON!");
            System.out.println("GAME OVER");
            gameOver = true;
            return 0;
        }

        if (targetNumber < num) {
            System.out.println(num + "? My number is smaller");
            return -1;
        } else {
            System.out.println(num + "? My number is bigger");
            return 1;
        }
    }

    public boolean gameOver() {
        return gameOver;
    }
}
