package gamecomp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gamecomp.display.Display;
import gamecomp.player.Human;
import gamecomp.player.Player;
import gamecomp.structs.Pair;

/**
 * Contains the main logic part of the game, as it processes.
 *
 */
public class GameLogic {
	
	private final Map map;
    private final Display display;
    private final Player player;
    private List<Pair<String,Pair<Integer,Integer>>> validDirections;
    private List<Pair<String,Integer>> validMoves;
    
    
	/**
	 * Default constructor
	 */
	public GameLogic() {
        map = new Map();
        display = new Display();  
        player = new Human();
        validMoves = new ArrayList<>();
        validDirections = new ArrayList<>();
    }
    
    public void startGame(){
        display.startScreen();
        display.map(map.getMap());
        setValidMoves();
        setValidDirections();
        takeTurns();
    }

    private void takeTurns(){
        boolean gameOver = false;
        boolean playersTurn = true;
        while(!gameOver){
            if(playersTurn){
                System.out.println("Your Move... ");
                String[] args = getMove();
                doMove(args);
                playersTurn = false;
            }
            else{

            }
        }
        
    }

    private String[] getMove(){
        while(true){       
                final String[] input = player.getInput();
                if(checkMove(input)){
                   return input;
                }
                else{
                    System.out.println("Enter a valid move : ");
                }
        }
    }

    private boolean checkMove(final String[] input){
        boolean valid = false;
        final Pair<String, Integer> move = new Pair<>(input[0], input.length - 1);
        for (final Pair<String, Integer> validMove : validMoves) {
            if(validMove.equals(move)){
                if(move.key.equals("MOVE")){
                    if(getValidDirections().contains(input[1])){
                        valid = true;
                    }  
                }
                else{
                    valid = true;
                }
               
            }
        }
        return valid;
    }

    private void doMove(String[] args){
        switch (args[0]) {
            case "HELLO": hello();       
                break;
            case "GOLD": gold();      
                break;
            case "MOVE": move(args[1].charAt(0));   
                break;
            case "PICKUP": pickup();        
                break;
            case "LOOK": look();
                break;
            case "QUIT": quitGame();
                break;
        }
    }

    private void setValidMoves(){
        validMoves.add(new Pair<>("MOVE",1));
        validMoves = Collections.unmodifiableList(validMoves);
    }

    private void setValidDirections(){
		validDirections.add(new Pair<>("N", new Pair<>(0,1)));
		validDirections.add(new Pair<>("S", new Pair<>(0,-1)));
		validDirections.add(new Pair<>("W", new Pair<>(-1,0)));
		validDirections.add(new Pair<>("E", new Pair<>(1,0)));
    }
    
    private List<String> getValidDirections(){
        List<String> directions = new ArrayList<>();
		for(Pair<String,Pair<Integer,Integer>> direction : validDirections){
			directions.add(direction.key);
		}
		return directions;
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