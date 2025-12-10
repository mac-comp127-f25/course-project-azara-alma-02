import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;

/*
* Authors: Alma and Azara
* Holds most of the game logic. Initializes the canvas and graphics objects. Has methods to move the baker,
* interact with stands, and the win game logic. Run this class to play the game.
*/
public class PieHollow {
    CanvasWindow canvas; 

    public static Image PieHollowMapImage =new Image(0, 0, "PieHollowMap.png");
    
    public static final int CANVAS_HEIGHT = PieHollowMapImage.getImageHeight();
    public static final int CANVAS_WIDTH = PieHollowMapImage.getImageWidth();
    public static final Color BACKDROP= Color.PINK; 
    public static final Color BOX_OUTLINE=Color.BLACK; 

    private Image bobbiImage;
    private Baker baker;
    public IngredientDisplay inventory;
    public PieScreen pieScreen; 

    List<String> ingredientsList= new ArrayList<>();
    public GraphicsGroup standGroup;
    public GraphicsGroup welcomeScreen;
    public GraphicsGroup winScreen;
    private List<Stand> standList = new ArrayList<>();
    
    private boolean pieMade = false;
    private boolean pieScreenPresent = false;
    private static final int NEEDED_INGREDIENTS = 7;

    public PieHollow(){
        canvas=new CanvasWindow("PieHollow",CANVAS_WIDTH,CANVAS_HEIGHT);
        this.standGroup=new GraphicsGroup();
        this.welcomeScreen=new GraphicsGroup();
        this.winScreen=new GraphicsGroup();
        this.pieScreen = new PieScreen();
        playGame();

    }

    /*
    * Calls placeElements to set up the initial state of pieHollow's screen.
     */
    private void playGame(){
       placeElements();
    }

    /*
    * Sets up the initial state of the canvas before the PieHollow Game begins. 
     */
    private void placeElements(){
        setBackground();
        inventory = new IngredientDisplay(canvas, BACKDROP,BOX_OUTLINE);
        makeBakeSale();
        makeKitchen();
        canvas.add(standGroup);
        makeStands();
        makeBobbi();
        canvas.add(welcomeScreen);
        makeWelcomeScreen();   
    }

