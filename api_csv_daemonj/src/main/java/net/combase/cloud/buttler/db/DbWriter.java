package net.combase.cloud.buttler.db;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import net.combase.api.domain.Customer;
import net.combase.cloud.buttler.db.domain.FilesParsed;
import net.combase.cloud.buttler.db.domain.ImportedCustomer;
import net.combase.cloud.buttler.db.domain.LastRevision;
import net.combase.cloud.buttler.db.domain.Token;

public class DbWriter extends DBController {

	public static FilesParsed writeToken(final Token token) throws IOException {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS token (id INTEGER PRIMARY KEY, token TEXT);");

			// stmt.execute("INSERT INTO token (token) VALUES ('" + token +
			// "')");
			stmt.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static FilesParsed writeParsedFiles(final FilesParsed filesParsed)
			throws IOException {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS files_parsed (id INTEGER PRIMARY KEY, customer_group NUMERIC, name TEXT, md5hash TEXT);");

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
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS imported_customer (id INTEGER PRIMARY KEY, file_id INTEGER, status INTEGER, customer_name TEXT, customer_numer INTEGER);");
			// stmt.execute("INSERT INTO token (token) VALUES ('" + token +
			// "')");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int writeExportedRevision(final LastRevision lastRevision)
			throws IOException {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS exported_revision (id INTEGER PRIMARY KEY, customer_group INTEGER, revision INTEGER);");
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
