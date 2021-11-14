package com.GuiApp.windowParts;

import com.GuiApp.MainWindow;
import com.GuiApp.windowParts.guiParts.GameControlArea;
import com.GuiApp.windowParts.guiParts.GameInfoArea;
import com.GuiApp.windowParts.guiParts.PlayerControlArea;
import com.GuiApp.windowParts.guiParts.PlayerInfoArea;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {
    private MainWindow mainWindow;

    private GameControlArea gameControlArea;
    private PlayerInfoArea playerInfoArea;
    private GameInfoArea gameInfoArea;
    private PlayerControlArea playerControlArea;

    private JTextArea gameLog;
    private JScrollPane scrollLog;

    public GuiPanel(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        prepare();
        createParts();
        prepareLogArea();

        add(gameControlArea);
        add(playerInfoArea);
        add(gameInfoArea);
        add(playerControlArea);
        add(scrollLog);
    }

    private void prepare() {
        setBackground(Color.RED);
        setLayout(new GridLayout(5, 1));
    }

    private void prepareLogArea() {
        gameLog = new JTextArea();
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
        scrollLog = new JScrollPane(gameLog);
    }

    private void createParts() {
        gameControlArea = new GameControlArea(this);
        playerInfoArea = new PlayerInfoArea();
        gameInfoArea = new GameInfoArea();
        playerControlArea = new PlayerControlArea(this);
    }

    public void recordLog(String msg) {
        gameLog.append(msg + "\n");
    }

    public void launchNewGame() {
        mainWindow.startNewGame();
    }

    public void refreshGuiInfo(GameMap map) {
        playerInfoArea.refreshPlayerInfo(map.getPlayer());
        gameInfoArea.refreshGameInfo(map.getCountEnemies(), map.getLevelCount(), map.getMapSize());
    }

    public void changePositionPlayer(int key) {
        mainWindow.changePositionPlayer(key);
    }
}
