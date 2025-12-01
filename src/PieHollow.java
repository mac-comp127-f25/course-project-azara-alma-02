import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;

public class PieHollow {
    CanvasWindow canvas; 
    public static final double CANVAS_HEIGHT = 600;
    public static final double CANVAS_WIDTH = 600;

    List<String> ingredientsList= new ArrayList<>();


    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",600, 600);
        playGame();
    
    }

    private void placeElements(){
        // setBackground();
        makeStands();
        // makeBaker();
        // makeBakeSale();
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
        GraphicsObject barn = new Barn().setStandProperties(CANVAS_HEIGHT);
        canvas.add(barn);

        GraphicsObject filling = new Filling().setStandProperties(CANVAS_HEIGHT);
        canvas.add(filling);

        GraphicsObject mill = new Mill().setStandProperties(CANVAS_HEIGHT);
        canvas.add(mill);

        GraphicsObject sugarSalt = new Sugar_Salt().setStandProperties(CANVAS_HEIGHT);
        canvas.add(sugarSalt);

        GraphicsObject well = new Well().setStandProperties(CANVAS_HEIGHT);
        canvas.add(well);
    }
    private void makeBaker(){

    }
    private void makeKitchen(){

    }
    private void makeBakeSale(){

    }


    public static void main(String[] args) {
        new PieHollow();
    }
}
