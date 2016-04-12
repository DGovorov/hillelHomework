package homework9.guessGame;

/**
 * Created by Dim on 27.03.2016.
 */
public class GuessingGamer {
    private GuessTheNumber game;

    public GuessingGamer(GuessTheNumber game) {
        this.game = game;
    }

    public int start(int lowerNumber, int upperNumber) {
        int guess = (lowerNumber+upperNumber)/2;
        int outcome = game.guessing(guess);

        if (outcome == 0){
            return 0;
        }
        if (outcome < 0){
            upperNumber = guess-1;
        } else {
            lowerNumber = guess+1;
        }
        return start(lowerNumber, upperNumber);
    }
}
