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
    private List<Pair<Character,Pair<Integer,Integer>>> validDirections;
    private List<Pair<String,Integer>> validMoves;
    private boolean playersTurn = true;
    
    
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
    
     /** 
     * 
     */
    public void startGame(){
        display.startScreen();
        map.spawnPlayer(player);
        display.map(map.getMap());
        setValidMoves();
        setValidDirections();
        takeTurns();
    }

    /** 
     * 
     */
    private void takeTurns(){
        boolean gameOver = false;
        while(!gameOver){
            if(playersTurn){
                System.out.println("Your Move : ");
                String[] args = getMove();
                doMove(player, args);
            }
            else{
                display.map(map.getMap());
                display.message("Monsters move...");
                playersTurn = true;
            }
        }
        
    }

    
    /** 
     * @return String[]
     */
    private String[] getMove(){
        while(true){       
                final String[] input = player.getInput();
                if(checkMove(input)){
                   return input;
                }
                else{
                    display.message("ERROR");
                }
        }
    }

    
    /** 
     * @param input
     * @return boolean
     */
    private boolean checkMove(final String[] input){
        boolean valid = false;
        final Pair<String, Integer> move = new Pair<>(input[0], input.length - 1);
        for (final Pair<String, Integer> validMove : validMoves) {
            if(validMove.equals(move)){
                if(move.getK().equals("MOVE")){
                    if(getValidDirections().contains(input[1].charAt(0))){
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

    
    /** 
     * @param player
     * @param args
     */
    private void doMove(Player player, String[] args){
        switch (args[0]) {
            case "HELLO": hello();      
                break;
            case "GOLD": gold();      
                break;
            case "MOVE": move(player,args[1].charAt(0)); playersTurn = false;   
                break;
            case "PICKUP": pickup(); playersTurn = false;       
                break;
            case "LOOK": look(player);
                break;
            case "QUIT": quitGame();
                break;
        }
    }
     /** 
     * 
     */
    private void setValidMoves(){
        validMoves.add(new Pair<>("MOVE",1));
        validMoves.add(new Pair<>("LOOK",0));
        validMoves.add(new Pair<>("HELLO",0));
        validMoves = Collections.unmodifiableList(validMoves);
    }

    /** 
     * 
     */
    private void setValidDirections(){
		validDirections.add(new Pair<>('N', new Pair<>(-1,0)));
		validDirections.add(new Pair<>('S', new Pair<>(1,0)));
		validDirections.add(new Pair<>('W', new Pair<>(0,-1)));
		validDirections.add(new Pair<>('E', new Pair<>(0,1)));
    }
    
    
    /** 
     * @return List<Character>
     */
    private List<Character> getValidDirections(){
        List<Character> directions = new ArrayList<>();
		for(Pair<Character,Pair<Integer,Integer>> direction : validDirections){
			directions.add(direction.getK());
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
    protected void hello() {
        display.message("Gold Required : "+map.getGoldRequired());
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
    protected void move(Player player, char direction) {
        for(Pair<Character,Pair<Integer,Integer>> directions : validDirections){
            if(directions.getK().equals(direction)){
                Pair<Integer,Integer> shift = directions.getV();
                if(map.tryUpdateMap(player.getPlayerSymbol(),map.getNewLocation(player.getPlayerSymbol(),shift))){
                    display.message("SUCCESS");
                    return;
                }
            }
        }
        display.message("FAILURE");
    }

    /**
     * Converts the map from a 2D char array to a single string.
     *
     * @return : A String representation of the game map.
     */
    protected void look(Player player){
        display.map(map.getPlayerView(player.getPlayerSymbol()));
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