/*
Eggs and Butter
 */

import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

public class Barn implements Stand {
  String name = "Bailey's Barn"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!

  double size = PieHollow.getSize();

  double X = size*0.4; 
  double Y= size*0.5;
  double Width = 40; 
  double Height =10;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject getGraphics(){
    Rectangle millShape = new Rectangle(X, Y, Width, Height);
    return millShape;
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
