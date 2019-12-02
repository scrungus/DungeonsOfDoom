package gamecomp.player;
/**
 * Bot
 */

public class Bot extends Player {

    private char[][] view;

    public Bot(){
        playerSymbol = 'B';
    }
    
    public void readMap(char[][] map){
        view = map;
    }
    /** 
     * @return String[]
     */
    @Override
    public String[] getInput() {
        // TODO Auto-generated method stub
        return null;
    }

    
    /** 
     * @return char
     */
    @Override
    public char getPlayerSymbol() {
        return playerSymbol;
    }

    
}