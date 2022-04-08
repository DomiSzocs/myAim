package game;

import game.data.GameData;

import javax.swing.*;
import java.awt.*;

public class Target extends JButton {
    private int size;
    private GameData gameData;
    public Target(GameData gameData) {
        super();
        size = 25;
        this.gameData = gameData;
        setContentAreaFilled(false);
        setVisible(true);
        setSize(new Dimension(size,size));
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(0,0, size, size);
    }

    public void paintBorder(Graphics g){
        g.setColor(Color.RED);
        g.drawOval(0, 0, size - 1, size - 1);
    }
}
