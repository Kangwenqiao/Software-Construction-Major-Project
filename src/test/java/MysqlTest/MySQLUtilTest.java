package MysqlTest; // Author: wqKang
// Author: wqKang

import ExerciseClass.AddEquation;
import ExerciseClass.IEquation;
import Mysql.MySQLUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
// Author: wqKang

/**
 * // Author: wqKang
 * MySQLUtil类的JUnit测试类。 // Author: wqKang
 */ // Author: wqKang
class MySQLUtilTest { // Author: wqKang
    // Author: wqKang
    private static Connection connection; // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 在所有测试运行之前的初始化方法。 // Author: wqKang
     */ // Author: wqKang
    @BeforeAll // Author: wqKang
    static void setUp() { // Author: wqKang
        try { // Author: wqKang
            // 获取数据库连接 // Author: wqKang
            connection = MySQLUtil.getConnection(); // Author: wqKang
        } catch (SQLException | ClassNotFoundException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 在所有测试运行之后的清理方法。 // Author: wqKang
     */ // Author: wqKang
    @AfterAll // Author: wqKang
    static void tearDown() { // Author: wqKang
        try { // Author: wqKang
            // 关闭数据库连接 // Author: wqKang
            if (connection != null) { // Author: wqKang
                connection.close(); // Author: wqKang
            } // Author: wqKang
        } catch (SQLException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 在每个测试方法运行之前的初始化方法。 // Author: wqKang
     */ // Author: wqKang
    @BeforeEach
    // Author: wqKang
    void clearTable() { // Author: wqKang
        // 清空表 // Author: wqKang
        MySQLUtil.truncateTable(connection); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 测试插入方程和获取最新方程的方法。 // Author: wqKang
     */ // Author: wqKang
    @Test
    // Author: wqKang
    void testInsertEquationAndGetLatestEquations() { // Author: wqKang
        int opNum1 = 5; // Author: wqKang
        String operation = "+"; // Author: wqKang
        int opNum2 = 3; // Author: wqKang
        // Author: wqKang
        // 插入方程 // Author: wqKang
        MySQLUtil.insertEquation(connection, opNum1, operation, opNum2); // Author: wqKang
        // Author: wqKang
        List<IEquation> equations = null; // Author: wqKang
        try { // Author: wqKang
            // 获取最新的方程 // Author: wqKang
            equations = MySQLUtil.getLatestEquations(connection, 1); // Author: wqKang
        } catch (SQLException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
        // Author: wqKang
        // 断言：只有一个方程 // Author: wqKang
        assertEquals(1, equations.size()); // Author: wqKang
        IEquation equation = equations.get(0); // Author: wqKang
        assertTrue(equation instanceof AddEquation); // Author: wqKang
        // 断言：方程的操作数正确 // Author: wqKang
        assertEquals(opNum1, equation.getOperand1()); // Author: wqKang
        assertEquals(opNum2, equation.getOperand2()); // Author: wqKang
    } // Author: wqKang
    // Author: wqKang

    /**
     * // Author: wqKang
     * 测试根据操作符和操作数创建方程的方法。 // Author: wqKang
     */ // Author: wqKang
    @Test
    // Author: wqKang
    void testCreateEquation() { // Author: wqKang
        char operator = '+'; // Author: wqKang
        short operand1 = 8; // Author: wqKang
        short operand2 = 4; // Author: wqKang
        // Author: wqKang
        // 创建方程 // Author: wqKang
        IEquation equation = MySQLUtil.createEquation(operator, operand1, operand2); // Author: wqKang
        // Author: wqKang
        // 断言：方程的类型正确 // Author: wqKang
        assertTrue(equation instanceof AddEquation); // Author: wqKang
        // 断言：方程的操作数正确 // Author: wqKang
        assertEquals(operand1, equation.getOperand1()); // Author: wqKang
        assertEquals(operand2, equation.getOperand2()); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
