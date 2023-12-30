package Mysql; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import ExerciseClass.IEquation;
import ExerciseClass.SubEquation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// Author: wqKang

/**
 * // Author: wqKang
 * MySQL 数据库工具类。 // Author: wqKang
 * 提供了连接数据库、执行 SQL 语句、插入和查询方程数据等功能。 // Author: wqKang
 */ // Author: wqKang
public class MySQLUtil { // Author: wqKang
	// Author: wqKang
	// JDBC 驱动和数据库连接参数 // Author: wqKang
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // Author: wqKang
	private static final String DB_URL = "jdbc:mysql://localhost:3306/app"; // Author: wqKang
	private static final String URL_EXTRA_PARA = "?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false"; // Author: wqKang
	private static final String USER = "root"; // Author: wqKang
	private static final String PASS = "2003Kangwenqiao"; // Author: wqKang
	// Author: wqKang
	// SQL 语句 // Author: wqKang
	private static final String INSERT_SQL = "INSERT INTO eq (op_num1, operation, op_num2) VALUES (?, ?, ?)"; // Author: wqKang
	private static final String SELECT_ALL_SQL = "SELECT * FROM eq"; // Author: wqKang
	private static final String TRUNCATE_TABLE_SQL = "TRUNCATE TABLE eq"; // Author: wqKang
	private static final String SELECT_LATEST_SQL = "SELECT * FROM eq ORDER BY id DESC LIMIT ?"; // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 获取数据库连接。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @return 数据库连接对象 // Author: wqKang
	 * @throws SQLException           SQL 异常 // Author: wqKang
	 * @throws ClassNotFoundException 类未找到异常 // Author: wqKang
	 */ // Author: wqKang
	public static Connection getConnection() throws SQLException, ClassNotFoundException { // Author: wqKang
		Class.forName(JDBC_DRIVER); // Author: wqKang
		return DriverManager.getConnection(DB_URL + URL_EXTRA_PARA, USER, PASS); // Author: wqKang
	} // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 查询并打印所有方程数据。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @param connection 数据库连接对象 // Author: wqKang
	 */ // Author: wqKang
	public static void selectAllData(Connection connection) { // Author: wqKang
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL); // Author: wqKang
			 ResultSet resultSet = preparedStatement.executeQuery()) { // Author: wqKang
			// Author: wqKang
			while (resultSet.next()) { // Author: wqKang
				// 打印每一行方程数据 // Author: wqKang
				System.out.println("ID: " + resultSet.getInt("id") + // Author: wqKang
						", op_num1: " + resultSet.getInt("op_num1") + // Author: wqKang
						", operation: " + resultSet.getString("operation") + // Author: wqKang
						", op_num2: " + resultSet.getInt("op_num2")); // Author: wqKang
			} // Author: wqKang
		} catch (SQLException e) { // Author: wqKang
			e.printStackTrace(); // Author: wqKang
		} // Author: wqKang
	} // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 清空整个表。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @param connection 数据库连接对象 // Author: wqKang
	 */ // Author: wqKang
	public static void truncateTable(Connection connection) { // Author: wqKang
		try (Statement statement = connection.createStatement()) { // Author: wqKang
			// 执行清空表的 SQL 语句 // Author: wqKang
			statement.executeUpdate(TRUNCATE_TABLE_SQL); // Author: wqKang
			System.out.println("表已被清空。"); // Author: wqKang
		} catch (SQLException e) { // Author: wqKang
			e.printStackTrace(); // Author: wqKang
		} // Author: wqKang
	} // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 插入方程数据并获取自增主键。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @param connection 数据库连接对象 // Author: wqKang
	 * @param opNum1     操作数1 // Author: wqKang
	 * @param operation  操作符 // Author: wqKang
	 * @param opNum2     操作数2 // Author: wqKang
	 */ // Author: wqKang
	public static void insertEquation(Connection connection, int opNum1, String operation, int opNum2) { // Author: wqKang
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) { // Author: wqKang
			preparedStatement.setInt(1, opNum1); // Author: wqKang
			preparedStatement.setString(2, operation); // Author: wqKang
			preparedStatement.setInt(3, opNum2); // Author: wqKang
			// Author: wqKang
			preparedStatement.executeUpdate(); // Author: wqKang
			// Author: wqKang
			// 获取插入的题目的自增主键值 // Author: wqKang
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys(); // Author: wqKang
			if (generatedKeys.next()) { // Author: wqKang
				int equationId = generatedKeys.getInt(1); // Author: wqKang
				System.out.println("题目已插入到数据库，ID: " + equationId); // Author: wqKang
			} // Author: wqKang
		} catch (SQLException e) { // Author: wqKang
			e.printStackTrace(); // Author: wqKang
		} // Author: wqKang
	} // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 获取最新的方程数据列表。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @param connection   数据库连接对象 // Author: wqKang
	 * @param numQuestions 获取的方程数量 // Author: wqKang
	 * @return 最新的方程数据列表 // Author: wqKang
	 * @throws SQLException SQL 异常 // Author: wqKang
	 */ // Author: wqKang
	public static List<IEquation> getLatestEquations(Connection connection, int numQuestions) throws SQLException { // Author: wqKang
		List<IEquation> equations = new ArrayList<>(); // Author: wqKang
		// Author: wqKang
		// 查询最新的方程数据 // Author: wqKang
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LATEST_SQL)) { // Author: wqKang
			preparedStatement.setInt(1, numQuestions); // Author: wqKang
			// Author: wqKang
			try (ResultSet resultSet = preparedStatement.executeQuery()) { // Author: wqKang
				while (resultSet.next()) { // Author: wqKang
					short operand1 = resultSet.getShort("op_num1"); // Author: wqKang
					char operator = resultSet.getString("operation").charAt(0); // Author: wqKang
					short operand2 = resultSet.getShort("op_num2"); // Author: wqKang
					// Author: wqKang
					// 根据数据库中的数据创建 IEquation 对象 // Author: wqKang
					IEquation equation = createEquation(operator, operand1, operand2); // Author: wqKang
					equations.add(equation); // Author: wqKang
				} // Author: wqKang
			} // Author: wqKang
		} // Author: wqKang
		// Author: wqKang
		return equations; // Author: wqKang
	} // Author: wqKang
	// Author: wqKang

	/**
	 * // Author: wqKang
	 * 根据操作符和操作数创建 IEquation 对象。 // Author: wqKang
	 * // Author: wqKang
	 *
	 * @param operator 操作符 // Author: wqKang
	 * @param operand1 操作数1 // Author: wqKang
	 * @param operand2 操作数2 // Author: wqKang
	 * @return IEquation 对象 // Author: wqKang
	 */ // Author: wqKang
	public static IEquation createEquation(char operator, short operand1, short operand2) { // Author: wqKang
		if (operator == '+') { // Author: wqKang
			return new AddEquation(operand1, operand2); // Author: wqKang
		} else if (operator == '-') { // Author: wqKang
			return new SubEquation(operand1, operand2); // Author: wqKang
		} else { // Author: wqKang
			throw new IllegalArgumentException("无效的操作符: " + operator); // Author: wqKang
		} // Author: wqKang
	} // Author: wqKang
	// Author: wqKang
} // Author: wqKang
