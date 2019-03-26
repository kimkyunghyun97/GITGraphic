package Main;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DrawingPanel.Drawingpanel;
import Menu.MenuBar;
import Toolbar.ToolBar;
import global.constants.EMainFrame;


public class Mainframe extends JFrame{

private static long serialversionUID = 1L;
	//components 메인 프레임이 new을 해야 생성 
	private MenuBar menuBar;
	private static ToolBar toolBar;
	private Drawingpanel drawingpanel;
	
	public Mainframe(){
	this.setLocation(EMainFrame.x.getValue(),EMainFrame.y.getValue());// 이메인프레임가면 만들어져있는 엑스를 가져와라
	this.setSize(EMainFrame.w.getValue(),EMainFrame.h.getValue());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//이때 뉴했으니 생성
	this.menuBar = new MenuBar();
	this.setJMenuBar(this.menuBar);
	
	
	this.setLayout(new BorderLayout());
	this.toolBar = new ToolBar();
	this.add(this.toolBar, BorderLayout.NORTH);
	//this.add(toolBar,	BorderLayout.WEST);	


	this.drawingpanel = new Drawingpanel();
	this.add(this.drawingpanel,BorderLayout.CENTER);
	
	this.menuBar.associate(this.drawingpanel);
	this.toolBar.associate(this.drawingpanel);
}	
}