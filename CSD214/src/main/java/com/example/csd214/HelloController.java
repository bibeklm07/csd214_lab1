package com.example.csd214;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<clubdetail> clubdetail;
    @FXML
    private TableColumn<clubdetail, Integer> clubid;
    @FXML
    private TableColumn<clubdetail, String> clubname;
    @FXML
    private TableColumn<clubdetail, String> mainplayer;

    ObservableList<clubdetail> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubid.setCellValueFactory(new
                PropertyValueFactory<clubdetail, Integer>("clubid"));
        clubname.setCellValueFactory(new
                PropertyValueFactory<clubdetail, String>("clubname"));
        mainplayer.setCellValueFactory(new
                PropertyValueFactory<clubdetail, String>("mainplayer"));

        clubdetail.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }

    public void populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/clubs";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM clubdetail";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int clubid = resultSet.getInt("clubid");
                String clubname = resultSet.getString("clubname");
                String mainplayer = resultSet.getString("mainplayer");

                clubdetail.getItems().add(new clubdetail(clubid, clubname, mainplayer
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}