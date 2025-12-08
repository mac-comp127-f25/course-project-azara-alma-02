/*
Eggs and Butter
 */

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;


public class Barn implements Stand {
  String name = "Bailey's Barn"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.4; 
  double Y= MapHeight*0.65;
  double Width = 180; 
  double Height = 180;

  // private Rectangle barnShape;

  private Image barnShape;

  @Override
  public String getName() {
    return name;
  }

    @Override
  public void addIngredients(List ingredientsList,IngredientDisplay inventory) {
    ingredientsList.add("Butter"); // Will need to change the code for this class to allow for the selection of different fillings.
    ingredientsList.add("Eggs");
    inventory.getEggsButterBoxText().setText("X");

  }

  @Override
  public GraphicsObject getGraphics(Color color){ //Changed this so that a new rectangle is not made every time getGraphics is called, so that interactions can work properly. 
    if (barnShape == null) {
            barnShape = new Image(X, Y, "BarnImage.png");
            barnShape.setMaxWidth(Width);
            barnShape.setMaxHeight(Height);
        }
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

  @Override
  public void changeKitchenText(IngredientDisplay inventory) {
    inventory.getKitchenText1().setText("You picked up eggs & butter!");
    inventory.getKitchenText2().setText("");
  }

  @Override
  public GraphicsText setLabel() {
    GraphicsText barnLabel=new GraphicsText(name, X+30, Y+Height-7);
    return barnLabel;
   
  }
}
