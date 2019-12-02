package gamecomp.display;

import java.io.File;
//import java.util.List;
import java.util.Scanner;
//import gamecomp.structs.Pair;
/**
 * Display
 */
public class Display {
/*
    private List<Pair<String,Integer>> messages;
    private String succ = "SUCCESS";
    private String fail = "FAIL";
    private String win = "WIN";
    private String lose = "LOSE";
*/
    public Display(){
    }

    public void map(char[][] map ){
        System.out.println("printing map..");
        for(int i = 0; i < map.length;i++){
            for(int j = 0; j< map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void message(String type){
        System.out.println(type);
    }

    public void startScreen(){
        try {
            Scanner input = new Scanner(new File("gamecomp/display/game_banner.txt"));
            while (input.hasNextLine()){
                System.out.println(input.nextLine());
            }
            input.close();    
        } catch (Exception e) {
           
        } finally{
            System.out.println();
            System.out.println("Welcome to the Dungeon of Doom naenae!");
            System.out.println();
        }                                                                                                                               
    }

}