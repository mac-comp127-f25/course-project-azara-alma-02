import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;

/*
* Authors: Alma and Azara
* Contains the methods used by the various stand classes and sort them into an interface. The methods contained return the stand's properties 
  (x,y, width, height, the stand's string name) as well as a graphics object tied to an image using their x,y,width and height. The stands 
  also have a method to set a label with their string name, and they update the bottom two lines of text in the user's inventory display.
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
