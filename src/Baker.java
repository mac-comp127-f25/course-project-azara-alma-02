import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
public class Baker {
    double MapHeight = PieHollow.getHeight();
    double MapWidth= PieHollow.getWidth();

    private double x;
    private double y;
    private final double SIZE = 60;
    private final double SPEED = 5;

    private Image bakerShape;
    
    public Baker(double startX, double startY) { 
        this.x = startX;
        this.y = startY; 
    }

    public void updatePosition(double newX, double newY) { 
       bakerShape.setPosition(newX, newY);   
    }

    /*
    * Moves the baker SPEED pixels to the left if they are not at the left edge of the window.
    */
    public void leftPressed(){
        if(x>0){
        this.x-=SPEED;                                              
        }                            
        updatePosition(x, y);       
    }

    /*
    * Moves the baker SPEED pixels to the right if they are not at the right edge of the window.
    */
    public void rightPressed(){
        if (x+SIZE<MapWidth-2){
            this.x+=SPEED;
        }
        updatePosition(x, y); 
    }

    /*
    * Moves the baker SPEED pixels up if they are not at the top edge of the window. 
    */
    public void upPressed(){
        if (y>0){
            this.y-=SPEED;
        }
        updatePosition(x, y);
    }

    /*
    * Moves the baker SPEED pixels down if they are not at the bottom edge of the window. 
    */
    public void downPressed(){
        if(y+SIZE<MapHeight-30){
            this.y+=SPEED;
        }
        updatePosition(x, y);
    }

    /*
    * Takes in a Stand object. Returns a boolean according to whether the baker object is in the vacinity 
    * of a stand object.  
    */
    public boolean reachesStand(Stand stand) {
        double leftBakerBound = this.x;
        double rightBakerBound = this.x + SIZE;
        double topBakerBound = this.y;
        double bottomBakerBound = this.y + SIZE;

        double leftStandBound = stand.getX(); 
        double rightStandBound = stand.getX() + stand.getWidth();
        double topStandBound = stand.getY();
        double bottomStandBound = stand.getY() + stand.getHeight();
        
        boolean xCollision = leftBakerBound < rightStandBound && rightBakerBound > leftStandBound; 
        boolean yCollision = topBakerBound < bottomStandBound && bottomBakerBound > topStandBound;

        return xCollision && yCollision;
    }

    public GraphicsObject getGraphics(){
        bakerShape = new Image(x, y, "BakerImage.png");
        bakerShape.setMaxWidth(SIZE);
        bakerShape.setMaxHeight(SIZE);

        return bakerShape;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getSize() { 
        return SIZE;
    }
    public double getSpeed() {
        return SPEED;
    }
}
