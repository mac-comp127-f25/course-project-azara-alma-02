import java.awt.Color;
import java.util.List;

import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;

/*
* Authors: Alma and Azara
* TODO: add description of class and methods
*/
public class BakeSale implements Stand {
    String name = "Bobbi's Bake Sale"; 
    
    double MapHeight = PieHollow.getHeight();
    double MapWidth=PieHollow.getWidth();
                                           
    private double X = MapWidth*0.79; 
    private double Y= MapHeight*0;
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
        // Not needed for bake sale.
    }

    @Override
    public void changeKitchenText(IngredientDisplay inventory) {
        // Not needed for bake sale.
    }

    @Override
    public GraphicsText setLabel() {
        GraphicsText bakeSaleLabel=new GraphicsText(name, X+20, Y+Height+5);
        return bakeSaleLabel;
    }


}
