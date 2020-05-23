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
  }

  public void loadScheduleClassPane()
  {
    scheduleClassPane.setVisible(true);
    scheduleDisplayEditExportPane.setVisible(false);
  }

  public void loadScheduleDisplayEditExportPane()
  {
    scheduleClassPane.setVisible(false);
    scheduleDisplayEditExportPane.setVisible(true);
    scheduleDisplayPane.setVisible(true);
    scheduleLogoPane.setVisible(true);
  }

  //------------------------------------Instructor------------------------------------------------
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
        for (int b = 0;
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
      }
      else
      {
        System.out.println("Wrong");

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
             b < adapter.getAllInstructors().get(i).getClasses().size(); b++)
        {
          editInstructorClassesInput.getItems()
              .add(adapter.getAllInstructors().get(i).getClasses().get(b));
        }
      }
      else
      {
        System.out.println("Wrong");
      }

    }
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
    Instructor tempInstructor = adapter.getAllInstructors()
        .get(instructorIndicator);
    tempInstructor.setFirstName(editInstructorFirstNameInput.getText());
    tempInstructor.setLastName(editInstructorLastNameInput.getText());
    tempInstructor.setAddress(editInstructorAddressInput.getText());
    tempInstructor.setEmail(editInstructorEmailInput.getText());
    tempInstructor.setPhoneNumber(editInstructorPhoneInput.getText());
    System.out.println(adapter.getAllInstructors().get(instructorIndicator));
    adapter
        .editInstructor("Instructors.bin", instructorIndicator, tempInstructor);
    System.out.println(adapter.getAllInstructors().get(instructorIndicator));
  }

  public void deleteInstructor()
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

  }
  // -------------------------Members----------------------------------

  public void registerMember()
  {
    Member newMember = new Member(registerMemberFirstNameInput.getText(),
        registerMemberLastNameInput.getText(),
        registerMemberAddressInput.getText(),
        registerMemberEmailInput.getText(), registerMemberPhoneInput.getText());
    registerMemberFirstNameInput.setText("");
    registerMemberLastNameInput.setText("");
    registerMemberAddressInput.setText("");
    registerMemberEmailInput.setText("");
    registerMemberPhoneInput.setText("");
    if (registerMemberMembershipInput.getValue().equals("Premium"))
    {
      newMember.upgradeMembership();
    }
    adapter.saveMembers("TestMembers.bin", newMember);
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
      }
    }
  }

  public void searchMemberByPhoneNumber()
  {
    String phoneNumber = searchMemberByPhoneInput.getText();

    ArrayList<Member> members = adapter.getAllMembers();
    for (int i = 0; i < members.size(); i++)
    {
      if (members.get(i).getPhoneNumber().equals(phoneNumber))
      {
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
      }
    }
  }

  public void saveMember()
  {
    Member tempMember = adapter.getAllMembers().get(memberIndicator);
    adapter.removeMember("TestMembers.bin", tempMember);

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
    adapter.saveMembers("TestMembers.bin", tempMember);
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

  public void deleteMember()
  {
    adapter.removeMember("TestMembers.bin",
        adapter.getAllMembers().get(memberIndicator));

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

// -------------------------Classes----------------------------------
public void saveAddedClasses(){
    System.out.println(adapter.getAllClasses());
    Class tempClass=new Class("No Name",0);
    tempClass.setName(addClassNameInput.getText());
    int a=Integer.parseInt(addClassCapacityInput.getText());
    tempClass.setMaxCapacity(a);
    adapter.saveClasses("Classes.bin",tempClass);
    addClassNameInput.clear();
    addClassCapacityInput.clear();
    System.out.println(adapter.getAllClasses());
    }
public void searchClassesByName(){
    for(int i=0;i<adapter.getAllClasses().size();i++){
    if(searchClassNameInput.getText().equals(adapter.getAllClasses().get(i).getName())){
    classIndicator=i;
    ediClassNameInput.setText(adapter.getAllClasses().get(i).getName());
    editClassCapacityInput.setText(String.valueOf(adapter.getAllClasses().get(i).getMaxCapacity()));
    }
    else{

    System.out.println("If this message appears "+adapter.getAllClasses().size()+" then it didnt find class");
    }
    }
    }
public void saveEditedClass(){
    System.out.println(adapter.getAllClasses());
    Class tempClass=new Class(ediClassNameInput.getText(),Integer.parseInt(editClassCapacityInput.getText()));
    adapter.editClass("Classes.bin",classIndicator,tempClass);
    System.out.println(adapter.getAllClasses());
    }
public void removeClass(){
    System.out.println(adapter.getAllClasses());
    adapter.removeClass("Classes.bin",adapter.getAllClasses().get(classIndicator));
    ediClassNameInput.clear();
    editClassCapacityInput.clear();
    searchClassNameInput.clear();
    System.out.println(adapter.getAllClasses());
    }
    }

