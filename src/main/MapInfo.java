package main;

/**
 * <code>MapInfo</code> is a singleton design pattern class (no direct 
 * instantiation) used for holding map information.
 *
 * Code for this found here:<br />
 * <li>http://www.javacoffeebreak.com/articles/designpatterns/index.html</li>
 * <li>http://www.javabeginner.com/learn-java/java-singleton-design-pattern</li>
 *
 * @author Nicolai, Lasse
 */

public class MapInfo {
	
	public byte[] currentPosition = new byte[2];
	public byte[][] maze = new byte[13][13];

	CanvasMaze canvasMaze;
	CanvasMenu canvasMenu;
	
   private static MapInfo mapObject;
   
   /** 
    * Make default constructor private to make sure no other class can 
    * instantiate.
    */
	private MapInfo(CanvasMaze canvasMaze, CanvasMenu canvasMenu) {
		this.canvasMaze = canvasMaze;
		this.canvasMenu = canvasMenu;
	}

    
	/**
    * When first called, the <code>getMapInfo</code>method creates a
    * singleton instance, assigns it to a member variable, and returns the
    * singleton.
    * Subsequent calls will return the same singleton, and all is well with
    * the world.
    *
    * Method is declared syncronized to prevent two threads from calling the
    * <code>getMapInfo</code> method at the same time.
    *
    * @return mapObject holds static instance of MapInfo object.
    */
	public static synchronized MapInfo getMapInfo(CanvasMaze canvasMaze, CanvasMenu canvasMenu) {
        if (mapObject == null) {
            mapObject = new MapInfo(canvasMaze, canvasMenu);
        }
        return mapObject;
    }
    
    public static synchronized MapInfo getMapInfo() {
        return mapObject;
    }
    
    public void setPosition(byte x, byte y) {
    	this.currentPosition[0] = x;
    	this.currentPosition[1] = y;
    	canvasMenu.labelPosition.setText(x + "," + y);
    	canvasMaze.position[0] = x;
    	canvasMaze.position[1] = y;
    	canvasMaze.update();
    }
    
    public void setMaze(byte[][] maze) {
    	canvasMaze.maze = maze;
    	canvasMaze.update();
    }
    
    public byte[][] getMaze() {
    	return maze;
    }
    
    /**
     * We override the inherited superclass implementation of clone() to
     * prevent cloning of the singleton.
     * 
     * For now the only superclass is Object, in which clone() is protected,
     * but later on we might inherit from another class that implements clone()
     *
     * @return nothing, throws exception
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
       throw new CloneNotSupportedException();
    }
    
}
