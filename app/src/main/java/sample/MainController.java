package sample;

import com.google.inject.Inject;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;

import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;

import javafx.scene.input.MouseEvent; 

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {

  //@FXML
  //private Button btnSubmit;

  @FXML
  private AnchorPane chart;

  @FXML
  private ChartController chartController;

  @FXML
  private MenubarController menubarController;

  @FXML
  private ToolbarController toolbarController;

  @FXML
  private void initialize () {
    System.out.println("Main window loaded.");
    if (chart == null)
      System.out.println("AP IS NULL!!!");

    var cPane = chart.getChildren().get(0);
    chart.setTopAnchor(cPane, 0d);
    chart.setLeftAnchor(cPane, 2d);
    chart.setBottomAnchor(cPane, 0d);
    chart.setRightAnchor(cPane, 2d);


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

  public ToolbarController getToolbar () {
    return toolbarController;
  }

  public ChartController getChart () {
    return chartController;
  }
}
