import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;


public interface Stand {                                  
    void addIngredients(List ingredientsList, GraphicsText inventory);   //Add Graphics Text for Ingredients label 
    String getName();
    GraphicsObject getGraphics(Color color);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    
}
