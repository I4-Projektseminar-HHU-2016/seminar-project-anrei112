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
    private ObservableList<String> Rezepte_Liste_ID;
	@FXML
	private ComboBox<String> combobox_Beilage = new ComboBox<String>();
	private ObservableList<String> Beilage_combobox_ID;
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
		aktualisieren(); 
	} 

	// Rezepte herausfiltern
	@FXML
	public void Rezepte_finden(ActionEvent event) {
    
	}

	@FXML
	public void Rezepte_anzeigen(ActionEvent event) {
		if (combobox_Beilage.getSelectionModel().getSelectedItem() != null &&     ) {
			// da fehlt noch was
			aktualisieren();
		}
	}
	
	@FXML
	public void Zutaten_anzeigen(ActionEvent event) {
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            if (Rezepte_Liste.getSelectionModel().getSelectedItem() != null) {
                ResultSet rs = statement.executeQuery("select * FROM Rezepte ");
                Zutat1_Label.setText(rs.getString("Zutat 1"));
                Zutat2_Label.setText(rs.getString("Zutat 2"));
                Zutat3_Label.setText(rs.getString("Zutat 3"));
                Zutat4_Label.setText(rs.getString("Zutat 4"));
                Zutat5_Label.setText(rs.getString("Zutat 5"));
                Zutat6_Label.setText(rs.getString("Zutat 6"));
                Zutat7_Label.setText(rs.getString("Zutat 7"));
                Zutat8_Label.setText(rs.getString("Zutat 8"));
                Zutat9_Label.setText(rs.getString("Zutat 9"));
                Zutat10_Label.setText(rs.getString("Zutat 10"));
                Zutat11_Label.setText(rs.getString("Zutat 11"));
                Zutat12_Label.setText(rs.getString("Zutat 12"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

/**
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
	**/


	

     
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
	
	public void aktualisieren() {
        // ComboBox Beilage füllen
        ObservableList<String> Beilage_combobox = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from Beilage");
            Beilage_combobox.add("egal");
            Beilage_combobox.add("Reis");
            Beilage_combobox.add("Nudeln");
            Beilage_combobox.add("Kartoffeln");
            while(rs.next()) {
                Beilage_combobox.add(rs.getString("Name"));
            }
            combobox_Beilage.setItems(Beilage_combobox);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        //Rezepte füllen
        ObservableList<String> items_Art = FXCollections.observableArrayList();
        Rezepte_Liste_ID = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("select * from Rezepte");
            while(rs.next()) {
                items_Rezepte.add(rs.getString("Name"));
                Rezepte_Liste_ID.add(rs.getString("Name"));
            }
            Rezepte_Liste.setItems(items_Rezepte);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }   
    }
	
	
	
}
