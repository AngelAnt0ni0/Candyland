
package candyland;

import java.awt.*;

public class Piece {   
    //public enum Shape {CIRCLE,TRIANGLE};
    //private Shape shape;
    private Color color;

    Piece()
    {
          //color = _color;
    }
    public static int doDiceRoll(){
        int val = (int)(Math.random()*6 +1);
        return(val);
    }
}
