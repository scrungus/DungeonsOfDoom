package gamecomp;
import java.util.Random;

import gamecomp.player.Player;
import gamecomp.structs.Pair;

/**
 * Reads and contains in memory the map of the game.
 *
 */
public class Map {

	/* Representation of the map */
	private char[][] map;
	
	/* Map name */
	private String mapName;

	private Pair<Character,Pair<Integer,Integer>> symbolPosition;
	private Pair<Character,Pair<Integer,Integer>> playerNextPosition;
	
	/* Gold required for the human player to win */
	private int goldRequired;
	
	/**
	 * Default constructor, creates the default map "Very small Labyrinth of doom".
	 */
	public Map() {
		mapName = "Very small Labyrinth of Doom";
		goldRequired = 2;
		map = new char[][]{
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','G','.','.','.','.','.','.','.','.','.','E','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','E','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','G','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#'},
		{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
	}

	public void spawnPlayer(Player player){
		Random rand = new Random();
			while(true){
				int lat = rand.nextInt(getWidth());
				int longi = rand.nextInt(getHeight());
				if(map[lat][longi] != 'G'){
					symbolPosition = new Pair<>(map[lat][longi],new Pair<>(lat,longi));
					if(tryUpdateMap(player.getPlayerSymbol(),new Pair<Integer,Integer>(lat,longi))){
						return;
					}
				} 
			}
		}		

	public boolean tryUpdateMap(char symbol, Pair<Integer,Integer> location){
		if(map[location.getK()][location.getV()] != '#'){
			playerNextPosition = new Pair<>(map[location.getK()][location.getV()],new Pair<>(location.getK(),location.getV()));
			Pair<Integer,Integer> player = findSymbol(symbol);
			map[player.getK()][player.getV()] = symbolPosition.getK();
			map[location.getK()][location.getV()] = symbol;
			symbolPosition = playerNextPosition;		
			return true;
		}
		return false;
	}

	private int getWidth(){
		return map.length;
	}

	private int getHeight(){
		return map[0].length;
	}
	
	public Pair<Integer,Integer> findSymbol(char symbol){
		for(int i = 0; i < map.length;i++){
            for(int j = 0; j< map[i].length;j++){
				if(map[i][j] == symbol){
					return new Pair<Integer,Integer>(i,j);
				}
			}
		}
		return new Pair<Integer,Integer>(0,0);
	}

	public Pair<Integer,Integer> getNewLocation(char symbol, Pair<Integer,Integer> shift){
		Pair<Integer,Integer> location= findSymbol(symbol);
		return new Pair<Integer,Integer>(location.getK()+shift.getK(),location.getV()+shift.getV());
	} 
	/**
	 * Constructor that accepts a map to read in from.
	 *
	 * @param : The filename of the map file.
	 */
	public Map(String fileName) {
		readMap(fileName);
	}

    /**
     * @return : Gold required to exit the current map.
     */
    protected int getGoldRequired() {
        return goldRequired;
    }

    /**
     * @return : The map as stored in memory.
     */
    protected char[][] getMap() {
        return map;
    }


    /**
     * @return : The name of the current map.
     */
    protected String getMapName() {
        return mapName;
    }


    /**
     * Reads the map from file.
     *
     * @param : Name of the map's file.
     */
    protected void readMap(String fileName) {
    }

}
