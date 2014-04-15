
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Implementation of MenuView for GUI based view
 */

package view;

import java.awt.Dimension;

import javax.swing.*;

import controller.MenuController;

public class GuiMenuView extends JFrame implements MenuView {

	private static final long serialVersionUID = 774843391465795258L;
	private MenuController controller;
	
	//GUI Elements
	private JPanel loadPanel;
	private JLabel loadLabel;
	private JList<String> list;
	private JScrollPane listScroller;
	private JButton loadBtn;
	
	private JPanel gamePanel;
	private JLabel playerLabel;
	private JTextField player;
	private JLabel levelLabel;
	private JSlider level;
	private JButton startBtn;
	
	public GuiMenuView(){
		super("Sudoku Main Menu");
	}

	@Override
	public void draw() {
		setLayout(null);
		
		//Load section
		loadPanel = new JPanel();
		loadPanel.setLayout(null);
		loadPanel.setBorder(BorderFactory.createTitledBorder("Load Game"));
		loadPanel.setBounds(3, 5, 200, 310);
		
		loadLabel = new JLabel("Select a file");
		loadLabel.setBounds(10, 20, 110, 25);
		loadPanel.add(loadLabel);
		
		String[] files = controller.getSavedGames();
		if(files == null){
			files = new String[0];
		}
		
		list = new JList<String> (files);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(175, 200));
		listScroller.setBounds(10, 40, 175, 200);
		loadPanel.add(listScroller);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(30, 260, 120, 25);
		loadBtn.setActionCommand("loadGameEvent");
		loadBtn.addActionListener(controller);
		loadPanel.add(loadBtn);
		
		add(loadPanel);
		
		//New game section
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setBorder(BorderFactory.createTitledBorder("New Game"));
		gamePanel.setBounds(205, 5, 215, 310);
		
		playerLabel = new JLabel("Enter your name");
		playerLabel.setBounds(10, 15, 110, 25);
		gamePanel.add(playerLabel);
		
		player = new JTextField();
		player.setBounds(10, 40, 200, 25);
		gamePanel.add(player);
		
		levelLabel = new JLabel("Select level");
		levelLabel.setBounds(10, 70, 110, 25);
		gamePanel.add(levelLabel);
		
		level = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
		level.setMajorTickSpacing(1);
		level.setSnapToTicks(true);
		level.setPaintLabels(true);
		level.setPaintTicks(true);
		level.setBounds(10, 100, 200, 40);
		gamePanel.add(level);
		
		startBtn = new JButton("Start");
		startBtn.setBounds(30, 260, 120, 25);
		startBtn.setActionCommand("newGameEvent");
		startBtn.addActionListener(controller);
		gamePanel.add(startBtn);
		
		add(gamePanel);
		System.out.println("View Drawn");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 337);
		this.setVisible(true);
	}

	@Override
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	@Override
	public void destroy() {
		this.dispose();
	}

	@Override
	public void setDelegate(MenuController c) {
		controller = c;
	}

	@Override
	public String getPlayerName() {
		return player.getText();
	}

	@Override
	public int getLevel() {
		return level.getValue();
	}

	@Override
	public String getSelectedFileName() {
		return "saveGames/" + list.getSelectedValue().toString();
	}

	@Override
	public boolean isFileSelected() {
		if(list.getSelectedIndex() < 0){
			return false;
		}
		return true;
	}

}
