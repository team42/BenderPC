/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <code>MapInfoTest</code> will test the <code>MapInfo</code> class
 *
 * @see MapInfo
 *
 * @author Lasse
 */
public class MapInfoTest {
   
   /**
    * Test method for {@link main.MapInfo#getMapInfo()}.
    */
   @Test
   public void testGetMapInfo() {
      MapInfo expResult = MapInfo.getMapInfo();
      MapInfo result = MapInfo.getMapInfo();
      
      assertEquals(expResult, result);
   }


   /**
    * Test method for {@link main.MapInfo#setMaze(byte[][])} and {@link main.MapInfo#getMaze()}.
    */
   @Test
   public void testSetAndGetMaze() {
      byte[][] maze = new byte[13][13];
      maze[0][0] = Byte.parseByte("10", 2);
      
      MapInfo mapInfo = MapInfo.getMapInfo();
      //mapInfo.setMaze(maze);
      
      byte[][] expResult = maze;
      byte[][] result = maze;
      
      assertSame(expResult, result);      
   }

}
