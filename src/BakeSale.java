import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class BakeSale {
    String name = "Bobbi's Bake Sale"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();


    private double X = MapWidth*0.9; // I kept these dimensions the same as Sugar & Salt just cause I wasn't sure what we would want.
    private double Y= MapHeight*0.05;
    private double Width = 40; 
    private double Height =20;

    public BakeSale(){
    }

    public String getName() {
        return name;
    }

    public GraphicsObject getGraphics(){
        Rectangle bakeSaleShape = new Rectangle(X, Y, Width, Height);
        return bakeSaleShape;

    }
}
