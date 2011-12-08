/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <code>CanvasMazeTest</code> will test the <code>CanvasMaze</code> class
 *
 * @see CanvasMaze
 * 
 * @author lasse
 *
 */
public class CanvasMazeTest {

   /**
    * Test method for {@link main.CanvasMaze#initMaze()}.
    */
   @Test
   public void testInitMaze() {
      CanvasMaze canvasMaze = new CanvasMaze();
      assertSame(canvasMaze.initMaze(), canvasMaze.initMaze());
   }

   /**
    * Test method for {@link main.CanvasMaze#findCorner()}.
    */
   @Test
   public void testFindCorner() {
      CanvasMaze canvasMaze = new CanvasMaze();
      assertSame(canvasMaze.findCorner(), canvasMaze.findCorner());
   }

}
