package view;

//Abstract view interface ensuring all view types can be treated as a general type
//All view implementations must implement this interface

public abstract interface View {
	public void draw();
	public void showMessage(String msg);
	public void destroy(); //Used to hide GUI views but CLI views cannot perform this
	public void setVisible(boolean flag);
}
