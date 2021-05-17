package sample;

import com.google.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {

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
    var cPane = (Pane)chart.getChildren().get(0);
    chart.setTopAnchor(cPane, 0.0);
    chart.setLeftAnchor(cPane, 2.0);
    chart.setBottomAnchor(cPane, 0.0);
    chart.setRightAnchor(cPane, 2.0);
  }

  public MenubarController getMenubar () {
    return menubarController;
  }

  public ToolbarController getToolbar () {
    return toolbarController;
  }

  public ChartController getChartController () {
    return chartController;
  }
}
