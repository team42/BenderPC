package Connection;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Set up a new connection to host on port and send message (data).
 * 
 * @author Nicolai
 *
 */
public class Client {

	private static String host = "192.168.1.73";
	private static final int port = 4242;
	
	/**
	 * Set up a new connection to host on port and send message (data).
	 * 
	 * @param message
	 */
	public void send(char[] message) {
		Socket socket = null;
		
		try {
			socket = new Socket(host,port);
			
			PrintWriter networkOutput = new PrintWriter(socket.getOutputStream(),true);

			networkOutput.println(message);
		} catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
		
		finally{
			try {
				System.out.println("\nClosing connection...");
				socket.close();
			} catch(IOException eoEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
	}

}