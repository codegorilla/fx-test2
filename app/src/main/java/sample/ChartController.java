package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.*;

public class ChartController {

  @FXML
  private AnchorPane chart;

  @FXML
  private CanvasPane cPane;

  @FXML
  private void initialize () {
    System.out.println("Main window loaded.");
    chart.setTopAnchor(cPane, 2.0);
    chart.setLeftAnchor(cPane, 2.0);
    chart.setBottomAnchor(cPane, 2.0);
    chart.setRightAnchor(cPane, 2.0);
  }

  @FXML
  public void handleClick (MouseEvent e) {
    System.out.println("HERE! ***");
    var canvas = cPane.getCanvas();
    var gc = cPane.getCanvas().getGraphicsContext2D();
    gc.setFill(Color.RED);
    gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    gc.setFill(Color.BLACK);
    gc.fillRect(75,75,100,100);
  }
}
