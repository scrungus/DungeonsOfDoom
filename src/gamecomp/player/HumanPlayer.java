package gamecomp.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the game with a human player and contains code needed to read inputs.
 *
 */
public class Human extends Player {

    /**
     * Reads player's input from the console.
     * <p>
     * return : A string containing the input the player entered.
     */
    public String[] getInput(){
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = {""};
            try {
                String line = reader.readLine();
                line = line.trim().toUpperCase();
                input = line.split(" ");
            
            } catch (IOException e) {
            }
        return input;
    }

    /**
     * Processes the command. It should return a reply in form of a String, as the protocol dictates.
     * Otherwise it should return the string "Invalid".
     *
     * @return : Processed output or Invalid if the @param command is wrong.
     */
    protected String getNextAction() {
        return null;
    }




}