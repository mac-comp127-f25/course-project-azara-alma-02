import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;


public class PieHollow {
    CanvasWindow canvas; 
    
    public static Image PieHollowMapImage =new Image(0, 0, "PieHollowMap.png");
    private Baker baker;
    public GraphicsText inventory; 

    public static final int CANVAS_HEIGHT = PieHollowMapImage.getImageHeight();
    public static final int CANVAS_WIDTH = PieHollowMapImage.getImageWidth();

    List<String> ingredientsList= new ArrayList<>();
    public GraphicsGroup standGroup;
    public GraphicsGroup welcomeScreen; 

    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",CANVAS_WIDTH,CANVAS_HEIGHT);
        this.standGroup=new GraphicsGroup();
        this.welcomeScreen=new GraphicsGroup();
        playGame();
    
    }

    private void placeElements(){
        setBackground();
        makeLabel();
        makeBakeSale();
        makeKitchen();
        canvas.add(standGroup);
        makeStands();
        canvas.add(welcomeScreen);
        makeWelcomeScreen();
    }

     private void KeyMoved(){
       canvas.animate(()->{
         for(Key key:canvas.getKeysPressed()){
            if (key.equals(Key.RIGHT_ARROW)){
                baker.rightPressed();
            }
            else if(key.equals(Key.LEFT_ARROW)){
                baker.leftPressed();
            }
            else if (key.equals(Key.UP_ARROW)){
                baker.upPressed();
            }
            else if (key.equals(Key.DOWN_ARROW)){
                baker.downPressed();
            }
            }  
        });
    }

    private void makeWelcomeScreen(){
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.30,CANVAS_HEIGHT*0.40,CANVAS_WIDTH*0.285,CANVAS_HEIGHT*0.2);
        backdrop.setFillColor(Color.PINK);
        welcomeScreen.add(backdrop);

        GraphicsText welcomeMessage= new GraphicsText(" Welcome to Pie Hollow! ", CANVAS_WIDTH*0.37, CANVAS_HEIGHT*0.42);
        welcomeMessage.setFillColor(Color.BLACK);
        welcomeScreen.add(welcomeMessage); 

        GraphicsText line1 = new GraphicsText("Collect all of your ingredients to make a pie", CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.45);
        welcomeScreen.add(line1);

        GraphicsText line2 = new GraphicsText("You will need to visit the well, mill, barn, shops", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.47); 
        welcomeScreen.add(line2);

        GraphicsText line3 = new GraphicsText("Collect your ingredients.", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.49); 
        welcomeScreen.add(line3);

        GraphicsText line4= new GraphicsText("Use the kitchen to make your pie",
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.51);
        welcomeScreen.add(line4);

        GraphicsText line5 = new GraphicsText("Then, bring your pie to the bakesale!!", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.53); 
        welcomeScreen.add(line5);
        

        Button playButton= new Button("PLAY!");
        playButton.setPosition(CANVAS_WIDTH*0.41, CANVAS_HEIGHT*0.55);
        welcomeScreen.add(playButton);
        

        playButton.onClick(() -> {             
        canvas.remove(welcomeScreen);
        makeBaker();
        }); 


       
    }


    private void playGame(){
       placeElements();
       KeyMoved();

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
        standGroup.add(barn);

        GraphicsObject filling = new Filling().getGraphics(Color.BLUE);
        standGroup.add(filling);

        GraphicsObject mill = new Mill().getGraphics(Color.YELLOW);
        standGroup.add(mill);

        GraphicsObject sugarSalt = new Sugar_Salt().getGraphics(Color.WHITE);
        standGroup.add(sugarSalt);

        GraphicsObject well = new Well().getGraphics(Color.BLACK);
        standGroup.add(well);
    }
    private void makeBaker(){
        baker = new Baker(0,0);
        canvas.add(baker.getGraphics());

    }
    private void makeKitchen(){
        GraphicsObject kitchen=new Kitchen().getGraphics();
        canvas.add(kitchen);

    }
    private void makeBakeSale(){
        GraphicsObject bakeSale = new BakeSale().getGraphics();
        canvas.add(bakeSale);
    }

    private void makeLabel(){
        inventory=new GraphicsText("I live", CANVAS_WIDTH*0.7, CANVAS_HEIGHT*0.8);
        canvas.add(inventory);
    }
    public static void main(String[] args) {
        new PieHollow();
    }
}
