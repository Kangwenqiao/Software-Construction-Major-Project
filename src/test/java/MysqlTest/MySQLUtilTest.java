package MysqlTest;

import ExerciseClass.AddEquation;
import ExerciseClass.IEquation;
import Mysql.MySQLUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * MySQLUtil类的JUnit测试类。
 */
class MySQLUtilTest {

    private static Connection connection;

    /**
     * 在所有测试运行之前的初始化方法。
     */
    @BeforeAll
    static void setUp() {
        try {
            // 获取数据库连接
            connection = MySQLUtil.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在所有测试运行之后的清理方法。
     */
    @AfterAll
    static void tearDown() {
        try {
            // 关闭数据库连接
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在每个测试方法运行之前的初始化方法。
     */
    @BeforeEach
    void clearTable() {
        // 清空表
        MySQLUtil.truncateTable(connection);
    }

    /**
     * 测试插入方程和获取最新方程的方法。
     */
    @Test
    void testInsertEquationAndGetLatestEquations() {
        int opNum1 = 5;
        String operation = "+";
        int opNum2 = 3;

        // 插入方程
        MySQLUtil.insertEquation(connection, opNum1, operation, opNum2);

        List<IEquation> equations = null;
        try {
            // 获取最新的方程
            equations = MySQLUtil.getLatestEquations(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 断言：只有一个方程
        assertEquals(1, equations.size());
        IEquation equation = equations.get(0);
        assertTrue(equation instanceof AddEquation);
        // 断言：方程的操作数正确
        assertEquals(opNum1, equation.getOperand1());
        assertEquals(opNum2, equation.getOperand2());
    }

    /**
     * 测试根据操作符和操作数创建方程的方法。
     */
    @Test
    void testCreateEquation() {
        char operator = '+';
        short operand1 = 8;
        short operand2 = 4;

        // 创建方程
        IEquation equation = MySQLUtil.createEquation(operator, operand1, operand2);

        // 断言：方程的类型正确
        assertTrue(equation instanceof AddEquation);
        // 断言：方程的操作数正确
        assertEquals(operand1, equation.getOperand1());
        assertEquals(operand2, equation.getOperand2());
    }
}
