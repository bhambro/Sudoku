
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Pause view implementation for GUI view
 */

package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.PauseController;

public class GuiPauseView extends JFrame implements PauseView {
	
	private static final long serialVersionUID = 8299626917847150144L;

	private PauseController controller;
	
	private JButton resume;
	private JButton save;
	private JButton menu;
	private JButton exit;
	
	public GuiPauseView(){
		super("Pause Menu");
	}
	
	public void disableSaveFunction(){
		save.setEnabled(false);
	}

	@Override
	public void draw() {
		setLayout(null);
		
		resume = new JButton("Resume");
		resume.setBounds(5, 5, 140, 25);
		resume.setActionCommand("resume");
		resume.addActionListener(controller);
		add(resume);
		
		save = new JButton("Save Game");
		save.setBounds(5, 35, 140, 25);
		save.setActionCommand("save");
		save.addActionListener(controller);
		add(save);
		
		menu = new JButton("Main Menu");
		menu.setBounds(5, 65, 140, 25);
		menu.setActionCommand("menu");
		menu.addActionListener(controller);
		add(menu);
		
		exit = new JButton("Exit Game");
		exit.setBounds(5, 95, 140, 25);
		exit.setActionCommand("exit");
		exit.addActionListener(controller);
		add(exit);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(150, 250);
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
	public void setDelegate(PauseController c) {
		controller = c;
	}

}
