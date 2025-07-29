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
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

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
    private TableColumn<moviesData, String> acailableMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> acailableMovies_col_movieTitle;

    @FXML
    private TableColumn<moviesData, String> acailableMovies_col_showingDate;

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
    private Spinner<Integer> acailableMovies_normalClassQuantity;

    @FXML
    private Button acailableMovies_receiptBtn;

    @FXML
    private Button acailableMovies_selectMovie;

    @FXML
    private Label acailableMovies_specialClassPrice;

    @FXML
    private Spinner<Integer> acailableMovies_specialClassQuantity;

    @FXML
    private TableView<moviesData> acailableMovies_tableView;

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
    private TableColumn<moviesData, String> addMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private TextField addMovies_genre;

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
    private TableColumn<moviesData, String> customers_col_date;

    @FXML
    private TableColumn<moviesData, String> customers_col_genre;

    @FXML
    private TableColumn<moviesData, String> customers_col_movieTitle;

    @FXML
    private TableColumn<moviesData, String> customers_col_ticketNumber;

    @FXML
    private TableColumn<moviesData, String> customers_col_time;

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
    private TableView<moviesData> customers_tableView;

    @FXML
    private DatePicker addMovies_date;

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
    private TableColumn<moviesData, String> editScreening_col_current;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_duration;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_genre;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_movie;

    @FXML
    private ComboBox<moviesData> editScreening_current;

    @FXML
    private Button editScreening_delete;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<moviesData> editScreening_tableView;

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

    private Image image;

    private double x = 0;
    private double y = 0;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    
    private float price1= 0;
    private float price2= 0;
    private float total= 0;
    private int qty1 = 0;
    private int qty2 = 0;
    
    
    public void buy(){
        
        String sql = "INSERT INTO Customer (type,total,date)VALUE(?,?,?)";
   connect = Database.connectDb();
 String type = null;  
        if (price1 > 0 && price2 == 0) {
            type = "Special Csass";
        } else if (price2 > 0 && price1 == 0) {
            type = "normal class";
        } else if (price2 > 0 && price1 > 0)
       try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, String.valueOf(total));
            Object setDate = null;
            prepare.setString(3, String.valueOf(setDate));
