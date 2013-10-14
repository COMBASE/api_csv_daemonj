package net.combase.cloud.buttler.db;

import java.awt.TrayIcon;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.combase.api.ApiProperties;
import net.combase.api.Token;
import net.combase.cloud.buttler.db.domain.FilesParsed;

public class DbReader extends DBController {
	public static String getToken(TrayIcon processTrayIcon) throws IOException {
		try {
			final Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM token;");

			Token token = new Token();
			while (rs.next()) {
				token.setToken(rs.getString("token"));
				break;
			}
			if (token.getToken() == null) {
				token = ApiProperties.generateToken(processTrayIcon);
				if (token != null && !token.equals(""))
					stmt.execute("INSERT INTO token (token) VALUES ('" + token + "')");
			}
			return token.getToken();
		} catch (SQLException e) {
			// e.printStackTrace();
			if (e.getMessage().contains("no such table: token")) {

				final Token t = ApiProperties.generateToken(processTrayIcon);
				if (t != null)
					DbWriter.writeToken(t);
			}

		}
		return null;
	}

	public static String getToken() throws IOException {
		try {
			final Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM token;");

			Token token = new Token();
			while (rs.next()) {
				token.setToken(rs.getString("token"));
				break;
			}
			if (token.getToken() == null) {
				token = ApiProperties.generateToken(null);
				if (token != null && !token.equals(""))
					stmt.execute("INSERT INTO token (token) VALUES ('" + token + "')");
			}
			return token.getToken();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static FilesParsed getFileByPath(String customerGroupNumber, String absolutePath) throws IOException {
		try {
			Connection con = connection;
			final Statement stmt = con.createStatement();
			final ResultSet rs = stmt.executeQuery("SELECT * FROM files_parsed WHERE customerGroup = "
					+ customerGroupNumber + " AND name = '" + absolutePath+"';");
			FilesParsed filesParsed = null;
			while (rs.next()) {
				filesParsed = new FilesParsed();
				filesParsed.setMd5Hash(rs.getString("md5hash"));
				filesParsed.setName(rs.getString("name"));
				filesParsed.setCustomerGroup(rs.getString("customerGroup"));
				break;
			}
			if (filesParsed == null)
				return filesParsed;
			return filesParsed;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
