package sample.state;

abstract class State {
  public void leftClick (double x, double y) {}
  public void rightClick (double x, double y) {}
  public abstract void clickDrawButton ();
}
