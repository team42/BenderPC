package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Connection.Client;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.EtchedBorder;

/**
 * <code>CanvasMenu</code> sets up the canvas with buttons and their actions.
 *
 *
 * @author Nicolai
 */
@SuppressWarnings("serial")
public class CanvasMenu extends JPanel {

	Client client = new Client();
	
	public JPanel panel1 = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	
	public JLabel labelPositionText;
	public JLabel labelPosition;
	
	public JButton buttonGetPos = new JButton("Get Position!");
	public JButton buttonSetPos = new JButton("Go to X,Y!");
	public JButton buttonStartMap = new JButton("Start Mapping!");
	public JButton buttonGetMap = new JButton("Get Map!");
	public JButton buttonStopMap = new JButton("Stop Mapping!");
	
	public JTextField textPane = new JTextField();
	
	public CanvasMenu() {
		setLayout(null);
		
		panel1.setLayout(null);
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setBounds(0, 0, 200, 160);
		add(panel1);
		
		labelPositionText = DefaultComponentFactory.getInstance().createLabel("Current Position:");
		labelPositionText.setFont(new Font("Verdana", Font.BOLD, 12));
		labelPositionText.setHorizontalAlignment(SwingConstants.CENTER);
		labelPositionText.setBounds(10, 25, 180, 15);
		panel1.add(labelPositionText);
		
		labelPosition = DefaultComponentFactory.getInstance().createLabel("X,Y");
		labelPosition.setFont(new Font("Verdana", Font.BOLD, 20));
		labelPosition.setHorizontalAlignment(SwingConstants.CENTER);
		labelPosition.setBounds(10, 45, 180, 35);
		panel1.add(labelPosition);
		
		buttonGetPos.setBounds(15, 85, 170, 50);
		buttonGetPos.setFont(new Font("Verdana", Font.BOLD, 16));
		buttonGetPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char message[] = new char[1];
				message[0] = 1;
				client.send(message);
			}
		});
		panel1.add(buttonGetPos);
		
		//------------------------------------------------------------------------------------------------
		
		panel2.setLayout(null);
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBounds(0, 190, 200, 175);
		add(panel2);
		
		JLabel labelPositionText2 = DefaultComponentFactory.getInstance().createLabel("New Position:");
		labelPositionText2.setFont(new Font("Verdana", Font.BOLD, 12));
		labelPositionText2.setHorizontalAlignment(SwingConstants.CENTER);
		labelPositionText2.setBounds(10, 25, 180, 15);
		panel2.add(labelPositionText2);
		
		textPane.setHorizontalAlignment(SwingConstants.CENTER);
		textPane.setFont(new Font("Verdana", Font.BOLD, 20));
		textPane.setText("X,Y");
		textPane.setBounds(30, 45, 140, 35);
		panel2.add(textPane);
		
		buttonSetPos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char message[] = new char[3];
				String positions[] = textPane.getText().split(",");
				MapInfo mapInfo = MapInfo.getMapInfo();
				message[0] = 2;
				try {
					message[1] = (char)Integer.parseInt(positions[0]);
					message[2] = (char)Integer.parseInt(positions[1]);
					if(mapInfo.getMaze()[message[1]][message[2]] != 0) {
						client.send(message);
					} else {
						JOptionPane.showMessageDialog(null, "Coordinate is not discovered!");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Coordinates must be numbers!");
				}
			}
		});
		buttonSetPos.setBounds(15, 85, 170, 50);
		buttonSetPos.setFont(new Font("Verdana", Font.BOLD, 16));
		panel2.add(buttonSetPos);
		
		JLabel labelPositionText21 = DefaultComponentFactory.getInstance().createLabel("(ignored while mapping)");
		labelPositionText21.setFont(new Font("Verdana", Font.BOLD, 10));
		labelPositionText21.setHorizontalAlignment(SwingConstants.CENTER);
		labelPositionText21.setBounds(10, 140, 180, 15);
		panel2.add(labelPositionText21);
		
		//------------------------------------------------------------------------------------------------
		
		panel3.setLayout(null);
		panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel3.setBounds(0, 395, 200, 215);
		add(panel3);
		
		buttonStartMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char message[] = new char[1];
				message[0] = 3;
				client.send(message);
			}
		});
		buttonStartMap.setBounds(15, 15, 170, 50);
		buttonStartMap.setFont(new Font("Verdana", Font.BOLD, 16));
		panel3.add(buttonStartMap);
		
		buttonGetMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char message[] = new char[1];
				message[0] = 4;
				client.send(message);
			}
		});
		buttonGetMap.setBounds(15, 80, 170, 50);
		buttonGetMap.setFont(new Font("Verdana", Font.BOLD, 16));
		panel3.add(buttonGetMap);
		
		buttonStopMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char message[] = new char[1];
				message[0] = 5;
				client.send(message);
			}
		});
		buttonStopMap.setBounds(15, 145, 170, 50);
		buttonStopMap.setFont(new Font("Verdana", Font.BOLD, 16));
		panel3.add(buttonStopMap);
		
	}
}
