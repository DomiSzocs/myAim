package game.panels;

import game.GameFrame;
import game.buttons.MainMenuButton;
import game.data.HighScoreEntry;

import javax.swing.*;
import java.awt.*;

public class HighScoresPanel extends JPanel {
    GameFrame gameFrame;
    JTextArea highScoresEntries;
    public HighScoresPanel(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
        setLayout(null);
        setBounds(0,0,1000,1000);

        JLabel titleLabel = new JLabel();
        titleLabel.setText("High Scores");
        titleLabel.setFont(new Font("Times Roman", Font.BOLD, 30));
        titleLabel.setBounds(400, 50, 500,50);

        JLabel informationTable = new JLabel();
        String informationText = "Pos: Score: Accuracy:";
        informationTable.setText(informationText);
        informationTable.setFont(new Font("Times Roman", Font.BOLD, 22));
        informationTable.setBounds(0, 150, 500,30);

        highScoresEntries = new JTextArea();
        highScoresEntries.setBounds(0,200,1000,400);
        highScoresEntries.setFont(new Font("Times Roman", Font.BOLD, 19));
        highScoresEntries.setEditable(false);
        highScoresEntries.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        highScoresEntries.setBackground(this.getBackground());

        MainMenuButton mainMenuButton = new MainMenuButton(gameFrame);
        mainMenuButton.setBounds(300,675,350,100);

        add(informationTable);
        add(titleLabel);
        add(highScoresEntries);
        add(mainMenuButton);
    }

    public void insertEntry(int pos, HighScoreEntry highScoreEntry){
        highScoresEntries.append(pos +"." + "\t" + highScoreEntry.toString() + "\n");
    }

    public void clearHighScoreEntries(){
        highScoresEntries.setText(null);
    }
}
