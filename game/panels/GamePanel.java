package game.panels;

import game.GameFrame;
import game.MyTimer;
import game.Target;
import game.data.GameData;
import game.data.HighScoreEntry;
import game.gamemodes.StillObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements ActionListener, MouseListener{
    private StillObject gameMode;
    private MyTimer timer;
    private GameData gameData;
    private GameFrame gameFrame;
    private Thread gameThread;
    private Thread timerThread;
    private Target target;
    private JLabel scoreLabel;
    private JLabel hintLabel;
    private JLabel timerLabel;
    private boolean firstClick;
    private int countBackFrom;


    public GamePanel(GameData gameData, GameFrame gameFrame) {
        super();
        setLayout(null);
        setBounds(0,0,1000,1000);
        this.gameMode = new StillObject(this);
        this.gameData = gameData;
        this.gameFrame = gameFrame;
        firstClick = true;

        gameThread = new Thread(gameMode);

        target = new Target(gameData);
        target.setLocation(450,450);
        target.addActionListener(this);

        add(target);

        hintLabel = new JLabel();
        hintLabel.setText("Click to start the game");
        hintLabel.setFont(new Font("Times Roman", Font.BOLD, 25));
        hintLabel.setBounds(350,100,350,100);
        add(hintLabel);

        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Times Roman", Font.BOLD, 25));
        scoreLabel.setBounds(350,100,350,100);
        scoreLabel.setVisible(true);
        add(scoreLabel);
        addMouseListener(this);

        countBackFrom = 10;

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("Times Roman", Font.BOLD, 40));
        timerLabel.setText(Integer.toString(countBackFrom));
        timerLabel.setBounds(800,50,100,100);
        add(timerLabel);

        timer = new MyTimer(countBackFrom,this);
        timerThread = new Thread(timer);
    }

    public void setTargetLocation(int x, int y){
        target.setLocation(x,y);
        target.repaint();
    }

    public void setTimerLabelText(int time){
        timerLabel.setText(Integer.toString(time));
    }

    public void stopTheGame(){
        gameMode.setEndOfGame(true);
        setVisible(false);
        gameFrame.setPostGamePanelVisibility(true);
        float accuracy = (float) gameData.getClicksOnTarget() / gameData.getNumberOfClicks() * 100;
        gameFrame.getPostGamePanel().setPostGameData(gameData.getScore(), accuracy);
        gameFrame.addNewHighScoreEntry(new HighScoreEntry(gameData.getScore(), accuracy));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(firstClick){
            hintLabel.setVisible(false);
            scoreLabel.setVisible(true);
            gameThread.start();
            timerThread.start();
            firstClick = false;
        }
        gameData.incNumberOfClicks();
        gameData.incClicksOnTarget();
        gameData.incScoreBy(100);
        scoreLabel.setText("Score:" + gameData.getScore());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(firstClick){
            hintLabel.setVisible(false);
            scoreLabel.setVisible(true);
            gameThread.start();
            timerThread.start();
            firstClick = false;
        }
        gameData.incNumberOfClicks();
        gameData.incScoreBy(-150);
        scoreLabel.setText("Score:" + gameData.getScore());
        scoreLabel.setFont(new Font("Times Roman", Font.BOLD, 19));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
