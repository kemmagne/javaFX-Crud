/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_7;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    //private Person selectedPerson;
   
    @FXML
    private TableView<Person> personTable;
    
    @FXML
    private TableColumn<Person, String> nomColumn;
    
    @FXML
    private TableColumn<Person, String> prenomColumn;
    
    @FXML
    private TableColumn<Person, String> ageColumn;
    
    @FXML
    private TextField txt_nom;
    
    @FXML
    private TextField txt_prenom;
    
    @FXML
    private TextField txt_age;
    
    @FXML
    private Button btn_ajouter;
    
    @FXML
    private Button btn_modifier;
     

    @FXML
    private Button btn_supprimer;   
  
    @FXML
    private Label label;

   // private T<?> selection;
    private Person selection;
    
    
    ObservableList<Person> list = FXCollections.observableArrayList(person -> new ObservableValue[]{person.nameProperty(), person.surnameProperty(), person.ageProperty()});

    
    public TextField getTxt_nom() {
        return txt_nom;
    }

    public TextField getTxt_prenom() {
        return txt_prenom;
    }

    public TextField getTxt_age() {
        return txt_age;
    }

    public Label getLabel() {
        return label;
    }

    public void setTxt_nom(TextField txt_nom) {
        this.txt_nom = txt_nom;
    }

    public void setTxt_prenom(TextField txt_prenom) {
        this.txt_prenom = txt_prenom;
    }

    public void setTxt_age(TextField txt_age) {
        this.txt_age = txt_age;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    
    
    
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        //System.out.println(txt_nom.getText());
        Person person = new Person();
        person.setName(txt_nom.getText());
        person.setSurname(txt_prenom.getText());
        person.setAge(txt_age.getText());
        
        personTable.getItems().add(person); 
        this.clear();
    }
    
     @FXML
    private void OnDeleted(ActionEvent event) {
        //System.out.println(txt_nom.getText());
         Person selectedItem = personTable.getSelectionModel().getSelectedItem();
         personTable.getItems().remove(selectedItem);
    }
    

    
    @FXML
    private void OnModify(ActionEvent event) {

       selection.setName(txt_nom.getText());
       selection.setSurname(txt_prenom.getText());
       selection.setAge(txt_age.getText());
   
    }
 
    public void clear(){
    
      this.txt_nom.setText(null);
      this.txt_prenom.setText(null);
      this.txt_age.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("name"));
        prenomColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("surname"));
        
        ageColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("age"));
       // personTable.getColumns().add(new TableColumn<Person, String>() {})
       
       
       
         personTable.setItems(list);
       
       personTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{ 

           
           if (newSelection != null) {
               
               txt_nom.setText(newSelection.getName());
               
               txt_prenom.setText(newSelection.getSurname());
               
               txt_age.setText(newSelection.getAge());
               
               selection =  newSelection;
                               
                
            } else {
             
               txt_nom.setText("");
               
               txt_prenom.setText("");
               
               txt_age.setText("");
               
            }
      });
       
       
       btn_ajouter.disableProperty().bind(txt_age.textProperty().isEmpty().and(txt_nom.textProperty().isEmpty().and(txt_prenom.textProperty().isEmpty())));
       btn_supprimer.disableProperty().bind(personTable.getSelectionModel().selectedItemProperty().isNull());
       btn_modifier.disableProperty().bind(personTable.getSelectionModel().selectedItemProperty().isNull());
       btn_ajouter.disableProperty().bind(txt_age.textProperty().isEmpty());
    }    
 
}
