import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
public class Kitchen implements Stand{ 
    String name = "Katie's Kitchen";                   //TODO: Make a Pie Image-add pie to ingredients list --have graphics text changed to be a pie
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();

    private double X = MapWidth*0.002; 
    private double Y= MapHeight*0.4;
    private double Width = 180; 
    private double Height = 200;
    
    private Image kitchenShape;

    public Kitchen(){
    }

    public String getName() {
        return name;
    }

    public GraphicsObject getGraphics(Color color){
        if (kitchenShape == null) {
            kitchenShape = new Image(X, Y, "KitchenImage.png");
            kitchenShape.setMaxWidth(Width);
            kitchenShape.setMaxHeight(Height);
        }
        return kitchenShape;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getWidth() {
        return Width;
    }

    public double getHeight() {
        return Height;
    }

    public void addIngredients(List ingredientsList, IngredientDisplay inventory) {
        // Does not add ingredients to ingredientList
    }

    @Override
    public void changeKitchenText(IngredientDisplay inventory) {
        //Not needed for the kitchen.
    }

    @Override
    public GraphicsText setLabel() {
        GraphicsText kitchenLabel=new GraphicsText(name, X+20, Y+Height-2);
        return kitchenLabel;
   
  }

}
