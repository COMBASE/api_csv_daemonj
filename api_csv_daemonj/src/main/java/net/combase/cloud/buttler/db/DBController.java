package net.combase.cloud.buttler.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {

	private static final DBController dbcontroller = new DBController();
	protected static Connection connection;
	private static final String DB_PATH = "butler.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des JDBC-Treibers");
			e.printStackTrace();
		}
	}

	public static DBController get() {
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

	public boolean checkFileWithDB(String absolutePath, String md5) {
		// TODO Auto-generated method stub
		return false;
	}




}
