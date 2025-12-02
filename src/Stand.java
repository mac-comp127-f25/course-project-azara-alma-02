import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;


public interface Stand {
    void addIngredients(List ingredientsList);
    String getName();
    GraphicsObject getGraphics(Color color);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    
}
