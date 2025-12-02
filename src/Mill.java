/*
   Flour
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Mill implements Stand{
  String name = "Milson's Mill";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.9;
  double Y= MapHeight*0.8;
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
    ingredientsList.add("Flour");

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
