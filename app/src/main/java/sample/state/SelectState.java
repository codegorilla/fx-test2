package sample.state;

class SelectState extends State {
  InteractionManager manager;

  public SelectState (InteractionManager manager) {
    this.manager = manager;
  }

  @Override
  public void leftClick (double x, double y) {
    String msg = String.format("Left-clicked at (%.1f, %.1f).", x, y);
    System.out.println(msg);
    msg = "Attempting to select something.";
    System.out.println(msg);
  }

  @Override
  public void rightClick (double x, double y) {
    String msg = String.format("Right-clicked at (%.1f, %.1f).", x, y);
    System.out.println(msg);
    msg = "Showing context menu.";
    System.out.println(msg);
  }

  @Override
  public void clickDrawButton () {
    String msg = "Clicked draw button.";
    System.out.println(msg);
    msg = "Transitioning from select state to draw state.";
    System.out.println(msg);
    manager.setState(new DrawState(manager));
  }
}
