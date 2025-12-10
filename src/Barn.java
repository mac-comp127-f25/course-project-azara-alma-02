import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
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
   
  /*
  * Returns the barn's X coordinate
  */
  @Override
  public double getX() {
    return X;
  }

  /*
  * Returns the barn's Y coordinate
  */
  @Override
  public double getY() {
    return Y;
  }

  /*
  * Returns the barn's width
  */
  @Override
  public double getWidth() {
    return Width;
  }

  /*
  * Returns the barn's height
  */
  @Override
  public double getHeight() {
    return Height;
  }

  /* 
  * Updates KitchenText 1 & 2: Tells the user what ingredients they've collected and shares a fun fact about the barn's inhabitant
  */
  @Override
  public void changeKitchenText(IngredientDisplay inventory) {
    inventory.getKitchenText1().setText("You picked up eggs & butter!");
    inventory.getKitchenText2().setText("Bailey built his new house!");
  }

  /*
  * Creates a graphics text, with the Barn's name positioned underneath the barn. 
  */
  @Override
  public GraphicsText setLabel() {
    GraphicsText barnLabel=new GraphicsText(name, X+30, Y+Height-7);
    return barnLabel;
   
  }
}
