package game.data;

import static java.lang.Math.max;

public class GameData {
    private int numberOfClicks;
    private int clicksOnTarget;
    private int score;

    public GameData() {
        numberOfClicks = 0;
        score = 0;
        clicksOnTarget = 0;
    }

    public void incNumberOfClicks(){
        numberOfClicks++;
    }

    public void incClicksOnTarget(){
        clicksOnTarget++;
    }

    public void incScoreBy(int by){
        score = max(0, score + by);
    }

    public int getNumberOfClicks() {
        return numberOfClicks;
    }

    public int getClicksOnTarget() {
        return clicksOnTarget;
    }

    public int getScore() {
        return score;
    }
}
