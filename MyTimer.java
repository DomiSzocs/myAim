package game;

import game.panels.GamePanel;

public class MyTimer extends Thread {
    private int start;
    private GamePanel gamePanel;

    public MyTimer(int start, GamePanel gamePanel) {
        this.start = start;
        this.gamePanel = gamePanel;
    }

    public void run() {
        while (start > 0) {
            try {
                gamePanel.setTimerLabelText(start);
                start--;
                gamePanel.repaint();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gamePanel.stopTheGame();
    }
}