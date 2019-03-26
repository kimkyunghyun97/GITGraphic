package Menu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import global.constants.EFileMenu;

public class Filemenu extends JMenu {
	private static long serialversionUID= 1L;
	private JMenuItem jmenuitem;
	
	public Filemenu(String next){
		super(next);
		
		this.jmenuitem = new JMenuItem(EFileMenu.newItem.getText());
		this.add(jmenuitem);
	}
}
