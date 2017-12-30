package com.sample.controller;

import java.util.ArrayList;

import com.sample.fxml.FXMLLocation;
import com.sample.model.Person;
import com.sample.view.StageView;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class FXMLTableViewController extends BaseController {

  ArrayList<Person> values;
  @FXML HBox hBox;
  @FXML TextField firstName;
  @FXML TextField lastName;
  @FXML TextField email;

  @Override
  protected ArrayList<Person> getTableValues() {
    values = Person.createInstance();
    return values;
  }

  @FXML
  private void addPeople(Event event) {
    addPeopleData();
  }

  @FXML
  private void onKeyPressed(KeyEvent event) {
    if (event != null && event.getCode().equals(KeyCode.ENTER)) {
      addPeopleData();
    }
  }

  private void addPeopleData() {
    ObservableList<Object> data = tableView.getItems();
    data.add(new Person(firstName.getText(), lastName.getText(), email.getText()));

    firstName.setText("");
    lastName.setText("");
    email.setText("");
  }

  @FXML
  private void addCompany(ActionEvent event) {
	  StageView addView = new StageView(FXMLLocation.ADD_COMPANY);
	  addView.showAndCenterOnScreen();
  }
}
