package model;

import java.io.File;
import java.util.ArrayList;

import controller.MenuController;

public class MenuModel {
	
	//Controller retained for possible future requirements
	private MenuController controller;
	
	public MenuModel(MenuController controller){
		this.controller = controller;
	}
	
	public String[] getSavedGames(){
		File dir = new File("saveGames");
		if((!dir.exists())){
			dir.mkdir();
		}
		
		ArrayList<String> fNames = new ArrayList<String>();
		File[] files = dir.listFiles();
		for(int f=0; f < files.length; f++){
			String fName = files[f].getName();
			if(fName.contains(".ser")){
				fNames.add(fName);
			}
		}
		
		String[] names = new String[fNames.size()];
		for(int n=0; n < fNames.size(); n++){
			String whole = fNames.get(n);
			String tName = whole.substring(0, whole.length() - 4);
			names[n] = tName;
		}
		
		return names;
	}

}
