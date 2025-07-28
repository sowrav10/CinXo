/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cinxo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bijoy
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane topForm;

    @FXML
    private Button Customer_btn;

    @FXML
    private Button acailableMovies_buyBtn;

    @FXML
    private Button acailableMovies_clearBtn;

    @FXML
    private TableColumn<?, ?> acailableMovies_col_genre;

    @FXML
    private TableColumn<?, ?> acailableMovies_col_movieTitle;

    @FXML
    private TableColumn<?, ?> acailableMovies_col_showingDate;

    @FXML
    private ImageView acailableMovies_imageView;

    @FXML
    private Label acailableMovies_movieDate;

    @FXML
    private Label acailableMovies_movieGenre;

    @FXML
    private Label acailableMovies_movieTitle;

    @FXML
    private Label acailableMovies_normalClassPrice;

    @FXML
    private Spinner<?> acailableMovies_normalClassQuantity;

    @FXML
    private Button acailableMovies_receiptBtn;

    @FXML
    private Button acailableMovies_selectMovie;

    @FXML
    private Label acailableMovies_specialClassPrice;

    @FXML
    private Spinner<?> acailableMovies_specialClassQuantity;

    @FXML
    private TableView<?> acailableMovies_tableView;

    @FXML
    private Label acailableMovies_title;

    @FXML
    private Label acailableMovies_total;

    @FXML
    private Button addMovies_btn;

    @FXML
    private Button addMovies_clearBtn;

    @FXML
    private TableColumn<moviesData, Date> addMovies_col_date;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_genere;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;

    @FXML
    private TextField addMovies_date;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private TextField addMovies_genere;

    @FXML
    private ImageView addMovies_imageview;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_insertBtn;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<moviesData> addMovies_tableView;

    @FXML
    private TextField addMovies_title;

    @FXML
    private Button addMovies_updateBtn;

    @FXML
    private AnchorPane addmovies_form;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private AnchorPane availablemovies_form;

    @FXML
    private Button close;

    @FXML
    private Button customers_clear;

    @FXML
    private TableColumn<?, ?> customers_col_date;

    @FXML
    private TableColumn<?, ?> customers_col_genre;

    @FXML
    private TableColumn<?, ?> customers_col_movieTitle;

    @FXML
    private TableColumn<?, ?> customers_col_ticketNumber;

    @FXML
    private TableColumn<?, ?> customers_col_time;

    @FXML
    private Label customers_date;

    @FXML
    private Button customers_delete;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private Label customers_genre;

    @FXML
    private Label customers_movieTicket;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<?> customers_tableView;

    @FXML
    private Label customers_time;

    @FXML
    private Label dashboard_availablemovies;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_totalearnmoney;

    @FXML
    private Label dashboard_totalsoldticket;

    @FXML
    private Button editScreen_btn;

    @FXML
    private AnchorPane editScreen_form;

    @FXML
    private TableColumn<?, ?> editScreening_col_current;

    @FXML
    private TableColumn<?, ?> editScreening_col_duration;

    @FXML
    private TableColumn<?, ?> editScreening_col_genre;

    @FXML
    private TableColumn<?, ?> editScreening_col_movie;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Button editScreening_delete;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<?> editScreening_tableView;

    @FXML
    private Label editScreening_title;

    @FXML
    private Button editScreening_update;
    
    @FXML
    private Button signout;

    @FXML
    private Button minimize;

    
    @FXML
    private Label username;
    
    private double x = 0;
    private double y = 0;
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

// NOW LETS PROCEED TO GIVE FUNCTIONS OUR ADD MOVIES :) BUT FIRST WE NEED TO CRE
    public ObservableList<moviesData> addMoviesList() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = (Connection) Database.connectDb();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date")
                        
                );
                listData.add(movD);
            }

        } catch (Exception e) {e.printStackTrace();}
        return listData;
    }
    
    private ObservableList<moviesData> listAddMovies;

public void showAddMoviesList() {
    listAddMovies = addMoviesList();
    addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
    addMovies_col_genere.setCellValueFactory(new PropertyValueFactory<>("genre"));
    addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

    addMovies_tableView.setItems(listAddMovies);
}





    

    public void logout() {
        signout.getScene().getWindow().hide();
    try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        
        root.setOnMousePressed((MouseEvent event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    public void switchForm(ActionEvent event){

    if(event.getSource() == dashboard_btn){
        dashboard_form.setVisible(true);
        addmovies_form.setVisible(false);
        availablemovies_form.setVisible(false);
        editScreen_form.setVisible(false);
        customers_form.setVisible(false);

        dashboard_btn.setStyle("-fx-background-color:#ae2d3c;");
        addMovies_btn.setStyle("-fx-background-color:transparent");
        availableMovies_btn.setStyle("-fx-background-color:transparent");
        editScreen_btn.setStyle("-fx-background-color:transparent");
        Customer_btn.setStyle("-fx-background-color:transparent");

    } else if (event.getSource() == addMovies_btn){
        dashboard_form.setVisible(false);
        addmovies_form.setVisible(true);
        availablemovies_form.setVisible(false);
        editScreen_form.setVisible(false);
        customers_form.setVisible(false);
        
         addMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
        dashboard_btn.setStyle("-fx-background-color:transparent");
        availableMovies_btn.setStyle("-fx-background-color:transparent");
        editScreen_btn.setStyle("-fx-background-color:transparent");
        Customer_btn.setStyle("-fx-background-color:transparent");

    }else if(event.getSource() == availableMovies_btn){
        dashboard_form.setVisible(false);
        addmovies_form.setVisible(false);
        availablemovies_form.setVisible(true);
        editScreen_form.setVisible(false);
        customers_form.setVisible(false);
        
         availableMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
        dashboard_btn.setStyle("-fx-background-color:transparent");
        addMovies_btn.setStyle("-fx-background-color:transparent");
        editScreen_btn.setStyle("-fx-background-color:transparent");
        Customer_btn.setStyle("-fx-background-color:transparent");

        
    }else if(event.getSource() == editScreen_btn){
        dashboard_form.setVisible(false);
        addmovies_form.setVisible(false);
        availablemovies_form.setVisible(false);
        editScreen_form.setVisible(true);
        customers_form.setVisible(false);
        
           editScreen_btn.setStyle("-fx-background-color:#ae2d3c;");
        dashboard_btn.setStyle("-fx-background-color:transparent");
        addMovies_btn.setStyle("-fx-background-color:transparent");
        availableMovies_btn.setStyle("-fx-background-color:transparent");
        Customer_btn.setStyle("-fx-background-color:transparent");

        
    }else if(event.getSource() == Customer_btn){
        dashboard_form.setVisible(false);
        addmovies_form.setVisible(false);
        availablemovies_form.setVisible(false);
        editScreen_form.setVisible(false);
        customers_form.setVisible(true);
        
           Customer_btn.setStyle("-fx-background-color:#ae2d3c;");
        dashboard_btn.setStyle("-fx-background-color:transparent");
        addMovies_btn.setStyle("-fx-background-color:transparent");
        availableMovies_btn.setStyle("-fx-background-color:transparent");
        editScreen_btn.setStyle("-fx-background-color:transparent");

        
    }
}

 

    public void displayUsername() {
    username.setText(getData.username);
}
    
    public void close() {
        System.exit(0);
    }

    
    public void minimize() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true); // Fixed typo here
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Add your logic here
        displayUsername();
        showAddMoviesList();
    }
}
