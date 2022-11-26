package team01.photon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import team01.photon.playview.MainView;

import java.util.Arrays;

public class EntryGraphics extends JPanel implements KeyListener {
    public EntryGraphicsView game;

    private final int frameW;
    private final int frameH;
    private int playerSelected;
    private boolean teamSelected; // False for red, true for green
    private boolean editingCodename; // False means entering ID, true means entering/editing codename

    // Spacing variables
    private final int pixelsBetweenBoxes;
    private final int boxHeight;
    private final int idWidth;
    private final int playerWidth;
    private final int redTeamX; // X value to start drawing the selection box for red team
    private final int greenTeamX; // X value to start drawing the selection box for blue team
    private final int startingY; // Y value to start drawing the selection box

    // Playername/ID editing variables
    private String currentEditText;
    private String acceptableIDchars;
    private String acceptableCodenameChars;
    private Font textFont;

    public int[] redTeamIDs;
    public int[] greenTeamIDs;
    public String[] redTeamNames;
    public String[] greenTeamNames;

    public EntryGraphics(EntryGraphicsView game, int width, int height) {
        this.game = game;
        frameW = width;
        frameH = height;
        playerSelected = 0;
        teamSelected = false;
        editingCodename = false;

        // Spacing variables
        pixelsBetweenBoxes = 5;
        boxHeight = 40;
        idWidth = 90;
        playerWidth = 250;
        redTeamX = 45;
        greenTeamX = 445;
        startingY = 120;

        currentEditText = "";
        acceptableIDchars = "0123456789";
        acceptableCodenameChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        textFont = new Font("SANS_SERIF", Font.PLAIN, 35);

        redTeamIDs = new int[15];
        Arrays.fill(redTeamIDs, -1);
        greenTeamIDs = new int[15];
        Arrays.fill(greenTeamIDs, -1);
        redTeamNames = new String[15];
        greenTeamNames = new String[15];

    }

    @Override
    public void paintComponent(final Graphics g) {
        // Default background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frameW, frameH);

        // Image background
        ImageIcon entryImage = new ImageIcon(this.getClass().getResource("/images/entryscreen.png"));
        g.drawImage(entryImage.getImage(), 0, 0, null);

        // Selection box outline
        g.setColor(System.currentTimeMillis() % 700 > 350 ? Color.BLUE : Color.WHITE);

        int x = (teamSelected ? greenTeamX : redTeamX) + (editingCodename ? idWidth + pixelsBetweenBoxes : 0);
        int y = startingY + playerSelected * (pixelsBetweenBoxes + boxHeight);
        int w = (editingCodename ? playerWidth : idWidth);
        int h = boxHeight;

        for (int outlineLayer = 0; outlineLayer < 5; outlineLayer++) {
            int olX = x + outlineLayer;
            int olY = y + outlineLayer;
            int olW = w + (9 - outlineLayer * 2);
            int olH = h + (9 - outlineLayer * 2);
            g.drawRect(olX, olY, olW, olH);
        }

        // Current text input drawing
        g.setFont(textFont);
        g.drawString(currentEditText, x + pixelsBetweenBoxes, y + boxHeight);

        // Stored IDs and codenames drawing
        g.setColor(Color.BLACK);

        // Red team IDs
        for (int id = 0; id < 15; id++) {
            x = redTeamX;
            y = startingY + id * (pixelsBetweenBoxes + boxHeight);

            int playerID = redTeamIDs[id];
            if (playerID > -1) {
                g.drawString(Integer.toString(playerID), x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        // Green team IDs
        for (int id = 0; id < 15; id++) {
            x = greenTeamX;
            y = startingY + id * (pixelsBetweenBoxes + boxHeight);

            int playerID = greenTeamIDs[id];
            if (playerID > -1) {
                g.drawString(Integer.toString(playerID), x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        // Red team names
        for (int id = 0; id < 15; id++) {
            x = redTeamX + idWidth + pixelsBetweenBoxes;
            y = startingY + id * (pixelsBetweenBoxes + boxHeight);

            String playerName = redTeamNames[id];
            if (playerName != null) {
                g.drawString(playerName, x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        // Red team names
        for (int id = 0; id < 15; id++) {
            x = greenTeamX + idWidth + pixelsBetweenBoxes;
            y = startingY + id * (pixelsBetweenBoxes + boxHeight);

            String playerName = greenTeamNames[id];
            if (playerName != null) {
                g.drawString(playerName, x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

    }

    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_F1:
                System.exit(1);
            case KeyEvent.VK_TAB:
                try {
                    if (!editingCodename) {
                        int playerID = Integer.parseInt(currentEditText);
                        String playerCodename = game.herokuDB.getCodenameById(playerID);
                        if (!teamSelected) {
                            redTeamIDs[playerSelected] = playerID;
                            if (playerCodename != "") {
                                redTeamNames[playerSelected] = playerCodename;
                                teamSelected = true;
                            } else {
                                editingCodename = true;
                            }
                            currentEditText = "";
                        } else {
                            greenTeamIDs[playerSelected] = playerID;
                            if (playerCodename != "") {
                                greenTeamNames[playerSelected] = playerCodename;
                                teamSelected = false;
                                playerSelected++;
                                if (playerSelected > 14) {
                                    playerSelected = 0;
                                }
                            } else {
                                editingCodename = true;
                            }
                            currentEditText = "";
                        }
                    } else {
                        if (!teamSelected) {
                            int playerID = redTeamIDs[playerSelected];
                            if (game.herokuDB.addPlayerRecord(playerID, currentEditText)) {
                                redTeamNames[playerSelected] = currentEditText;
                                editingCodename = false;
                                teamSelected = true;
                                currentEditText = "";
                            }
                        } else {
                            int playerID = greenTeamIDs[playerSelected];
                            if (game.herokuDB.addPlayerRecord(playerID, currentEditText)) {
                                greenTeamNames[playerSelected] = currentEditText;
                                editingCodename = false;
                                teamSelected = false;
                                playerSelected++;
                                if (playerSelected > 14) {
                                    playerSelected = 0;
                                }
                                currentEditText = "";
                            }
                        }
                    }
                } catch (Exception e) {
                }
                break;
            case KeyEvent.VK_F5:
                game.game.switchToPlayScreen();
        }
    }

    public void keyReleased(KeyEvent ke) {
    }

    public void keyTyped(KeyEvent ke) {
        if (!editingCodename) {
            if (acceptableIDchars.indexOf(ke.getKeyChar()) > -1) {
                currentEditText = currentEditText + ke.getKeyChar();
            }
        } else {
            if (acceptableCodenameChars.indexOf(ke.getKeyChar()) > -1) {
                currentEditText = currentEditText + ke.getKeyChar();
            }
        }
    }
}
