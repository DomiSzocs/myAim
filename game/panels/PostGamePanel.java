package game.panels;

import game.GameFrame;
import game.buttons.MainMenuButton;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PostGamePanel extends JPanel {
    private GameFrame gameFrame;
    private JLabel scoreLabel;
    private JLabel accuracyLabel;
    public PostGamePanel(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
        setLayout(null);
        setBounds(0,0,1000,1000);

        scoreLabel = new JLabel();
        scoreLabel.setBounds(300, 100, 350,100);
        scoreLabel.setFont(new Font("Times Roman", Font.BOLD,30));

        accuracyLabel = new JLabel();
        accuracyLabel.setBounds(300,250,350,100);
        accuracyLabel.setFont(new Font("Times Roman", Font.BOLD,30));

        MainMenuButton mainMenuButton = new MainMenuButton(gameFrame);
        mainMenuButton.setBounds(300,725,350,100);

        add(scoreLabel);
        add(accuracyLabel);
        add(mainMenuButton);
    }

    public void setPostGameData(int score, float accuracy){
        scoreLabel.setText("Score:" + score);
        DecimalFormat df = new DecimalFormat("0.00");
        accuracyLabel.setText("Accuracy: " + df.format(accuracy) + "%");
    }
}
