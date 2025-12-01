import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;

public class PieHollow {
    CanvasWindow canvas; 
    public static final double CANVAS_HEIGHT = 600;
    public static final double CANVAS_WIDTH = 600;

    List<String> ingredientsList= new ArrayList<>();

    public GraphicsGroup standGroup;


    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",600, 600);
        playGame();
    
    }

    private void placeElements(){
        // setBackground();
        makeStands();
        // makeBaker();
        makeBakeSale();
        // makeKitchen();
    }

    private void playGame(){
       placeElements();
    }

    public static double getSize(){
        return CANVAS_HEIGHT;
    }

    private double getCanvasSize(){
        return CANVAS_HEIGHT;
    }

    // Elements
    private void setBackground(){
    }
    private void makeStands(){
        GraphicsObject barn = new Barn().getGraphics();
        canvas.add(barn);
        // standGroup.add(barn);

        GraphicsObject filling = new Filling().getGraphics();
        canvas.add(filling);
        // standGroup.add(filling);

        GraphicsObject mill = new Mill().getGraphics();
        canvas.add(mill);
        // standGroup.add(mill);

        GraphicsObject sugarSalt = new Sugar_Salt().getGraphics();
        canvas.add(sugarSalt);
        // standGroup.add(sugarSalt);

        GraphicsObject well = new Well().getGraphics();
        canvas.add(well);
        // standGroup.add(well);
    }
    private void makeBaker(){

    }
    private void makeKitchen(){

    }
    private void makeBakeSale(){
        GraphicsObject bakeSale = new BakeSale().getGraphics();
        canvas.add(bakeSale);

    }


    public static void main(String[] args) {
        new PieHollow();
    }
}
