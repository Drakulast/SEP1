import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class GUIController
{
  @FXML private Button overviewButton;
  @FXML private Button instructorsButton;
  @FXML private Button searchInstructorByNameButton;
  @FXML private Button searchInstructorByPhoneButton;
  @FXML private Button membersButton;
  @FXML private Button searchMemberByNameButton;
  @FXML private Button searchMemberByPhoneButton;
  @FXML private Button classesButton;
  @FXML private Button scheduleButton;
  @FXML private Button registerInstructorSaveButton;
  @FXML private Button registerInstructorAddClassButton;

  @FXML private TextField area1;
  @FXML private TextField area2;
  @FXML private TextField area3;
  @FXML private TextField registerInstructorFirstNameInput;
  @FXML private TextField registerInstructorLastNameInput;
  @FXML private TextField registerInstructorAddressInput;
  @FXML private TextField registerInstructorEmailInput;
  @FXML private TextField registerInstructorPhoneInput;
  @FXML private TextField registerInstructorClassInput;
  @FXML private TextField searchInstructorByNameFirstNameInput;
  @FXML private TextField searchInstructorByNameLastNameInput;
  @FXML private TextField searchInstructorByPhoneInput;
  @FXML private TextField editInstructorFirstNameInput;
  @FXML private TextField editInstructorLastNameInput;
  @FXML private TextField editInstructorAddressInput;
  @FXML private TextField editInstructorEmailInput;
  @FXML private TextField editInstructorPhoneInput;
  @FXML private ListView editInstructorClassesInput;

  @FXML private TextField editMemberFirstNameInput;
  @FXML private TextField editMemberLastNameInput;
  @FXML private TextField editMemberAddressInput;
  @FXML private TextField editMemberEmailInput;
  @FXML private TextField editMemberMembershipInput;
  @FXML private TextField editMemberPhoneInput;
  @FXML private TextField searchMemberByPhoneInput;
  @FXML private TextField searchMemberByNameFirstNameInput;
  @FXML private TextField searchMemberByNameLastNameInput;
  @FXML private TextField registerMemberPhoneInput;
  @FXML private TextField registerMemberEmailInput;
  @FXML private TextField registerMemberFirstNameInput;
  @FXML private TextField registerMemberLastNameInput;
  @FXML private TextField registerMemberAddressInput;
  @FXML private ComboBox registerMemberMembershipInput;
  @FXML private Button editMemberSaveButton;
  @FXML private Button editMemberDeleteButton;
  @FXML private Button registerMemberSaveButton;
  @FXML private Button editInstructorDeleteButton;
  @FXML private Button editInstructorSaveButton;
  @FXML private Button editInstructorAddButton;


  @FXML private Pane overviewPane;
  @FXML private Pane instructorsPane;
  @FXML private Pane registerInstructorPane;
  @FXML private Pane findInstructorPane;
  @FXML private Pane searchInstructorByNamePane;
  @FXML private Pane searchInstructorByPhonePane;
  @FXML private Pane editInstructorPane;
  @FXML private Pane membersPane;
  @FXML private Pane registerMemberPane;
  @FXML private Pane findMemberPane;
  @FXML private Pane searchMemberByNamePane;
  @FXML private Pane searchMemberByPhonePane;
  @FXML private Pane editMemberPane;
  @FXML private Pane classesPane;
  @FXML private Pane addClassPane;
  @FXML private Pane searchClassPane;
  @FXML private Pane editClassPane;
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
    setCurrentInstructors();
    setCurrentClasses();
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
  public void setCurrentInstructors()
  {

    area2.setText(String.valueOf(adapter.getAllInstructors().size()));
  }

  public void setCurrentClasses()
  {
    area3.setText(String.valueOf(adapter.getAllClasses().size()));
  }


  public void setTodayDate()
  {
    dateLabel.setText(adapter.today());
  }



  //INSTRUCTORS PANE METHODS
  public void loadInstructorsPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(true);
    registerInstructorPane.setVisible(true);
    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);
    editInstructorPane.setVisible(false);
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

  public void loadRegisterInstructorPane()
  {
    registerInstructorPane.setVisible(true);
    findInstructorPane.setVisible(false);

    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);
  }

  public void loadFindInstructorPane()
  {
    registerInstructorPane.setVisible(false);
    findInstructorPane.setVisible(true);
    searchInstructorByNamePane.setVisible(true);
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setVisible(true);
    searchInstructorByPhoneButton.setVisible(true);
  }

  public void loadSearchInstructorByNamePane()
  {
    searchInstructorByNamePane.setVisible(true);
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);
  }

  public void loadSearchInstructorByPhonePane()
  {
    searchInstructorByNamePane.setVisible(false);
    searchInstructorByPhonePane.setVisible(true);
    editInstructorPane.setVisible(false);
  }

  public void loadEditInstructorPane()
  {
    editInstructorPane.setVisible(true);
    searchInstructorByNamePane.setVisible(false);
    searchInstructorByPhonePane.setVisible(false);


    searchInstructorByNameButton.setVisible(false);
    searchInstructorByPhoneButton.setVisible(false);
  }

  public void searchInstructor()
  {
    loadEditInstructorPane();
  }

  //MEMBERS PANE METHODS
  public void loadMembersPane()
  {
    screenSaverPane.setVisible(false);
    overviewPane.setVisible(false);
    instructorsPane.setVisible(false);
    membersPane.setVisible(true);
    loadRegisterMemberPane();
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

  public void loadRegisterMemberPane()
  {
    registerMemberPane.setVisible(true);
    findMemberPane.setVisible(false);

    searchMemberByNameButton.setVisible(false);
    searchMemberByPhoneButton.setVisible(false);
  }

  public void loadFindMemberPane()
  {
    registerMemberPane.setVisible(false);
    findMemberPane.setVisible(true);
    searchMemberByNamePane.setVisible(true);
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);

    searchMemberByNameButton.setVisible(true);
    searchMemberByPhoneButton.setVisible(true);
  }

  public void loadSearchMemberByNamePane()
  {
    searchMemberByNamePane.setVisible(true);
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);
  }

  public void loadSearchMemberByPhonePane()
  {
    searchMemberByNamePane.setVisible(false);
    searchMemberByPhonePane.setVisible(true);
    editMemberPane.setVisible(false);
  }

  public void loadEditMemberPane()
  {
    editMemberPane.setVisible(true);
    searchMemberByNamePane.setVisible(false);
    searchMemberByPhonePane.setVisible(false);


    searchMemberByNameButton.setVisible(false);
    searchMemberByPhoneButton.setVisible(false);
  }

  public void searchMember()
  {
    loadEditMemberPane();
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

  public void loadAddClassPane()
  {
    addClassPane.setVisible(true);
    searchClassPane.setVisible(false);
  }

  public void loadSearchClassPane()
  {
    addClassPane.setVisible(false);
    searchClassPane.setVisible(true);
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

  // Members functionality for members UI


}
