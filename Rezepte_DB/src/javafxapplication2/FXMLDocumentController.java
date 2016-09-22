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

    // Rezepte herausfiltern
    @FXML
    private void Rezepte_anzeigen(ActionEvent event) {

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            String queryString = "SELECT Name_Rezept FROM enthaelt WHERE 1=1 ";
            if (combobox_Beilage.getSelectionModel().getSelectedIndex()>=0) {
                queryString = queryString+" AND Name_Zutat_1 = '"+combobox_Beilage.getSelectionModel().getSelectedItem()+"'";
            }
            if (checkbox_Kidneybohnen.isSelected()) {
                queryString = queryString+" AND Name_Zutat_2 = '"+checkbox_Kidneybohnen.getText()+"'";
            }
            if (checkbox_Paprika.isSelected()) {
                queryString = queryString+" AND Name_Zutat_3 = '"+checkbox_Paprika.getText()+"'";
            }
            if (checkbox_Spinat.isSelected()) {
                queryString = queryString+" AND Name_Zutat_4 = '"+checkbox_Spinat.getText()+"'";
            }
            if (checkbox_Brokkoli.isSelected()) {
                queryString = queryString+" AND Name_Zutat_5 = '"+checkbox_Brokkoli.getText()+"'";
            }
            if (checkbox_Tomaten.isSelected()) {
                queryString = queryString+" AND Name_Zutat_6 = '"+checkbox_Tomaten.getText()+"'";
            }
            System.out.println(combobox_Beilage.getSelectionModel().getSelectedIndex() + " " + queryString);
            ResultSet rs = statement.executeQuery(queryString);
            Rezepte_Liste.getItems().clear();
            while(rs.next()) {
                Rezepte_Liste.getItems().add(rs.getString("Name_Rezept"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        
            aktualisieren();
        
    }
    
    @FXML
    public void Zutaten_anzeigen(ActionEvent event) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            if (Rezepte_Liste.getSelectionModel().getSelectedItem() != null) {
                ResultSet rs = statement.executeQuery("select * FROM Rezepte WHERE Name_Rezept = '"+Rezepte_Liste.getSelectionModel().getSelectedItem()+"'");
                Zutat1_Label.setText(rs.getString("Zutat_1"));
                Zutat2_Label.setText(rs.getString("Zutat_2"));
                Zutat3_Label.setText(rs.getString("Zutat_3"));
                Zutat4_Label.setText(rs.getString("Zutat_4"));
                Zutat5_Label.setText(rs.getString("Zutat_5"));
                Zutat6_Label.setText(rs.getString("Zutat_6"));
                Zutat7_Label.setText(rs.getString("Zutat_7"));
                Zutat8_Label.setText(rs.getString("Zutat_8"));
                Zutat9_Label.setText(rs.getString("Zutat_9"));
                Zutat10_Label.setText(rs.getString("Zutat_10"));
                Zutat11_Label.setText(rs.getString("Zutat_11"));
                Zutat12_Label.setText(rs.getString("Zutat_12"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
	try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:Rezepte.db");
	}
	catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
	}
	aktualisieren();
    }
	
    public void aktualisieren() {
        // ComboBox Beilage füllen
        ObservableList<String> Beilage_combobox = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from Zutaten WHERE ist_Beilage = 1");
            while(rs.next()) {
                Beilage_combobox.add(rs.getString("Zutat_Name"));
            }
            combobox_Beilage.setItems(Beilage_combobox);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
