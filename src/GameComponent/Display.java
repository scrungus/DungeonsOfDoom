package GameComponent;

import java.util.Arrays;
import java.util.List;

/**
 * Display
 */
public class Display {

    public Display(){
    }

    public void map(char[][] map ){
        for(int i = 0; i < map.length;i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public void startScreen(){

    }

}