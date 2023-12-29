package Mysql;

import ExerciseClass.AddEquation;
import ExerciseClass.IEquation;
import ExerciseClass.SubEquation;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL 数据库工具类。
 * 提供了连接数据库、执行 SQL 语句、插入和查询方程数据等功能。
 */
public class MySQLUtil {

	// JDBC 驱动和数据库连接参数
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/app";
	private static final String URL_EXTRA_PARA = "?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "2003Kangwenqiao";

	// SQL 语句
	private static final String INSERT_SQL = "INSERT INTO eq (op_num1, operation, op_num2) VALUES (?, ?, ?)";
	private static final String SELECT_ALL_SQL = "SELECT * FROM eq";
	private static final String TRUNCATE_TABLE_SQL = "TRUNCATE TABLE eq";
	private static final String SELECT_LATEST_SQL = "SELECT * FROM eq ORDER BY id DESC LIMIT ?";
	private static final String SHOW_VARIABLES_SQL = "SHOW VARIABLES LIKE 'general_log'";
	private static final String SET_LOG_ON_SQL = "SET GLOBAL general_log = 'ON'";
	private static final String SET_LOG_OFF_SQL = "SET GLOBAL general_log = 'OFF'";
	private static final String SHOW_SELECT_QUERIES_SQL = "SHOW GLOBAL STATUS LIKE 'Com_select'";
	private static final String SHOW_INSERT_QUERIES_SQL = "SHOW GLOBAL STATUS LIKE 'Com_insert'";

	/**
	 * 获取数据库连接。
	 *
	 * @return 数据库连接对象
	 * @throws SQLException            SQL 异常
	 * @throws ClassNotFoundException 类未找到异常
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL + URL_EXTRA_PARA, USER, PASS);
	}

	/**
	 * 查询并打印所有方程数据。
	 *
	 * @param connection 数据库连接对象
	 */
	public static void selectAllData(Connection connection) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
			 ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				// 打印每一行方程数据
				System.out.println("ID: " + resultSet.getInt("id") +
						", op_num1: " + resultSet.getInt("op_num1") +
						", operation: " + resultSet.getString("operation") +
						", op_num2: " + resultSet.getInt("op_num2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空整个表。
	 *
	 * @param connection 数据库连接对象
	 */
	public static void truncateTable(Connection connection) {
		try (Statement statement = connection.createStatement()) {
			// 执行清空表的 SQL 语句
			statement.executeUpdate(TRUNCATE_TABLE_SQL);
			System.out.println("表已被清空。");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入方程数据并获取自增主键。
	 *
	 * @param connection 数据库连接对象
	 * @param opNum1     操作数1
	 * @param operation  操作符
	 * @param opNum2     操作数2
	 */
	public static void insertEquation(Connection connection, int opNum1, String operation, int opNum2) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, opNum1);
			preparedStatement.setString(2, operation);
			preparedStatement.setInt(3, opNum2);

			preparedStatement.executeUpdate();

			// 获取插入的题目的自增主键值
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int equationId = generatedKeys.getInt(1);
				System.out.println("题目已插入到数据库，ID: " + equationId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取最新的方程数据列表。
	 *
	 * @param connection    数据库连接对象
	 * @param numQuestions  获取的方程数量
	 * @return 最新的方程数据列表
	 * @throws SQLException SQL 异常
	 */
	public static List<IEquation> getLatestEquations(Connection connection, int numQuestions) throws SQLException {
		List<IEquation> equations = new ArrayList<>();

		// 查询最新的方程数据
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LATEST_SQL)) {
			preparedStatement.setInt(1, numQuestions);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					short operand1 = resultSet.getShort("op_num1");
					char operator = resultSet.getString("operation").charAt(0);
					short operand2 = resultSet.getShort("op_num2");

					// 根据数据库中的数据创建 IEquation 对象
					IEquation equation = createEquation(operator, operand1, operand2);
					equations.add(equation);
				}
			}
		}

		return equations;
	}

	/**
	 * 根据操作符和操作数创建 IEquation 对象。
	 *
	 * @param operator 操作符
	 * @param operand1 操作数1
	 * @param operand2 操作数2
	 * @return IEquation 对象
	 */
	public static IEquation createEquation(char operator, short operand1, short operand2) {
		if (operator == '+') {
			return new AddEquation(operand1, operand2);
		} else if (operator == '-') {
			return new SubEquation(operand1, operand2);
		} else {
			throw new IllegalArgumentException("无效的操作符: " + operator);
		}
	}

}
