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
	private void drawShape(){//��������
		Graphics graphics =this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics);
	}
	private void initDrawing(int x, int y){
		this.currentTool.setOrigin(x,y);// �׸� �׸� �غ� �Ѵ�
		this.drawShape();
	}
	private void keepDrawing(int x, int y){//������ ���� ����� ��� �����̴� ��, ��ġ�� ���콺 �� �����ϋ� 
		this.drawShape();
		this.currentTool.setPoint(x,y);
		this.drawShape();
	}
	private void continueDrawing(int x, int y){//w�߰��� ��� �Լ�. 
		this.currentTool.addPoint(x,y);
	}
	private void finishDrawing(int x, int y){//������ ������ ���ϰ� �ǴϽ� �������� ����.
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