Alert alert;
           if (acailableMovies_imageView.getImage() == null || acailableMovies_movieTitle.getText().isEmpty()) {
               alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Please select the movie first");
               alert.showAndWait();
           }else if (price1 == 0 && price2 ==0){
           
            alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error Message");
               alert.setHeaderText(null);
               alert.setContentText("Please select the movie first");
               alert.showAndWait();
           
           }else{
            prepare.executeUpdate();
            alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Successfully purchase!");
               alert.showAndWait();
               
               String sql1= "SELECT * FROM customer";
               
               prepare = connect.prepareStatement(sql1);
               result = prepare.executeQuery();
               int num=0 ;
               while(result.next()){
                   num=result.getInt("id");
              
               }
               String sql2 = "INSERT INTO customer_info (id, customer_id,total,movieTitle) VALUES(?,?,?,?)";
           prepare=connect.prepareStatement(sql2);
           prepare.setString(1, String.valueOf(num));
           prepare.setString(2, type);
           prepare.setString(3, String.valueOf(total));
           prepare.setString(4, acailableMovies_title.getText());
           prepare.execute();
           
           clearPurchaseTicketInfo();
           }
        } catch (Exception e) {e.printStackTrace();}

    }
    
    public void clearPurchaseTicketInfo() {
    spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
    spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

    acailableMovies_specialClassQuantity.setValueFactory(spinner1);
    acailableMovies_normalClassQuantity.setValueFactory(spinner2);

    acailableMovies_specialClassPrice.setText("$0.0");
    acailableMovies_normalClassPrice.setText("$0.0");
    acailableMovies_total.setText("$0.0");
}
    
    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    
    public void showSpinnerValue(){
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
         spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
         
        acailableMovies_specialClassQuantity.setValueFactory(spinner1);
        acailableMovies_normalClassQuantity.setValueFactory(spinner2);

    
    }
    
    
    public void getSpinnerValue(){
        
        qty1 = acailableMovies_specialClassQuantity.getValue();
        qty2 = acailableMovies_normalClassQuantity.getValue();
        price1 = (qty1 * 550);
        price2 = (qty2 * 300);
        
        total = (price1+price2);
        
        acailableMovies_specialClassPrice.setText("৳"+String.valueOf(price1));
        acailableMovies_normalClassPrice.setText("৳"+ String.valueOf(price2));
        
        acailableMovies_total.setText(String.valueOf(total)
        );
    }
    

    public ObservableList<moviesData> availableMoviesList() {
        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie WHERE current = 'Showing'";
        connect = Database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                         result.getString("movieTitle"),
                         result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                listAvMovies.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAvMovies;
    }

    private ObservableList<moviesData> availableMoviesList;

    public void showAvailableMovies() {

        availableMoviesList = availableMoviesList();

        acailableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        acailableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        acailableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        acailableMovies_tableView.setItems(availableMoviesList);
    }

    public void selectAvailableMovies() {
    moviesData movD = acailableMovies_tableView.getSelectionModel().getSelectedItem();
    int num = acailableMovies_tableView.getSelectionModel().getSelectedIndex();
    if (num < 0) { // Simplified condition
        return;
    }
    acailableMovies_movieTitle.setText(movD.getTitle());
    acailableMovies_movieGenre.setText(movD.getGenre());
    acailableMovies_movieDate.setText(String.valueOf(movD.getDate()));
    getData.path = movD.getImage();
    getData.title = movD.getTitle();
}

 public void selectMovie() {

        String uri = "file:" + getData.path;

        image = new Image(uri, 136, 180, false, true);
        acailableMovies_imageView.setImage(image);

        acailableMovies_title.setText(getData.title);

        // CLEAR TEXT
        acailableMovies_movieTitle.setText("");
        acailableMovies_movieGenre.setText("");
        acailableMovies_movieDate.setText("");
    }

    private String[] currentList = {"Showing", "End Showing"};

    public void comboBox() {
        List<String> listCurrent = new ArrayList<>();

        for (String data : currentList) {
            listCurrent.add(data);
        }

        ObservableList listC = FXCollections.observableArrayList(listCurrent);

        editScreening_current.setItems(listC);

    }

    public void updateEditScreening() {
        String sql = "UPDATE movie SET current = '"
                + editScreening_current.getSelectionModel().getSelectedItem()
                + "' WHERE movieTitle = '" + editScreening_title.getText() + "'";
        connect = Database.connectDb();

        try {
            statement = connect.createStatement();
            Alert alert;

            if (editScreening_title.getText().isEmpty() || editScreening_imageView.getImage() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated !");
                alert.showAndWait();
                showEditScreening();
                clearEditScreening();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearEditScreening() {
        editScreening_title.setText("");
        editScreening_imageView.setImage(null);
//   editScreening_current.setSelectionModel(null);
    }

    public void searchEditScreening() {
        FilteredList<moviesData> filter = new FilteredList<>(editScreeningL, e -> true);

        editScreening_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateMoviesData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                // This condition is incomplete and will always return false
                if (predicateMoviesData.getTitle().toLowerCase().contains(searchKey)) {

                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(searchKey)) {

                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(searchKey)) {

                    return true;
                } else if (predicateMoviesData.getCurrent().toLowerCase().contains(searchKey)) {
                    return true;
                }

                return false;
            });
        });
        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
        editScreening_tableView.setItems(sortData);
    }

    public void selectEditScreening() {

        moviesData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
        int num = editScreening_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String uri = "file:" + movD.getImage();
        image = new Image(uri, 138, 183, false, true);
        editScreening_imageView.setImage(image);

        editScreening_title.setText(movD.getTitle());
    }

     public ObservableList<moviesData> editScreeningList() {
        ObservableList<moviesData> editSList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = Database.connectDb();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));
                editSList.add(movD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return editSList;
    }
    private ObservableList<moviesData> editScreeningL;

    public void showEditScreening() {
        editScreeningL = editScreeningList();

        editScreening_col_movie.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));

        editScreening_tableView.setItems(editScreeningL);
    }

    public void searchAddMovies() {
        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);

        addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateMoviesData -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }

                String keySearch = newValue.toLowerCase();

                // Example condition: match title or genre
                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)
                        || predicateMoviesData.getGenre().toLowerCase().contains(keySearch)
                        || predicateMoviesData.getDuration().toLowerCase().contains(keySearch)
                        || predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }

                return false;
            });
        });

        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
        addMovies_tableView.setItems(sortData);
    }

    public void importImage() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*.png", "*.jpg"));

        Stage stage = (Stage) addmovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 127, 167, false, true);
            addMovies_imageview.setImage(image);
            getData.path = file.getAbsolutePath();
        }
    }

    public void movieId() {

        String sql = "SELECT count(id) FROM movie";

        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                getData.movieId = result.getInt("count(id)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void insertAddMovies() {
    String checkSql = "SELECT * FROM movie WHERE movieTitle = ?";
    String insertSql = "INSERT INTO movie (id, movieTitle, genre, duration, image, date) VALUES (?, ?, ?, ?, ?, ?)";

    connect = Database.connectDb();
    Alert alert;

    try {
        // Validate inputs
        if (addMovies_title.getText().isEmpty() ||
            addMovies_genre.getText().isEmpty() ||
            addMovies_duration.getText().isEmpty() ||
            addMovies_date.getValue() == null) {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields and select a date.");
            alert.showAndWait();
            return;
        }

        // Check for duplicate movie title
        prepare = connect.prepareStatement(checkSql);
        prepare.setString(1, addMovies_title.getText());
        result = prepare.executeQuery();

        if (result.next()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(addMovies_title.getText() + " already exists!");
            alert.showAndWait();
            return;
        }

        // Generate unique movie ID
        movieId(); // sets getData.movieId
        String mID = String.valueOf(getData.movieId + 1);

        // Fix null image path
        String uri = (getData.path != null) ? getData.path.replace("\\", "\\\\") : "";

        // Prepare insert
        prepare = connect.prepareStatement(insertSql);
        prepare.setString(1, mID);
        prepare.setString(2, addMovies_title.getText());
        prepare.setString(3, addMovies_genre.getText());
        prepare.setString(4, addMovies_duration.getText());
        prepare.setString(5, uri);
        prepare.setDate(6, java.sql.Date.valueOf(addMovies_date.getValue())); // correct date usage

        prepare.executeUpdate();

        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully added new movie!");
        alert.showAndWait();

        showAddMoviesList();
        clearAddMovieList();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void updateAddMovies() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE movie SET movieTitle = '" + addMovies_title.getText()
                + "', genre = '" + addMovies_genre.getText()
                + "', duration = '" + addMovies_duration.getText()
                + "', image = '" + uri
                + "', date = '" + addMovies_date.getValue()
                + "'WHERE id = '" + String.valueOf(getData.movieId) + "'";

        connect = Database.connectDb();

        try {

            statement = connect.createStatement();

            Alert alert;

            if (addMovies_title.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageview.getImage() == null
                    || addMovies_date.getValue() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else {

                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully updated " + addMovies_title.getText());
                alert.showAndWait();

                clearAddMovieList();
                showAddMoviesList();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAddMovies() {
        String sql = "DELETE FROM movie WHERE movieTitle = ?";
        connect = Database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, addMovies_title.getText());
            int rowsAffected = prepare.executeUpdate();

            statement = connect.createStatement();

            Alert alert;

            if (addMovies_title.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_date.getValue() == null
                    || addMovies_imageview.getImage() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to selete? " + "?");
                alert.showAndWait();

                alert = new Alert(AlertType.CONFIRMATION);

                Optional<ButtonType> option = alert.showAndWait();

                if (ButtonType.OK.equals(option.get())) {

                    statement.executeUpdate(sql);

                    showAddMoviesList();
                    clearAddMovieList();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully deleted!");
                    alert.showAndWait();

                } else {

                    return;
                }
            }
            alert.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAddMovieList() {
        addMovies_title.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_imageview.setImage(null);
        addMovies_date.setValue(null);
    }

// NOW LETS PROCEED TO GIVE FUNCTIONS OUR ADD MOVIES :) BUT FIRST WE NEED TO CRE
    public ObservableList<moviesData> addMoviesList() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = Database.connectDb();
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                System.out.println("Movie title: " + result.getString("movieTitle"));
                movD = new moviesData(
                        result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current")
                );
                listData.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMoviesList();

        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));  // ✅ fixed spelling
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);
    }

    public void selectAddMoviesList() {

        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        getData.movieId = movD.getID();

        addMovies_title.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());
        String getDate = String.valueOf(movD.getDate());

        String uri = "file:" + movD.getImage();

        image = new Image(uri, 127, 167, false, true);
        addMovies_imageview.setImage(image);

        addMovies_date.setValue(movD.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());

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

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
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

        } else if (event.getSource() == addMovies_btn) {
            dashboard_form.setVisible(false);
            addmovies_form.setVisible(true);
            availablemovies_form.setVisible(false);
            editScreen_form.setVisible(false);
            customers_form.setVisible(false);
showAddMoviesList();
            addMovies_btn.setStyle("-fx-background-color:#ae2d3c;");
            dashboard_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreen_btn.setStyle("-fx-background-color:transparent");
            Customer_btn.setStyle("-fx-background-color:transparent");

        } else if (event.getSource() == availableMovies_btn) {
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

        } else if (event.getSource() == editScreen_btn) {
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

        } else if (event.getSource() == Customer_btn) {
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
        showEditScreening();
        comboBox();
        showAvailableMovies();
        showSpinnerValue();
    }
}
