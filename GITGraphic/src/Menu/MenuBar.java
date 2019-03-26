package Menu;
import javax.swing.JMenuBar;


import DrawingPanel.Drawingpanel;
import global.constants.EMenu;



public class MenuBar extends JMenuBar {
	private static long serialversionUID= 1L;
	private Filemenu filemenu;	
	
	private Drawingpanel drawingpanel;
	public void associate(Drawingpanel drawingpanel) {
		this.drawingpanel = drawingpanel;
	}
	
	public MenuBar(){
		this.filemenu = new Filemenu(EMenu.fileMenu.getText());
		this.add(this.filemenu);
}
}
