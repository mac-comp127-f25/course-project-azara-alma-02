/*
Water 
 */

import java.util.List;
import java.awt.Color;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

public class Well implements Stand {

    String name ="Well";
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
    
    double X= MapWidth *0.25; 
    double Y= MapHeight *0.65; 
    double Height= 20; 
    double Width =20; 

    private Rectangle wellShape; 

    @Override
    public void addIngredients(List ingredientsList,GraphicsText inventory) {
        ingredientsList.add("Water");
        String text=inventory.getText();
        inventory.setText(text+ " " + "Water");
    }

    @Override
    public String getName() {
        return name; 
    }


    @Override
    public GraphicsObject getGraphics(Color color) {
        if (wellShape == null) {
            wellShape = new Rectangle(X, Y, Width, Height);
            wellShape.setFillColor(color);
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
