import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

/*
 * Authors: Alma and Azara 
 * This creates a display in PieHollow that tells the user what ingredients they need to get gives them directions on what to do during the game, 
 * and creates a more engaging game experience as the display is updated in the pieHollow and stand class with updated directions, ingredients 
 * in the user's inventory and fun insights into NPC's lives. It utlizes a rectangle as the background and graphicsTexts. 
 */
public class IngredientDisplay{

    double CANVAS_HEIGHT = PieHollow.getHeight();
    double CANVAS_WIDTH=PieHollow.getWidth();

    public GraphicsText flourBoxText;
    public GraphicsText waterBoxText;
    public GraphicsText sugarSaltBoxText;
    public GraphicsText eggsButterBoxText;
    public GraphicsText blueberriesBoxText; 
    public GraphicsText kitchenText1;
    public GraphicsText kitchenText2; 

    public IngredientDisplay(CanvasWindow canvas, Color backdropColor, Color boxLineColor){
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.80,CANVAS_HEIGHT*0.6,CANVAS_WIDTH*0.2,CANVAS_HEIGHT*0.4);
        backdrop.setFillColor(backdropColor);
        canvas.add(backdrop);
       
        GraphicsText titleText= new GraphicsText("Ingredients", CANVAS_WIDTH*0.875,CANVAS_HEIGHT*0.62);
        canvas.add(titleText);
        
        //Well
        Rectangle waterBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.63, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        waterBox.setStrokeColor(boxLineColor);
        canvas.add(waterBox);
        waterBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.645);
        canvas.add(waterBoxText);
        GraphicsText waterText=new GraphicsText("Water", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.645);
        canvas.add(waterText);

        //Mill
        Rectangle flourBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.66, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        flourBox.setStrokeColor(boxLineColor);
        canvas.add(flourBox);
        flourBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.675);
        canvas.add(flourBoxText);
        GraphicsText flourText=new GraphicsText("Flour", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.675);
        canvas.add(flourText);

        //Sugar_Salt
        Rectangle sugarSaltBox=new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.69, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        sugarSaltBox.setStrokeColor(boxLineColor);
        canvas.add(sugarSaltBox);
        sugarSaltBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.705);
        canvas.add(sugarSaltBoxText);
        GraphicsText sugarSaltText=new GraphicsText("Sugar & Salt", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.705);
        canvas.add(sugarSaltText);

        //Barn 
        Rectangle eggsButterBox= new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.72, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        eggsButterBox.setStrokeColor(boxLineColor);
        canvas.add(eggsButterBox);
        eggsButterBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.735);
        canvas.add(eggsButterBoxText);
        GraphicsText eggsButterText=new GraphicsText("Eggs & Butter", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.735);
        canvas.add(eggsButterText);
        
        //Filling 
        Rectangle blueberriesBox= new Rectangle(CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.75, CANVAS_WIDTH*0.02, CANVAS_HEIGHT*0.02);
        blueberriesBox.setStrokeColor(boxLineColor);
        canvas.add(blueberriesBox);
        blueberriesBoxText= new GraphicsText(null,CANVAS_WIDTH*0.815,CANVAS_HEIGHT*0.765);
        canvas.add(blueberriesBoxText);
        GraphicsText blueberriesText=new GraphicsText("Blueberries", CANVAS_WIDTH*0.84,CANVAS_HEIGHT*0.765);
        canvas.add(blueberriesText);

        //Kitchen Text
        kitchenText1=new GraphicsText(null, CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.8);
        canvas.add(kitchenText1);
        kitchenText2= new GraphicsText(null, CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.83);
        canvas.add(kitchenText2);
    }

    /* 
    * Returns waterBoxText
     */
    public GraphicsText getWaterBoxText(){
        return waterBoxText;
    }

    /*
    * Returns flourBoxText
     */
    public GraphicsText getFlourBoxText(){
        return flourBoxText; 
    }

    /*
    * Returns sugarSaltBoxText
     */
    public GraphicsText getSugarSaltBoxText(){
        return sugarSaltBoxText;
    }

    /*
    * Returns eggsButterBoxText
    */
    public GraphicsText getEggsButterBoxText(){
        return eggsButterBoxText;
    }

    /*
    * Returns blueberriesBoxTect
     */
    public GraphicsText getBlueberriesBoxText(){
        return blueberriesBoxText; 
    }

    /*
    * Returns kitchenText1
     */
    public GraphicsText getKitchenText1(){
        return kitchenText1;
    }

    /*
    * Returns kitchenText 2
     */
    public GraphicsText getKitchenText2(){
        return kitchenText2; 
    }


}