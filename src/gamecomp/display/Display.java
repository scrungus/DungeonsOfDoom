package gamecomp.display;

import java.io.File;
import java.util.Scanner;

/**
 * Display
 */
public class Display {

    public Display(){
    }

    public void map(char[][] map ){
        for(int i = 0; i < map.length;i++){
            for(int j = 0; j< map[i].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
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