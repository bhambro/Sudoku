
/*
 * Author: Ben Hambrook
 * Date: 1/4/14
 * Purpose: Sudoku (game) view implementation for GUI view
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.SudokuController;

public class GuiSudokuView extends JFrame implements SudokuView, DocumentListener {

	private static final long serialVersionUID = -4927944102303090610L;
	private SudokuController controller;
	
	//UI Elements
	private ArrayList<SudokuTextBox> cells;
	private JLabel timer;
	private JLabel timerLabel;
	private JButton pause;
	private GridPanel gridPanel;
	
	public GuiSudokuView(){
		super("Sudoku");
		setLayout(null);
		
		pause = new JButton("Pause Game");
		pause.setBounds(325, 50, 100, 25);
		add(pause);
		
		timerLabel = new JLabel("Time:");
		timerLabel.setBounds(330, 20, 80, 25);
		add(timerLabel);
		
		timer = new JLabel("00:00");
		timer.setBounds(375, 20, 100, 25);
		add(timer);
		
		gridPanel = new GridPanel();
		gridPanel.setBounds(0,0,500,500);
		add(gridPanel);
		
		cells = new ArrayList<SudokuTextBox>();
		createCells();
	}

	@Override
	public void draw() {
		if(pause.getActionListeners().length == 0){
			pause.setActionCommand("pause");
			pause.addActionListener(controller);
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(425, 350);
		this.setVisible(true);
	}
	
	public void createCells(){
		int cell = 0;
		for(int col = 0; col < 9; col++){
			int colPos = 2 + ((col + 1) * (28 + 3));
			for(int row = 0; row < 9; row++){
				int rowPos = 2 + ((row + 1) * (25 + 3));
				if(row >= 6){
					rowPos += 6;
				} else if(row >= 3){
					rowPos += 3;
				}

				SudokuTextBox temp = new SudokuTextBox();
				temp.setIndex(cell);
				temp.setBounds(colPos, rowPos, 28, 25);
				
				//Action listener for key press
				temp.getDocument().putProperty("owner", temp);
				temp.getDocument().addDocumentListener(this);
				cells.add(temp);
				add(temp);
				cell ++;
			}
		}
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
	public void setTimerText(String time) {
		timer.setText(time);
	}

	@Override
	public void setGridValue(int index, int value, boolean editable) {
		System.out.println("Setting index: " + index + " to: " + value);
		final SudokuTextBox thisField = cells.get(index);
		if(! editable){
			thisField.setText(value + "");
			thisField.setEditable(false);
			thisField.setBackground(Color.lightGray);
		} else {
			if(value == 0){
				//Reset the text field to empty string on validation fail
				//Use runnable object in invoke later as will be called within 
				//the event from the field we are trying to modify
				Runnable textReset = new Runnable(){
					public void run(){
						thisField.setText("");
					}
				};
				SwingUtilities.invokeLater(textReset);
			} else {
				thisField.setText(value + "");
			}
			thisField.setEditable(true);
			thisField.setBackground(Color.white);
		}		
	}

	@Override
	public void setDelegate(SudokuController c) {
		controller = c;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		//Convert document event to an action event so the controller can deal with it
		SudokuTextBox src = (SudokuTextBox) e.getDocument().getProperty("owner");
		ActionEvent ae = new ActionEvent(src, ActionEvent.ACTION_PERFORMED, "cellUpdated");
		controller.actionPerformed(ae);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		//Events ignored
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		//Events ignored
	}

}
