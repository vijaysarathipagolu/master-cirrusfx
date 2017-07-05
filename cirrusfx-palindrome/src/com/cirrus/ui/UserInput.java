/**
 * 
 */
package com.cirrus.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author vijay
 *
 */
public class UserInput extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		arg0.setTitle("CirrsuFx Palindrome Search");
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(20,50,50,50));
		
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,30,10,30));
		
		Text headLine = new Text("Palindrome Search");
		hb.getChildren().add(headLine);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		
		Label lowerBoundLabel = new Label("Lower Bound");
        final TextField lowerBoundTxt = new TextField();
		Label upperBoundLabel = new Label("Upper Bound");
		final TextField upperBoundTxt = new TextField();
		
		
		
		gridPane.add(lowerBoundLabel,0,0);
		gridPane.add(lowerBoundTxt,1,0);
		gridPane.add(upperBoundLabel,0,1);
		gridPane.add(upperBoundTxt,1,1);
		
		bPane.setTop(hb);
		bPane.setCenter(gridPane);
		
		Scene sc = new Scene(bPane);
		
		arg0.setScene(sc);
		arg0.show();
	}

	
}
