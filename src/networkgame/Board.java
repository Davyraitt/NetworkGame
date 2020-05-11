package networkgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jfree.fx.FXGraphics2D;
import org.jfree.fx.ResizableCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;

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
	
	
	@Override
	public void start ( Stage stage ) throws Exception {
		
		BorderPane mainPane = new BorderPane ( ); // creating a new borderpane
		
		//methods for input
		canvas = new ResizableCanvas ( g -> draw ( g ) , mainPane );
		canvas.setFocusTraversable ( true );
		mainPane.setCenter ( canvas );
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
	
	public void init ( ) { // initialisation method
	
	
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
		
		Piece piece1 = new Piece ( 1, 1 );
		piece1.draw ( graphics );
		
		//FPS drawen
		if ( timer >= 1000000000 )
		{ // prints how many updates we did in the last second?
			lastFPSValue = updates;
			
		}
		
		//draws the FPS right corner
		graphics.drawString ( String.valueOf ( lastFPSValue ) , 975 , 15 );
		
		// Stop drawing
		graphics.dispose ( );
	}
}
