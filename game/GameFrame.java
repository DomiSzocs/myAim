package game;

import game.data.HighScoreEntry;
import game.panels.HighScoresPanel;
import game.panels.MainMenuPanel;
import game.panels.PostGamePanel;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {
    private MainMenuPanel mainMenuPanel;
    private HighScoresPanel highScoresPanel;
    private PostGamePanel postGamePanel;
    private List<HighScoreEntry> highScoreList;


    public GameFrame(){
        super("myAim");
        setBounds(500,10,1000,1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        mainMenuPanel = new MainMenuPanel(this);
        add(mainMenuPanel);

        highScoresPanel = new HighScoresPanel(this);
        add(highScoresPanel);
        highScoresPanel.setVisible(false);

        postGamePanel = new PostGamePanel(this);
        add(postGamePanel);
        postGamePanel.setVisible(false);

        highScoreList = new ArrayList<HighScoreEntry>();
        //initHighScoreList();
    }

    public void setMainMenuPanelVisibility(boolean b){
        mainMenuPanel.setVisible(b);
    }

    public void setHighScoresPanelVisibility(boolean b){
        highScoresPanel.setVisible(b);
    }

    public void setPostGamePanelVisibility(boolean b){
        postGamePanel.setVisible(b);
    }

    public PostGamePanel getPostGamePanel() {
        return postGamePanel;
    }

    public void addNewHighScoreEntry(HighScoreEntry highScoreEntry){
        try{
            int i = 0;
            for(HighScoreEntry highScoreEntryIterator : highScoreList){
                if(i >= 10){break;}
                if (highScoreEntry.getScore() > highScoreEntryIterator.getScore()){
                    highScoreList.add(i, highScoreEntry);
                }
                else if (highScoreEntry.getScore() == highScoreEntryIterator.getScore() &&
                        highScoreEntry.getAccuracy() > highScoreEntryIterator.getAccuracy()){
                    highScoreList.add(i, highScoreEntry);
                }
                i++;
            }
            if(i < 10){
                highScoreList.add(i, highScoreEntry);
            }
        }catch (Exception ignored){}
    }

    public void updateHighScorePanel(){
        highScoresPanel.clearHighScoreEntries();
        int i = 1;
        for(HighScoreEntry highScoreEntryIterator : highScoreList){
            highScoresPanel.insertEntry(i++, highScoreEntryIterator);
        }
    }

    public void saveHighScores(){
        try {
            FileWriter fileWriter = new FileWriter("src/game/data/HighScores.txt");
            for(HighScoreEntry highScoreEntryIterator : highScoreList) {
                fileWriter.write(highScoreEntryIterator.toString() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*private ArrayList<HighScoreEntry> initHighScoreList() {
        BufferedReader bf;
        String line;
        ArrayList<HighScoreEntry> list = new ArrayList<HighScoreEntry>();
        try {
            bf = new BufferedReader(new FileReader("src/game/data/HighScores.txt"));
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(" ");
                System.out.println(parts[0]);
                int score = Integer.parseInt(parts[0]);
                float accuracy = Float.parseFloat(parts[1]);
                System.out.println(score + " " + accuracy);
                list.add(new HighScoreEntry(3,34.6f));
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }*/
}
