import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

public class IngredientDisplay{

    double CANVAS_HEIGHT = PieHollow.getHeight();
    double CANVAS_WIDTH=PieHollow.getWidth();

    public GraphicsText flourBoxText;
    public GraphicsText waterBoxText;
    public GraphicsText sugarSaltBoxText;
    public GraphicsText eggsButterBoxText;
    public GraphicsText blueberriesBoxText; 

    public IngredientDisplay(CanvasWindow canvas, Color color){
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.80,CANVAS_HEIGHT*0.7,CANVAS_WIDTH*0.2,CANVAS_HEIGHT*0.4);
        backdrop.setFillColor(color);
        canvas.add(backdrop);
       
        GraphicsText titleText= new GraphicsText("Ingredients", CANVAS_WIDTH*0.875,CANVAS_HEIGHT*0.72);
        canvas.add(titleText);
        
        //Well
        Rectangle waterBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.73, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        canvas.add(waterBox);
        waterBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.745);
        canvas.add(waterBoxText);
        GraphicsText waterText=new GraphicsText("Water", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.745);
        canvas.add(waterText);

        //Mill
        Rectangle flourBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.76, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        canvas.add(flourBox);
        flourBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.775);
        canvas.add(flourBoxText);
        GraphicsText flourText=new GraphicsText("Flour", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.775);
        canvas.add(flourText);

        //Sugar_Salt
        Rectangle sugarSaltBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.79, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        canvas.add(sugarSaltBox);
        sugarSaltBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.805);
        canvas.add(sugarSaltBoxText);
        GraphicsText sugarSaltText=new GraphicsText("Sugar & Salt", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.805);
        canvas.add(sugarSaltText);

        //Barn 
        Rectangle eggsButterBox= new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.82, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        canvas.add(eggsButterBox);
        eggsButterBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.835);
        canvas.add(eggsButterBoxText);
        GraphicsText eggsButterText=new GraphicsText("Eggs & Butter", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.835);
        canvas.add(eggsButterText);
        
        //Filling 
        Rectangle blueberriesBox= new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.85, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        canvas.add(blueberriesBox);
        blueberriesBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.865);
        canvas.add(blueberriesBoxText);
        GraphicsText blueberriesText=new GraphicsText("Blueberries", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.865);
        canvas.add(blueberriesText);

    }

    public GraphicsText getWaterBoxText(){
        return waterBoxText;
    }

    public GraphicsText getFlourBoxText(){
        return flourBoxText; 
    }

    public GraphicsText getSugarSaltBoxText(){
        return sugarSaltBoxText;
    }

    public GraphicsText getEggsButterBoxText(){
        return eggsButterBoxText;
    }

    public GraphicsText getBlueberriesBoxText(){
        return blueberriesBoxText; 
    }


}