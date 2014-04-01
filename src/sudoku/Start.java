package sudoku;

public class Start {
	
	public static void main(String[] args){
		if(args.length == 1){
			if(args[0].equals("text-view")){
				//Over-ride the default view type - all controllers will be passed CLI views
				ApplicationDelegate.getInstance().setViewType(ApplicationDelegate.ViewType.CLI_VIEWTYPE);
			}
		}
		ApplicationDelegate.getInstance().showMainMenu();
	}
}
