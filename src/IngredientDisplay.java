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

        kitchenText1=new GraphicsText(null, CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.8);
        canvas.add(kitchenText1);

        kitchenText2= new GraphicsText(null, CANVAS_WIDTH*0.81, CANVAS_HEIGHT*0.83);
        canvas.add(kitchenText2);
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

    public GraphicsText getKitchenText1(){
        return kitchenText1;
    }


    public GraphicsText getKitchenText2(){
        return kitchenText2; 
    }


}