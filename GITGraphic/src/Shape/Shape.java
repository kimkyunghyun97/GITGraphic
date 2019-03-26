package Shape;

import java.awt.Graphics;

public abstract class Shape {
	protected int x1 ,y1, x2, y2;
	
	public void setOrigin(int x, int y ){//원점 세팅
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}
	public void setPoint(int x, int y ){//원점 세팅
		this.x2 = x;
		this.y2 = y;
	}
	abstract public void draw(Graphics graphics);//좌표와 그림 그리는것 분리
	public void addPoint(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}
