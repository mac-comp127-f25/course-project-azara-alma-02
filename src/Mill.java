/*
   Flour
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Mill implements Stand{
  String name = "Milson's Mill";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject setStandProperties(double size){
    double X = size*0.9;
    double Y= size*0.8;
    double Width = 40; 
    double Height =10;
    Rectangle millShape = new Rectangle(X, Y, Width, Height);
    return millShape;
  }
    
  @Override
  public void addIngredients(List ingredientsList) {
    ingredientsList.add("Flour");

  }
}
