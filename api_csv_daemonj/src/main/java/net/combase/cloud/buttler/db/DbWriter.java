package net.combase.cloud.buttler.db;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import net.combase.api.domain.Customer;
import net.combase.cloud.buttler.db.domain.FilesParsed;
import net.combase.cloud.buttler.db.domain.ImportedCustomer;

public class DbWriter extends DBController {

	public static FilesParsed writeParsedFiles(final Long customerGroupNumber)
			throws IOException {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS token (token);");

			// stmt.execute("INSERT INTO token (token) VALUES ('" + token +
			// "')");

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ImportedCustomer writeCusomers(
			final Long customerGroupNumber, final Customer customer)
			throws IOException {
		try {
			Statement stmt = connection.createStatement();
			// stmt.executeUpdate("CREATE TABLE IF NOT EXISTS token (token);");
			// final String token = getToken();
			// stmt.execute("INSERT INTO token (token) VALUES ('" + token +
			// "')");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int writeLastExportedRevision(
			final Long customerGroupNumber, final int revison)
			throws IOException {
		try {
			Statement stmt = connection.createStatement();
			// stmt.executeUpdate("CREATE TABLE IF NOT EXISTS token (token);");
			// final String token = getToken();
			// stmt.execute("INSERT INTO token (token) VALUES ('" + token +
			// "')");
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
