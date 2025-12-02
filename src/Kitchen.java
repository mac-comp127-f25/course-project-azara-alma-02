import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Kitchen {
    String name = "Katie's Kitchen"; 
    
    double size = PieHollow.getSize();

    private double X = size*0.1; 
    private double Y= size*0.7;
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
