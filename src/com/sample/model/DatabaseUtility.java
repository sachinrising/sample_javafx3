package com.sample.model;

public class DatabaseUtility {

	private static final String USB_DB = "usb.db";

	private static final String USB_DB_URL = "jdbc:sqlite:db/" + USB_DB;

	public static final String LOGIN_TABLE_SQL = "CREATE TABLE IF NOT EXISTS login (\n"
			+ " id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, user VARCHAR(10) NOT NULL UNIQUE, \n"
			+ " password VARCHAR(64) NOT NULL, sqltime TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL);";
	
	public static final String INSERT_INTO_LOGIN_TBL = "INSERT INTO login (user, password) VALUES (?,?);";

	public static String getDefaultDB() {
		return USB_DB_URL;
	}
	
}
