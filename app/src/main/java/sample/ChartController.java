package sample;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;

import sample.state.InteractionManager;

public class ChartController {

  @FXML
  private Pane cPane;

  @FXML
  private ResizableCanvas canvas;

  @Inject
  private MainController mainController;

  @Inject
  private InteractionManager interactionManager;

  private GraphicsContext gc;

  // Position strokes between pixels for crisp lines
  private final double EPSILON = 0.50;

  // Last position
  private double lastX = 0.0;
  private double lastY = 0.0;

  // Rubber band line
  private Line line;

  // Drawing modes
  //public static final int NONE  = 0;
  //public static final int ROUTE = 1;
  //private int drawingMode = NONE;


  @FXML
  private void initialize () {
    System.out.println("Main window loaded.");
    canvas.setSizeBinding(cPane);
    gc = canvas.getGraphicsContext2D();
    clear();
    line = new Line();
    line.setStartX(0.0f);
    line.setStartY(0.0f);
    line.setEndX(0.0f);
    line.setEndY(0.0f);
    line.setMouseTransparent(true);
    line.setVisible(false);
    cPane.getChildren().add(line);

    // We need to add canvas to the interactionManager
    // Be careful - if we change DI to use setter injection then we might
    // Need to change where this goes due to timing
    interactionManager.setCanvas(canvas);
  }

  @FXML
  public void handleClick (MouseEvent e) {
    System.out.println("HERE! ***");
    var x = e.getX();
    var y = e.getY();
    if (e.getButton() == MouseButton.PRIMARY) {
      interactionManager.leftClick(x, y);
      var w = 20f;
      var h = 20f;
      gc.setStroke(Color.RED);
      gc.strokeRect(x + EPSILON - w/2, y + EPSILON - h/2, w, h);
      line.setStartX(x);
      line.setStartY(y);
      lastX = x;
      lastY = y;
    }
    else if (e.getButton() == MouseButton.SECONDARY) {
      interactionManager.rightClick(x, y);
    }
  }

  @FXML
  public void handleMove (MouseEvent e) {
    System.out.println("MOVED! ***");
    var x = e.getX();
    var y = e.getY();
    line.setEndX(x + EPSILON);
    line.setEndY(y + EPSILON);
//     gc.setStroke(Color.RED);
// //    gc.strokeLine(lastX, lastY, x, y);
  }

  public void clear () {
    // gc.setFill(Color.BLACK);
    // gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
  }

  public void testnow () {
    System.out.println("HERE IN TESTNOW! ***");
    gc.setFill(Color.BLUE);
    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    gc.setFill(Color.WHITE);
    gc.fillRect(75,75,100,100);
  }

}
