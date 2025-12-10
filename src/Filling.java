import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* Creates the filling stand object
*/
public class Filling implements Stand {
  String name = "Bridget's Blueberries";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.37;
  double Y= MapHeight*0.2;
  double Width = 150; 
  double Height = 150;
  
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
    ingredientsList.add("Blueberries"); 
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

  @Override
  public void changeKitchenText(IngredientDisplay inventory) {
    inventory.getKitchenText1().setText("You picked up blueberries!");
    inventory.getKitchenText2().setText("Bridget recently had a baby!");
  }

  @Override
  public GraphicsText setLabel() {
    GraphicsText fillingLabel=new GraphicsText(name, X+5, Y+Height-7);
    return fillingLabel;
   
  }
}
