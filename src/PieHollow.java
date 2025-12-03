import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;

public class PieHollow {
    CanvasWindow canvas; 
    
    public static Image PieHollowMapImage =new Image(0, 0, "PieHollowMap.png");

    public static final int CANVAS_HEIGHT = PieHollowMapImage.getImageHeight();
    public static final int CANVAS_WIDTH = PieHollowMapImage.getImageWidth();

    List<String> ingredientsList= new ArrayList<>();


    public GraphicsGroup standGroup;

    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",CANVAS_WIDTH,CANVAS_HEIGHT);
        this.standGroup=new GraphicsGroup();
        playGame();
    
    }

    private void placeElements(){
        setBackground();
        makeBaker();
        makeBakeSale();
        makeKitchen();
        makeStands();
    }

    private void KeyMoved(){

        canvas.animate(->
            {

        });

        

    }


    private void playGame(){
       placeElements();

    }

    public static double getHeight(){
        return CANVAS_HEIGHT;
    }

    public static double getWidth(){
        return CANVAS_WIDTH;
    }

    // Elements
    private void setBackground(){
        PieHollowMapImage.setMaxWidth(CANVAS_WIDTH);
        PieHollowMapImage.setMaxHeight(CANVAS_HEIGHT);
        canvas.add(PieHollowMapImage);
    }

    private void makeStands(){
        GraphicsObject barn = new Barn().getGraphics(Color.RED);
        canvas.add(barn);
        //standGroup.add(barn);

        GraphicsObject filling = new Filling().getGraphics(Color.BLUE);
        canvas.add(filling);
        //standGroup.add(filling);

        GraphicsObject mill = new Mill().getGraphics(Color.YELLOW);
        canvas.add(mill);
        //standGroup.add(mill);

        GraphicsObject sugarSalt = new Sugar_Salt().getGraphics(Color.WHITE);
        canvas.add(sugarSalt);
        //standGroup.add(sugarSalt);

        GraphicsObject well = new Well().getGraphics(Color.BLACK);
        canvas.add(well);
        //standGroup.add(well);
    }
    private void makeBaker(){
        GraphicsObject baker=new Baker(0,0).getGraphics();
        canvas.add(baker);

    }
    private void makeKitchen(){
        GraphicsObject kitchen=new Kitchen().getGraphics();
        canvas.add(kitchen);

    }
    private void makeBakeSale(){
        GraphicsObject bakeSale = new BakeSale().getGraphics();
        canvas.add(bakeSale);

    }
    public static void main(String[] args) {
        new PieHollow();
    }
}
