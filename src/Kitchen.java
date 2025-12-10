import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

/*
* Authors: Alma and Azara
* Extends the Stand interface. Creates the kitchen object. Has getter methods for its x and y position, 
* as well as its width and height. Does not directly change the kitchen text or alter the ingredients list.
*/
public class Kitchen implements Stand{ 
    String name = "Katie's Kitchen";                 
    
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
        // Not needed for kitchen.
    }

    @Override
    public void changeKitchenText(IngredientDisplay inventory) {
        // Not needed for the kitchen.
    }

    @Override
    public GraphicsText setLabel() {
        GraphicsText kitchenLabel=new GraphicsText(name, X+20, Y+Height-2);
        return kitchenLabel;
   
  }

}
