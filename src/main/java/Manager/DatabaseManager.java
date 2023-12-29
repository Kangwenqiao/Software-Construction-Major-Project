package Manager;

import Mysql.MySQLUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 数据库管理器类，用于管理数据库操作。
 * 提供了打印所有方程、清空整个表等功能。
 */
public class DatabaseManager {

    public static void main(String[] args) {
        try (Connection connection = MySQLUtil.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("请输入操作数字 (1: 打印所有方程, 2: 清空整个表, 3: 打印生成数据库今日日志为一个文件, 0: 退出): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("所有方程:");
                        MySQLUtil.selectAllData(connection);
                        break;
                    case 2:
                        System.out.println("清空整个表:");
                        MySQLUtil.truncateTable(connection);
                        break;
                    case 0:
                        System.out.println("退出程序。");
                        return;
                    default:
                        System.out.println("无效的操作数字，请重新输入。");
                        break;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
