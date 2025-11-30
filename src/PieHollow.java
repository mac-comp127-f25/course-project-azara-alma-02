import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;

public class PieHollow {
    CanvasWindow canvas; 
    public static final double CANVAS_HEIGHT = 600;
    public static final double CANVAS_WIDTH = 600;

    List<String> ingredientsList= new ArrayList();


    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",600, 600);
        //playGame();
    
    }

    private void placeElements(){
        setBackground();
        makeStands();
        makeBaker();
        makeBakeSale();
        makeKitchen();
    }

    //private void playGame(){
    //    placeElements();
    //}

    private double getCanvasSize(){
        return CANVAS_HEIGHT;
    }

    // Elements
    private void setBackground(){
    }
    private void makeStands(){

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
