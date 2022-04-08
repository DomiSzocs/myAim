package game.panels;

import game.GameFrame;
import game.buttons.ExitButton;
import game.buttons.HighScoresButton;
import game.buttons.PlayButton;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    GameFrame gameFrame;
    public MainMenuPanel(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
        setLayout(null);
        setBounds(0,0,1000,1000);

        JLabel nameLabel = new JLabel("Welcome to myAim!");;
        nameLabel.setBounds(250,100,700,100);
        nameLabel.setFont(new Font("Times Roman", Font.BOLD, 50));

        PlayButton playButton = new PlayButton(gameFrame);
        playButton.setBounds(300,350,350,100);

        HighScoresButton highScoresButton = new HighScoresButton(gameFrame);
        highScoresButton.setBounds(300,500,350,100);

        ExitButton exitButton = new ExitButton();
        exitButton.setBounds(300,650,350,100);

        add(nameLabel);
        add(playButton);
        add(highScoresButton);
        add(exitButton);
    }
}
