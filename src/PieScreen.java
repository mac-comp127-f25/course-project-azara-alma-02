import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
/*
* Authors: Alma and Azara 
* Contains an Image with a string path to PieImage.png that is overlayed onto a rectangle. Has two methods, one adds the screen to the canvas 
 and the other removes it from the canvas. 
*/
public class PieScreen {
    double CANVAS_HEIGHT = PieHollow.getHeight();
    double CANVAS_WIDTH= PieHollow.getWidth();

    private Rectangle backdrop;
    private Image pie;

    public void addScreen(CanvasWindow canvas, Color color) {
        backdrop = new Rectangle(CANVAS_WIDTH*0.80,CANVAS_HEIGHT*0.6,CANVAS_WIDTH*0.2,CANVAS_HEIGHT*0.18);
        backdrop.setFillColor(color);
        canvas.add(backdrop);

        pie = new Image(CANVAS_WIDTH*0.83, CANVAS_HEIGHT*0.6, "PieImage.png");
        pie.setMaxWidth(CANVAS_WIDTH*0.2);
        pie.setMaxHeight(CANVAS_HEIGHT*0.18);
        canvas.add(pie);
    }

    public void removeScreen(CanvasWindow canvas) {
        canvas.remove(backdrop);
        canvas.remove(pie);
    }


}
