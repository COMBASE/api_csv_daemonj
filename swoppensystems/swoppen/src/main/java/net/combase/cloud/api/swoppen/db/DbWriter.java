package net.combase.cloud.api.swoppen.db;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import net.combase.api.Token;
import net.combase.api.domain.Customer;
import net.combase.cloud.api.swoppen.db.domain.FilesParsed;
import net.combase.cloud.api.swoppen.db.domain.ImportedCustomer;
import net.combase.cloud.api.swoppen.db.domain.LastRevision;

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

	public static FilesParsed writeParsedFiles(final FilesParsed filesParsed) throws IOException {
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

	public static ImportedCustomer writeCusomers(final Long customerGroupNumber, final Customer customer)
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

	public static int writeExportedRevision(final LastRevision lastRevision) throws IOException {
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

	public static void createTableFiles() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS files_parsed (customerGroup INTEGER, name TEXT, md5Hash TEXT);");

	}

	public static void createTableCustomer() throws SQLException {
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS imported_customer (status INTEGER, file_id INTEGER, customer_number NUMBER, customer_name TEXT);");

	}

	public static ImportedCustomer updateCustomer(ImportedCustomer existingClienCustomer) {
		// print
		// "UPDATE parsed_lines SET current = $customer->{current} WHERE customer_number = $customer->{customer_number}\n";
		if (existingClienCustomer != null) {
//			try {
//				Statement stmt = connection.createStatement();
				String string = "UPDATE imported_customer SET status = '" + existingClienCustomer.getStatus()
						+ "' file_id = '" + existingClienCustomer.getFileId() + "' customer_name = '"
						+ existingClienCustomer.getCustomerName() + "' WHERE customer_number = ? '"
						+ existingClienCustomer.getCustomerNumber() + "';";
				System.out.println(string);
//				stmt.executeUpdate(string);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}
		// TODO Auto-generated method stub
		return null;
	}

	public static ImportedCustomer setCustomer(ImportedCustomer existingClienCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	public static FilesParsed setFile(String number, String absolutePath) {
		// TODO Auto-generated method stub
		return null;
	}

}
