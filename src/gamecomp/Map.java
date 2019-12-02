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

	private int PLAYER_VIEW = 2;
	private int LOOK_SIZE = 5;
	
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

	public char[][] getPlayerView(char playerSymbol){
		char[][] playerview = new char[LOOK_SIZE][LOOK_SIZE];
		int k,l; k=l=0;
		Pair<Integer,Integer> location= findSymbol(playerSymbol);
		System.out.println("location : "+location.getK()+" "+location.getV());
		Pair<Integer,Integer> heightPoints = new Pair<Integer,Integer>(location.getK()-PLAYER_VIEW,location.getK()+PLAYER_VIEW);
		Pair<Integer,Integer> widthPoints = new Pair<Integer,Integer>(location.getV()-PLAYER_VIEW,location.getV()+PLAYER_VIEW);
		System.out.println("height : "+heightPoints.getK()+" "+heightPoints.getV());
		System.out.println("width : "+widthPoints.getK()+" "+widthPoints.getV());
		for(int i = heightPoints.getK();i<= heightPoints.getV();i++){
			System.out.println("i : "+i);
			for(int j = widthPoints.getK();j<= widthPoints.getV();j++){
				System.out.println("j : "+j);
				if(map.length > i && map[0].length > j && (i >=0 && j >=0)){
					System.out.println("true");
					System.out.println("map height and width : "+ map.length + " " + map[0].length);
					System.out.println("k and l : " +k+ " "+ l);
					playerview[k][l] = map[i][j];
				}
				else{
					System.out.println("wall");
					System.out.println("k and l : " +k+ " "+ l);
					playerview[k][l] = '#';
				}
				l++;
			}
			l = 0;
			k++;
		}
		return playerview;
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
