import java.util.List;

import edu.macalester.graphics.GraphicsObject;

public interface Stand {
    void addIngredients(List ingredientsList);
    String getName();
    GraphicsObject getGraphics();
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    
}
