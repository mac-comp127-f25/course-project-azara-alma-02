import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* Extends the Stand interface. Creates the sugar and salt stand object. Has getter methods for its x and y position, 
* as well as its width and height. Has methods to change the kitchen text, called on interaction and a method 
* to add ingredients to ingredients list.
*/
public class Sugar_Salt implements Stand {
  String name = "Carrie's Confections";
  double MapHeight = PieHollow.getHeight();
  double MapWidth=PieHollow.getWidth();

  double X = MapWidth*0.23;
  double Y= MapHeight*0.2;
  double Width = 150; 
  double Height = 150;

  private Image sugarSaltShape;

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void addIngredients(List <String> ingredientsList, IngredientDisplay inventory) {
    ingredientsList.add("Sugar");
    ingredientsList.add("Salt");
    inventory.getSugarSaltBoxText().setText("X");

  }

  @Override
  public GraphicsObject getGraphics(Color color) {
    if (sugarSaltShape == null) {
            sugarSaltShape = new Image(X, Y, "SugarSaltImage.png"); 
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

  @Override
  public void changeKitchenText(IngredientDisplay inventory) {
    inventory.getKitchenText1().setText("You picked up sugar & salt!");
    inventory.getKitchenText2().setText("Carrie's cat wanted to cuddle!");
  }
  @Override
  public GraphicsText setLabel() {
    GraphicsText sugarSaltLabel=new GraphicsText(name, X+5, Y+Height+10);
    return sugarSaltLabel; 
  }

}