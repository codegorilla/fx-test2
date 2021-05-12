package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App extends Application {

  @Override
  public void start (Stage stage) throws Exception {
    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    //Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    //Scene scene = new Scene(new StackPane(l), 640, 480);
    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
    Scene scene = new Scene(root, 640, 480);
    stage.setScene(scene);
    stage.show();

// This would go back into main.fxml but then we need a MainController class
//    fx:controller="sample.MainController">

    System.out.println("Squeeze me some guice!");
    Injector injector = Guice.createInjector(new TextEditorModule());
    TextEditor editor = injector.getInstance(TextEditor.class);
    editor.makeSpellCheck();
  }

  public static void main (String[] args) {
    launch();
  }

}
