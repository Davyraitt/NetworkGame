package networkgame;

import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Piece {
	
	float xPos;
	float yPos;
	
	public Piece ( float x, float y) {
		xPos = ( x - 1) * 125;
		yPos = ( y - 1) * 125;
	}
	
	public void draw ( FXGraphics2D graphics) {
		graphics.setColor ( Color.pink );
		graphics.fill ( new Ellipse2D.Double ( (12 + xPos), (10 + yPos) , 100 , 100 ) );
	}
}
