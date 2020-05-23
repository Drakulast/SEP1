import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
  @FXML private TextArea editInstructorClassesInput;

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
  @FXML private Pane screenSaverPane;

  @FXML private Label dateLabel;

  private FitnessCenterFileAdapter adapter;
  private ArrayList<String> instrAddClasses = new ArrayList<String>();
  private ArrayList<String> indicatorArray = new ArrayList<String>();
  private int instructorIndicator = 0;

  public void initialize()
  {
    adapter = new FitnessCenterFileAdapter("TestMembers.bin", "Instructors.bin",
        "Classes.bin", "ScheduledClasses.bin");
    loadOverviewPane();
    setNumberOfMembers();
    setCurrentInstructors();
    setCurrentClasses();
    setTodayDate();

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
    registerMemberMembershipInput.getItems().add("Standard");
    registerMemberMembershipInput.getItems().add("Premium");
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
    registerMemberMembershipInput.getItems().add("Standard");
    registerMemberMembershipInput.getItems().add("Premium");
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

  // Instructors
  //------------------------------------------------------------------------------------
  public void mouseClickOnAdd()
  {
    instrAddClasses.add(registerInstructorClassInput.getText());
    registerInstructorClassInput.setText("");

  }

  public void saveAndRegisterInstructor()
  {
    Instructor tempInstructor = new Instructor(
        registerInstructorFirstNameInput.getText(),
        registerInstructorLastNameInput.getText(),
        registerInstructorAddressInput.getText(),
        registerInstructorEmailInput.getText(),
        registerInstructorPhoneInput.getText(), instrAddClasses);
    adapter.saveInstructors("Instructors.bin", tempInstructor);
    instrAddClasses.clear();
    registerInstructorFirstNameInput.setText("");
    registerInstructorLastNameInput.setText("");
    registerInstructorAddressInput.setText("");
    registerInstructorEmailInput.setText("");
    registerInstructorPhoneInput.setText("");
    System.out.println(tempInstructor);

  }

  public void searchInstructorByName()
  {
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (searchInstructorByNameFirstNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getFirstName())
          && searchInstructorByNameLastNameInput.getText()
          .equals(adapter.getAllInstructors().get(i).getLastName()))
      {
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
        for (int b = 0; b < adapter.getAllInstructors().get(instructorIndicator)
            .getNumberOfClasses(); b++)
        {
          //          editInstructorClassesInput.getItems().add(adapter.getAllInstructors().get(instructorIndicator).);
        }
      }
      else
      {
        System.out.println("SAY THAT THREE TIMES AND YOU ARE A CUNT");

      }

    }
  }

  public void searchInstructorByPhoneNumber()
  {
    for (int i = 0; i < adapter.getAllInstructors().size(); i++)
    {
      if (searchInstructorByPhoneInput.getText()
          .equals(adapter.getAllInstructors().get(i).getPhoneNumber()))
      {
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
             b < adapter.getAllInstructors().get(i).getNumberOfClasses(); b++)
        {
          editInstructorClassesInput.setPrefColumnCount(1);
          editInstructorClassesInput.setPrefRowCount(
              adapter.getAllInstructors().get(i).getNumberOfClasses());
        }
      }
      else
      {
        System.out.println("SAY THAT THREE TIMES AND YOU ARE A CUNT");
        System.out.println(searchInstructorByPhoneInput.getText());
        System.out.println(adapter.getAllInstructors().get(i).getPhoneNumber());
        System.out.println(adapter.getAllInstructors());
      }

    }
  }

  public void addInstructorClassListView()
  {

  }

  public void removeInstructorClassListView()
  {

  }

  public void saveEditedInstructor()
  {
    Instructor tempInstructor2 = adapter.getAllInstructors()
        .get(instructorIndicator);
    tempInstructor2.setFirstName(editInstructorFirstNameInput.getText());
    tempInstructor2.setLastName(editInstructorLastNameInput.getText());
    tempInstructor2.setAddress(editInstructorAddressInput.getText());
    tempInstructor2.setEmail(editInstructorEmailInput.getText());
    tempInstructor2.setPhoneNumber(editInstructorPhoneInput.getText());
    System.out.println(adapter.getAllInstructors());
    adapter.removeInstructor("Instructors.bin",
        adapter.getAllInstructors().get(instructorIndicator));
    System.out.println(adapter.getAllInstructors());
    adapter.saveInstructors("Instructors.bin", tempInstructor2);
    System.out.println(adapter.getAllInstructors());
  }
  // -------------------------Members----------------------------------

  public void SaveAndRegisterMember()
  {
    Member newMember = new Member(registerMemberFirstNameInput.getText(),
        registerMemberLastNameInput.getText(),
        registerMemberAddressInput.getText(),
        registerMemberEmailInput.getText(), registerMemberPhoneInput.getText());
    adapter.saveMembers("TestMembers.bin", newMember);
    registerMemberFirstNameInput.setText("");
    registerMemberLastNameInput.setText("");
    registerMemberAddressInput.setText("");
    registerMemberEmailInput.setText("");
    registerMemberPhoneInput.setText("");
    if (registerMemberMembershipInput.getValue().equals("Premium"))
    {
      newMember.upgradeMembership();
    }
    System.out.println(newMember);
  }

  public void searchMemberByName()
  {
    String firstName = searchMemberByNameFirstNameInput.getText();
    String lastName = searchMemberByNameLastNameInput.getText();

    ArrayList<Member> members = adapter.getAllMembers();
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getFirstName().equals(firstName) && members.get(i)
          .getLastName().equals(lastName))
      {
        editMemberFirstNameInput.setText(members.get(i).getFirstName());
        editMemberFirstNameInput.setEditable(true);
        editMemberLastNameInput.setText(members.get(i).getLastName());
        editMemberLastNameInput.setEditable(true);
        editMemberAddressInput.setText(members.get(i).getAddress());
        editMemberAddressInput.setEditable(true);
        editMemberEmailInput.setText(members.get(i).getEmail());
        editMemberEmailInput.setEditable(true);
        editMemberMembershipInput.setEditable(true);
        if (registerMemberMembershipInput.getValue().equals("Premium"))
        {
          editMemberMembershipInput.getSelectionModel().select("Premium");
        }
        else
        {
          editMemberMembershipInput.getSelectionModel().select("Standard");
        }
        editMemberPhoneInput.setText(members.get(i).getPhoneNumber());
      }
    }
  }

}
