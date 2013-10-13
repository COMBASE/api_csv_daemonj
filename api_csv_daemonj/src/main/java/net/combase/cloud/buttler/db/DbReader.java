package net.combase.cloud.buttler.db;

import java.awt.TrayIcon;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import net.combase.api.ApiProperties;
import net.combase.api.Token;
import net.combase.cloud.buttler.db.domain.FilesParsed;
import net.combase.cloud.buttler.db.domain.ImportedCustomer;

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

	public static List<ImportedCustomer> getCustomer(final Long customerGroupNumber) {
		return null;
	}

	public static List<FilesParsed> getFiles(final Long customerGroupNumber) {
		return null;
	}

	public static List<FilesParsed> getLastRevision(final Long customerGroupNumber) {
		return null;
	}
}
