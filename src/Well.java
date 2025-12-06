/*
Water 
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;


public class Well implements Stand {

    String name ="Well";
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
    
    double X= MapWidth *0.15; 
    double Y= MapHeight *0.55; 
    double Height= 80; 
    double Width = 80; 

    private Image wellShape; 

    @Override
    public void addIngredients(List ingredientsList,IngredientDisplay inventory) {
        ingredientsList.add("Water");
        inventory.getWaterBoxText().setText("X");
    }

    @Override
    public String getName() {
        return name; 
    }


    @Override
    public GraphicsObject getGraphics(Color color) {
    if (wellShape == null) {
            wellShape = new Image(X, Y, "WellImage.png");
            wellShape.setMaxWidth(Width);
            wellShape.setMaxHeight(Height);
        }
        return wellShape;
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
