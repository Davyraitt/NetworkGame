package networkgame;

import org.jfree.fx.FXGraphics2D;

import java.awt.*;

public class Vakje {

    private int posX;
    private int posY;
    private boolean occipied;
    private Color color;

    private Board board = new Board();

    public Vakje(int posX, int posY, boolean occipied, Color color) {
        this.posX = posX;
        this.posY = posY;
        this.occipied = occipied;
        this.color = color;

    }

    public void draw ( FXGraphics2D graphics ) {
        if (this.color.equals(Color.GRAY)){
            graphics.setColor(Color.GRAY);
            graphics.fillRect(posX * 125, posY * 125, 125, 125);
        }

        if (this.color.equals(Color.WHITE)){
            graphics.setColor(Color.WHITE);
            graphics.fillRect(posX * 125, posY * 125, 125, 125);
        }

    }


    public boolean isOccipied(){
        for (Piece p : board.getAllPieces()){
            if(p.getxPos() == this.posX && p.getyPos() == this.posY){
                this.occipied = true;
            }

            else occipied = false;
        }

        return occipied;
    }
}
