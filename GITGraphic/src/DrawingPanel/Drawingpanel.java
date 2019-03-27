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
	
	private enum EActionState{eReady, eCMCDrawing, ePDRDrawing} ;//npointdrawing twopointdrawing moveing �����K�ϸ� keepdraing���� ������ �����̱�
	//�׸�, ���׶�� ���� �ƴ°��� ������������ ���� ��Ÿ������ �̾Ƴ���. ������ �׸��� ����� ������ ���� ���� �ͳ��� ������ �з��ؾ���. ������������ �Ѱ��̴�. 
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
			keepDrawing(e.getX() ,e.getY()); //�׸��� ���� �Ǿ�����츸 �׷���
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
