package sample.state;

import sample.ResizableCanvas;

public class InteractionManager {

  // Need to put a drawing manager in here or maybe the canvas and
  ResizableCanvas canvas;

  // State pattern
  State selectState;
  State drawState;

  State state;

  public InteractionManager () {
    // Initialize states
    //drawState = new DrawState(this);
    selectState = new SelectState(this);

    state = selectState;
  }

  public void setCanvas (ResizableCanvas canvas) {
    this.canvas = canvas;
    //gc = canvas.getGraphicsContext2D();
  }

  public ResizableCanvas getCanvas () {
    return canvas;
  }

  public void leftClick (double x, double y) {
    state.leftClick(x, y);
  }

  public void rightClick (double x, double y) {
    state.rightClick(x, y);
  }

  public void clickDrawButton () {
    state.clickDrawButton();
  }

  public void setState (State state) {
    this.state = state;
  }

  public State getDrawState () {
    return drawState;
  }

  public State getSelectState () {
    return selectState;
  }
}
