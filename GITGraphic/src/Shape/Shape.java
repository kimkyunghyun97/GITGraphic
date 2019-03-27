package Shape;

import java.awt.Graphics;

public abstract class Shape {
	protected int x1 ,y1, x2, y2;
	protected int X[] = new int [100], Y[]= new int [100];
	protected int point = 0;
	protected int doublee;
	
	public int ChangePoint() {
		return point = 0;
	}
	public void setOriginPolygon(int x, int y) {
		X[point] = x;
		Y[point] = y;
		point++;
	}
	public void setDoubleePolygon(int x, int y) {
		X[point] = x;
		Y[point] = y;
	}
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
	public void addPoint(int x, int y) {
		X[point] = x;
		Y[point] = y;
	}
	abstract public void draw(Graphics graphics);//좌표와 그림 그리는것 분리
	
	
}
