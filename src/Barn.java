/*
Eggs and Butter
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

public class Barn implements Stand {
  String name = "Bailey's Barn"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject setStandProperties(double size){
    double X = size*0.4; // I kept these dimensions the same as Sugar & Salt just cause I wasn't sure what we would want.
    double Y= size*0.5;
    double Width = 40; 
    double Height =10;
    Rectangle millShape = new Rectangle(X, Y, Width, Height);
    return millShape;
  }
    
  @Override
  public void addIngredients(List ingredientsList) {
    ingredientsList.add("Butter");
    ingredientsList.add("Eggs");

  }


}
