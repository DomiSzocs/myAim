package game.buttons;

import game.GameFrame;
import game.data.GameData;
import game.panels.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayButton extends JButton implements Button {
    GameFrame gameFrame;
    public PlayButton(GameFrame gameFrame) {
        super("Play");
        super.setFont(new Font("Times Roman", Font.BOLD, 19));
        this.gameFrame = gameFrame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameFrame.setMainMenuPanelVisibility(false);
        gameFrame.setHighScoresPanelVisibility(false);
        gameFrame.setPostGamePanelVisibility(false);
        gameFrame.add(new GamePanel(new GameData(), gameFrame));
    }
}
