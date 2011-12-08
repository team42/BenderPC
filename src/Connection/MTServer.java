package Connection;

import java.io.*;
import java.net.*;


/**
 * Starts a server listening on port 4224.
 * 
 * @author Nicolai
 *
 */
public class MTServer {

	private static ServerSocket serverSocket;
	private static final int port = 4224;
	
	/**
	 * Starts a server listening on port 4224.
	 * @throws IOException
	 */
	public void Server() throws IOException {
		
		try{
			serverSocket = new ServerSocket(port);
		} catch(IOException ioEx) {
			System.out.println("\nUnable to set up port!");
			System.exit(1);
		}
		
		do {
			Socket client = serverSocket.accept();
			
			ClientHandler handler = new ClientHandler(client);
			handler.start();
		} while (true);
	}
}