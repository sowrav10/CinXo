/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package cinxo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Bijoy
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane signin_form;
    @FXML
    private Button signup_close;
    @FXML
    private Button signup_minimize;
    @FXML 
    private TextField signin_username;
    @FXML
    private PasswordField signin_password;
    @FXML
    private Button signin_loginbtn;
    @FXML
    private Hyperlink signin_create_ac;
    @FXML
    private AnchorPane signup_form;
    @FXML
    private TextField signup_username;
    @FXML
    private PasswordField signup_password;
    @FXML
    private Button signup_singupbtn;
    @FXML
    private Hyperlink signup_alreadyhaveac;
    @FXML
    private TextField signup_email;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    
public void signin() {

    String sql = "SELECT * FROM admin WHERE Username = ? AND Password = ?";

    connect = Database.connectDb();

    try {
        if (signin_username.getText().isEmpty() || signin_password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            return;
        }

        prepare = connect.prepareStatement(sql);
        prepare.setString(1, signin_username.getText());
        prepare.setString(2, signin_password.getText());
        result = prepare.executeQuery();

        Alert alert;

        if (result.next()) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Logged In!");
            alert.showAndWait();

            // TODO: Load dashboard or new scene here
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Username/Password");
            alert.showAndWait();
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    
    public void switchForm(ActionEvent event){
    if(event.getSource()== signin_create_ac){
    
        
        signin_form.setVisible(false);
    signup_form.setVisible(true);
    
    } else if (event.getSource()== signup_alreadyhaveac ){
        signin_form.setVisible(true);
        signup_form.setVisible(false);
        
        
       }
    }
    
    public void signin_close(){
    System.exit(0);
    
    }
    
    public void signin_minimize(){
        Stage stage= (Stage)signin_form.getScene().getWindow();
    
    stage.setIconified(true);
    }
    
    public void signup_close(){
    System.exit(0);
    
    }
    
    public void signup_minimize(){
        Stage stage= (Stage)signin_form.getScene().getWindow();
    
    stage.setIconified(true);
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
