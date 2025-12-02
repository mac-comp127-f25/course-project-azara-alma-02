import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Kitchen {
    String name = "Katie's Kitchen"; 
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();

    private double X = MapWidth*0.05; 
    private double Y= MapHeight*0.67;
    private double Width = 40; 
    private double Height =20;

    public Kitchen(){
    }

    public String getName() {
        return name;
    }

    public GraphicsObject getGraphics(){
        Rectangle kitchenShape = new Rectangle(X, Y, Width, Height);
        return kitchenShape;

    }
}
