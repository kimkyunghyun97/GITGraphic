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
	
	private enum EActionState{eReady, eCMCDrawing, ePDRDrawing} ;//npointdrawing twopointdrawing moveing 무빙핳하면 keepdraing에서 원점만 움직이기
	//네모, 동그라미 인줄 아는것은 폴리모피즘을 통해 배타적으로 뽑아낸다. 도형을 그리는 방식이 같은것 끼리 같은 것끼리 도형을 분류해야함. 폴리모피즘의 한계이다. 
	private EActionState eActionState;
	
	private MouseHandler MouseHandler;
	public Drawingpanel(){
	
	this.eActionState = EActionState.eReady;
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
	}
	private class MouseHandler implements MouseListener, MouseMotionListener{
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(eActionState== EActionState.eReady){
			initDrawing(e.getX() ,e.getY());
			eActionState= EActionState.ePDRDrawing;
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			 if (eActionState == EActionState.ePDRDrawing){
		            finishDrawing(e.getX(), e.getY());
		            eActionState = EActionState.eReady;
		         }
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			 if (eActionState == EActionState.ePDRDrawing){
		            keepDrawing(e.getX(), e.getY());
		         }
		      }
		@Override
		public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1){
			mouse1Clicked(e);
		}
		else if(e.getClickCount()==2){
			mouse2Clicked(e);
		}
		}
		private void mouse1Clicked(MouseEvent e){
			if(eActionState== EActionState.eReady){
			initDrawing(e.getX() ,e.getY());
			eActionState= EActionState.eCMCDrawing;
			}
			else if(eActionState== EActionState.eCMCDrawing){
			finishDrawing(e.getX() ,e.getY());
			eActionState =EActionState.eReady;
			}
		}
		public void mouseMoved(MouseEvent e) {
			if(eActionState== EActionState.eCMCDrawing){
			keepDrawing(e.getX() ,e.getY()); //그림이 시작 되었을경우만 그려라
			}
			}
		private void mouse2Clicked(MouseEvent e){
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		
	}

}
