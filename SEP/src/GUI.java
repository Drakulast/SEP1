import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application
{

  public void start(Stage window) throws IOException
  {
    GUController controller;
    window.setTitle("VIAFit");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("GUI.fxml"));
    Scene scene = new Scene(loader.load());
    controller = loader.getController();
    controller.init();
    window.setResizable(false);
    window.setScene(scene);
    window.show();

  }

}


