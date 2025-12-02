/*
Water 
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Well implements Stand {

    String name ="Well";
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
    
    double X= MapWidth *0.25; 
    double Y= MapHeight *0.65; 
    double Height= 20; 
    double Width =20; 

    

    @Override
    public void addIngredients(List ingredientsList) {
        ingredientsList.add("Water");
    }

    @Override
    public String getName() {
        return name; 
    }


    @Override
    public GraphicsObject getGraphics() {
        Rectangle WellShape = new Rectangle(X, Y, Width, Height);
        return WellShape;
    }

    @Override
    public double getX() {
        return X; 
    }

    @Override
    public double getY() {
        return Y; 
    }

    @Override
    public double getWidth() {
        return Width;
    }

    @Override
    public double getHeight() {
        return Height;
    }
    
}
