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
  @FXML private Button instructorsButton;
  @FXML private Button membersButton;
  @FXML private Button classesButton;
  @FXML private Button scheduleButton;

  @FXML private TextField area1;

  @FXML private Pane overviewPane;
  @FXML private Pane instructorsPane;
  @FXML private Pane membersPane;
  @FXML private Pane classesPane;
  @FXML private Pane schedulePane;
  @FXML private Pane screenSaverPane;

  @FXML private Label dateLabel;

  private FitnessCenterFileAdapter adapter;

  public void initialize()
  {
    adapter = new FitnessCenterFileAdapter("TestMembers.bin", "Instructors.bin",
        "Classes.bin", "ScheduledClasses.bin");
    loadOverviewPane();
    setNumberOfMembers();
    setTodayDate();

    System.out.println(adapter.getAllMembers());
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
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(true);
    instructorsPane.setVisible(false);
    membersPane.setVisible(false);
    classesPane.setVisible(false);
    schedulePane.setVisible(false);
    overviewButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
  }

  public void setNumberOfMembers()
  {

    String numberOfMembers = String.valueOf(adapter.getAllMembers().size());
    area1.setText(numberOfMembers);
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
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
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
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
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
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
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
    overviewButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    instructorsButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    membersButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    classesButton.setStyle(
        "-fx-background-color: #12123A;-fx-font-size: 24px;fx-font-weight: bold;");
    scheduleButton.setStyle(
        "-fx-background-color: #000037;-fx-font-size: 24px;fx-font-weight: bold;");
  }

}
