package game.buttons;

import game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuButton extends JButton implements ActionListener {
    GameFrame gameFrame;

    public MainMenuButton(GameFrame gameFrame) {
        super("Main Menu");
        super.setFont(new Font("Times Roman", Font.BOLD,19));
        this.gameFrame = gameFrame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameFrame.setMainMenuPanelVisibility(true);
        gameFrame.setPostGamePanelVisibility(false);
        gameFrame.setHighScoresPanelVisibility(false);
    }
}
