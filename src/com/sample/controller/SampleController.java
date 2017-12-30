package com.sample.controller;

import com.sample.fxml.FXMLLocation;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class SampleController extends BaseController {

  public SampleController() {
    System.out.println("Controller runs here");
  }

  @FXML private PasswordField passwordField;
  @FXML private Button signInBtn;
  @FXML private Button signUpBtn;
  @FXML private AnchorPane signInPane;
  @FXML private AnchorPane signUpPane;

  @FXML
  protected void handleSubmitButtonAction(ActionEvent event) {
    primeStage.changeStage(FXMLLocation.FXML_TABLEVIEW_FXML, true);
  }

  @FXML
  private void handleSignUpButtonAction(ActionEvent event) {}

  @FXML
  private void closeTheScreen(MouseEvent event) {
    primeStage.close();
  }

  @FXML
  private void setHandCursor(MouseEvent event) {
    primeStage.getScene().setCursor(Cursor.HAND);
  }

  @FXML
  private void setResetCursor(MouseEvent event) {
    primeStage.getScene().setCursor(Cursor.DEFAULT);
  }

  @FXML
  private void showSignUp(ActionEvent event) {
    switchHideSignUpSignIn(false, signInPane, signUpPane);
  }

  @FXML
  private void showLogin(ActionEvent event) {
    switchHideSignUpSignIn(true, signUpPane, signInPane);
  }

  private void switchHideSignUpSignIn(boolean isSignIn, Parent hideparent, Parent showParent) {

    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.800), hideparent);

    Point3D axis = Rotate.Y_AXIS;
    rotateTransition.setAxis(axis);
    rotateTransition.setFromAngle(0);
    rotateTransition.setToAngle(180);

    RotateTransition rotateTransition2 = new RotateTransition(Duration.seconds(0.800), showParent);
    rotateTransition2.setAxis(axis);
    rotateTransition2.setFromAngle(180);
    rotateTransition2.setToAngle(360);

    rotateTransition2.setOnFinished(
        value -> {
          signInBtn.setVisible(!isSignIn);
          signUpBtn.setVisible(isSignIn);
        });

    rotateTransition.setOnFinished(
        value -> {
          hideparent.setVisible(false);
          showParent.setVisible(true);
          rotateTransition2.play();
        });
    rotateTransition.setCycleCount(1);
    rotateTransition.play();
  }
}
