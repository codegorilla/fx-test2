package sample;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolbarController {

  @FXML
  private ToolBar toolBar;

  @Inject
  private MainController mainController;

  @FXML private void initialize () {
    System.out.println("Toolbar loaded.");
    //toolbar.setFocusTraversable(false);
  }

  public void disableFocusTraversable () {
    toolBar.setFocusTraversable(false);
  }

  @FXML
  public void handleZoomIn (ActionEvent e) {
    //mpc.zoomIn();
  }

  @FXML
  public void handleZoomOut (ActionEvent e) {
    //mpc.zoomOut();
  }

  @FXML
  public void handleToggleGrid (ActionEvent e) {
    //mpc.toggleGrid();
  }

  @FXML
  public void handleDrawPoint (ActionEvent e) {
    //mpc.drawPoint();
  }

  @FXML
  public void handleStartDraw (ActionEvent e) {
    mainController.getChartController().setDrawingMode(ChartController.ROUTE);
  }

  @FXML
  public void handleStopDraw (ActionEvent e) {
    //mpc.stopDraw();
  }

  void testme () {
    System.out.println("Test me! I am a toolbar controller!");
  }
}
