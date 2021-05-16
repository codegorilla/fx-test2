package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.inject.Guice;
//import com.google.inject.Injector;

public class App extends Application {

  private final int START_WIDTH  = 960;
  private final int START_HEIGHT = 540;

  private BorderPane root;

  @Override
  public void init () throws Exception {
    System.out.println("Initializing application...");
    var javaVersion = System.getProperty("java.version");
    var javafxVersion = System.getProperty("javafx.version");
    var injector = Guice.createInjector(new GuiceModule());
    var loader = new FXMLLoader(getClass().getResource("main.fxml"));
    loader.setControllerFactory(injector::getInstance);
    root = loader.load();
  }

  @Override
  public void start (Stage stage) throws Exception {
    stage.setTitle("Track Commander");
    stage.setScene(new Scene(root, START_WIDTH, START_HEIGHT));
    stage.show();

    // System.out.println("Squeeze me some guice!");
    // TextEditor editor = injector.getInstance(TextEditor.class);
    // editor.makeSpellCheck();
  }

  public static void main (String[] args) {
    App.launch(args);
  }
}
