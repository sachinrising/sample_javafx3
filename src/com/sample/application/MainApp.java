package com.sample.application;

import com.sample.fxml.FXMLLocation;
import com.sample.view.StageView;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StageView stageView = new StageView(FXMLLocation.SAMPLE_FXML, StageStyle.UNDECORATED);
		stageView.showAndCenterOnScreen();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
