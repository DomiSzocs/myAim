package game.data;

import java.text.DecimalFormat;

public class HighScoreEntry {
    private int score;
    private float accuracy;

    public HighScoreEntry(int score, float accuracy) {
        this.score = score;
        this.accuracy = accuracy;
    }

    public int getScore() {
        return score;
    }

    public float getAccuracy() {
        return accuracy;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return score + "\t" + df.format(accuracy) + "%";
    }
}
