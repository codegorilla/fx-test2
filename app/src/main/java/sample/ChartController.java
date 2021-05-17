package sample;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;

public class ChartController {

//  @FXML
//  private AnchorPane chart;

  @FXML
  private CanvasPane cPane;

  @Inject
  private MainController mainController;

  private ResizableCanvas canvas;

  private GraphicsContext gc;

  // Position strokes between pixels for crisp lines
  private final double EPSILON = 0.50;

  // Last position
  private double lastX = 0.0;
  private double lastY = 0.0;

  // Rubber band line
  private Line line;

  @FXML
  private void initialize () {
    System.out.println("Main window loaded.");
    //if (chart == null)
    //  System.out.println("ITS NULL!!! 1");
    //chart.setTopAnchor(cPane, 0d);
    //chart.setLeftAnchor(cPane, 2d);
    //chart.setBottomAnchor(cPane, 0d);
    //chart.setRightAnchor(cPane, 2d);
    //if (chart == null)
    //  System.out.println("ITS NULL!!! 2");
    canvas = cPane.getCanvas();
    gc = cPane.getCanvas().getGraphicsContext2D();
    clear();
    line = new Line();
    line.setStartX(0.0f);
    line.setStartY(0.0f);
    line.setEndX(100.0f);
    line.setEndY(100.0f);
    //chart.getChildren().add(line);
    //if (chart == null)
    //  System.out.println("ITS NULL!!!");

  }

  @FXML
  public void handleClick (MouseEvent e) {
    System.out.println("HERE! ***");
    var x = e.getX();
    var y = e.getY();
    var w = 20d;
    var h = 20d;
    gc.setStroke(Color.RED);
    gc.strokeRect(x + EPSILON - w/2, y + EPSILON - h/2, w, h);
    lastX = x;
    lastY = y;
  }

  @FXML
  public void handleMove (MouseEvent e) {
    System.out.println("MOVED! ***");
    var x = e.getX() + EPSILON;
    var y = e.getY() + EPSILON;
    gc.setStroke(Color.RED);
//    gc.strokeLine(lastX, lastY, x, y);
  }


  public void clear () {
    gc.setFill(Color.BLACK);
    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
  }

  public void testnow () {
    System.out.println("HERE IN TESTNOW! ***");
    gc.setFill(Color.BLUE);
    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    gc.setFill(Color.WHITE);
    gc.fillRect(75,75,100,100);
  }

}
