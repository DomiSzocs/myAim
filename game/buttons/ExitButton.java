package game.buttons;

import game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ExitButton extends JButton implements Button {
    GameFrame gameFrame;
    public ExitButton(GameFrame gameFrame) {
        super("Exit");
        super.setFont(new Font("Times Roman", Font.BOLD, 19));
        this.gameFrame = gameFrame;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameFrame.saveHighScores();
        System.exit(0);
    }
}
