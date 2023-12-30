package Manager; // Author: wqKang
// Author: wqKang
// Author: wqKang

import Mysql.MySQLUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
// Author: wqKang

/**
 * // Author: wqKang
 * 数据库管理器类，用于管理数据库操作。 // Author: wqKang
 * 提供了打印所有方程、清空整个表等功能。 // Author: wqKang
 */ // Author: wqKang
public class DatabaseManager { // Author: wqKang
    // Author: wqKang
    public static void main(String[] args) { // Author: wqKang
        try (Connection connection = MySQLUtil.getConnection()) { // Author: wqKang
            Scanner scanner = new Scanner(System.in); // Author: wqKang
            // Author: wqKang
            while (true) { // Author: wqKang
                System.out.println("请输入操作数字 (1: 打印所有方程, 2: 清空整个表, 3: 打印生成数据库今日日志为一个文件, 0: 退出): "); // Author: wqKang
                int choice = scanner.nextInt(); // Author: wqKang
                // Author: wqKang
                switch (choice) { // Author: wqKang
                    case 1: // Author: wqKang
                        System.out.println("所有方程:"); // Author: wqKang
                        MySQLUtil.selectAllData(connection); // Author: wqKang
                        break; // Author: wqKang
                    case 2: // Author: wqKang
                        System.out.println("清空整个表:"); // Author: wqKang
                        MySQLUtil.truncateTable(connection); // Author: wqKang
                        break; // Author: wqKang
                    case 0: // Author: wqKang
                        System.out.println("退出程序。"); // Author: wqKang
                        return; // Author: wqKang
                    default: // Author: wqKang
                        System.out.println("无效的操作数字，请重新输入。"); // Author: wqKang
                        break; // Author: wqKang
                } // Author: wqKang
            } // Author: wqKang
        } catch (SQLException | ClassNotFoundException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
