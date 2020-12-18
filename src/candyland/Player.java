
package candyland;
import java.awt.*;

public class Player extends Piece{
    private static Player currentTurn;
    private static Player players[] = new Player[2];
    private Color color;
    private static int currentRow;
    private static int currentColumn;
    private static int columnDir;
    private static int rowDir;
    //private static int coinsCollected;
    Player(){
        super();
    }
    public static void Reset(){
        currentRow = 1;
        currentColumn = 1;
        rowDir = 0;
        columnDir = 0;
        players[0] = new Player();
        players[1] = new Player();
    }
    public static void SwitchTurn()
    {
        if (currentTurn == players[0])
            currentTurn = players[1];
        else
            currentTurn = players[0];
    }
    public static void Draw(Graphics2D g){
        g.setColor(Color.green);
        g.fillRect(Window.getX(0)+currentColumn*Window.getWidth2()/Window.numColumns,
        Window.getY(0)+currentRow*Window.getHeight2()/Window.numRows,
        Window.getWidth2()/Window.numColumns,
        Window.getHeight2()/Window.numRows);
    }
    public static void Animate(){
        if (Board.board[currentRow+rowDir][currentColumn+columnDir] == Board.PATH)
        {
            currentRow += rowDir;
            currentColumn+=columnDir;
            
        }   
        rowDir = 0;
        columnDir = 0;
        
    }
    public static void moveUp(){
        rowDir = -1;
        columnDir = 0;
    }
    public static void moveDown(){
        rowDir = 1 ;
        columnDir = 0;
    }
    public static void moveLeft(){
        rowDir = 0;
        columnDir = -1;
    }
    public static void moveRight(){
        rowDir = 0;
        columnDir = 1;
        System.out.println(currentColumn);
    }
    
    public static void MovePlayer(){
        int val = Player.doDiceRoll();
        while(val > 0)
        {
            if(goLeft() ){
            if(Board.board[currentRow][currentColumn--] == Board.PATH){
                System.out.println("Before "+currentColumn);
                currentColumn--;
                val--;
                System.out.println("After "+currentColumn);
            }
        }            
            //move right
            if (Board.board[currentRow][currentColumn+1] == Board.PATH )
            {
                currentColumn++;
                val--;
            }
            //moves down
            else if(Board.board[currentRow+1][currentColumn] == Board.PATH)
            {
                currentRow++;
                val--;
            }
            
            else
            {
                System.out.println("Stop");
                val--;
            }
        } 
    }
    public static boolean goLeft(){
        if(currentRow == 3 || currentRow == 7 || currentRow == 11 || currentRow == 15 || currentRow == 19)
        return(true);
        return(false);
        
    }
}
