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
    public IngredientDisplay inventory; 

    public static final int CANVAS_HEIGHT = PieHollowMapImage.getImageHeight();
    public static final int CANVAS_WIDTH = PieHollowMapImage.getImageWidth();
    public static final Color BACKDROP= Color.PINK; 
    public static final Color BOX_OUTLINE=Color.BLACK; 

    List<String> ingredientsList= new ArrayList<>();
    public GraphicsGroup standGroup;
    public GraphicsGroup welcomeScreen;
    public GraphicsGroup winScreen;
    private List<Stand> standList = new ArrayList<>();
    
    private boolean pieMade = false;
    private static final int NEEDED_INGREDIENTS = 7;

    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",CANVAS_WIDTH,CANVAS_HEIGHT);
        this.standGroup=new GraphicsGroup();
        this.welcomeScreen=new GraphicsGroup();
        this.winScreen=new GraphicsGroup();
        playGame();
    
    }

    private void placeElements(){
        setBackground();
        inventory = new IngredientDisplay(canvas, BACKDROP,BOX_OUTLINE);
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
            checkInteractions();  
        });
    }

    private void makeWelcomeScreen(){
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.30,CANVAS_HEIGHT*0.40,CANVAS_WIDTH*0.285,CANVAS_HEIGHT*0.2);
        backdrop.setFillColor(BACKDROP);
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
        KeyMoved(); 
        });   
    }

    private void makeWinScreen(){ //Buttons here not quite working right yet.
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.30,CANVAS_HEIGHT*0.40,CANVAS_WIDTH*0.285,CANVAS_HEIGHT*0.15);
        backdrop.setFillColor(BACKDROP);
        winScreen.add(backdrop);

        GraphicsText congratsMessage= new GraphicsText("YOU WIN!", CANVAS_WIDTH*0.4, CANVAS_HEIGHT*0.42);
        congratsMessage.setFillColor(Color.BLACK);
        winScreen.add(congratsMessage); 

        GraphicsText line1= new GraphicsText("Your pie was delicious!", CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.44); 
        line1.setFillColor(Color.BLACK);
        winScreen.add(line1); 

        GraphicsText line2= new GraphicsText("It was the best pie at the bakesale.",CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.46);
        line2.setFillColor(Color.BLACK);
        winScreen.add(line2);

        GraphicsText line3 = new GraphicsText ("You can either play again or exit the game",CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.48);
        line2.setFillColor(Color.BLACK);
        winScreen.add(line3);

        Button exitButton= new Button("EXIT");
        exitButton.setPosition(CANVAS_WIDTH*0.35, CANVAS_HEIGHT*0.5);
        winScreen.add(exitButton);

        Button playAgainButton= new Button ("PLAY AGAIN"); 
        playAgainButton.setPosition(CANVAS_WIDTH*0.45, CANVAS_HEIGHT*0.5);
        winScreen.add(playAgainButton);

        exitButton.onClick(()->{
        canvas.removeAll();
        canvas.closeWindow();
        });

        playAgainButton.onClick(()->{
            //Clears x's 
            inventory.getEggsButterBoxText().setText(null);
            inventory.getBlueberriesBoxText().setText(null);
            inventory.getFlourBoxText().setText(null);
            inventory.getSugarSaltBoxText().setText(null);
            inventory.getWaterBoxText().setText(null);

            //Clear's inventory 
            for (int i=6; i<ingredientsList.size();i--){
                ingredientsList.remove(i);
            }
            
            pieMade=false;

            makeStands();
            makeBakeSale();
            makeKitchen();

            canvas.remove(winScreen);
            
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
        Stand barn = new Barn();
        Stand filling = new Filling();
        Stand mill = new Mill();
        Stand sugarSalt = new Sugar_Salt();
        Stand well = new Well();

        standList.add(barn); //I added this so we can iterate over the stands, so now they exist seperately to their graphics objects
        canvas.add(barn.setLabel());
        standList.add(filling);
        canvas.add(filling.setLabel());
        standList.add(mill);
        canvas.add(mill.setLabel());
        standList.add(sugarSalt);
        canvas.add(sugarSalt.setLabel());
        standList.add(well);
        canvas.add(well.setLabel());


        standGroup.add(barn.getGraphics(Color.RED));
        standGroup.add(filling.getGraphics(Color.BLUE));
        standGroup.add(mill.getGraphics(Color.BLUE));
        standGroup.add(sugarSalt.getGraphics(Color.WHITE));
        standGroup.add(well.getGraphics(Color.BLACK));
    }

    private void makeBaker(){
        baker = new Baker(CANVAS_WIDTH*0.061,CANVAS_HEIGHT*0.56);
        canvas.add(baker.getGraphics());
    }

    private void makeKitchen(){
        Stand kitchen = new Kitchen();
        standList.add(kitchen);
        standGroup.add(kitchen.getGraphics(Color.RED));
        canvas.add(kitchen.setLabel());
    }

    private void makeBakeSale(){
        Stand bakeSale = new BakeSale();
        standList.add(bakeSale);
        standGroup.add(bakeSale.getGraphics(Color.RED));
        canvas.add(bakeSale.setLabel());
    }
  
    private void checkInteractions() {
        for(int i = standList.size() - 1; i >= 0; i--) { //Did this backward so elements can be removed safely.
            Stand stand = standList.get(i);

            if(baker.reachesStand(stand)) {
                String standName = stand.getName();
                if (standName == "Katie's Kitchen") {
                    if (!pieMade && ingredientsList.size() >= NEEDED_INGREDIENTS) {
                        ingredientsList.clear();
                        pieMade = true;
                        inventory.getKitchenText1().setText("Pie made!"); // Want to change this so now the ingredients list just says pie, after intearction with the kitchen.
                        inventory.getKitchenText2().setText("Go to the Bake Sale!"); // Would be cool if these things showed up somewhere, but not quite sure how to do that, might have misinterpreted this methods purpose
                    } else if(pieMade) {
                        inventory.getKitchenText1().setText("You made a pie!");
                        inventory.getKitchenText2().setText("Sell it at the bake sale now!");
                    } else {
                        int neededIngredients = NEEDED_INGREDIENTS - ingredientsList.size();
                        inventory.getKitchenText1().setText("You are missing some ingredients!");
                        inventory.getKitchenText2().setText(neededIngredients + " more needed.");
                    }
                    return;
                } else if (standName == "Bobbi's Bake Sale") {
                    if (pieMade) {
                    canvas.add(winScreen);
                    makeWinScreen();
                    } else {
                        inventory.getKitchenText1().setText("No Pie to Sell!"); // not sure how to use getKitchenText!!
                        inventory.getKitchenText2().setText("Visit the Kitchen first.");
                    }
                    return;
                } else {
                    standGroup.remove(stand.getGraphics(Color.RED));
                    stand.addIngredients(ingredientsList, inventory); //Can create another method in each stand class that creates the pop-ups we talked about! Also, our ingredients list is showing up horizontally on the canvas, might want to change that too
                    stand.changeKitchenText(inventory);
                    standList.remove(i); //Add here the shapes back on to the canvas after removal!
                    canvas.add(stand.getGraphics(Color.RED));
                    if(ingredientsList.size()==7){
                        inventory.getKitchenText1().setText("The kitchen is open");
                        inventory.getKitchenText2().setText("Go make your pie!"); 
                    }
                    return;
                }    
            }
        }
    }

    public static void main(String[] args) {
        new PieHollow();
    }
}
