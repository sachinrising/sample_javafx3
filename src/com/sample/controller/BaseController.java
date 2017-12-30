package com.sample.controller;

import java.util.ArrayList;

import com.sample.view.StageView;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class BaseController {

	StageView primeStage;

	@FXML
	protected TableView<Object> tableView;

	@FXML
	private void initialize() {
		populateData();
	}

	protected void populateData() {
		if (tableView != null)
			tableView.getItems().setAll(getTableValues());
	}

	protected ArrayList<?> getTableValues() {
		return null;
	}

	public void setPrimeStage(StageView primeStage) {
		this.primeStage = primeStage;
	}

	public StageView getPrimeStage() {
		return primeStage;
	}

}
