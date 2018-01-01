package com.sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {

	private String databaseURL;
	
	private final String LOGIN_TABLEL = "CREATE TABLE IF NOT EXISTS login (\n"
			+ " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user VARCHAR(10) NOT NULL UNIQUE, \n"
			+ " password VARCHAR(64) NOT NULL, sqltime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL);";

	String tables[] = {LOGIN_TABLEL};
	
	public void create () {
		
		for(String tableSQL: tables) {
			createTable(tableSQL);
		}
	}

	private void createTable(String tableSQL) {

		try(Connection conn = DriverManager.getConnection(databaseURL) ) {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(tableSQL);
		} catch (SQLException ex) {
			
		}
	}
	
	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}
}
