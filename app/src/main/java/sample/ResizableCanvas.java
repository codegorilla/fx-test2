package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.*;

public class ResizableCanvas extends Canvas {

  @Override
  public boolean isResizable() {
    return true;
  }

  public ResizableCanvas () {
    super();
    widthProperty().addListener(evt -> draw());
    heightProperty().addListener(evt -> draw());
  }

  public ResizableCanvas (double width, double height) {
    super(width, height);
    widthProperty().addListener(evt -> draw());
    heightProperty().addListener(evt -> draw());
  }

  private void draw () {
    System.out.println("Resized!");
    double width = getWidth();
    double height = getHeight();

    var gc = getGraphicsContext2D();
    gc.clearRect(0, 0, width, height);

    gc.setStroke(Color.RED);
    gc.strokeLine(0, 0, width, height);
    gc.strokeLine(0, height, width, 0);
  }

  @Override
  public double prefWidth(double height) {
    return getWidth();
  }

  @Override
  public double prefHeight(double width) {
    return getHeight();
  }
}
