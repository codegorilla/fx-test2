package sample;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;


public class ContentController {

  @FXML
  private StackPane map;

  @FXML private void initialize () {
    System.out.println("Main window loaded.");
    CanvasPane cPane = new CanvasPane(250, 250);
    GraphicsContext gc = cPane.getCanvas().getGraphicsContext2D();
    gc.setFill(Color.BLACK);
    gc.fillRect(75,75,100,100);
    cPane.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    map.getChildren().add(cPane);
  }
}
