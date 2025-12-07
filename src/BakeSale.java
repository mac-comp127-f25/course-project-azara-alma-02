import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class BakeSale implements Stand {
    String name = "Bobbi's Bake Sale"; // I thought it might be fun to do cute alliteration for all the stand names, but toatally happy with whatever!
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
                                                         //Need a Pie in Inventory 

    private double X = MapWidth*0.85; // I kept these dimensions the same as Sugar & Salt just cause I wasn't sure what we would want.
    private double Y= MapHeight*0.01;
    private double Width = 180; 
    private double Height = 180;

    private Image bakeSaleShape;

    public BakeSale(){
    }

    public String getName() {
        return name;
    }

    public GraphicsObject getGraphics(Color color){
        if (bakeSaleShape == null) {
            bakeSaleShape = new Image(X, Y, "BakeSaleImage.png");
            bakeSaleShape.setMaxWidth(Width);
            bakeSaleShape.setMaxHeight(Height);
        }
        return bakeSaleShape;
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
        // Does not add ingredients
    }

}
