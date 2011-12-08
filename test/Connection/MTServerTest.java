/**
 * 
 */
package Connection;

import static org.junit.Assert.*;

import java.io.IOException;

import main.CanvasMaze;

import org.junit.Test;

/**
 * <code>MTServerTest</code> will test the <code>MTServer</code> class
 *
 * @see MTServer
 * @author lasse
 *
 */
public class MTServerTest {

   /**
    * Test method for {@link Connection.MTServer#Server()}.
    */
   @Test
   public void testServer() {
      MTServer server = new MTServer();
      
      try {
         server.Server();
      } catch (IOException e) {
         fail("testServer failed!");
      }
   }

}
