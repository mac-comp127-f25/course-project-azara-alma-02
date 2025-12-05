/*
  Salt and Sugar
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class Sugar_Salt implements Stand {
  String name = "Sugar & Salt";
  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.1;
  double Y= MapHeight*0.2;
  double Width = 80; 
  double Height = 80;

  private Image sugarSaltShape;

  @Override
  public String getName() {
    return name;
  }

  
  @Override
  public void addIngredients(List ingredientsList, GraphicsText inventory) {
    ingredientsList.add("Sugar");
    ingredientsList.add("Salt");
    String text=inventory.getText();
    inventory.setText(text+ " " + "Sugar" + " " + "Salt");

  }

  @Override
  public GraphicsObject getGraphics(Color color) {
    if (sugarSaltShape == null) {
            sugarSaltShape = new Image(X, Y, "SugarSaltImage.png"); //Consider changing this image, does not really match others.
            sugarSaltShape.setMaxWidth(Width);
            sugarSaltShape.setMaxHeight(Height);
        }
        return sugarSaltShape;
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