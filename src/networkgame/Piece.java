package networkgame;

import org.jfree.fx.FXGraphics2D;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Piece {
	
	float xPos;
	float yPos;
	Color colorPiece;
	private Ellipse2D ellipse2D;
	private String player;
	private int piecenr;
	
	
	public Piece ( float x, float y, Color color, String playerstring, int number) {
		xPos = ( x - 1) * 125;
		yPos = ( y - 1) * 125;
		ellipse2D =  new Ellipse2D.Double ( (12 + xPos), (10 + yPos) , 100 , 100 );
		colorPiece = color;
		player = playerstring;
		piecenr = number;
		
	}
	
	public void draw ( FXGraphics2D graphics) {
		graphics.setColor ( colorPiece );
		graphics.fill ( ellipse2D );
	}
	
	public void update ( int newxPos, int newyPos ) {
		ellipse2D =  new Ellipse2D.Double ( (newxPos), (newyPos) , 100 , 100 );
		
	}
	
	public Ellipse2D getEllipse2D ( ) {
		return ellipse2D;
	}
	
	
	public void getPiece ( ) {
		System.out.println ( "The selected piece is: " + piecenr + "       // from player: " + player);
	}
	
	
}
