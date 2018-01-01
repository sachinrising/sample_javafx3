package com.sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class CreateDatabase {

	private void createDatabase() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseUtility.getDefaultDB());
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}

	}
}
