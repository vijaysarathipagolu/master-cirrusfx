
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
 *         The class creates a UI console using javaFX for the user to input the
 *         lower and upper boundary values and displays the largest palindrome
 *         in the given range back to the user in the UI console.
 *
 */
public class UserInput extends Application {

	public static void main(String[] args) {
		launch(args); // launches the application.
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

		arg0.setTitle("CirrsuFx Palindrome Search");
		BorderPane bPane = new BorderPane();
		bPane.setPadding(new Insets(20, 70, 70, 70));

		HBox hb = new HBox();
		hb.setPadding(new Insets(10, 30, 10, 30));

		Text headLine = new Text("Palindrome Search");
		headLine.setFont(Font.font("Times New", FontWeight.EXTRA_BOLD, 30));
		hb.getChildren().add(headLine);

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setVgap(5);
		gridPane.setHgap(5);

		Label lowerBoundLabel = new Label("Lower Bound: ");
		final TextField lowerBoundTxt = new TextField();
		Label upperBoundLabel = new Label("Upper Bound: ");
		final TextField upperBoundTxt = new TextField();
		Button searchBtn = new Button("Search");
		final Label lblSearch = new Label();

		// Adding the input and search button labels to the grid pane
		gridPane.add(lowerBoundLabel, 0, 0);
		gridPane.add(lowerBoundTxt, 1, 0);
		gridPane.add(upperBoundLabel, 0, 1);
		gridPane.add(upperBoundTxt, 1, 1);
		gridPane.add(lblSearch, 2, 1);
		gridPane.add(searchBtn, 1, 2);

		bPane.setTop(hb); // adding the horizontal box to the border pane at the

		bPane.setCenter(gridPane); // adding the grid pane to the border pane at

		Label searchResult = new Label(); // label to display the search results

		// this function is used to handle the button onClick action event, it's
		// invoked every time the button is clicked!
		searchBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String result = "";
				searchResult.setText(""); // clearing the previous search result

				try {
					String lowBound = lowerBoundTxt.getText().toString();
					String upBound = upperBoundTxt.getText().toString();

					// returns the largest palindrome number from the range
					result = getLargestPalindrome(lowBound, upBound);
					searchResult.setText("The largest Palindrome Number in the range is: " + result);
					searchResult.setFont(Font.font("Times New", FontWeight.BOLD, 10));

				} catch (NoSuchElementException ne) {
					// this catch block is used to handle negative number inputs
					System.out.println(ne.getMessage());
					searchResult.setText("The Lower, Upper bound values can't be negative");
					searchResult.setFont(Font.font("Times New", FontWeight.BOLD, 10));
				} catch (NumberFormatException nf) {
					// this catch block is used to handle null inputs
					System.out.println(nf.getMessage());
					searchResult.setText("The input bound values can't be empty");
					searchResult.setFont(Font.font("Times New", FontWeight.BOLD, 10));
				}
			}
		});

		// adding the search result label to the grid pane
		gridPane.add(searchResult, 1, 3);
		Scene sc = new Scene(bPane);

		arg0.setScene(sc);
		arg0.show();
	}

	/*
	 * This method returns the Largest palindrome number found in the given
	 * input range
	 */
	public String getLargestPalindrome(String lowBound, String upBound) {

		List<Integer> al = new ArrayList<Integer>();

		int lowerBound = Integer.valueOf(lowBound);
		int upperBound = Integer.valueOf(upBound);

		for (int i = lowerBound; i <= upperBound; i++) {
			int j = i;
			int sum = 0;
			while (j > 0) {
				sum = (sum * 10) + (j % 10);
				j = j / 10;
			}

			if (sum == i)
				al.add(i); // adding the element to the list if its a palindrome
		}

		al.forEach(System.out::println); // printing all elements

		// returning the max element from the stream
		return al.stream().max(Integer::compare).get().toString();

	}

}
