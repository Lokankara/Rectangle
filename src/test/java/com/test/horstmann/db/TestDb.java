package com.test.horstmann.db;

import java.sql.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.text.DecimalFormat;

//class BottleService {
//
//    private final UserDao userDao;
//
//    public boolean saveUser(User user) {
//        return userDao.saveUser(user);
//    }
//
//    public Optional<User> findUserById(Long id) {
//        return userDao.findUserById(id);
//    }
//
//}
//public class JdbcUserDao implements UserDao {
//
//    private static final String SELECT_BY_USERNAME_SQL = "SELECT username, password, salt, auth FROM users WHERE username=?;";
//    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, salt, role, auth, created) VALUES (?, ?, ?, ?, ?, ?);";
//
//    private final JdbcUserTemplate jdbcUserTemplate;
//
//    public JdbcUserDao(JdbcUserTemplate jdbcUserTemplate) {
//        this.jdbcUserTemplate = jdbcUserTemplate;
//    }
//
//    @Override
//    public Optional<User> findUserById(Long id) {
//        return jdbcUserTemplate.findUserByNameQuery(
//                id, SELECT_BY_USERNAME_SQL);
//    }
//
//    public boolean saveUser(User user) {
//        return jdbcUserTemplate
//                .setUserQuery(user, INSERT_USER_SQL);
//    }
//}
//
//
//class JdbcBottleTemplate {
//	 public Optional<User> findUserByNameQuery(Long id, String sql) {
//	        Optional<User> user = Optional.empty();
//	        try (Connection connection = connectionFactory.getConnection();
//	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//	            preparedStatement.setLong(1, id);
//	            ResultSet resultSet = preparedStatement.executeQuery();
//	            logger.info(String.valueOf(preparedStatement));
//	            while (resultSet.next()) {
//	                user = ROW_USER_MAPPER.userMapper(resultSet);
//	            }
//	            return user;
//	        } catch (SQLException sqlException) {
//	            throw new RuntimeException(sqlException.getMessage(), sqlException);
//	        }
//	    }
//}

public class TestDb {

	public static void main(String args[]) throws IOException, SQLException {
		
		
		Connection connection = getConnection();

		long start = System.nanoTime();
		try {
			runTest(connection);
		} catch (SQLException ex) {
			for (Throwable t : ex)
				System.err.println(t.getMessage());

		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		long end = System.nanoTime();
		System.out.println((end - start) / 1000_000);

	}

	public static void runTest(Connection connection) throws SQLException, IOException {

		try (Statement stat = connection.createStatement()) {

//			stat.executeUpdate("CREATE DATABASE bottles;");
			stat.executeUpdate("DROP TABLE bottles");
			stat.executeUpdate(
					"CREATE TABLE bottles (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, volume DECIMAL(5, 2) NOT NULL, material VARCHAR(255) NOT NULL);\r\n");
			stat.executeUpdate("INSERT INTO bottles (name, volume, material)\r\n"
					+ "VALUES ('Wine', 0.75, 'Glass'),\r\n" + "        ('Vodka', 0.5, 'Glass'),\r\n"
					+ "       ('Tequila', 0.7, 'Glass'),\r\n" + "       ('Whiskey', 0.75, 'Glass'),\r\n"
					+ "       ('Coca-Cola', 1.5, 'Plastic'),\r\n" + "       ('Juice', 0.5, 'Glass'),\r\n"
					+ "       ('Fanta', 0.33, 'Plastic'),\r\n" + "       ('Juice', 0.25, 'Metal'),\r\n"
					+ "       ('Water', 1.5, 'Plastic'),\r\n" + "       ('Soda', 0.5, 'Plastic'),\r\n"
					+ "       ('Beer', 0.56, 'Metal'),\r\n" + "       ('Milk', 1.0, 'Plastic');");

			Map<String, List<Bottle>> map = new HashMap<>();
			String S = "volume <= 0.5";
			String M = "volume BETWEEN 0.51 AND 0.99";
			String L = "volume >= 1.0";
			String wine = "name = 'Wine'";
			String juice = "name = 'Juice'";
			String water = "name= 'Water'";
			String metal = "material = 'Metal'";
			String glass = "material = 'Glass'";
			String plastic = "material = 'Plastic'";

			List<String> queries = List.of(S, M, L, wine, juice, water, metal, glass, plastic);

			for (String string : queries) {
				try (ResultSet resultSet = stat.executeQuery("SELECT * FROM bottles WHERE " + string)) {
					map.put(string, BottleMapper.mapper(resultSet));
				}
			}
			for (String string : map.keySet()) {

				System.out.println(map.get(string));
			}
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
}

class BottleMapper {
	public static List<Bottle> mapper(ResultSet resultSet) throws SQLException {
		List<Bottle> list = new ArrayList<>();
		while (resultSet.next()) {
			list.add(new Bottle(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("volume"),
					resultSet.getString("material")));
		}
		return list;
	}
}
