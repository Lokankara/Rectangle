package com.homework.db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openjdk.jmh.runner.RunnerException;

import static com.homework.db.Queries.*;

public class Dispatcher {
	public static void main(String[] args) throws SQLException, DaoException {

		ConnectionPool connectionPool = new ConnectionPool();
		JdbcTemplate dao = new JdbcTemplate(connectionPool);
		BottleController bottleController = new BottleController(dao);
//		View view = new View(bottleController);
//        view.printAllBottles();
//        System.out.println(dao.execute(query));

		boolean execute = dao.executeUpdate(INSERT);
		List<Bottle> list = dao.execute(SELECT);
		System.out.println(list);

		long start, end;
		start = System.nanoTime();
//		list.forEach(query -> System.out.println(dao.getBy(String.format("%s%s", SELECT, query))));
		end = System.nanoTime();
		System.err.println((end - start) / 1_000_000);

	}
}

class Queries {
	public static final String SELECT = "SELECT id, name, volume, material FROM bottles ";
	public static final String WHERE = SELECT + "WHERE ";

	public static final List<String> volumes = List.of("<= 0.5", "BETWEEN 0.51 AND 0.99", ">= 1.0");
	public static final List<String> names = List.of("Water", "Juice", "Wine");
	public static final List<String> materials = List.of("Plastic", "Glass", "Metal");

	public static final String custom = WHERE + "volume >= 0.5 AND volume <= 1.0 AND material = 'Glass'";

	public static final String DROP = "DROP TABLE bottles";
	public static final String INSERT = "INSERT INTO bottles (name, volume, material) VALUES ('Milk', 1.0, 'Plastic');";
	public static final String CREATE = "CREATE TABLE bottles (id SERIAL PRIMARY KEY, name VARCHAR(255) NOT NULL, volume DECIMAL(5, 2) NOT NULL, material VARCHAR(255) NOT NULL);\r\n";
	public static final String INSERT_ALL = "INSERT INTO bottles (name, volume, material)\r\n"
			+ "VALUES ('Wine', 0.75, 'Glass'),\r\n" + "        ('Vodka', 0.5, 'Glass'),\r\n"
			+ "       ('Tequila', 0.7, 'Glass'),\r\n" + "       ('Whiskey', 0.75, 'Glass'),\r\n"
			+ "       ('Coca-Cola', 1.5, 'Plastic'),\r\n" + "       ('Juice', 0.5, 'Glass'),\r\n"
			+ "       ('Fanta', 0.33, 'Plastic'),\r\n" + "       ('Juice', 0.25, 'Metal'),\r\n"
			+ "       ('Water', 1.5, 'Plastic'),\r\n" + "       ('Soda', 0.5, 'Plastic'),\r\n"
			+ "       ('Beer', 0.56, 'Metal'),\r\n" + "       ('Milk', 1.0, 'Plastic');";
}

class BottleController {

	private final JdbcTemplate bottleDao;

	public BottleController(JdbcTemplate bottleDao) {
		this.bottleDao = bottleDao;
	}

	public boolean set(String query) throws DaoException {
		return bottleDao.executeUpdate(query);
	}

	public List<Bottle> findBy(String query){
		List<Bottle> bottles = new ArrayList<>();
		try {
			bottles = bottleDao.execute(query);
		} catch (DaoException e) {
			System.err.println(e.getMessage());
//			throw new SQLException(e);
		}
		return bottles;
	}
}

class JdbcTemplate implements BottleDao {
	private static final Logger LOGGER = Logger.getLogger(JdbcTemplate.class.getName());
	private final ConnectionPool connectionPool;

	public JdbcTemplate(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	public boolean executeUpdate(String sql) throws DaoException {
		boolean executeUpdate;
		Connection connection = null;
		try {
			connection = connectionPool.getConnection();

			try (Statement stat = connection.createStatement()) {
				executeUpdate = stat.executeUpdate(sql) > 0;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			if (connection != null) {
				try {
					connectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					throw new DaoException(e);
				}
			}
		}
		return executeUpdate;
	}

	public List<Bottle> execute(String sql) throws DaoException {
		Connection connection = null;
		List<Bottle> bottles = new ArrayList<>();
		try {
			connection = connectionPool.getConnection();

			try (PreparedStatement statement = connection.prepareStatement(sql);
					ResultSet resultSet = statement.executeQuery()) {
					bottles = mapper(resultSet);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			if (connection != null) {
				try {
					connectionPool.releaseConnection(connection);
				} catch (SQLException e) {
					throw new DaoException(e);
				}
			}
		}
		return bottles;
	}

	private static List<Bottle> mapper(ResultSet resultSet) throws SQLException {
		List<Bottle> bottles = new ArrayList<>();
		while (resultSet.next()) {
			bottles.add(new Bottle(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("volume"),
					resultSet.getString("material")));
		}
		return bottles;
	}

	public List<Bottle> getBy(String query) throws DaoException {
		List<Bottle> result = new ArrayList<>();
		try {
			result = execute(query);
		} catch (DaoException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return result;
	}
}

class Bottle {
	private final int id;
	private final String name;
	private final double volume;
	private final String material;

	public Bottle(int id, String name, double volume, String material) {
		this.id = id;
		this.name = name;
		this.volume = volume;
		this.material = material;
	}

	@Override
	public String toString() {
		return String.format("%s %s bottle#%d %.2f liters", material, name, id, volume);
	}
}

class ConnectionPool {
	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class.getName());
	private final static String path = "C:\\Users\\PPoliak\\eclipse-workspace\\lab\\src\\test\\resources\\database.properties";
	private final String url;
	private final String user;
	private final String password;
	private final int maxConnections;
	private final int initialConnections;
	private final List<Connection> connections;

	public ConnectionPool() throws SQLException {
		Properties props = readProps();
		this.url = props.getProperty("jdbc.url");
		this.user = props.getProperty("jdbc.username");
		this.password = props.getProperty("jdbc.password");
		System.setProperty("jdbc.drivers", props.getProperty("jdbc.drivers"));
		this.maxConnections = Integer.parseInt(props.getProperty("jdbc.pool.size"));
		this.initialConnections = Integer.parseInt(props.getProperty("jdbc.pool.init"));
		this.connections = new ArrayList<>();

		for (int i = 0; i < initialConnections; i++) {
			connections.add(createConnection());
		}
	}

	private static Properties readProps() {
		Properties props = new Properties();
		try (InputStream inputStream = Files.newInputStream(Paths.get(path))) {
			props.load(inputStream);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return props;
	}

	private Connection createConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		return connection;
	}

	public synchronized Connection getConnection() throws SQLException {
		if (connections.isEmpty() && poolSize() < maxConnections) {
			connections.add(createConnection());
		}
		return connections.remove(0);
	}

	public synchronized void releaseConnection(Connection connection) throws SQLException {
		if (poolSize() < initialConnections) {
//            connection.rollback();
			connections.add(connection);
		} else {
			connection.close();
		}
	}

	private int poolSize() {
		return connections.size();
	}
}

class View {
	BottleController bottleController;

	public View(BottleController bottleController) {
		this.bottleController = bottleController;
	}

	public void print(Bottle bottle) {
		System.out.println(bottle);
	}

	public void printAllBottles() {
		bottleController.findBy(custom).forEach(this::print);
	}
}

class DaoException extends Throwable {
	private static final long serialVersionUID = -7651490132839520312L;

	public DaoException(SQLException e) {
		super(e.getMessage());
		System.err.println(e.getMessage());
	}
}

interface BottleDao {
	public boolean executeUpdate(String sql) throws DaoException;

	public List<Bottle> execute(String sql) throws DaoException;
}