    /*
    * Checks which key was pressed by the user and calls the appropriate baker method to update the baker's position based on the key pressed. 
    * Animates the baker's movement continously and calls checkInteractions after every key press to see if the baker has hit an applicable 
    * GraphicsObject. 
     */
     private void keyMoved(){
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
    /*
    * Handles interactions between the baker and the stands. Iterates through a list of the stands and adds 
    * ingredients according to what stand is interacted with. Dictates weather interaction with the kitchen 
    * bake sale is possible according to how many ingredients have been collected. Calls win screen when game
    * completed. 
     */
    private void checkInteractions() {
        for(int i = standList.size() - 1; i >= 0; i--) { 
            Stand stand = standList.get(i);

            if(baker.reachesStand(stand)) {
                String standName = stand.getName();
                if (standName == "Katie's Kitchen") {
                    if (!pieMade && ingredientsList.size() >= NEEDED_INGREDIENTS) {
                        ingredientsList.clear();
                        pieMade = true;
                        inventory.getKitchenText1().setText("You made a pie!"); 
                        inventory.getKitchenText2().setText("Sell it at the bake sale now!");
                        if(!pieScreenPresent) {
                            pieScreen.addScreen(canvas, BACKDROP); 
                            pieScreenPresent = true;
                        }    
                    } else if (pieMade) { 
                        inventory.getKitchenText1().setText("You made a pie!");
                        inventory.getKitchenText2().setText("Sell it at the bake sale now!");
                    } else {
                        int neededIngredients = NEEDED_INGREDIENTS - ingredientsList.size();
                        inventory.getKitchenText1().setText("You need some ingredients!");
                        inventory.getKitchenText2().setText(neededIngredients + " more needed.");
                    }
                    return;
                } else if (standName == "Bobbi's Bake Sale") {
                    if (pieMade) {
                    canvas.add(winScreen);
                    makeWinScreen();
                    } else {
                        inventory.getKitchenText1().setText("No Pie to Sell!"); 
                        inventory.getKitchenText2().setText("Visit the Kitchen first.");
                    }
                    return;
                } else {
                    standGroup.remove(stand.getGraphics(Color.RED));
                    stand.addIngredients(ingredientsList, inventory); 
                    stand.changeKitchenText(inventory);
                    standList.remove(i); 
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

    public static double getHeight(){
        return CANVAS_HEIGHT;
    }

    public static double getWidth(){
        return CANVAS_WIDTH;
    }

    /*
    *Sets the width and height of PieHollow's background map image and adds it to the canvas. 
     */
    private void setBackground(){
        PieHollowMapImage.setMaxWidth(CANVAS_WIDTH);
        PieHollowMapImage.setMaxHeight(CANVAS_HEIGHT);
        canvas.add(PieHollowMapImage);
    }

    /*
    * Adds elements to the welcomeScreen GraphicsGroup which give the user instrcutions on how to play the game. Contains a play button which 
    * removes the welcomeScreen from the canvas and calls makeBaker() and keyMoved to set up the window for the user to begin playing PieHollow. 
     */
    private void makeWelcomeScreen(){
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.3,CANVAS_HEIGHT*0.40,CANVAS_WIDTH*0.3,CANVAS_HEIGHT*0.2);
        backdrop.setFillColor(BACKDROP);
        welcomeScreen.add(backdrop);

        GraphicsText welcomeMessage= new GraphicsText(" Welcome to Pie Hollow! ", CANVAS_WIDTH*0.37, CANVAS_HEIGHT*0.42);
        welcomeMessage.setFillColor(Color.BLACK);
        welcomeScreen.add(welcomeMessage); 

        GraphicsText line1 = new GraphicsText("Your friend Bobbi has asked you to make a pie ", CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.45);
        welcomeScreen.add(line1);

        GraphicsText line2 = new GraphicsText("Collect all of your ingredients to make a pie", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.47); 
        welcomeScreen.add(line2);

        GraphicsText line3 = new GraphicsText("You will need to visit the well, mill, barn, shops", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.49); 
        welcomeScreen.add(line3);

        GraphicsText line4= new GraphicsText("Collect your ingredients.",
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.51);
        welcomeScreen.add(line4);

        GraphicsText line5 = new GraphicsText("Use the kitchen to make your pie", 
        CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.53); 
        welcomeScreen.add(line5);

        GraphicsText line6=new GraphicsText("Then, bring your pie to Bobbi's Bakesale!!",CANVAS_WIDTH*0.31, CANVAS_HEIGHT*0.55);
        welcomeScreen.add(line6);
        
        Button playButton= new Button("PLAY!");
        playButton.setPosition(CANVAS_WIDTH*0.41, CANVAS_HEIGHT*0.56);
        welcomeScreen.add(playButton);
        
        playButton.onClick(() -> {             
        canvas.remove(welcomeScreen);
        makeBaker();
        keyMoved(); 
        });   
    }

    /* 
    * Creates each ingredient stand, adds it to standlist, adds its label to the canvas, and adds its graphics to the standGroup. 
     */
    private void makeStands(){
        Stand barn = new Barn();
        Stand filling = new Filling();
        Stand mill = new Mill();
        Stand sugarSalt = new Sugar_Salt();
        Stand well = new Well();

        standList.add(barn); 
        standList.add(filling);
        standList.add(mill);
        standList.add(sugarSalt);
        standList.add(well);
        
        canvas.add(barn.setLabel());
        canvas.add(filling.setLabel());
        canvas.add(mill.setLabel());
        canvas.add(sugarSalt.setLabel());
        canvas.add(well.setLabel());

        standGroup.add(barn.getGraphics(Color.RED));
        standGroup.add(filling.getGraphics(Color.BLUE));
        standGroup.add(mill.getGraphics(Color.BLUE));
        standGroup.add(sugarSalt.getGraphics(Color.WHITE));
        standGroup.add(well.getGraphics(Color.BLACK));
    }

    /*
    * Creates an instance of the baker class and adds its graphics to the canvas. 
     */
    private void makeBaker(){
        baker = new Baker(CANVAS_WIDTH*0.061,CANVAS_HEIGHT*0.56);
        canvas.add(baker.getGraphics());
    }

    /* 
    * Intializes bobbiImage and adds it to the canvas. 
     */
    private void makeBobbi(){
       bobbiImage=new Image(CANVAS_WIDTH*0.77, CANVAS_HEIGHT*0.13,"BobbiImage.png");
       bobbiImage.setMaxWidth(60);
       bobbiImage.setMaxHeight(60);
       canvas.add(bobbiImage);
    }

    /* 
    * Creates an instace of the Kitchen class (kitchen), adds it to the standlist, adds it's graphics to the standGroup, and add's the kitchen's
     label to the canvas
     */
    private void makeKitchen(){
        Stand kitchen = new Kitchen();
        standList.add(kitchen);
        standGroup.add(kitchen.getGraphics(Color.RED));
        canvas.add(kitchen.setLabel());
    }

    /* 
    *Creates an instace of the BakeSale (bakeSale) class, adds it to the standlist, adds it's graphics to the standGroup, and add's the bakeSale's 
    label to the canvas
     */
    private void makeBakeSale(){
        Stand bakeSale = new BakeSale();
        standList.add(bakeSale);
        standGroup.add(bakeSale.getGraphics(Color.RED));
        canvas.add(bakeSale.setLabel());
    }

    /*
    * Adds elements to the winScreen GraphicsGroup, which contains the win message the user sees upon succesfully completing the game. Creates a 
    play again buttton and an exit button, which closes the window, so the user can chose to leave the game or playagain. Contains callbacks to 
    each button. playAgainButton's callback resets canvas, standGroup, pie elements, and removes winScreen from the canvas. 
     */
    private void makeWinScreen(){ 
        Rectangle backdrop=new Rectangle(CANVAS_WIDTH*0.30,CANVAS_HEIGHT*0.40,CANVAS_WIDTH*0.285,CANVAS_HEIGHT*0.15);
        backdrop.setFillColor(BACKDROP);
        winScreen.add(backdrop);

        GraphicsText congratsMessage= new GraphicsText("YOU WIN!", CANVAS_WIDTH*0.4, CANVAS_HEIGHT*0.42);
        congratsMessage.setFillColor(Color.BLACK);
        winScreen.add(congratsMessage); 

        GraphicsText line1= new GraphicsText("Your pie was delicious! Bobbi loved it!", CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.45); 
        line1.setFillColor(Color.BLACK);
        winScreen.add(line1); 

        GraphicsText line2= new GraphicsText("It was the best pie at the bakesale.",CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.47);
        line2.setFillColor(Color.BLACK);
        winScreen.add(line2);

        GraphicsText line3 = new GraphicsText ("You can either play again or exit the game",CANVAS_WIDTH*0.33, CANVAS_HEIGHT*0.49);
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
            inventory.getEggsButterBoxText().setText(null);
            inventory.getBlueberriesBoxText().setText(null);
            inventory.getFlourBoxText().setText(null);
            inventory.getSugarSaltBoxText().setText(null);
            inventory.getWaterBoxText().setText(null);

            for (int i=6; i<ingredientsList.size();i--){
                ingredientsList.remove(i);
            }
            pieMade=false;
            pieScreen.removeScreen(canvas);
            pieScreenPresent = false;
            makeStands();
            makeBakeSale();
            makeKitchen();
            canvas.remove(winScreen); 
        });
    }

    public static void main(String[] args) {
        new PieHollow();
    }
}
