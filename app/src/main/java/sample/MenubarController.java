package sample;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;



public class MenubarController {

  @FXML
  private MenuBar menuBar;
  
  @FXML
  private MenuItem miExit;

  @Inject
  private MainController mainController;

  @FXML
  private void initialize () {
    System.out.println("Menubar loaded.");
  }

  @FXML
  public
  void handleZoomIn (ActionEvent e) {
//    mpc.zoomIn();
  }

  @FXML
  public void handleZoomOut (ActionEvent e) {
//    mpc.zoomOut();
  }

  @FXML
  void handleCopy (ActionEvent e) {
    System.out.println("You have selected File -> Copy!");
    mainController.getChart().testnow();
    
    // Now we want to do some action on the canvas
    // How to get a hold of the canvas?
    // Only way seems to use the chart controller to register the canvas
    // with some app context, then as the app context for the canvas
    // Is another option dependency injection?
//    tc.testme();
  }

  @FXML
  void handleExit (ActionEvent e) {
    System.out.println("User wants to exit. Please delete your computer.");
    dispose();
    Stage stage = (Stage) menuBar.getScene().getWindow();
    // do what you have to do
    stage.close();
  }

  void dispose () {
    // if (mapView != null) {
    //   mapView.dispose();
    // }
  }

//  void setToolbarController (ToolbarController tc) {
//    this.tc = tc;
//  }


  void testme () {
    System.out.println("Test me! I am a menubar controller!");
  }

//  void setMapPaneController (MapPaneController mpc) {
//    this.mpc = mpc;
//  }

}
