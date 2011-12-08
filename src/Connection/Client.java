package Connection;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	// Nicolai

	private static String host = "192.168.1.73";
	private static final int port = 4242;
	
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