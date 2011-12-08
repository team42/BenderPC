package Connection;

import java.io.*;
import java.net.*;
import java.util.*;

import main.MapInfo;

/**
 * This class handles the clients that receives maze data from the server.
 * 
 * @author Nicolai
 *
 */
public class ClientHandler extends Thread {

	private Socket client;
	private DataInputStream input;
	
	MapInfo mapInfo = MapInfo.getMapInfo();
	byte maze[][] = new byte[13][13];
	
	/**
	 * Start receiving data.
	 * 
	 * @param socket
	 */
	public ClientHandler(Socket socket) {
		client = socket;
		
		try {
			input = new DataInputStream(client.getInputStream());
			
		} catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
	
	/**
	 * Read input into byte array.
	 */
	public void run() {
		byte received[] = new byte[200];
		
		try {
			input.read(received);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(received[0]) {
			case 6:
				mapInfo.setPosition(received[1], received[2]);
				break;
			case 7:
				int current = 1;
				for(int j=0; j<13; j++) {
					for(int i=0; i<13; i++) {
						if(received[current] == 20) {
							maze[i][j] = 0;
						} else {
							maze[i][j] = received[current];
						}
						current++;
					}
				}
				mapInfo.setMaze(maze);
				break;
			default:
				System.out.println("Server ERROR God Damnit!!!!!");
				break;
		}
		
		try {
			if (client != null) {
				client.close();
			}
		} catch(IOException ioEx) {
			System.out.println("Unable to disconnect!");
		}
	}
}
