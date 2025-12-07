import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class Kitchen implements Stand{ 
    String name = "Katie's Kitchen";                   //Make a Pie Image-add pie to ingredients list --have graphics text changed to be a pie
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();

    private double X = MapWidth*0.05; 
    private double Y= MapHeight*0.67;
    private double Width = 40; 
    private double Height =20;
    
    private Rectangle kitchenShape;

    public Kitchen(){
    }

    public String getName() {
        return name;
    }

    public GraphicsObject getGraphics(Color color){
        if (kitchenShape == null) {
            kitchenShape = new Rectangle(X, Y, Width, Height);
        }
        return kitchenShape;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getWidth() {
        return Width;
    }

    public double getHeight() {
        return Height;
    }

    public void addIngredients(List ingredientsList, IngredientDisplay inventory) {
        // Does not add ingredients
    }
}
