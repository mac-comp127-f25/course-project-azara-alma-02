import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* Extends the Stand interface. Creates the barn stand object. Has getter methods for its x and y position, 
* as well as its width and height. Has methods to change the kitchen text, called on interaction and a method 
* to add ingredients to ingredients list.
*/
public class Barn implements Stand {
  String name = "Bailey's Barn";

  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.4; 
  double Y= MapHeight*0.65;
  double Width = 180; 
  double Height = 180;

  private Image barnShape;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addIngredients(List ingredientsList,IngredientDisplay inventory) {
    ingredientsList.add("Butter"); 
    ingredientsList.add("Eggs");
    inventory.getEggsButterBoxText().setText("X");

  }

  @Override
  public GraphicsObject getGraphics(Color color){ 
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
    inventory.getKitchenText2().setText("Bailey built his new bungalo!");
  }
  
  @Override
  public GraphicsText setLabel() {
    GraphicsText barnLabel=new GraphicsText(name, X+30, Y+Height-7);
    return barnLabel;
   
  }
}
