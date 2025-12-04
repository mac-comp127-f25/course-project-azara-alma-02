import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Baker {
    //We might want to move the inventory to the baker class, because then we could use a hash map to keep track, instead of array list. Plus then it like "belongs" to the baker, not the game.
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
    
    private double x;
    private double y;
    private Rectangle bakerShape;
    private final double SIZE = 20;
    private final double SPEED = 10;
    
    public Baker(double startX, double startY) { //Start position on canvas determined in constructor, not in getGraphics.
        this.x = startX;
        this.y = startY;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getSize() { // Just made these so we can use outside of the class.
        return SIZE;
    }
    public double getSpeed() {
        return SPEED;
    }

    public void updatePosition(double newX, double newY) { // I think in the main gain method we have movements that create nex xs/ys depending on key movements, and each like if statement calla this method to move the baker. Model a bit off of breakout.
       bakerShape.setPosition(newX, newY);   
    }


    //Consider Baker size

    public void leftPressed(){
        if(x>0){
        this.x-=SPEED;                                              
        }                            
        updatePosition(x, y);        //Add collison checker 
    }

    public void rightPressed(){
        if (x+SIZE<MapWidth-2){
            this.x+=SPEED;
        }
        updatePosition(x, y); 
    }

    public void upPressed(){
        if (y>0){
            this.y-=SPEED;
        }
        updatePosition(x, y);
    }

    public void downPressed(){
        if(y+SIZE<MapHeight-30){
            this.y+=SPEED;
        }
        updatePosition(x, y);

    }

    public GraphicsObject getGraphics(){
        bakerShape = new Rectangle(x, y, SIZE, SIZE);
        return bakerShape;
  }
}
