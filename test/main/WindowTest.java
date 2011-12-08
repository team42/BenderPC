/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  <code>WindowTest</code> will test the <code>WindowTest</code> class
 *
 * @see Window
 * 
 * @author lasse
 *
 */
public class WindowTest {

   /**
    * Test method for {@link main.Window#Window()}.
    */
   @Test
   public void testWindow() {
      Window expectedFrame = new Window();
      Window actualFrame = new Window();
      assertNotSame(expectedFrame, actualFrame);
   }


   /**
    * Test method for {@link main.Window#initMaze()}.
    */
   @Test
   public void testInitMaze() {      
      byte[][] expectedMaze = Window.initMaze();
      byte[][] actualMaze = Window.initMaze();
      assertArrayEquals(expectedMaze, actualMaze);
   }

}
