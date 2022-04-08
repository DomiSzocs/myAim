package game.gamemodes;

import game.panels.GamePanel;

import java.util.Random;

public class StillObject implements GameMode {
    GamePanel gamePanel;
    boolean endOfGame;

    public StillObject(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        endOfGame = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        int x;
        int y;
        while(!endOfGame){
            x = 200 + random.nextInt(600);
            y = 400 + random.nextInt(300);
            gamePanel.setTargetLocation(x,y);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setEndOfGame(boolean endOfGame) {
        this.endOfGame = endOfGame;
    }
}
