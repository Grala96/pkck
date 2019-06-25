package app;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import data.Database;
import data.PersonType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox headVBox;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuBar_menu;

    @FXML
    private MenuItem menuOpen;

    @FXML
    private MenuItem menuSaveAs;

    @FXML
    private MenuItem menuQuit;

    @FXML
    private TextField peopleInputPersonId;

    @FXML
    private TextField peopleInputHeight;

    @FXML
    private TextField peopleInputFirstname;

    @FXML
    private TextField peopleInputHeightUnit;

    @FXML
    private TextField peopleInputMiddlename;

    @FXML
    private TextField peopleInputWeight;

    @FXML
    private TextField peopleInputLastname;

    @FXML
    private TextField peopleInputWeightUnit;

    @FXML
    private TextField peopleInputBirthday;

    @FXML
    private TextField peopleInputCompanyId;

    @FXML
    private Button peopleAddButton;

    @FXML
    private Button peopleResetButton;

    @FXML
    private TableView<Person> personTableView = new TableView<>();

    private FileController fileController = new FileController();
    private Database database = new Database();

    private ObservableList<Person> personObservableList = FXCollections.observableList(new ArrayList<>());

    @FXML
    void initialize() {
        configTableView();

        assert headVBox != null : "fx:id=\"headVBox\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuBar_menu != null : "fx:id=\"menuBar_menu\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuOpen != null : "fx:id=\"menuOpen\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuSaveAs != null : "fx:id=\"menuSaveAs\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuQuit != null : "fx:id=\"menuQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert personTableView != null : "fx:id=\"personTableView\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputPersonId != null : "fx:id=\"peopleInputPersonId\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputHeight != null : "fx:id=\"peopleInputHeight\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputFirstname != null : "fx:id=\"peopleInputFirstname\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputHeightUnit != null : "fx:id=\"peopleInputHeightUnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputMiddlename != null : "fx:id=\"peopleInputMiddlename\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputWeight != null : "fx:id=\"peopleInputWeight\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputLastname != null : "fx:id=\"peopleInputLastname\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputWeightUnit != null : "fx:id=\"peopleInputWeightUnit\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputBirthday != null : "fx:id=\"peopleInputBirthday\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleInputCompanyId != null : "fx:id=\"peopleInputCompanyId\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleAddButton != null : "fx:id=\"peopleAddButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert peopleResetButton != null : "fx:id=\"peopleResetButton\" was not injected: check your FXML file 'sample.fxml'.";

        menuQuit.setOnAction(e -> System.exit(0));

        menuOpen.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            Stage openFile = new Stage();
            openFile.setTitle("Wybierz plik XML do odczytu.");
            File file = fileChooser.showOpenDialog(openFile);
            if (file != null) {
                this.database = fileController.loadXML(file);
                personTableView.getItems().clear();
                for (PersonType personType : this.database.getPeople().getPerson()) {
                    System.out.println(personType.toString());
                    personObservableList.add(new Person(personType));
                }
                personTableView.setItems(personObservableList);
            }
        });

        menuSaveAs.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            Stage saveFile = new Stage();
            saveFile.setTitle("Wybierz ścieżkę do zapisu pliku XML.");
            File file = fileChooser.showSaveDialog(saveFile);
            if (file != null) {
                fileController.saveXML(file, database);
            }
        });
    }

    private void configTableView() {
        personTableView.setEditable(true);

        TableColumn personidCol = new TableColumn("Person ID");
        personidCol.setMinWidth(100);
        personidCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("personid"));

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstname"));

        TableColumn middleNameCol = new TableColumn("Middle Name");
        middleNameCol.setMinWidth(100);
        middleNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("middlename"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastname"));

        TableColumn birthdayCol = new TableColumn("Birthday");
        birthdayCol.setMinWidth(150);
        birthdayCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("birthday"));

        TableColumn heightCol = new TableColumn("Height");
        heightCol.setMinWidth(100);
        heightCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("height"));

        TableColumn heightUnitCol = new TableColumn("Height Unit");
        heightUnitCol.setMinWidth(100);
        heightUnitCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("heightUnit"));

        TableColumn weightCol = new TableColumn("Weight");
        weightCol.setMinWidth(100);
        weightCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("weight"));

        TableColumn weightUnitCol = new TableColumn("Birthday");
        weightUnitCol.setMinWidth(100);
        weightUnitCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("weightUnit"));

        TableColumn companyidCol = new TableColumn("Company ID");
        companyidCol.setMinWidth(100);
        companyidCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("companyid"));

        personTableView.setItems(personObservableList);
        personTableView.getColumns().addAll(personidCol, firstNameCol, middleNameCol, lastNameCol, birthdayCol, heightCol, heightUnitCol, weightCol, weightUnitCol, companyidCol);
    }


}
