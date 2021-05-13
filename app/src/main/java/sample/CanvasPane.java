package sample;

import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;

public class CanvasPane extends Pane {

  private final Canvas canvas;

  public CanvasPane (double width, double height) {
    canvas = new Canvas(width, height);
    getChildren().add(canvas);
  }

  public Canvas getCanvas () {
    return canvas;
  }

  @Override
  protected void layoutChildren () {
    super.layoutChildren();
    final var x = snappedLeftInset();
    final var y = snappedTopInset();
    final var w = snapSizeX(getWidth()) - x - snappedRightInset();
    final var h = snapSizeY(getHeight()) - y - snappedBottomInset();
    canvas.setLayoutX(x);
    canvas.setLayoutY(y);
    canvas.setWidth(w);
    canvas.setHeight(h);
  }
}
