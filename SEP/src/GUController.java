import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class GUController
{
  @FXML private Button overviewButton;
  @FXML private TextField area1;
  @FXML private Pane overviewPane;
  @FXML private Pane instructorsPane;
  @FXML private Pane membersPane;
  @FXML private Pane classesPane;
  @FXML private Pane schedulePane;
  @FXML private Pane screenSaverPane;
  @FXML private Label dateLabel;



  public void init()
  {
    loadOverviewPane();
    setNumberOfMembers();
    setTodayDate();
//    Platform.runLater(() ->
//    {
//      setNumberOfMembers();
//    });
  }

  //SCREEN SAVER PANE METHODS
  public void loadScreenSaver()
  {
    screenSaverPane.setVisible(true);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
  }

  //OVERVIEW PANE METHODS
  public void loadOverviewPane()
  {
    //overviewButton.setStyle("-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(true);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);

  }

  public void setNumberOfMembers()
  {
    area1.setText("545");
  }

  public void setTodayDate()
  {
    dateLabel.setText("21/05/2020");
  }

  //INSTRUCTORS PANE METHODS
  public void loadInstructorsPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(true);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
  }

  //MEMBERS PANE METHODS
  public void loadMembersPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(true);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
  }

  //CLASSES PANE METHODS
  public void loadClassesPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(true);
    schedulePane.setVisible(false);
  }

  //SCHEDULE PANE METHODS
  public void loadSchedulePane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(true);
  }





}
