import edu.macalester.graphics.CanvasWindow;

public class PieHollow {
    CanvasWindow canvas; 


    public PieHollow(){
        canvas=new CanvasWindow("PieHollow", 600, 600);
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
