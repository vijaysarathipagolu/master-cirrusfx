/**
 * 
 */
package com.cirrus.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		bPane.setPadding(new Insets(20,70,70,70));
		
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(10,30,10,30));
		
		Text headLine = new Text("Palindrome Search");
		headLine.setFont(Font.font("Times New",FontWeight.EXTRA_BOLD,30));
		hb.getChildren().add(headLine);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20,20,20,20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		
		Label lowerBoundLabel = new Label("Lower Bound");
        final TextField lowerBoundTxt = new TextField();
		Label upperBoundLabel = new Label("Upper Bound");
		final TextField upperBoundTxt = new TextField();
		Button searchBtn = new Button("Search");
		final Label lblSearch = new Label();
		
		
		gridPane.add(lowerBoundLabel,0,0);
		gridPane.add(lowerBoundTxt,1,0);
		gridPane.add(upperBoundLabel,0,1);
		gridPane.add(upperBoundTxt,1,1);
		gridPane.add(lblSearch, 2, 1);
		gridPane.add(searchBtn, 1, 2);
		
		bPane.setTop(hb);
		bPane.setCenter(gridPane);
		
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String result="";Text searchResult = null;
				try{
				String lowBound = lowerBoundTxt.getText().toString();
				String upBound = upperBoundTxt.getText().toString();
				result = getLargestPalindrome(lowBound, upBound);
				searchResult = new Text("The largest Palindrome Number in the range is: " +result);
				searchResult.setFont(Font.font("Times New",FontWeight.BOLD,10));
				gridPane.add(searchResult,1,3);
				}catch(NoSuchElementException ne){
					System.out.println(ne.getMessage());
					searchResult = new Text("The Lower, Upper bound values can't be negative");
					searchResult.setFont(Font.font("Times New",FontWeight.BOLD,10));
					gridPane.add(searchResult,1,3);
				}catch(NumberFormatException nf){
					System.out.println(nf.getMessage());
					searchResult = new Text("The input bound values can't be empty");
					searchResult.setFont(Font.font("Times New",FontWeight.BOLD,10));
					gridPane.add(searchResult,1,3);
				}
			}
		});
		
		Scene sc = new Scene(bPane);
		
		arg0.setScene(sc);
		arg0.show();
	}
	
	
	public String getLargestPalindrome(String lowBound, String upBound){
		
		List<Integer> al = new ArrayList<Integer>();
		
		int lowerBound = Integer.valueOf(lowBound);
		int upperBound = Integer.valueOf(upBound);
		
		System.out.println(lowerBound + "----" +upperBound);
		
		for(int i=lowerBound;i<=upperBound; i++ ){
			int j = i;
			int sum=0;
			while(j>0){
			sum = (sum*10) + (j%10);
			j = j/10;
			}
			
			if(sum == i)
			al.add(i);	
		}
		
		al.forEach(System.out::println);

		return	al.stream().max(Integer::compare).get().toString();
		

		
		
	}

	
}
