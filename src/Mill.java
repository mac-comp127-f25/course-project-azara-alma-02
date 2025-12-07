/*
   Flour
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;


public class Mill implements Stand{
  String name = "Milson's Mill";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.85;
  double Y= MapHeight*0.35;
  double Width = 200; 
  double Height = 250;

  private Image millShape;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public GraphicsObject getGraphics(Color color){
    if (millShape == null) {
            millShape = new Image(X, Y, "MillImage.png"); //Maybe move on canvas a bit
            millShape.setMaxWidth(Width);
            millShape.setMaxHeight(Height);
        }
        return millShape;
  }
    
  @Override
  public void addIngredients(List ingredientsList,IngredientDisplay inventory) {
    ingredientsList.add("Flour");
    inventory.getFlourBoxText().setText("X");


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
  @Override
  public void changeKitchenText(IngredientDisplay inventory) {
    inventory.getKitchenText1().setText("You picked up flour!");
    inventory.getKitchenText2().setText("");
  }
}
