import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;


/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
public interface Stand {                                  
    void addIngredients(List ingredientsList, IngredientDisplay inventory);   //Add Graphics Text for Ingredients label 
    String getName();
    GraphicsObject getGraphics(Color color);
    GraphicsText setLabel();
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    void changeKitchenText(IngredientDisplay inventory);
    //TODO: Change ingredients list to just have a pie once a pie is made. Don't forget to reset once the game resets!!!!
    
}
