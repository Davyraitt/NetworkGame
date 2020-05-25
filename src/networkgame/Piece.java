package networkgame;

import org.jfree.fx.FXGraphics2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static networkgame.KindOfPieces.*;

public class Piece {

	private float xPos;
	private float yPos;
	private Color colorPiece;
	private Ellipse2D ellipse2D;
	private String player;
	private int piecenr;
	private boolean king;
	private BufferedImage image;

	public Piece() {
	}

	public Piece (float x, float y, Color color, String playerstring, int number, boolean king) {
		xPos = ( x - 1) * 125;
		yPos = ( y - 1) * 125;
		ellipse2D =  new Ellipse2D.Double ( (12 + xPos), (10 + yPos) , 100 , 100 );
		colorPiece = color;
		player = playerstring;
		piecenr = number;
		this.king = king;

		switch () {

			case RED_NORMAL:
				try {
					image = ImageIO.read(new File("/pieceRedKing.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case RED_KING:
				try {
					image = ImageIO.read(new File("/pieceRedKing.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case BLACK_NORMAL:
				try {
					image = ImageIO.read(new File("/pieceRedKing.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case BLACK_KING:
				try {
					image = ImageIO.read(new File("/pieceRedKing.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
		}

		
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

	public float getxPos() {
		return xPos;
	}

	public float getyPos() {
		return yPos;
	}
}
