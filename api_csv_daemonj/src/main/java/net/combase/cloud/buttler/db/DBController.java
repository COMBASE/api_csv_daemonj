package net.combase.cloud.buttler.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.combase.cloud.buttler.api.ApiUtil;

public class DBController {

	private static final DBController dbcontroller = new DBController();
	private static Connection connection;
	private static final String DB_PATH = "testdb.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			e.printStackTrace();
		}
	}

	private DBController() {
	}

	public static DBController getInstance() {
		return dbcontroller;
	}

	public void initDBConnection() {
		try {
			if (connection != null)
				return;
			System.out.println("Creating Connection to Database...");
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
			if (!connection.isClosed())
				System.out.println("...Connection established");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					if (!connection.isClosed() && connection != null) {
						connection.close();
						if (connection.isClosed())
							System.out.println("Connection to Database closed");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static String getToken() throws IOException {
		try {
			final Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM token;");
			String token = null;
			while (rs.next()) {

				token = rs.getString("token");
			}
			if (token == null) {
				token = ApiUtil.generateToken();
				if (token != null && !token.equals(""))
					stmt.execute("INSERT INTO token (token) VALUES ('" + token
							+ "')");
			}
			return token;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generateToken() throws IOException {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS token (token);");
			final String token = getToken();
			stmt.execute("INSERT INTO token (token) VALUES ('" + token + "')");

			return token;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void handleDB() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS books;");
			stmt.executeUpdate("CREATE TABLE books (author, title, publication, pages, price);");
			stmt.execute("INSERT INTO books (author, title, publication, pages, price) VALUES ('Paulchen Paule', 'Paul der Penner', '2001-05-06', '1234', '5.67')");

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, ?);");

			ps.setString(1, "Willi Winzig");
			ps.setString(2, "Willi's Wille");
			ps.setDate(3, Date.valueOf("2011-05-16"));
			ps.setInt(4, 432);
			ps.setDouble(5, 32.95);
			ps.addBatch();

			ps.setString(1, "Anton Antonius");
			ps.setString(2, "Anton's Alarm");
			ps.setDate(3, Date.valueOf("2009-10-01"));
			ps.setInt(4, 123);
			ps.setDouble(5, 98.76);
			ps.addBatch();

			connection.setAutoCommit(false);
			ps.executeBatch();
			connection.setAutoCommit(true);

			ResultSet rs = stmt.executeQuery("SELECT * FROM books;");
			while (rs.next()) {
				System.out.println("Autor = " + rs.getString("author"));
				System.out.println("Titel = " + rs.getString("title"));
				System.out.println("Erscheinungsdatum = "
						+ rs.getDate("publication"));
				System.out.println("Seiten = " + rs.getInt("pages"));
				System.out.println("Preis = " + rs.getDouble("price"));
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Couldn't handle DB-Query");
			e.printStackTrace();
		}
	}
}
