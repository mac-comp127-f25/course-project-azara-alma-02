/*
  Fruits filling. (Blueberries)
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;


public class Filling implements Stand {
  String name = "Fabulous Fruits";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.3;
  double Y= MapHeight*0.2;
  double Width = 80; 
  double Height = 80;
  
  private Image fillingShape;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject getGraphics(Color color){
    if (fillingShape == null) {
            fillingShape = new Image(X, Y, "FillingImage.png");
            fillingShape.setMaxWidth(Width);
            fillingShape.setMaxHeight(Height);
        }
        return fillingShape;
  }
    
  @Override
  public void addIngredients(List ingredientsList,IngredientDisplay inventory) {
    ingredientsList.add("Blueberries"); // Will need to change the code for this class to allow for the selection of different fillings.
    inventory.getBlueberriesBoxText().setText("X");


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
