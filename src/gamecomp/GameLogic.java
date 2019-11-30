package gamecomp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import javafx.util.Pair;

import gamecomp.display.Display;
import jdk.internal.util.xml.impl.Pair;


/**
 * Contains the main logic part of the game, as it processes.
 *
 */
public class GameLogic {
	
	private final Map map;
    private final Display display;
    
	/**
	 * Default constructor
	 */
	public GameLogic() {
        map = new Map();
        display = new Display();  
    }
    
    public void startGame(){
        display.startScreen();
        display.map(map.getMap());
        addValidMoves();
        getMove("Your move : ");
    }

    private String[] getMove(final String movePrompt){
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(movePrompt);
        while(true){
            try {
                final String line = reader.readLine();
                line.trim();
                final String[] input = line.split(" ");
                if(checkMove(input)){
                   return input;
                }
                else{
                    System.out.println("Enter a valid move : ");
                }
            } catch (final IOException e) {
            }
        }
    }

    private boolean checkMove(final String[] input){
        if(validMoves.contains(input[0].trim()) && input.length <= 2){
            return true; 
        }
        else{
            return false;
        }
    }

    private void addValidMoves(){
        Pair<String,Integer> move = new Pair<>("MOVE",1);
        validMoves.add(move);
        validMoves = Collections.unmodifiableList(validMoves);
    }

    /**
	 * Checks if the game is running
	 *
     * @return if the game is running.
     */
    protected boolean gameRunning() {
        return false;
    }

    /**
	 * Returns the gold required to win.
	 *
     * @return : Gold required to win.
     */
    protected String hello() {
        return null;
    }
	
	/**
	 * Returns the gold currently owned by the player.
	 *
     * @return : Gold currently owned.
     */
    protected String gold() {
        return null;
    }

    /**
     * Checks if movement is legal and updates player's location on the map.
     *
     * @param direction : The direction of the movement.
     * @return : Protocol if success or not.
     */
    protected String move(final char direction) {
        return null;
    }

    /**
     * Converts the map from a 2D char array to a single string.
     *
     * @return : A String representation of the game map.
     */
    protected String look() {
        return null;
    }

    /**
     * Processes the player's pickup command, updating the map and the player's gold amount.
     *
     * @return If the player successfully picked-up gold or not.
     */
    protected String pickup() {
        return null;
    }

    /**
     * Quits the game, shutting down the application.
     */
    protected void quitGame() {

    }

}