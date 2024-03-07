package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class newuserController {

    @FXML
    private TextField city;

    @FXML
    private TextField email;

    @FXML
    private TextField first;

    @FXML
    private TextField gender;

    @FXML
    private TextField last;

    @FXML
    private PasswordField pass;

    @FXML
    private Button registers;

    @FXML
    private TextField street;

    @FXML
    private TextField userID;

    @FXML
    public void clickRegister() throws IOException, SQLException {
    	
        
     
    
        if (userID.getText().isEmpty() || pass.getText().isEmpty() || first.getText().isEmpty() || last.getText().isEmpty() ||  email.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty() ||  gender.getText().isEmpty() ) {
            // Show error message
        	Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please fill all fields");
            alert.setContentText("One or more fields are empty. Please fill all fields to proceed.");
            alert.showAndWait();
        } else {
            // Connect to database
            Connection connection = DatabaseConnection.connectDb();

            if (connection != null) {
                // Prepare SQL statement
                String sql = "insert into user values("+userID.getText()+",'"+pass.getText()+"','"+first.getText()+"','"+last.getText()+"','"+email.getText()+"','"+city.getText()+"','"+street.getText()+"','"+gender.getText()+"')";

                executeQuery(sql);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText("Registration successful");
                    alert.setContentText("Your account has been successfully created.");
                    alert.showAndWait();

                   
                    
    		 Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	     Stage stage = new Stage();
    	     Scene scene = new Scene(root);

    	     stage.setScene(scene);
    	     stage.show();

    	     // Close the current stage (optional, depending on your application flow)
    	     ((Stage) registers.getScene().getWindow()).close();
                }
    	                }
        }
    
    public void executeQuery(String query) {
        Connection conn = connectDb();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection connectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/life","root","1234567890");
            return connect;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    
    

  

        	 
         }

}
