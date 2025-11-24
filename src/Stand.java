import java.util.List;

import edu.macalester.graphics.GraphicsObject;

public interface Stand {
    List getIngredients();
    String getName();
    void setStandProperties();
    GraphicsObject getGraphics();
    
}
