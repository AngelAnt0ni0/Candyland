
package candyland;
import java.awt.*;

public class Wall extends Piece{
    private Color color;
    Wall(){
       super();
    int val = (int)(Math.random()*3);
    if(val == 0)
        color = Color.RED;
    else if(val == 1)
        color = Color.BLUE;
    else
        color = Color.GREEN;
    }
    public static void Draw(Graphics2D g){
        //Display the objects of the board
        for (int zrow=0;zrow<Board.getNumColumns();zrow++)
        {
            for (int zcolumn=0;zcolumn<Board.getNumColumns();zcolumn++)
            {
//If the location on the board is snake, then draw the box gray.                
                if (Board.board[zrow][zcolumn] == Board.WALL)
                {
                    g.setColor(Color.gray);
                    g.fillRect(Window.getX(0)+zcolumn*Window.getWidth2()/Board.getNumColumns(),
                    Window.getY(0)+zrow*Window.getHeight2()/Board.getNumRows(),
                    Window.getWidth2()/Board.getNumColumns(),
                    Window.getHeight2()/Board.getNumColumns());
                }  

            }
        }
    }
}
