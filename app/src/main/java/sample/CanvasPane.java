package sample;

import javafx.scene.layout.Pane;

public class CanvasPane extends Pane {

  private final ResizableCanvas canvas;

  public CanvasPane () {
    // In order to be used in FXML, the constructor cannot take any arguments
    super();
    canvas = new ResizableCanvas(960, 540);
    getChildren().add(canvas);
    canvas.widthProperty().bind(this.widthProperty());
    canvas.heightProperty().bind(this.heightProperty());
  }

  public ResizableCanvas getCanvas () {
   return canvas;
  }

  // Alternative to binding
  // @Override
  // protected void layoutChildren () {
  //   super.layoutChildren();
  //   final var x = snappedLeftInset();
  //   final var y = snappedTopInset();
  //   final var w = snapSizeX(getWidth()) - x - snappedRightInset();
  //   final var h = snapSizeY(getHeight()) - y - snappedBottomInset();
  //   canvas.setLayoutX(x);
  //   canvas.setLayoutY(y);
  //   canvas.setWidth(w);
  //   canvas.setHeight(h);
  // }
}
