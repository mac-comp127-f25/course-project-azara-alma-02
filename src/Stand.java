import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;

/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
public interface Stand {                                  
    void addIngredients(List <String> ingredientsList, IngredientDisplay inventory);   
    String getName();
    GraphicsObject getGraphics(Color color);
    GraphicsText setLabel();
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    void changeKitchenText(IngredientDisplay inventory); 
}
