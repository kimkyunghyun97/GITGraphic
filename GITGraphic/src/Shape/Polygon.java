package Shape;

import java.awt.Graphics;

public class Polygon extends Shape {

	@Override
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.drawPolygon(X, Y, point+1);
	}

}
