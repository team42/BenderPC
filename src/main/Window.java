package main;

import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

import Connection.MTServer;

/**
 * <code>Window</code> is the main program to launch the window.
 *
 *
 * @author Nicolai
 */
@SuppressWarnings("serial")
public class Window extends JFrame {

	private JPanel contentPane;

	static CanvasMaze canvasMaze = new CanvasMaze();
	static CanvasMenu canvasMenu = new CanvasMenu();
	
	static MapInfo mapInfo;
	static MTServer server = new MTServer();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		Window frame = new Window();
		frame.setVisible(true);
		frame.setResizable(true);
		mapInfo = MapInfo.getMapInfo(canvasMaze, canvasMenu);
		server.Server();
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 850);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		canvasMaze.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		canvasMaze.setBounds(10, 10, 800, 800);
		contentPane.add(canvasMaze);
		
		canvasMenu.setBounds(820, 10, 200, 800);
		contentPane.add(canvasMenu);
	}
	
	/**
	 * Initialize the maze.
	 * 
	 * @return byte array containing the maze.
	 */
	public static byte[][] initMaze() {
		byte[][] maze = new byte[13][13];
		
		int i=5;
		int j=5;
		
		maze[0+i][0+j] = Byte.parseByte("1000", 2);
		maze[0+i][1+j] = Byte.parseByte("1110", 2);
		maze[0+i][2+j] = Byte.parseByte("1010", 2);
		maze[0+i][3+j] = Byte.parseByte("1010", 2);
		maze[0+i][4+j] = Byte.parseByte("0110", 2);
		
		maze[1+i][0+j] = Byte.parseByte("1100", 2);
		maze[1+i][1+j] = Byte.parseByte("0011", 2);
		maze[1+i][2+j] = Byte.parseByte("1000", 2);
		maze[1+i][3+j] = Byte.parseByte("0110", 2);
		maze[1+i][4+j] = Byte.parseByte("0101", 2);
		
		maze[2+i][0+j] = Byte.parseByte("1001", 2);
		maze[2+i][1+j] = Byte.parseByte("1010", 2);
		maze[2+i][2+j] = Byte.parseByte("1010", 2);
		maze[2+i][3+j] = Byte.parseByte("0011", 2);
		maze[2+i][4+j] = Byte.parseByte("0001", 2);
		
		return maze;
	}
}
