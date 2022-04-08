package game.buttons;

import game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HighScoresButton extends JButton implements Button {
    GameFrame gameFrame;
    public HighScoresButton(GameFrame gameFrame) {
        super("High Scores");
        super.setFont(new Font("Times Roman", Font.BOLD, 19));
        this.gameFrame = gameFrame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameFrame.setMainMenuPanelVisibility(false);
        gameFrame.setPostGamePanelVisibility(false);
        gameFrame.setHighScoresPanelVisibility(true);
        gameFrame.saveHighScores();
        gameFrame.updateHighScorePanel();
    }
}
