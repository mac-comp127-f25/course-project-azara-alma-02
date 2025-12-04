/*
Eggs and Butter
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

public class Barn implements Stand {
  String name = "Bailey's Barn"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.4; 
  double Y= MapHeight*0.5;
  double Width = 80; 
  double Height =80;

  @Override
  public String getName() {
    return name;
  }

    @Override
  public void addIngredients(List ingredientsList,GraphicsText inventory) {
    ingredientsList.add("Butter"); // Will need to change the code for this class to allow for the selection of different fillings.
    ingredientsList.add("Eggs");
    String text=inventory.getText();
    inventory.setText(text+ " " + "Butter" + " " +"Eggs");

  }

  @Override
  public GraphicsObject getGraphics(Color color){
    Rectangle barnShape = new Rectangle(X, Y, Width, Height);
    barnShape.setFillColor(color);
    return barnShape;
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
