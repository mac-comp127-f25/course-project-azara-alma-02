/*
  Salt and Sugar
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Sugar_Salt implements Stand {
  String name = "Sugar & Salt";
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
  public GraphicsObject getGraphics(double size) {
    Rectangle saltSugarShape = new Rectangle(X, Y, Width, Height);
    return saltSugarShape;
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getGraphics'");
  }

  @Override
  public int getX() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getX'");
  }

  @Override
  public int getY() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getY'");
  }

  @Override
  public int getWidth() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
  }

  @Override
  public int getHeight() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
  }

}