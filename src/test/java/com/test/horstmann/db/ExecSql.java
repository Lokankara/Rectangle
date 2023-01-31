package com.test.horstmann.db;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.sql.*;

class ExecSql {
	public static void main(String args[]) throws IOException {
		try (Scanner in = args.length == 0 ? new Scanner(System.in)
				: new Scanner(Paths.get(args[0]), StandardCharsets.UTF_8)) {
			try (Connection conn = getConnection(); Statement stat = conn.createStatement()) {
				while (true) {
					if (args.length == 0)
						System.out.println("Enter command or EXIT to exit:");
					if (!in.hasNextLine())
						return;
					String line = in.nextLine().trim();
					if (line.equalsIgnoreCase("EXIT"))
						return;
					if (line.endsWith(";"))
						line = line.substring(0, line.length() - 1);
					try {
						boolean isResult = stat.execute(line);
						if (isResult) {
							try (ResultSet rs = stat.getResultSet()) {
								showResultSet(rs);
							}
						} else {
							int updateCount = stat.getUpdateCount();
							System.out.println(updateCount + " rows updated");
						}
					} catch (SQLException e) {
						for (Throwable t : e)
							System.out.println(t.getMessage());
					}
				}
			}
		} catch (SQLException e) {
			for (Throwable t : e)
				System.out.println(t.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		var props = new Properties();
		try (InputStream in = Files.newInputStream(
				Paths.get("C:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\test\\resources\\database.properties"))) {
			props.load(in);
		}
		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);
	}

	public static void showResultSet(ResultSet result) throws SQLException {
		ResultSetMetaData metaData = result.getMetaData();
		int columnCount = metaData.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			if (i > 1)
				System.out.print(", ");
			System.out.print(metaData.getColumnLabel(i));
		}
		System.out.println();

		while (result.next()) {
			for (int i = 1; i <= columnCount; i++) {
				if (i > 1)
					System.out.print(", ");
				System.out.print(result.getString(i));
			}
			System.out.println();
		}
	}
}