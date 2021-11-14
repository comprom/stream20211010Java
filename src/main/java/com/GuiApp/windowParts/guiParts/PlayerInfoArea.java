package com.GuiApp.windowParts.guiParts;

import com.GuiApp.models.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoArea extends JPanel {

    private String prefixHP = "Health: ";
    private String prefixStr = "Str: ";
    private String prefixPosition = "Position: ";

    private JLabel playerHP;
    private JLabel playerStr;
    private JLabel playerPosition;

    public PlayerInfoArea() {
        setLayout(new GridLayout(4,1));

        playerHP = new JLabel(prefixHP + "-");
        playerStr = new JLabel(prefixStr + "-");
        playerPosition = new JLabel(prefixPosition + "-:-");

        add(new JLabel("= Player Info =", SwingConstants.CENTER));
        add(playerHP);
        add(playerStr);
        add(playerPosition);
    }

    public void refreshPlayerInfo(Player player) {
        playerHP.setText(prefixHP + player.getHealth());
        playerPosition.setText(prefixPosition + player.getPosition());
    }

}
