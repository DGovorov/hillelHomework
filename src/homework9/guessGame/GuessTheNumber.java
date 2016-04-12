package homework9.guessGame;

import java.util.Random;

/**
 * Created by Dim on 26.03.2016.
 */
public class GuessTheNumber {
    private int targetNumber;
    private boolean gameOver = true;

    public GuessTheNumber(int lowerNumber, int upperNumber) {
        generateTarget(lowerNumber, upperNumber);
        gameOver = false;
    }

    public GuessTheNumber(int lowerNumber, int upperNumber, int targetNumber) {
        this.targetNumber = targetNumber;
        gameOver = false;
    }

    private void generateTarget(int lowerNumber, int upperNumber) {
        Random r = new Random();
        targetNumber = r.nextInt((upperNumber - lowerNumber) + 1) + lowerNumber;
    }

    public int guessing(int num) {
        if (num == targetNumber) {
            gameOver = true;
            return 0;
        }

        if (targetNumber < num) {
            return -1;
        } else {
            return 1;
        }
    }

    public boolean gameOver() {
        return gameOver;
    }
}
