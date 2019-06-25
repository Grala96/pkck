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
    private MenuItem menuNew;

    @FXML
    private MenuItem menuOpen;

    @FXML
    private MenuItem MenuSave;

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
    private TableView<PersonView.Person> personTableView = new TableView<>();

    private FileController fileController = new FileController();
    private Database database = new Database();

    private ObservableList<PersonView.Person> personObservableList = null;

    private List<PersonView.Person> converter(List<PersonType> list) {
        List<PersonView.Person> personList = new ArrayList<>();
        for (PersonType personType : list) {
            personList.add(new PersonView.Person(personType));
        }
        return personList;
    }

    @FXML
    void initialize() {
        configTableView();

        assert headVBox != null : "fx:id=\"headVBox\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuBar_menu != null : "fx:id=\"menuBar_menu\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuNew != null : "fx:id=\"menuNew\" was not injected: check your FXML file 'sample.fxml'.";
        assert menuOpen != null : "fx:id=\"menuOpen\" was not injected: check your FXML file 'sample.fxml'.";
        assert MenuSave != null : "fx:id=\"MenuSave\" was not injected: check your FXML file 'sample.fxml'.";
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
                System.out.println(this.database.toString());
                if(personTableView.getItems() != null){
                    personTableView.getItems().clear();
                }
                personObservableList = FXCollections.observableArrayList(converter(this.database.getPeople().getPerson()));
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

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<PersonView.Person, String>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<PersonView.Person, String>("lastName"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<PersonView.Person, String>("email"));

        personTableView.setItems(personObservableList);
        personTableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
    }


}
