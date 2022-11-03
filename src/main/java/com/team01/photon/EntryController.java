package com.team01.photon;
import java.awt.event.*;

public class EntryController implements KeyListener {

    public Game game;
    public EntryGraphics graphics;
    public boolean onEntryScreen;

    public String currentEditText;
    private final String acceptableIDchars;
    private final String acceptableCodenameChars;

    public EntryController(Game game, EntryGraphics graphics){ //This will eventually need references to the PlayScreen
        this.game = game;
        onEntryScreen = true;
        this.graphics = graphics;

        currentEditText = "";
        acceptableIDchars = "0123456789";
        acceptableCodenameChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public void keyPressed(KeyEvent ke)
    {
        if(onEntryScreen){ //Entry screen controls
            switch(ke.getKeyCode())
            {
                case KeyEvent.VK_TAB:
                    try {
                        if (!graphics.editingCodename) {
                            int playerID = Integer.parseInt(currentEditText);
                            if(game.IsIDAlreadyEntered(playerID))
                            {
                                break; //Skip all this and don't properly "input" the ID if it is already entered (this probably needs better feedback to user later)
                            }

                            if(game.ExistsInDatabase(playerID)){
                                game.AddToTeamByID(playerID, graphics.teamSelected);

                                if(graphics.teamSelected){ //If we have filled out the green side, increment to the next player index
                                    graphics.playerSelected++;
                                }
                                graphics.teamSelected = !graphics.teamSelected; //Swap team selection
                                currentEditText = "";
                            }else{
                                graphics.editingCodename = true;
                                graphics.temporaryIDText = currentEditText; //Give the graphics a temporary ID string to render before the Player object is actually made
                                currentEditText = "";
                            }
                        } else {
                            int playerID = Integer.parseInt(graphics.temporaryIDText);
                            String codename = currentEditText;
                            currentEditText = "";
                            graphics.temporaryIDText = "";
                            game.AddToDatabase(playerID, codename);
                            game.AddToTeamByID(playerID, graphics.teamSelected);

                            if(graphics.teamSelected){ //If we have filled out the green side, increment to the next player index
                                graphics.playerSelected++;
                            }
                            graphics.teamSelected = !graphics.teamSelected; //Swap team selection

                            graphics.editingCodename = false;
                        }
                        graphics.editText = currentEditText;
                    }catch(Exception e){}
                    break;
            }
        }else{ //Play screen controls

        }
    }
    public void keyReleased(KeyEvent ke)
    {
    }
    public void keyTyped(KeyEvent ke)
    {
        if(onEntryScreen){ //Entry screen typing
            if(!graphics.editingCodename){
                if(acceptableIDchars.indexOf(ke.getKeyChar()) > -1)
                {
                    currentEditText = currentEditText + ke.getKeyChar();
                    graphics.editText = currentEditText;
                }
            }else{
                if(acceptableCodenameChars.indexOf(ke.getKeyChar()) > -1)
                {
                    currentEditText = currentEditText + ke.getKeyChar();
                    graphics.editText = currentEditText;
                }
            }
        }
    }
}
