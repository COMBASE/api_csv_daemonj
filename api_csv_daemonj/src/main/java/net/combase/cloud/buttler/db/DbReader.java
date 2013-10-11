package net.combase.cloud.buttler.db;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import net.combase.cloud.buttler.api.ApiUtil;
import net.combase.cloud.buttler.db.domain.FilesParsed;
import net.combase.cloud.buttler.db.domain.ImportedCustomer;

public class DbReader extends DBController {
	public static String getToken() throws IOException {
		try {
			final Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM token;");

			String token = null;
			while (rs.next()) {
				token = rs.getString("token");
				if (token == null) {
					token = ApiUtil.generateToken();
					if (token != null && !token.equals(""))
						stmt.execute("INSERT INTO token (token) VALUES ('"
								+ token + "')");
				}
				break;
			}
			return token;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<ImportedCustomer> getCustomer(
			final Long customerGroupNumber) {
		return null;
	}

	public static List<FilesParsed> getFiles(final Long customerGroupNumber) {
		return null;
	}

	public static List<FilesParsed> getLastRevision(
			final Long customerGroupNumber) {
		return null;
	}
}
