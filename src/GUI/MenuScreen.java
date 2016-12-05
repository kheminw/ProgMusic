package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MenuScreen implements Initializable{
	private Parent root;
	public MenuScreen() throws IOException{
		root = FXMLLoader.load(getClass().getResource("MenuScreen.fxml"));
		
		
	}
	public Parent getRoot(){
		return root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	 
}
