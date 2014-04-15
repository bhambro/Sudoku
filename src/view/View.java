
/*
 * Author: Ben Hambrook
 * Date: 15/4/14
 * Purpose: Abstract view interface ensuring all view types can be treated as a general
 * 			type, all implementations must implement this interface
 */

package view;

public abstract interface View {
	public void draw();
	public void showMessage(String msg);
	public void destroy(); //Used to hide GUI views but CLI views cannot perform this
	public void setVisible(boolean flag);
}
