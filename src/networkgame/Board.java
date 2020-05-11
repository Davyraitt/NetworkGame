package networkgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Board extends Application {
	
	//project data
	private int width = 1000; // size of the canvas
	private int height = 1002; // size of the canvas
	private ResizableCanvas canvas;
	
	//fps and fps counter
	private int x = 0; // x coordinate
	private int fps = 60; // frames per second , amount of times we want to call update and draw PER SECOND
	private int timePerUpdate = 1_000_000_000 / fps; // 1 second divided by our fps, now we get our frames per
	// second
	private double delta = 0; // delta is the amount of time we have left, untill we call update and draw
	private long lastTime = System.nanoTime ( ); // gets current computertime in nanoseconds
	private long timer = 0; // time until we hit 1s, print out how many updates and draw we did
	private int updates = 0; // int for the fps counter
	private int lastFPSValue = 0;
	private boolean colored = false;
	
	//creating the pieces for player 1;
	private Piece P1Piece1;
	private Piece P1Piece2;
	private Piece P1Piece3;
	private Piece P1Piece4;
	private Piece P1Piece5;
	private Piece P1Piece6;
	private Piece P1Piece7;
	private Piece P1Piece8;
	private Piece P1Piece9;
	private Piece P1Piece10;
	private Piece P1Piece11;
	private Piece P1Piece12;
	
	//creating the pieces for player 2;
	private Piece P2Piece1;
	private Piece P2Piece2;
	private Piece P2Piece3;
	private Piece P2Piece4;
	private Piece P2Piece5;
	private Piece P2Piece6;
	private Piece P2Piece7;
	private Piece P2Piece8;
	private Piece P2Piece9;
	private Piece P2Piece10;
	private Piece P2Piece11;
	private Piece P2Piece12;
	
	// arraylist with all the pieces
	ArrayList < Piece > allPieces = new ArrayList <> ( );
	
	@Override
	public void start ( Stage stage ) throws Exception {
		
		BorderPane mainPane = new BorderPane ( ); // creating a new borderpane
		
		//methods for input
		canvas = new ResizableCanvas ( g -> draw ( g ) , mainPane );
		canvas.setFocusTraversable ( true );
		mainPane.setCenter ( canvas );
		
		canvas.setOnMouseDragged ( this::mouseDragged );
		
		FXGraphics2D g2d = new FXGraphics2D ( canvas.getGraphicsContext2D ( ) );
		
		//calls our init method
		init ( );
		
		new AnimationTimer ( ) { // main game loop, constantly runs update(update) and draw (draw) to show
			// things on the screen
			long last = -1;
			
			@Override
			public void handle ( long now ) {
				now = System.nanoTime ( );
				delta += ( now - lastTime ) / timePerUpdate; // delta variable tells the computer when and
				// when not to call update and draw
				timer += now - lastTime; // adding the amount of time which has passed, sinds we
				// update/drawed
				lastTime = now;
				if ( last == -1 )
				{
					last = now;
				}
				update ( ( now - last ) / 1000000000.0 );
				last = now;
				draw ( g2d );
				updates = updates + 1;
				delta = delta - 1;
				
				if ( timer >= 1000000000 )
				{ // prints how many updates we did in the last second?
					updates = 0; // reset the variables
					timer = 0;  // reset the variables
					
				}
				
			}
		}.start ( );
		
		stage.setScene ( new Scene ( mainPane , width , height ) );
		stage.setTitle ( "Checkers" );
		stage.show ( );
	}
	
	private void mouseDragged ( MouseEvent mouseEvent ) {
		
		for ( int i = 0 ; i < allPieces.size ( ) ; i++ )
		{
			if ( allPieces.get ( i ).getEllipse2D ( ).contains ( mouseEvent.getX ( ) , mouseEvent.getY ( ) ) )
			{
				allPieces.get ( i ).getPiece ( );
				allPieces.get ( i ).update ( ( int ) mouseEvent.getX ( ) + - 50 , ( int ) mouseEvent.getY ( ) + - 50 );
			}
		}
		
	}
	
	public void init ( ) { // initialisation method
		
		//creating the pieces for player 1;
		P1Piece1 = new Piece ( 2 , 1 , Color.pink , "Player1" , 1 );
		P1Piece2 = new Piece ( 4 , 1 , Color.pink , "Player1" , 2 );
		P1Piece3 = new Piece ( 6 , 1 , Color.pink , "Player1" , 3 );
		P1Piece4 = new Piece ( 8 , 1 , Color.pink , "Player1" , 4 );
		P1Piece5 = new Piece ( 1 , 2 , Color.pink , "Player1" , 5 );
		P1Piece6 = new Piece ( 3 , 2 , Color.pink , "Player1" , 6 );
		P1Piece7 = new Piece ( 5 , 2 , Color.pink , "Player1" , 7 );
		P1Piece8 = new Piece ( 7 , 2 , Color.pink , "Player1" , 8 );
		P1Piece9 = new Piece ( 2 , 3 , Color.pink , "Player1" , 9 );
		P1Piece10 = new Piece ( 4 , 3 , Color.pink , "Player1" , 10 );
		P1Piece11 = new Piece ( 6 , 3 , Color.pink , "Player1" , 11 );
		P1Piece12 = new Piece ( 8 , 3 , Color.pink , "Player1" , 12 );
		
		allPieces.add ( P1Piece1 );
		allPieces.add ( P1Piece2 );
		allPieces.add ( P1Piece3 );
		allPieces.add ( P1Piece4 );
		allPieces.add ( P1Piece5 );
		allPieces.add ( P1Piece6 );
		allPieces.add ( P1Piece7 );
		allPieces.add ( P1Piece8 );
		allPieces.add ( P1Piece9 );
		allPieces.add ( P1Piece10 );
		allPieces.add ( P1Piece11 );
		allPieces.add ( P1Piece12 );
		
		//creating the pieces for player 2;
		
		P2Piece1 = new Piece ( 1 , 8 , Color.CYAN , "Player2" , 1 );
		P2Piece2 = new Piece ( 3 , 8 , Color.CYAN , "Player2" , 2 );
		P2Piece3 = new Piece ( 5 , 8 , Color.CYAN , "Player2" , 3 );
		P2Piece4 = new Piece ( 7 , 8 , Color.CYAN , "Player2" , 4 );
		P2Piece5 = new Piece ( 2 , 7 , Color.CYAN , "Player2" , 5 );
		P2Piece6 = new Piece ( 4 , 7 , Color.CYAN , "Player2" , 6 );
		P2Piece7 = new Piece ( 6 , 7 , Color.CYAN , "Player2" , 7 );
		P2Piece8 = new Piece ( 8 , 7 , Color.CYAN , "Player2" , 8 );
		P2Piece9 = new Piece ( 1 , 6 , Color.CYAN , "Player2" , 9 );
		P2Piece10 = new Piece ( 3 , 6 , Color.CYAN , "Player2" , 10 );
		P2Piece11 = new Piece ( 5 , 6 , Color.CYAN , "Player2" , 11 );
		P2Piece12 = new Piece ( 7 , 6 , Color.CYAN , "Player2" , 12 );
		
		allPieces.add ( P2Piece1 );
		allPieces.add ( P2Piece2 );
		allPieces.add ( P2Piece3 );
		allPieces.add ( P2Piece4 );
		allPieces.add ( P2Piece5 );
		allPieces.add ( P2Piece6 );
		allPieces.add ( P2Piece7 );
		allPieces.add ( P2Piece8 );
		allPieces.add ( P2Piece9 );
		allPieces.add ( P2Piece10 );
		allPieces.add ( P2Piece11 );
		allPieces.add ( P2Piece12 );
		
	}
	
	private void update ( double v ) {
		long now = System.nanoTime ( );
		long last = -1;
		
		
	}
	
	private void draw ( FXGraphics2D graphics ) {
		graphics.setBackground ( Color.white );
		
		//Clearing the screen first
		graphics.clearRect ( 0 , 0 , this.width , this.height );
		
		for ( int i = 0 ; i < 1000 ; i = i + 125 ) // loop that draws the checker board
		{
			if ( colored )
			{
				graphics.setColor ( Color.white );
				colored = false;
			} else
			{
				graphics.setColor ( Color.black );
				colored = true;
			}
			
			for ( int j = 2 ; j < 1000 ; j = j + 125 )
			{
				
				if ( colored )
				{
					graphics.setColor ( Color.white );
					colored = false;
				} else
				{
					graphics.setColor ( Color.black );
					colored = true;
				}
				
				graphics.fillRect ( i , j , 125 , 125 );
				
			}
		}
		
		//FPS drawen
		if ( timer >= 1000000000 )
		{ // prints how many updates we did in the last second?
			lastFPSValue = updates;
			
		}
		
		for ( int i = 0 ; i < allPieces.size ( ) ; i++ )
		{
			allPieces.get ( i ).draw ( graphics );
		}
		
		//draws the FPS right corner
		graphics.drawString ( String.valueOf ( lastFPSValue ) , 975 , 15 );
		
		// Stop drawing
		graphics.dispose ( );
	}
	
}
