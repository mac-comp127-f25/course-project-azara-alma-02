/*
  Salt and Sugar
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Sugar_Salt implements Stand {
  String name = "Sugar & Salt";
  double size = PieHollow.getSize();
  double X = size*0.1;
  double Y= size*0.2;
  double Width = 40; 
  double Height =10;

  @Override
  public String getName() {
    return name;
  }

  
  @Override
  public void addIngredients(List ingredientsList) {
    ingredientsList.add("Sugar");
    ingredientsList.add("Salt");

  }

  @Override
  public GraphicsObject getGraphics() {
    Rectangle saltSugarShape = new Rectangle(X, Y, Width, Height);
    return saltSugarShape;
  }

  @Override
  public double getX() {
    return X;
  }

  @Override
  public double getY() {
    return Y;
  }

  @Override
  public double getWidth() {
    return Width;
  }

  @Override
  public double getHeight() {
   return Height;
  }

}