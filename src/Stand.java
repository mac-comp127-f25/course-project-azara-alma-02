import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;


public interface Stand {                                  
    void addIngredients(List ingredientsList, IngredientDisplay inventory);   //Add Graphics Text for Ingredients label 
    String getName();
    GraphicsObject getGraphics(Color color);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    void changeKitchenText(IngredientDisplay inventory);
    //Add text with the name of each stand.
    //Update kitchen text, called when interaction with baker happen.
    //Change ingredients list to just have a pie once a pie is made. Don't forget to reset once the game resets!!!!
    
}
