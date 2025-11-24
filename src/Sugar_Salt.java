/*
  Salt and Sugar
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Sugar_Salt implements Stand {

  @Override
  public String getName() {
    String name = "Sugar & Salt";
    return name;

  }

  @Override
  public GraphicsObject setStandProperties(double size){
    double X = size*0.1;
    double Y= size*0.2;
    double Width = 40; 
    double Height =10;
    Rectangle saltSugarShape = new Rectangle(X, Y, Width, Height);
    return saltSugarShape;
  }

  
  @Override
  public void addIngredients(List ingredientsList) {
    ingredientsList.add("Sugar");
    ingredientsList.add("Salt");

  }

}