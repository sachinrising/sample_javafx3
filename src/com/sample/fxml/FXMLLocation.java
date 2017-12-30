package com.sample.fxml;

public class FXMLLocation {
	
	private static final String DEFAULT_FXML_PATH = "/com/sample/fxml/";
	private static final String FXML_EXTENSION =".fxml";
	
	public static final String SAMPLE_FXML 			= "Sample";
	public static final String FXML_TABLEVIEW_FXML 	= "Fxml_TableView";
	public static final String ADD_COMPANY 			= "Add_Company";

	public static String getFXMLPath(String FXML) {
		return DEFAULT_FXML_PATH + FXML + FXML_EXTENSION;
	}
}
