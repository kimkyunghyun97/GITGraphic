package DrawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import Shape.Shape;
import global.constants.EToolBar;

public class Drawingpanel extends JPanel {
	private static long serialversionUID = 1L;
	
	
	private MouseHandler MouseHandler;
	public Drawingpanel(){
	
	this.setBackground(Color.white);
	this.MouseHandler = new MouseHandler();
	this.addMouseListener(this.MouseHandler);
    this.addMouseMotionListener(this.MouseHandler);
   
    //currentTool = EToolBar.select.getshape();
    currentTool = EToolBar.rectangle.getshape();
	}
	
	private Shape currentTool;

	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getshape();
	}
	private void drawShape(){//원점세팅
		Graphics graphics =this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics);
	}
	private void initDrawing(int x, int y){
		this.currentTool.setOrigin(x,y);// 그림 그릴 준비를 한다
		this.drawShape();
	}
	private void keepDrawing(int x, int y){//마지막 점을 안찍고 계속 움직이는 점, 위치는 마우스 막 움직일떄 
		this.drawShape();
		this.currentTool.setPoint(x,y);
		this.drawShape();
	}
	private void continueDrawing(int x, int y){//w중간점 찍는 함수. 
		this.currentTool.addPoint(x,y);
	}
	private void finishDrawing(int x, int y){//무브의 마지막 점하고 피니시 마지막점 같다.
		this.drawShape();
		this.currentTool.setPoint(x,y);
		this.drawShape();
	}
	private class MouseHandler implements MouseListener, MouseMotionListener{
	

		@Override
		public void mousePressed(MouseEvent e) {
			initDrawing(e.getX() ,e.getY());
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			finishDrawing(e.getX() ,e.getY());
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			keepDrawing(e.getX() ,e.getY());
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1){
			initDrawing(e.getX() ,e.getY());
			continueDrawing(e.getX() ,e.getY());
		}
		else if(e.getClickCount()==2){
			finishDrawing(e.getX() ,e.getY());
		}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			keepDrawing(e.getX() ,e.getY());
		}
	}

}
