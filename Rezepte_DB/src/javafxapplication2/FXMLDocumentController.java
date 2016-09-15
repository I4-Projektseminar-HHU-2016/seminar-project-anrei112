/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Annika Reich
 */

public class FXMLDocumentController implements Initializable {
    Connection connection = null;


// Listen, Comboboxen und Checkboxen
@FXML
private ListView<String> Rezepte_Liste;
@FXML
private ComboBox<String> combobox_Beilage = new ComboBox<String>();
@FXML
private CheckBox checkbox_Tomaten = new CheckBox();
@FXML
private CheckBox checkbox_Kidneybohnen = new CheckBox();
@FXML
private CheckBox checkbox_Paprika = new CheckBox();
@FXML
private CheckBox checkbox_Brokkoli = new CheckBox();
@FXML
private CheckBox checkbox_Spinat = new CheckBox();
@FXML
private Label Zutat1_Label;
@FXML
private Label Zutat2_Label;
@FXML
private Label Zutat3_Label;
@FXML
private Label Zutat4_Label;
@FXML
private Label Zutat5_Label;
@FXML
private Label Zutat6_Label;
@FXML
private Label Zutat7_Label;
@FXML
private Label Zutat8_Label;
@FXML
private Label Zutat9_Label;
@FXML
private Label Zutat10_Label;
@FXML
private Label Zutat11_Label;
@FXML
private Label Zutat12_Label;
   

@FXML
private void handleButtonAction(ActionEvent event) {
    System.out.println("You clicked me!");
    aktualisiere_Rezepte(); 
} 

// Rezepte herausfiltern
@FXML
public void Rezepte_finden() {
    
}

@FXML
public void Rezepte_anzeigen() {
    
}

// Zutaten waehlen
private void Beilage_waehlen(ActionEvent event) {
    
}
    
private void Tomaten_waehlen(ActionEvent event) {
    
}
    
private void Kidneybohnen_waehlen(ActionEvent event) {
    
}

private void Paprika_waehlen(ActionEvent event) {
    
}

private void Brokkoli_waehlen(ActionEvent event) {
    
}

private void Spinat_waehlen(ActionEvent event) {
    
}

public void aktualisieren() {
    // ComboBox Beilage füllen
}
     
@Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO
    try {
  // create a database connection
        connection = DriverManager.getConnection("jdbc:sqlite:DBS.db");
        }
    catch(SQLException e) {
  // if the error message is "out of memory",
  // it probably means no database file is found
    System.err.println(e.getMessage());
    }
    aktualisieren();
}
