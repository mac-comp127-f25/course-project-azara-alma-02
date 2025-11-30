import java.util.List;

import edu.macalester.graphics.GraphicsObject;

public interface Stand {
    void addIngredients(List ingredientsList);
    String getName();
    GraphicsObject setStandProperties(double size);
    
}
