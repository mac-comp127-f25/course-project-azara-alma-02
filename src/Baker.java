import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;


public class Baker {
    //We might want to move the inventory to the baker class, because then we could use a hash map to keep track, instead of array list. Plus then it like "belongs" to the baker, not the game.
    double MapHeight = PieHollow.getHeight();
    double MapWidth= PieHollow.getWidth();
    
    private double x;
    private double y;
    private final double SIZE = 60;
    private final double SPEED = 10;
    private static final double INTERACTION_WIDTH = 10;

    private Image bakerShape;
    
    public Baker(double startX, double startY) { //Start position on canvas determined in constructor, not in getGraphics.
        this.x = startX;
        this.y = startY; //Have her genrate at the kitchen!!
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

    public boolean reachesStand(Stand stand) {
        double leftBakerBound = this.x;
        double rightBakerBound = this.x + SIZE;
        double topBakerBound = this.y;
        double bottomBakerBound = this.y + SIZE;

        double leftStandBound = stand.getX() - INTERACTION_WIDTH; //- so it can extend out to the left, same for reaching up with topStandBound.
        double rightStandBound = stand.getX() + stand.getWidth() + INTERACTION_WIDTH;
        double topStandBound = stand.getY() - INTERACTION_WIDTH;
        double bottomStandBound = stand.getY() + stand.getHeight() + INTERACTION_WIDTH;
        
        boolean xCollision = leftBakerBound < rightStandBound && rightBakerBound > leftStandBound; //Lol thanks conceptual mastery puzzles.
        boolean yCollision = topBakerBound < bottomStandBound && bottomBakerBound > topStandBound;

        return xCollision && yCollision;
    }

    public GraphicsObject getGraphics(){
        bakerShape = new Image(x, y, "BakerImage.png");
        bakerShape.setMaxWidth(SIZE);
        bakerShape.setMaxHeight(SIZE);

        return bakerShape;
  }
}
