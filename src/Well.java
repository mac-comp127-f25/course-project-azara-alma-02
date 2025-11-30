/*
Water 
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Well implements Stand {

    @Override
    public void addIngredients(List ingredientsList) {
        ingredientsList.add("Water");
    }

    @Override
    public String getName() {
        String name ="Well";
        return name; 
    }

    @Override
    public GraphicsObject setStandProperties(double size) {
        double X= size *0.3; 
        double Y= size *0.7; 
        double Height= 20; 
        double Width =20; 
        Rectangle WellShape = new Rectangle(X, Y, Width, Height);
        return WellShape;
        
    }
    
}
