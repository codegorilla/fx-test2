package sample.state;

import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;

import sample.Point;
import sample.ResizableCanvas;

class DrawState extends State {
  InteractionManager manager;

  // Might need to have an external point buffer, otherwise this gets
  // erased whenever the state changes. Perhaps we should be linked
  // directly to some data structure that is used to redraw the canvas?
  LinkedList<Point> points;

  private final double EPSILON = 0.50;

  private int substate;

  private final int BEFORE_FIRST_POINT = 0;
  private final int AFTER_FIRST_POINT = 1;

  public DrawState (InteractionManager manager) {
    this.manager = manager;
    points = new LinkedList<Point>();
    substate = BEFORE_FIRST_POINT;
  }

  @Override
  public void leftClick (double x, double y) {
    String msg = String.format("Left-clicked at (%.1f, %.1f)", x, y);
    System.out.println(msg);

    // Drawing code - can we factor this out into a drawing layer?
    var gc = manager.getCanvas().getGraphicsContext2D();
    var w = 30f;
    var h = 30f;
    gc.setStroke(Color.BLUE);

    if (substate == BEFORE_FIRST_POINT) {
      points.add(new Point(x, y));
      
      // Drawing code
      gc.strokeRect(x + EPSILON - w/2, y + EPSILON - h/2, w, h);

      msg = "Transitioning from draw-1 to draw-2.";
      System.out.println(msg);
      substate = AFTER_FIRST_POINT;
    }
    else if (substate == AFTER_FIRST_POINT) {
      points.add(new Point(x, y));

      // Drawing code
      gc.strokeRect(x + EPSILON - w/2, y + EPSILON - h/2, w, h);

      msg = "No action: already in draw-2.";
      System.out.println(msg);
    }
  }

  @Override
  public void rightClick (double x, double y) {
    String msg = String.format("Right-clicked at (%.1f, %.1f).", x, y);
    System.out.println(msg);
    msg = "Transitioning from draw state to select state.";
    System.out.println(msg);
    msg = String.format("Drew total of %d points.", points.size());
    System.out.println(msg);
    manager.setState(manager.getSelectState());
  }

  @Override
  public void clickDrawButton () {
    String msg = "Clicked the draw button.";
    System.out.println(msg);
    msg = "No action: already in draw state.";
    System.out.println(msg);
  }
}
