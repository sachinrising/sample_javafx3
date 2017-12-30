package com.sample.view;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sample.controller.BaseController;
import com.sample.fxml.FXMLLocation;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageView extends Stage implements IViewStage {

  Parent parent;
  Scene viewScene;
  String fxml;
  BaseController baseController;

  public StageView(String fxml) {
    initialization(fxml);
  }

  public StageView(String fxml, StageStyle style) {
    initialization(fxml);
    initStyle(style);
  }

  private void initialization(String fxml) {
    this.fxml = fxml;
    initParent();
    setScene(initScene());
  }

  /** Sets the Pane by fetching the FXML */
  @Override
  public void initParent() {
    try {
      String fxmlPath = FXMLLocation.getFXMLPath(getFXML());

      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//      ResourceBundle resourceBundle = ResourceBundle.getBundle("com.sample.internationalized.Bundle", new Locale("en", "EN"));
      ResourceBundle resourceBundle = ResourceBundle.getBundle("com.sample.internationalized.Bundle", new Locale("fr", "FR"));
      loader.setResources(resourceBundle);
 
      parent = (Pane) loader.load();
      baseController = (BaseController) loader.getController();

      if (baseController != null) {
        baseController.setPrimeStage(this);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Scene initScene() {
    viewScene = new Scene(parent);
    return viewScene;
  }

  @Override
  public String getFXML() {
    return fxml;
  }

  public void changeStage(String fxml, boolean closeCurrent) {
    StageView stageView = new StageView(fxml);

    if (closeCurrent) {
      this.hide();
    }

    stageView.showAndCenterOnScreen();
  }

  public void showAndCenterOnScreen() {
    show();
//    centerOnScreen();
    setScreenOnCenter();
    setY(getY() + 50);
    getIcons();
  }
  
  private void setScreenOnCenter() {
	  Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
      setX((primScreenBounds.getWidth() - getWidth()) / 2);
      setY((primScreenBounds.getHeight() - getHeight()) / 2);
  }
}
