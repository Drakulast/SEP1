import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class GUIController
{
  @FXML private Button overviewButton;
  @FXML private Button instructorsButton;
  @FXML private Button registerInstructorButton;
  @FXML private Button findEditInstructorButton;
  @FXML private Button searchInstructorByNameButton;
  @FXML private Button searchInstructorByPhoneButton;
  @FXML private Button membersButton;
  @FXML private Button registerMemberButton;
  @FXML private Button findEditMemberButton;
  @FXML private Button searchMemberByNameButton;
  @FXML private Button searchMemberByPhoneButton;
  @FXML private Button classesButton;
  @FXML private Button addClassButton;
  @FXML private Button findEditClassButton;
  @FXML private Button scheduleButton;
  @FXML private Button scheduleClassButton;
  @FXML private Button findEditScheduleButton;
  @FXML private Button editScheduledClassButton;
  @FXML private Button removeScheduledClassPaneButton;
  @FXML private Button signUpMemberScheduledClassButton;
  @FXML private Button cancelMemberScheduledClassButton;
  @FXML private Button exportScheduledClassButton;
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
  @FXML private TextField addClassToInstructorInput;

  @FXML private TextField editMemberFirstNameInput;
  @FXML private TextField editMemberLastNameInput;
  @FXML private TextField editMemberAddressInput;
  @FXML private TextField editMemberEmailInput;
  @FXML private ComboBox<String> editMemberMembershipInput;
  @FXML private TextField editMemberPhoneInput;
  @FXML private TextField searchMemberByPhoneInput;
  @FXML private TextField searchMemberByNameFirstNameInput;
  @FXML private TextField searchMemberByNameLastNameInput;
  @FXML private TextField registerMemberPhoneInput;
  @FXML private TextField registerMemberEmailInput;
  @FXML private TextField registerMemberFirstNameInput;
  @FXML private TextField registerMemberLastNameInput;
  @FXML private TextField registerMemberAddressInput;
  @FXML private ComboBox<String> registerMemberMembershipInput;
  @FXML private Button editMemberSaveButton;
  @FXML private Button editMemberDeleteButton;
  @FXML private Button registerMemberSaveButton;
  @FXML private Button editInstructorDeleteButton;
  @FXML private Button editInstructorSaveButton;
  @FXML private Button editInstructorAddButton;

  @FXML private TextField addClassNameInput;
  @FXML private TextField addClassCapacityInput;
  @FXML private TextField searchClassNameInput;
  @FXML private TextField ediClassNameInput;
  @FXML private TextField editClassCapacityInput;
  @FXML private Button addClassSaveButton;
  @FXML private Button searchClassButton;
  @FXML private Button editClassSaveButton;
  @FXML private Button editClassRemoveButton;

  @FXML private TextField scheduleClassHourInput;
  @FXML private TextField scheduleClassMinuteInput;
  @FXML private TextField scheduleClassDurationInput;
  @FXML private TextField editScheduledClassHourInput;
  @FXML private TextField editScheduledClassMinuteInput;
  @FXML private TextField editScheduledClassDurationInput;
  @FXML private TextField scheduledClassNameOutput;
  @FXML private TextField scheduledClassDateOutput;
  @FXML private TextField scheduledClassDurationOutput;
  @FXML private TextField scheduledClassInstructorOutput;
  @FXML private TextField scheduledClassTimeOutput;
  @FXML private TextField scheduledClassCapacityOutput;
  @FXML private TextField scheduleExportYearInput;
  @FXML private ListView searchScheduledClassListView;
  @FXML private TextArea scheduledClassMembersOutput;
  @FXML private TextArea scheduleExportScheduleOutput;
  @FXML private DatePicker scheduleClassDateInput;
  @FXML private DatePicker searchScheduledClassFromInput;
  @FXML private DatePicker searchScheduledClassToInput;
  @FXML private DatePicker editScheduledClassDateInput;
  @FXML private ComboBox<String> scheduleClassClassInput;
  @FXML private ComboBox<String> scheduleClassInstructorInput;
  @FXML private ComboBox<String> editScheduledClassClassInput;
  @FXML private ComboBox<String> editScheduledClassInstructorInput;
  @FXML private ComboBox<Member> signUpScheduledClassPremiumMembersInput;
  @FXML private ComboBox<Member> cancelScheduledClassAttendingMemberInput;
  @FXML private ComboBox<String> scheduleExportMonthInput;
  @FXML private Button scheduleClassSaveButton;
  @FXML private Button searchScheduledClassButton;
  @FXML private Button editScheduledClassSaveButton;
  @FXML private Button removeScheduledClassButton;
  @FXML private Button signUpMemberButton;
  @FXML private Button scheduleExportGetScheduleButton;
  @FXML private Button scheduleExportButton;

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
  @FXML private Pane schedulePane;
  @FXML private Pane scheduleClassPane;
  @FXML private Pane scheduleDisplayEditExportPane;
  @FXML private Pane scheduleDisplayPane;
  @FXML private Pane scheduleEditPane;
  @FXML private Pane scheduleRemovePane;
  @FXML private Pane scheduleSignUpMemberPane;
  @FXML private Pane scheduleCancelMemberPane;
  @FXML private Pane scheduleExportPane;
  @FXML private Pane scheduleLogoPane;
  @FXML private Pane screenSaverPane;

  @FXML private Label dateLabel;

  private FitnessCenterFileAdapter adapter;
  private ArrayList<String> instrAddClasses = new ArrayList<String>();
  private ArrayList<String> indicatorArray = new ArrayList<String>();
  private int instructorIndicator = 0;
  private int classIndicator = 0;
  private int memberIndicator;
  private boolean searchMemberBy;
  private String darkBgButton = "-fx-background-color: #717171;";
  private String lightBgButton = "-fx-background-color: #b8b8b8;";
  private ArrayList<Member> premiumMembers;
  private ArrayList<String> months;

  public void initialize()
  {
    adapter = new FitnessCenterFileAdapter("TestMembers.bin", "Instructors.bin",
        "Classes.bin", "ScheduledClasses.bin");
    loadOverviewPane();
    setNumberOfMembers();
    setCurrentInstructors();
    setCurrentClasses();
    setTodayDate();
    registerMemberMembershipInput.getItems().add("Standard");
    registerMemberMembershipInput.getItems().add("Premium");
    editMemberMembershipInput.getItems().add("Standard");
    editMemberMembershipInput.getItems().add("Premium");

    //System.out.println(adapter.getAllMembers());
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
    loadRegisterInstructorPane();
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

    registerInstructorButton.setStyle(darkBgButton);
    findEditInstructorButton.setStyle(lightBgButton);
  }

  public void loadFindInstructorPane()
  {
    registerInstructorPane.setVisible(false);
    findInstructorPane.setVisible(true);
    loadSearchInstructorByNamePane();
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setVisible(true);
    searchInstructorByPhoneButton.setVisible(true);

    registerInstructorButton.setStyle(lightBgButton);
    findEditInstructorButton.setStyle(darkBgButton);
  }

  public void loadSearchInstructorByNamePane()
  {
    searchInstructorByNamePane.setVisible(true);
    searchInstructorByPhonePane.setVisible(false);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setStyle(darkBgButton);
    searchInstructorByPhoneButton.setStyle(lightBgButton);
  }

  public void loadSearchInstructorByPhonePane()
  {
    searchInstructorByNamePane.setVisible(false);
    searchInstructorByPhonePane.setVisible(true);
    editInstructorPane.setVisible(false);

    searchInstructorByNameButton.setStyle(lightBgButton);
    searchInstructorByPhoneButton.setStyle(darkBgButton);
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

    registerMemberButton.setStyle(darkBgButton);
    findEditMemberButton.setStyle(lightBgButton);
  }

  public void loadFindMemberPane()
  {
    registerMemberPane.setVisible(false);
    findMemberPane.setVisible(true);
    loadSearchMemberByNamePane();
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);
    searchMemberByNameButton.setVisible(true);
    searchMemberByPhoneButton.setVisible(true);

    registerMemberButton.setStyle(lightBgButton);
    findEditMemberButton.setStyle(darkBgButton);
  }

  public void loadSearchMemberByNamePane()
  {
    searchMemberByNamePane.setVisible(true);
    searchMemberByPhonePane.setVisible(false);
    editMemberPane.setVisible(false);

    searchMemberByNameButton.setStyle(darkBgButton);
    searchMemberByPhoneButton.setStyle(lightBgButton);
  }

  public void loadSearchMemberByPhonePane()
  {
    searchMemberByNamePane.setVisible(false);
    searchMemberByPhonePane.setVisible(true);
    editMemberPane.setVisible(false);

    searchMemberByNameButton.setStyle(lightBgButton);
    searchMemberByPhoneButton.setStyle(darkBgButton);
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
    loadAddClassPane();
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

    addClassButton.setStyle(darkBgButton);
    findEditClassButton.setStyle(lightBgButton);
  }

  public void loadSearchClassPane()
  {
    addClassPane.setVisible(false);
    searchClassPane.setVisible(true);

    addClassButton.setStyle(lightBgButton);
    findEditClassButton.setStyle(darkBgButton);
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
    loadScheduleClassPane();
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

    scheduleClassDateInput.setValue(null);
    scheduleClassHourInput.clear();
    scheduleClassMinuteInput.clear();
    scheduleClassDurationInput.clear();
    scheduleClassClassInput.getItems().clear();
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      scheduleClassClassInput.getItems()
          .add(adapter.getAllClasses().get(i).getName());
    }

    scheduleClassInstructorInput.getItems().clear();
  }

  public void loadScheduleClassPane()
  {
    scheduleClassPane.setVisible(true);
    scheduleDisplayEditExportPane.setVisible(false);
    scheduleClassDateInput.setValue(null);
    scheduleClassHourInput.clear();
    scheduleClassMinuteInput.clear();
    scheduleClassDurationInput.clear();
    scheduleClassClassInput.getItems().clear();
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      scheduleClassClassInput.getItems()
          .add(adapter.getAllClasses().get(i).getName());
    }
    scheduleClassInstructorInput.getItems().clear();

    scheduleClassButton.setStyle(darkBgButton);
    findEditScheduleButton.setStyle(lightBgButton);
  }

  public void loadScheduleDisplayEditExportPane()
  {
    scheduleClassPane.setVisible(false);
    scheduleDisplayEditExportPane.setVisible(true);
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(true);

    scheduleClassButton.setStyle(lightBgButton);
    findEditScheduleButton.setStyle(darkBgButton);
    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
    searchScheduledClassFromInput.setValue(null);
    searchScheduledClassToInput.setValue(null);
    searchScheduledClassListView.getItems().clear();
  }

  public void loadScheduleEditPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(true);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(darkBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
    editScheduledClassHourInput.clear();
    editScheduledClassMinuteInput.clear();
    editScheduledClassClassInput.getItems().clear();
    editScheduledClassDurationInput.clear();
    editScheduledClassInstructorInput.getItems().clear();
    editScheduledClassDateInput.setValue(null);

  }

  public void loadScheduleRemovePane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(true);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);
    scheduledClassDateOutput.clear();
    scheduledClassTimeOutput.clear();
    scheduledClassNameOutput.clear();
    scheduledClassInstructorOutput.clear();
    scheduledClassDurationOutput.clear();
    scheduledClassCapacityOutput.clear();

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(darkBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  public void loadScheduleSignUpMemberPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(true);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(darkBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  public void loadScheduleCancelMemberPane()
  {
    scheduleDisplayPane.setVisible(true);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(true);
    scheduleExportPane.setVisible(false);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(darkBgButton);
    exportScheduledClassButton.setStyle(lightBgButton);
  }

  public void loadScheduleExportPane()
  {
    scheduleDisplayPane.setVisible(false);
    scheduleEditPane.setVisible(false);
    scheduleRemovePane.setVisible(false);
    scheduleSignUpMemberPane.setVisible(false);
    scheduleCancelMemberPane.setVisible(false);
    scheduleExportPane.setVisible(true);
    scheduleLogoPane.setVisible(false);

    editScheduledClassButton.setStyle(lightBgButton);
    removeScheduledClassPaneButton.setStyle(lightBgButton);
    signUpMemberScheduledClassButton.setStyle(lightBgButton);
    cancelMemberScheduledClassButton.setStyle(lightBgButton);
    exportScheduledClassButton.setStyle(darkBgButton);

    scheduleExportMonthInput.setValue(null);
    scheduleExportScheduleOutput.clear();
    scheduleExportYearInput.clear();
    loadMonths();
  }
  //------------------------------------Alert Panel-----------------------------------------------

  public void messageWarning(String message)
  {
    Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText("Warning!");
    alert.setTitle(null);
    alert.showAndWait();
  }

  public void messageError(String message)
  {
    Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setTitle(null);
    alert.setHeaderText("Error!");
    alert.showAndWait();
  }

  public void messageNone(String message)
  {
    Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText(null);
    alert.setTitle(null);
    alert.showAndWait();
  }

  public void messageInformation(String message)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
    alert.setContentText(message);
    alert.setHeaderText(null);
    alert.setTitle(null);
    alert.showAndWait();
  }

  public boolean messageConfirmation(String message, Alert.AlertType alertType)
  {
    Alert alert = new Alert(alertType, "", ButtonType.OK, ButtonType.CANCEL);
    alert.setContentText(message);
    alert.setTitle(null);
    alert.setHeaderText("Confirmation");
    alert.showAndWait();
    if (alert.getResult() == ButtonType.OK)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  //------------------------------------Instructor------------------------------------------------
  public void mouseClickOnAdd()
  {
    instrAddClasses.add(registerInstructorClassInput.getText());
    registerInstructorClassInput.setText("");

  }

  public void saveAndRegisterInstructor()
  {
    if (adapter.getInstructor(registerInstructorPhoneInput.getText()) == null)
    {
      Instructor tempInstructor = new Instructor(
          registerInstructorFirstNameInput.getText(),
          registerInstructorLastNameInput.getText(),
          registerInstructorAddressInput.getText(),
          registerInstructorEmailInput.getText(),
          registerInstructorPhoneInput.getText(), instrAddClasses);
      adapter.saveInstructors("Instructors.bin", tempInstructor);
      messageInformation("Instructor Added!");
      instrAddClasses.clear();
      registerInstructorFirstNameInput.setText("");
      registerInstructorLastNameInput.setText("");
      registerInstructorAddressInput.setText("");
      registerInstructorEmailInput.setText("");
      registerInstructorPhoneInput.setText("");
      System.out.println(tempInstructor);
      setCurrentInstructors();
    }
    else
    {
      messageWarning("An instructor with this phone number already exists");
    }
  }

  public void searchInstructorByName()
  {
    editInstructorClassesInput.getItems().clear();
    int ex = 0;
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {

      if (searchInstructorByNameFirstNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getFirstName())
          && searchInstructorByNameLastNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getLastName()))
      {
        instructorIndicator = i;
        ex = 1;
        editInstructorFirstNameInput
            .setText(adapter.getAllInstructors().get(i).getFirstName());
        editInstructorLastNameInput
            .setText(adapter.getAllInstructors().get(i).getLastName());
        editInstructorAddressInput
            .setText(adapter.getAllInstructors().get(i).getAddress());
        editInstructorEmailInput
            .setText(adapter.getAllInstructors().get(i).getEmail());
        editInstructorPhoneInput
            .setText(adapter.getAllInstructors().get(i).getPhoneNumber());
        for (int b = 0;
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
        loadEditInstructorPane();
        break;
      }

    }
    if (ex == 0)
    {
      messageWarning("Instructor not found!");
    }
    searchInstructorByNameFirstNameInput.clear();
    searchInstructorByNameLastNameInput.clear();
  }

  public void searchInstructorByPhoneNumber()
  {
    editInstructorClassesInput.getItems().clear();
    int ex = 0;
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (searchInstructorByPhoneInput.getText()
          .equals(adapter.getAllInstructors().get(i).getPhoneNumber()))
      {
        ex = 1;
        instructorIndicator = i;

        editInstructorFirstNameInput
            .setText(adapter.getAllInstructors().get(i).getFirstName());
        editInstructorLastNameInput
            .setText(adapter.getAllInstructors().get(i).getLastName());
        editInstructorAddressInput
            .setText(adapter.getAllInstructors().get(i).getAddress());
        editInstructorEmailInput
            .setText(adapter.getAllInstructors().get(i).getEmail());
        editInstructorPhoneInput
            .setText(adapter.getAllInstructors().get(i).getPhoneNumber());
        for (int b = 0;
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
        loadEditInstructorPane();
        break;
      }
    }
    if (ex == 0)
    {
      messageWarning("Instructor not found!");
    }
    searchInstructorByPhoneInput.clear();
  }

  public void addInstructorClassListView()
  {
    Instructor tempInstructor = adapter.getAllInstructors()
        .get(instructorIndicator);
    tempInstructor.getClasses().add(addClassToInstructorInput.getText());
    editInstructorClassesInput.getItems()
        .add(addClassToInstructorInput.getText());
    adapter
        .editInstructor("Instructors.bin", instructorIndicator, tempInstructor);
    addClassToInstructorInput.setText("");

  }

  public void removeInstructorClassListView()
  {
    for (int i = 0;
         i < adapter.getAllInstructors().get(instructorIndicator).getClasses()
             .size(); i++)
    {
      if (addClassToInstructorInput.getText().equals(
          adapter.getAllInstructors().get(instructorIndicator).getClasses()
              .get(i)))
      {
        Instructor tempInstructor = adapter.getAllInstructors()
            .get(instructorIndicator);
        tempInstructor.getClasses().remove(i);

        adapter.editInstructor("Instructors.bin", instructorIndicator,
            tempInstructor);
        editInstructorClassesInput.getItems().remove(i);
        addClassToInstructorInput.setText("");
      }
    }
  }

  public void saveEditedInstructor()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      Instructor tempInstructor = adapter.getAllInstructors()
          .get(instructorIndicator);
      tempInstructor.setFirstName(editInstructorFirstNameInput.getText());
      tempInstructor.setLastName(editInstructorLastNameInput.getText());
      tempInstructor.setAddress(editInstructorAddressInput.getText());
      tempInstructor.setEmail(editInstructorEmailInput.getText());
      tempInstructor.setPhoneNumber(editInstructorPhoneInput.getText());
      System.out.println(adapter.getAllInstructors().get(instructorIndicator));
      adapter.editInstructor("Instructors.bin", instructorIndicator,
          tempInstructor);

      System.out.println(adapter.getAllInstructors().get(instructorIndicator));
      loadFindInstructorPane();
      loadSearchInstructorByNamePane();
      setCurrentInstructors();

    }
  }

  public void deleteInstructor()
  {
    if (messageConfirmation("Do you want to delete this instructor?",
        Alert.AlertType.WARNING))
    {
      System.out.println(adapter.getAllInstructors().size());
      adapter.removeInstructor("Instructors.bin",
          adapter.getAllInstructors().get(instructorIndicator));
      editInstructorFirstNameInput.setText("");
      editInstructorLastNameInput.setText("");
      editInstructorAddressInput.setText("");
      editInstructorEmailInput.setText("");
      editInstructorPhoneInput.setText("");
      editInstructorClassesInput.getItems().clear();
      System.out.println(adapter.getAllInstructors().size());
      loadFindInstructorPane();
      searchInstructorByNameFirstNameInput.setText("");
      searchInstructorByNameLastNameInput.setText("");
      loadSearchInstructorByNamePane();
      setCurrentInstructors();
    }
  }
  // -------------------------Members----------------------------------

  public void registerMember()
  {
    if (adapter.getMember(registerMemberPhoneInput.getText()) == null)
    {
      Member newMember = new Member(registerMemberFirstNameInput.getText(),
          registerMemberLastNameInput.getText(),
          registerMemberAddressInput.getText(),
          registerMemberEmailInput.getText(), registerMemberPhoneInput.getText());
      registerMemberFirstNameInput.clear();
      registerMemberLastNameInput.clear();
      registerMemberAddressInput.clear();
      registerMemberEmailInput.clear();
      registerMemberPhoneInput.clear();
      if (registerMemberMembershipInput.getValue().equals("Premium"))
      {
        newMember.upgradeMembership();
      }
      adapter.saveMembers("TestMembers.bin", newMember);
      setNumberOfMembers();
      registerMemberMembershipInput.setValue(null);
      messageInformation("Member Added!");
    }
    else
    {
      messageWarning("A member with this phone number already exists");
    }

  }

  public void searchMemberByName()
  {
    String firstName = searchMemberByNameFirstNameInput.getText();
    String lastName = searchMemberByNameLastNameInput.getText();
    ArrayList<Member> members = adapter.getAllMembers();


    int ok=0;
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getFirstName().equals(firstName) && members.get(i)
          .getLastName().equals(lastName))
      {
        ok++;
      }
    }

    int ex = 0;
    if(ok==1)
    {
      for (int i = 0; i < members.size(); i++)
      {
        if (members.get(i).getFirstName().equals(firstName) && members.get(i)
            .getLastName().equals(lastName))
        {
          ex = 1;
          memberIndicator = i;
          searchMemberBy = true;
          editMemberFirstNameInput.setText(members.get(i).getFirstName());
          editMemberLastNameInput.setText(members.get(i).getLastName());
          editMemberAddressInput.setText(members.get(i).getAddress());
          editMemberEmailInput.setText(members.get(i).getEmail());
          editMemberPhoneInput.setText(members.get(i).getPhoneNumber());
          if (members.get(i).hasPremiumMembership())
          {
            editMemberMembershipInput.getSelectionModel().select("Premium");
          }
          else
          {
            editMemberMembershipInput.getSelectionModel().select("Standard");
          }
          loadEditMemberPane();
          break;
        }
      }
      if (ex == 0)
      {
        messageWarning("Member not found!");
      }
    }
    else
    {
      messageWarning("More members with this name have been found.\n Try to search by phone number.");
    }
    searchMemberByNameFirstNameInput.clear();
    searchMemberByNameLastNameInput.clear();
  }

  public void searchMemberByPhoneNumber()
  {
    String phoneNumber = searchMemberByPhoneInput.getText();
    int ex = 0;
    ArrayList<Member> members = adapter.getAllMembers();
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhoneNumber().equals(phoneNumber))
      {
        ex = 1;
        memberIndicator = i;
        searchMemberBy = false;
        editMemberFirstNameInput.setText(members.get(i).getFirstName());
        editMemberLastNameInput.setText(members.get(i).getLastName());
        editMemberAddressInput.setText(members.get(i).getAddress());
        editMemberEmailInput.setText(members.get(i).getEmail());
        editMemberPhoneInput.setText(members.get(i).getPhoneNumber());
        if (members.get(i).hasPremiumMembership())
        {
          editMemberMembershipInput.getSelectionModel().select("Premium");
        }
        else
        {
          editMemberMembershipInput.getSelectionModel().select("Standard");
        }
        loadEditMemberPane();
        break;
      }
    }
    if (ex == 0)
    {
      messageWarning("Member not found!");
    }
    searchMemberByPhoneInput.clear();
  }

  public void saveMember()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      Member tempMember = adapter.getAllMembers().get(memberIndicator);
      tempMember.setFirstName(editMemberFirstNameInput.getText());
      tempMember.setLastName(editMemberLastNameInput.getText());
      tempMember.setAddress(editMemberAddressInput.getText());
      tempMember.setEmail(editMemberEmailInput.getText());
      tempMember.setPhoneNumber(editMemberPhoneInput.getText());
      if (editMemberMembershipInput.getValue().equals("Premium"))
      {
        tempMember.upgradeMembership();
      }
      else
      {
        tempMember.downgradeMembership();
      }

      adapter.editMember("TestMembers.bin", memberIndicator, tempMember);
      setNumberOfMembers();
      if (searchMemberBy)
      {
        loadFindMemberPane();
        loadSearchMemberByNamePane();
        searchMemberByNameFirstNameInput.setText("");
        searchMemberByNameLastNameInput.setText("");
      }
      else
      {
        loadFindMemberPane();
        loadSearchMemberByPhonePane();
        searchMemberByPhoneInput.setText("");
      }
    }
  }

  public void deleteMember()
  {
    if (messageConfirmation("Do you want to delete this member?",
        Alert.AlertType.WARNING))
    {
      adapter.removeMember("TestMembers.bin",
          adapter.getAllMembers().get(memberIndicator));
      setNumberOfMembers();

      if (searchMemberBy)
      {
        loadFindMemberPane();
        loadSearchMemberByNamePane();
        searchMemberByNameFirstNameInput.setText("");
        searchMemberByNameLastNameInput.setText("");
      }
      else
      {
        loadFindMemberPane();
        loadSearchMemberByPhonePane();
        searchMemberByPhoneInput.setText("");
      }
    }
  }

  // -------------------------Classes----------------------------------
  public void saveAddedClasses()
  {
    if (addClassCapacityInput.getText().matches("[0-9]+"))
    {
      System.out.println(adapter.getAllClasses());
      Class tempClass = new Class("No Name", 0);
      tempClass.setName(addClassNameInput.getText());
      int a = Integer.parseInt(addClassCapacityInput.getText());
      tempClass.setMaxCapacity(a);
      adapter.saveClasses("Classes.bin", tempClass);
      setCurrentClasses();
      addClassNameInput.clear();
      addClassCapacityInput.clear();
      System.out.println(adapter.getAllClasses());
      addClassNameInput.setText("");
      addClassCapacityInput.setText("");
    }
    else
    {
      messageWarning("Maximum capacity needs to be a number!");
    }
  }

  public void searchClassesByName()
  {
    int ex = 0;
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      if (searchClassNameInput.getText()
          .equals(adapter.getAllClasses().get(i).getName()))
      {
        ex = 1;
        classIndicator = i;
        ediClassNameInput.setText(adapter.getAllClasses().get(i).getName());
        editClassCapacityInput.setText(
            String.valueOf(adapter.getAllClasses().get(i).getMaxCapacity()));
      }
      else
      {

        System.out.println(
            "If this message appears " + adapter.getAllClasses().size()
                + " then it didnt find class");
      }
    }
    if (ex == 0)
    {
      messageWarning("Class not found!");
    }
  }

  public void saveEditedClass()
  {
    if (messageConfirmation("Do you want to save?",
        Alert.AlertType.CONFIRMATION))
    {
      System.out.println(adapter.getAllClasses());
      Class tempClass = new Class(ediClassNameInput.getText(),
          Integer.parseInt(editClassCapacityInput.getText()));
      adapter.editClass("Classes.bin", classIndicator, tempClass);
      setCurrentClasses();
      System.out.println(adapter.getAllClasses());
    }
  }

  public void removeClass()
  {
    if (messageConfirmation("Do you want to delete this class?",
        Alert.AlertType.WARNING))
    {
      System.out.println(adapter.getAllClasses());
      adapter.removeClass("Classes.bin",
          adapter.getAllClasses().get(classIndicator));
      setCurrentClasses();
      ediClassNameInput.clear();
      editClassCapacityInput.clear();
      searchClassNameInput.clear();
      System.out.println(adapter.getAllClasses());
    }
  }

  // -------------------------Schedule----------------------------------
  public void comboBoxClass()
  {
    if (scheduleClassClassInput.getSelectionModel().getSelectedItem() != null)
    {
      comboBoxDependency();
    }
    else
    {
      scheduleClassClassInput.getItems().clear();
    }
  }

  public void comboBoxDependency()
  {
    scheduleClassInstructorInput.getItems().clear();
    String tempString = scheduleClassClassInput.getSelectionModel()
        .getSelectedItem();
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (adapter.getAllInstructors().get(i).hasClass(tempString))
      {
        String help = adapter.getAllInstructors().get(i).getFullName();
        if (!scheduleClassInstructorInput.getItems().contains(help))
        {
          scheduleClassInstructorInput.getItems()
              .add(adapter.getAllInstructors().get(i).getFullName());
        }
      }
    }

  }

  public void schedule()
  {
    int test = -1;
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (adapter.getAllInstructors().get(i).getFullName().equals(
          scheduleClassInstructorInput.getSelectionModel().getSelectedItem()))
      {
        test = i;
      }
    }
    System.out.println("test");
    System.out.println(adapter.getAllScheduledClasses());
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    tempDateTime
        .setMinute(Integer.parseInt(scheduleClassMinuteInput.getText()));
    tempDateTime.setHour(Integer.parseInt(scheduleClassHourInput.getText()));
    tempDateTime.setYear(scheduleClassDateInput.getValue().getYear());
    tempDateTime.setMonth(scheduleClassDateInput.getValue().getMonthValue());
    tempDateTime.setDay(scheduleClassDateInput.getValue().getDayOfMonth());
    Class tempClass = adapter.getAllClasses()
        .get(scheduleClassClassInput.getSelectionModel().getSelectedIndex());
    Instructor tempInstructor = adapter.getAllInstructors().get(test);

    ArrayList<Member> tempMembers = new ArrayList<Member>();

    ScheduledClass tempScheduledClass = new ScheduledClass(tempClass,
        tempInstructor, tempDateTime, tempMembers,
        Integer.parseInt(scheduleClassDurationInput.getText()));
    adapter.saveScheduleClasses("ScheduledClasses.bin", tempScheduledClass);
    messageInformation("Class Scheduled!");
    scheduleClassDateInput.setValue(null);
    scheduleClassHourInput.clear();
    scheduleClassMinuteInput.clear();
    scheduleClassDurationInput.clear();
    scheduleClassClassInput.getItems().clear();
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      scheduleClassClassInput.getItems()
          .add(adapter.getAllClasses().get(i).getName());
    }
    scheduleClassInstructorInput.getItems().clear();
    System.out.println("test");
    System.out.println(adapter.getAllScheduledClasses());
    System.out.println(adapter.getAllInstructors());
  }

  public void searchForScheduledClasses()
  {
    searchScheduledClassListView.getItems().clear();
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClass = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    for (int i = 0; i < tempScheduledClass.size(); i++)
    {
      searchScheduledClassListView.getItems().add(
          tempScheduledClass.get(i).getClassItem().getName() + ", "
              + tempScheduledClass.get(i).getDateTime());
    }
    loadScheduleEditPane();
  }

  public void editSchedule()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClass = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();

    scheduledClassDateOutput
        .setText(tempScheduledClass.get(index).getDateTime().getDate());
    scheduledClassTimeOutput
        .setText(tempScheduledClass.get(index).getDateTime().getTime());
    scheduledClassNameOutput
        .setText(tempScheduledClass.get(index).getClassItem().getName());
    scheduledClassInstructorOutput
        .setText(tempScheduledClass.get(index).getInstructor().getFullName());
    scheduledClassDurationOutput
        .setText(String.valueOf(tempScheduledClass.get(index).getDuration()));
    scheduledClassCapacityOutput.setText(String.valueOf(
        tempScheduledClass.get(index).getClassItem().getMaxCapacity()));
    String membersOutput = "";
    for (int j = 0; j < tempScheduledClass.get(index).getMembers().size(); j++)
    {
      membersOutput += tempScheduledClass.get(index).getMembers().get(j) + "\n";
    }
    scheduledClassMembersOutput.setText(membersOutput);

    signUpScheduledClassPremiumMembersInput.getItems().clear();
    updatePremiumMembers();
    loadPremiumMembersForSignUp();

    cancelScheduledClassAttendingMemberInput.getItems().clear();
    loadMemberAttendanceList();

    LocalDate tempLocal = LocalDate
        .of(tempScheduledClass.get(index).getDateTime().getYear(),
            tempScheduledClass.get(index).getDateTime().getMonth(),
            tempScheduledClass.get(index).getDateTime().getDay());
    editScheduledClassDateInput.setValue(tempLocal);

    editScheduledClassHourInput.setText(
        String.valueOf(tempScheduledClass.get(index).getDateTime().getHour()));
    editScheduledClassMinuteInput.setText(String
        .valueOf(tempScheduledClass.get(index).getDateTime().getMinute()));
    editScheduledClassDurationInput
        .setText(String.valueOf(tempScheduledClass.get(index).getDuration()));

    //Classes
    for (int i = 0; i < adapter.getAllClasses().size(); i++)
    {
      if (!(editScheduledClassClassInput.getItems()
          .contains(adapter.getAllClasses().get(i).getName())))
      {
        editScheduledClassClassInput.getItems()
            .add(adapter.getAllClasses().get(i).getName());
      }

    }
    for (int b = 0; b < editScheduledClassClassInput.getItems().size(); b++)
    {
      if (editScheduledClassClassInput.getItems().get(b)
          .contains(tempScheduledClass.get(index).getClassItem().getName()))
      {
        editScheduledClassClassInput.getSelectionModel().select(b);
      }
    }
    //Instructor

    editScheduledClassInstructorInput.getItems().clear();
    String tempClass = editScheduledClassClassInput.getSelectionModel()
        .getSelectedItem();
    for (int c = 0; c < adapter.getAllInstructors().size(); c++)
    {
      if (adapter.getAllInstructors().get(c).hasClass(tempClass))
      {
        if (!editScheduledClassInstructorInput.getItems()
            .contains(adapter.getAllInstructors().get(c).getFullName()))
        {
          editScheduledClassInstructorInput.getItems()
              .add(adapter.getAllInstructors().get(c).getFullName());
        }
      }
    }
    for (int i = 0; i < tempScheduledClass.size(); i++)
    {
      for (int b = 0;
           b < editScheduledClassInstructorInput.getItems().size(); b++)
      {
        try
        {
          if (tempScheduledClass.get(index).getInstructor().getFullName()
              .equals(editScheduledClassInstructorInput.getItems().get(b)))
          {
            editScheduledClassInstructorInput.getSelectionModel().select(b);
            break;
          }
        }
        catch (NullPointerException e)
        {
          System.out.println("No instructor assigned");
        }
      }
      break;
    }

  }

  public void saveEditedScheduledClass()
  {
    System.out.println(
        searchScheduledClassListView.getSelectionModel().getSelectedItems());
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());

    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    DateTime tempDate = new DateTime(1, 1, 1, 1, 1);
    tempDate.setDay(editScheduledClassDateInput.getValue().getDayOfMonth());
    tempDate.setMonth(editScheduledClassDateInput.getValue().getMonthValue());
    tempDate.setYear(editScheduledClassDateInput.getValue().getYear());
    tempDate.setHour(Integer.parseInt(editScheduledClassHourInput.getText()));
    tempDate
        .setMinute(Integer.parseInt(editScheduledClassMinuteInput.getText()));
    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();
    ScheduledClass tempScheduledClass2;
    for (int i = 0; i < tempArray.size(); i++)
    {
      if ((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName()) && (tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime()))
      {
        index = i;
        System.out.println("IT WORKS !");
        break;
      }
    }
    Class tempClass = adapter.getAllClasses().get(
        editScheduledClassClassInput.getSelectionModel().getSelectedIndex());

    ArrayList<Instructor> tempInstructors = adapter.getAllInstructors();
    Instructor tempInstructor = null;
    String tempInstructorName = editScheduledClassInstructorInput
        .getSelectionModel().getSelectedItem();
    for (int j = 0; j < tempInstructors.size(); j++)
    {
      if (tempInstructors.get(j).getFullName().equals(tempInstructorName))
      {
        tempInstructor = tempInstructors.get(j);
        break;
      }
    }
    try
    {
      tempScheduledClass2 = new ScheduledClass(tempClass, tempInstructor,
          tempDate,
          Integer.parseInt(editScheduledClassDurationInput.getText()));
      adapter.editScheduledClasses("ScheduledClasses.bin", index,
          tempScheduledClass2);
    }
    catch (NullPointerException e)
    {
      System.out.println(
          "Instructor not found (is null), saveEditedScheduledClass method");
    }

    searchForScheduledClasses();
    editScheduledClassHourInput.clear();
    editScheduledClassMinuteInput.clear();
    editScheduledClassClassInput.getItems().clear();
    editScheduledClassDurationInput.clear();
    editScheduledClassInstructorInput.getItems().clear();
    editScheduledClassDateInput.setValue(null);
  }

  public void removeScheduledClass()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);
    if (messageConfirmation(
        "Are you sure you want to remove this class from the schedule?",
        Alert.AlertType.CONFIRMATION))
    {
      adapter.removeScheduledClass("ScheduledClasses.bin", tempScheduledClass);
      scheduledClassDateOutput.clear();
      scheduledClassTimeOutput.clear();
      scheduledClassNameOutput.clear();
      scheduledClassInstructorOutput.clear();
      scheduledClassDurationOutput.clear();
      scheduledClassCapacityOutput.clear();
      searchForScheduledClasses();
    }
  }

  public void updatePremiumMembers()
  {
    ArrayList<Member> allMembers = adapter.getAllMembers();
    premiumMembers = new ArrayList<Member>();
    for (int i = 0; i < allMembers.size(); i++)
    {
      if (allMembers.get(i).hasPremiumMembership())
      {
        premiumMembers.add(allMembers.get(i));
      }
    }
  }

  public void loadPremiumMembersForSignUp()
  {
    System.out.println("Enters first time");
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);
    ArrayList<Member> memberList = tempScheduledClass.getMembers();

    if (memberList.size() > 0)
    {
      for (int j = 0; j < memberList.size(); j++)
      {
        premiumMembers.remove(memberList.get(j));
      }
    }

    for (int i = 0; i < premiumMembers.size(); i++)
    {
      signUpScheduledClassPremiumMembersInput.getItems()
          .add(premiumMembers.get(i));
    }

  }

  public void addPremiumMemberToScheduledClass()
  {
    Member tempMember = signUpScheduledClassPremiumMembersInput
        .getSelectionModel().getSelectedItem();

    System.out.println(tempMember);
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();
    for (int i = 0; i < tempArray.size(); i++)
    {
      if ((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName()) && (tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime()))
      {
        index = i;
        break;
      }
    }

    tempScheduledClass.addMember(tempMember);
    adapter.editScheduledClasses("ScheduledClasses.bin", index,
        tempScheduledClass);
    signUpScheduledClassPremiumMembersInput.setValue(null);
  }

  public void loadMemberAttendanceList()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    ArrayList<Member> memberList = tempScheduledClass.getMembers();
    for (int j = 0; j < memberList.size(); j++)
    {
      cancelScheduledClassAttendingMemberInput.getItems()
          .add(memberList.get(j));
    }
  }

  public void cancelMemberAttendance()
  {
    DateTime tempDateTime = new DateTime(0, 0, 0, 0, 0);
    DateTime tempDateTime2 = new DateTime(0, 0, 0, 0, 0);
    tempDateTime.setYear(searchScheduledClassFromInput.getValue().getYear());
    tempDateTime
        .setMonth(searchScheduledClassFromInput.getValue().getMonthValue());
    tempDateTime
        .setDay(searchScheduledClassFromInput.getValue().getDayOfMonth());
    tempDateTime2.setYear(searchScheduledClassToInput.getValue().getYear());
    tempDateTime2
        .setMonth(searchScheduledClassToInput.getValue().getMonthValue());
    tempDateTime2
        .setDay(searchScheduledClassToInput.getValue().getDayOfMonth());
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getScheduledClassesInTimeInterval(tempDateTime, tempDateTime2);
    int index = searchScheduledClassListView.getSelectionModel()
        .getSelectedIndex();
    ArrayList<ScheduledClass> tempArray = adapter.getAllScheduledClasses();
    ScheduledClass tempScheduledClass = tempScheduledClasses.get(index);

    for (int i = 0; i < tempArray.size(); i++)
    {
      if (((tempArray.get(i).getClassItem().getName())
          .equals(tempScheduledClass.getClassItem().getName())) && ((tempArray
          .get(i).getDateTime()).equals(tempScheduledClass.getDateTime())))
      {
        System.out.println(i);
        index = i;
        break;
      }
    }
    Member tempMember = cancelScheduledClassAttendingMemberInput
        .getSelectionModel().getSelectedItem();
    System.out.println(tempMember);
    System.out.println(tempScheduledClass.getMembers());
    tempScheduledClass.removeMember(tempMember);
    System.out.println(tempScheduledClass.getMembers());
    adapter.editScheduledClasses("ScheduledClasses.bin", index,
        tempScheduledClass);
    cancelScheduledClassAttendingMemberInput.setValue(null);
  }

  //--------------------------------------------------------------------------------------------
  public void loadMonths()
  {
    months = new ArrayList<String>();
    months.add("January");
    months.add("February");
    months.add("March");
    months.add("April");
    months.add("May");
    months.add("June");
    months.add("July");
    months.add("August");
    months.add("September");
    months.add("October");
    months.add("November");
    months.add("December");
    for (int i = 0; i < months.size(); i++)
    {
      scheduleExportMonthInput.getItems().add(months.get(i));
    }
  }

  public void getSchedule()
  {
    String month = scheduleExportMonthInput.getSelectionModel()
        .getSelectedItem();
    int year = Integer.parseInt(scheduleExportYearInput.getText());
    int c = 0;
    for (int i = 0; i < months.size(); i++)
    {
      if (month.equals(months.get(i)))
      {
        c = i;
        break;
      }
    }
    int lastDay = DateTime.lastDayOfTheMonth(c + 1, year);
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getAllScheduledClasses();
    String returnScheduledClasses = "";
    DateTime tempDateTime;
    for (int j = 1; j <= lastDay; j++)
    {
      tempDateTime = new DateTime(j, c + 1, year, 0, 0);
      for (int i = 0; i < tempScheduledClasses.size(); i++)
      {
        if (tempDateTime.equalsDate(tempScheduledClasses.get(i).getDateTime()))
        {
          returnScheduledClasses +=
              tempScheduledClasses.get(i).getClassItem().getName() + ", "
                  + tempScheduledClasses.get(i).getDateTime() + ", with "
                  + tempScheduledClasses.get(i).getInstructor().getFullName()
                  + "\n";
        }
      }
    }
    System.out.println(returnScheduledClasses);
    scheduleExportScheduleOutput.setText(returnScheduledClasses);
  }

  // Exporting to xml
  public void exportToXml()
  {
    ArrayList<ScheduledClass> scheduledClasses = new ArrayList<ScheduledClass>();
    String month = scheduleExportMonthInput.getSelectionModel()
        .getSelectedItem();
    int year = Integer.parseInt(scheduleExportYearInput.getText());
    int c = 0;
    for (int i = 0; i < months.size(); i++)
    {
      if (month.equals(months.get(i)))
      {
        c = i;
        break;
      }
    }
    int lastDay = DateTime.lastDayOfTheMonth(c + 1, year);
    ArrayList<ScheduledClass> tempScheduledClasses = adapter
        .getAllScheduledClasses();
    DateTime tempDateTime;
    for (int j = 1; j <= lastDay; j++)
    {
      tempDateTime = new DateTime(j, c + 1, year, 0, 0);
      for (int i = 0; i < tempScheduledClasses.size(); i++)
      {
        if (tempDateTime.equalsDate(tempScheduledClasses.get(i).getDateTime()))
        {
          scheduledClasses.add(tempScheduledClasses.get(i));
        }
      }
    }

    MyTextFileIO textFileIO = new MyTextFileIO();
    String xmlFile = "scheduleExport.xml";
    String stringToAppend = "";
    try
    {
      textFileIO
          .writeToFile(xmlFile, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      textFileIO.writeToFile(xmlFile, "<schedule>");
      for (ScheduledClass scheduledClass : scheduledClasses)
      {
        stringToAppend +=
            "<scheduledClass>" + "<class>" + "<name>" + scheduledClass
                .getClassItem().getName() + "</name>" + "<capacity>"
                + scheduledClass.getClassItem().getMaxCapacity() + "</capacity>"
                + "</class>" + "<instructor>" + "<firstName>" + scheduledClass
                .getInstructor().getFirstName() + "</firstName>" + "<lastName>"
                + scheduledClass.getInstructor().getLastName() + "</lastName>"
                + "</instructor>" + "<date>" + "<day>" + scheduledClass
                .getDateTime().getDay() + "</day>" + "<month>" + scheduledClass
                .getDateTime().getMonth() + "</month>" + "</date>" + "<time>"
                + "<hour>" + scheduledClass.getDateTime().displayHour()
                + "</hour>" + "<minute>" + scheduledClass.getDateTime()
                .displayMinute() + "</minute>" + "</time>"
                + "</scheduledClass>";
      }
      textFileIO.appendToFile(xmlFile, stringToAppend);
      textFileIO.appendToFile(xmlFile, "</schedule>");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found.");
      System.exit(1);
    }
    scheduleExportMonthInput.setValue(null);
    scheduleExportScheduleOutput.clear();
    scheduleExportYearInput.clear();
    loadMonths();
  }
}



