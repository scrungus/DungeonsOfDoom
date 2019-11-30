package gamecomp;
/**
 * Reads and contains in memory the map of the game.
 *
 */
public class Map {

	/* Representation of the map */
	private char[][] map;
	
	/* Map name */
	private String mapName;
	
	/* Gold required for the human player to win */
	private int goldRequired;

	private List<String> validDirections = new ArrayList<>();
	
	/**
	 * Default constructor, creates the default map "Very small Labyrinth of doom".
	 */
	public Map() {
		setValidDirections();
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
	
	/**
	 * Constructor that accepts a map to read in from.
	 *
	 * @param : The filename of the map file.
	 */
	public Map(String fileName) {
		addValidDirections();
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

	private setValidDirections(){

	}

	private List<String> getValidDirections(){
		
	}

}
