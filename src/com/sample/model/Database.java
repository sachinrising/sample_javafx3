package com.sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {

	static int numberOfConnection = 10;
	static ArrayList<Connection> connections = new ArrayList<>();

	static String databaseURL;

	public static void setDatabaseURL(String databaseURL) {
		Database.databaseURL = databaseURL;
	}

	public static final int FIRST_CONNECTION = 0;

	public static void generateConnections() {

		for (int i = 0; i < numberOfConnection; i++) {
			try {
				Connection con = DriverManager.getConnection(databaseURL);

				if (con != null) {
					con.setAutoCommit(false);
					connections.add(con);
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	synchronized public static Connection getConnection() {

		if (!connections.isEmpty()) {
			Connection con = connections.get(FIRST_CONNECTION);
			connections.remove(FIRST_CONNECTION);
			return con;
		}

		return null;
	}

	synchronized public static boolean freeConnection(Connection con) {

		if (con == null) {
			return false;
		}

		connections.add(con);
		return false;
	}
}
