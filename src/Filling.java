/*
  Fruits filling. (Blueberries)
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Filling implements Stand {
  String name = "Fabulous Fruits";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.3;
  double Y= MapHeight*0.2;
  double Width = 40; 
  double Height =10;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject getGraphics(Color color){
    Rectangle millShape = new Rectangle(X, Y, Width, Height);
    millShape.setFillColor(color);
    return millShape;
  }
    
  @Override
  public void addIngredients(List ingredientsList) {
    ingredientsList.add("Blueberries"); // Will need to change the code for this class to allow for the selection of different fillings.

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
