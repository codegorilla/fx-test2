package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;

import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

import javafx.scene.input.MouseEvent; 

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.google.inject.Inject;


public class MainController {

  //@FXML
  //private Button btnSubmit;

  @Inject
  private ChartController chartController;

  @Inject
  private MenubarController menubarController;

  @FXML
  private void initialize () {
    System.out.println("Main window loaded.");

    //sp.setResizableWithParent(vb, false);
    //sp.setDividerPositions(0.25);
    //vb.setMinWidth(0);
    // Doesn't affect min width
    //vb.setVisible(false);
    //btnTest1.setVisible(false);

    //sp.getItems().remove(0);
    //sp.getItems().add(0, vb);

  }

  public MenubarController getMenubar () {
    return menubarController;
  }

  public ChartController getChart () {
    return chartController;
  }
}
