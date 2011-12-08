package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * <code>CanvasMaze</code> is responsible for drawing the graphics, i.e. maze.
 *
 *
 * @author Nicolai
 */
@SuppressWarnings("serial")
public class CanvasMaze extends JPanel {
	
	public int i,j;
	public byte[][] maze = new byte[13][13];

	public byte[] position = new byte[2];
	
	private int X_start = 0, X_end = 0;
	private int Y_start = 12, Y_end = 0;
	
	public CanvasMaze() {
		//initMaze();
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
	
	public void update() {
		repaint();
	}
	
	public void draw(Graphics g) {
		findCorner();
		
		g.setColor(Color.DARK_GRAY);
		
		int mazeSize = 100;
		int x=0, y=0;
		
		for(i=Y_start; i>Y_end-1; i--) {
			for(j=X_start; j<X_end+1; j++) {
				if(maze[j][i] != 0) {
					g.drawString("["+j+","+i+"]", x*mazeSize+58, y*mazeSize+70);
					if((maze[j][i] & Byte.parseByte("1000", 2)) == 0) {
						drawWall(g, x*mazeSize, y*mazeSize, (x+1)*mazeSize, y*mazeSize);
					}
					if((maze[j][i] & Byte.parseByte("0100", 2)) == 0) {
						drawWall(g, (x+1)*mazeSize, (y+1)*mazeSize, (x+1)*mazeSize, y*mazeSize);
					}
					if((maze[j][i] & Byte.parseByte("0010", 2)) == 0) {
						drawWall(g, x*mazeSize, (y+1)*mazeSize, (x+1)*mazeSize, (y+1)*mazeSize);
					}
					if((maze[j][i] & Byte.parseByte("0001", 2)) == 0) {
						drawWall(g, x*mazeSize, (y+1)*mazeSize, x*mazeSize, y*mazeSize);
					}
				}
				x++;
			}
			x=0;
			y++;
		}		
	}
	
	public Boolean initMaze() {

		for (i = 0; i < 7; i++) {
			for (j = 0; j < 7; j++) {
				if(j==0) {
					maze[i][j] = Byte.parseByte("1000", 2);
				} else if(j==6) {
					maze[i][j] = Byte.parseByte("0010", 2);
				} else {
					maze[i][j] = Byte.parseByte("1010", 2);
				}
			}
		}
		return true;
	}
	
	public Boolean findCorner() {
		X: for(i=0; i<13; i++) {
			for(j=0; j<13; j++) {
				if(maze[i][j] != 0) {
					X_start = i;
					break X;
				}
			}
		}
		
		if(X_start + 6 > 12) {
			X_end = 12;
		} else {
			X_end = X_start + 6;
		}
		
		Y: for(i=12; i>00; i--) {
			for(j=0; j<13; j++) {
				if(maze[j][i] != 0) {
					Y_start = i;
					break Y;
				}
			}
		}
		
		if(Y_start - 6 < 0) {
			Y_end = 0;
		} else {
			Y_end = Y_start - 6;
		}
		
		return true;
	}
	
	void drawWall(Graphics g, int aX, int aY, int bX, int bY) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10));
		g2.drawLine((int) aX+50, (int) aY+50, (int) bX+50, (int) bY+50);
		g2.setStroke(new BasicStroke(1));
	}
}
