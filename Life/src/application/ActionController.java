package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ActionController implements Initializable {


    @FXML
    private TextField age;

    @FXML
    private TableColumn<Patient, Integer> ages;

    @FXML
    private Button btdelete;

    @FXML
    private Button btinsert;

    @FXML
    private Button btupdate;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<Patient, Integer> iid;

    @FXML
    private TableColumn<Patient, String> iiname;

    @FXML
    private TextField iname;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<Patient, String> names;

    @FXML
    private TextField payment;

    @FXML
    private TableColumn<Patient, Double> payments;

    @FXML
    private TextField phone;

    @FXML
    private TableColumn<Patient, String> phones;

    @FXML
    private TableView<Patient> table;

    @FXML
    private TextField year;

    @FXML
    private TableColumn<Patient, Integer> years;
   @FXML 
  private void insert() {
    	String query = "insert into patient values("+id.getText()+",'"+iname.getText()+"','"+name.getText()+"','"+age.getText()+"','"+year.getText()+"','"+phone.getText()+"','"+payment.getText()+"')";
    	executeQuery(query);
    	showPatients();
    }
    
  
    @FXML 
    private void updateButton() {
    String query = "UPDATE patient SET insurance_id='"+id.getText()+"',insurance_name='"+iname.getText()+"',name='"+name.getText()+"',age='"+age.getText()+"', year='"+year.getText()+"',number='"+phone.getText()+"',payment='"+payment.getText()+"' ";
    executeQuery(query);
	showPatients();
    }
    
    @FXML
    private void deleteButton() {
    	String query = "DELETE FROM patient WHERE insurance_id="+id.getText()+"";
    	executeQuery(query);
    	showPatients();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showPatients();
	}
	 public Connection getConnection() {
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/life", "root", "1234567890");
	            return conn;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 public void executeQuery(String query) {
	        Connection conn = getConnection();
	        Statement st;
	        try {
	            st = conn.createStatement();
	            st.executeUpdate(query);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public ObservableList<Patient> getpList() {
	        ObservableList<Patient> pList = FXCollections.observableArrayList();
	        Connection connection = getConnection();
	        String query = "SELECT * FROM patient";
	        Statement st;
	        ResultSet rs;

	        try {
	            st = connection.createStatement();
	            rs = st.executeQuery(query);
	            Patient patient;
	            while (rs.next()) {
	                patient = new Patient(rs.getInt("insurance_id"), rs.getString("insurance_name"), rs.getString("name"), rs.getInt("age"), rs.getInt("year"), rs.getString("number"), rs.getDouble("payment"));
	                pList.add(patient);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return pList;
	    }

	    public void showPatients() {
	    	 ObservableList<Patient> list = getpList();

		        iid.setCellValueFactory(new PropertyValueFactory<>("id"));
		        iiname.setCellValueFactory(new PropertyValueFactory<>("iname"));
		        names.setCellValueFactory(new PropertyValueFactory<>("name"));
		        ages.setCellValueFactory(new PropertyValueFactory<>("age"));
		        years.setCellValueFactory(new PropertyValueFactory<>("year"));
		        phones.setCellValueFactory(new PropertyValueFactory<>("number"));
		        payments.setCellValueFactory(new PropertyValueFactory<>("payment"));
		        


		        table.setItems(list);
	    }
}
