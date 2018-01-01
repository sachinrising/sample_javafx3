package com.sample.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDatabase {

	private final int ID_COL = 0;
	private final int USER_COL = 1;
	private final int PASSWORD_COL = 2;
	private final int CREATION_TIME_COL = 3;

	Connection connection;

	public LoginDatabase() {
		createTable();
	}

	private void createTable() {

		connection = Database.getConnection();

		if (connection == null) {
			System.err.println("Could not connect to the database");
			return;
		}

		try (Statement stmt = connection.createStatement()) {

			stmt.execute(DatabaseUtility.LOGIN_TABLE_SQL);
			defaultValues(connection);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private void defaultValues(Connection conn) {
		String user = "admin";
		String password = "admin";

		insertIntoLoginTable(conn, user, password);
	}

	private String cryptWithMD5(String pass) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");

			byte[] passBytes = pass.getBytes();
			byte[] digestBytes = md5.digest(passBytes);

			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < digestBytes.length; i++) {
				sb.append(Integer.toHexString(0xff & digestBytes[i]));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return null;
	}

	public void insertIntoLoginTable(Connection conn, String userName, String password) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(DatabaseUtility.INSERT_INTO_LOGIN_TBL);
			pstmt.setString(USER_COL, userName);
			pstmt.setString(PASSWORD_COL, cryptWithMD5(password));

			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean validateLogin(String user, String password) {

		Connection conn = connection;

		String validateQuery = "SELECT USER, PASSWORD FROM login WHERE USER = ?;";

		boolean isValid = false;

		try (PreparedStatement pstmt = conn.prepareStatement(validateQuery)) {
			pstmt.setString(USER_COL, user);
			ResultSet result = pstmt.executeQuery();

			if (result != null && result.next()) {
				String originalPwd = result.getString(PASSWORD_COL);

				if (originalPwd.equals(cryptWithMD5(password))) {
					isValid = true;
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return isValid;
	}
}
