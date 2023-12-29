package javafx;

import Mysql.MySQLUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class MainNew {
    public static void main(String[] args) {
        try (Connection connection = MySQLUtil.getConnection()) {
            MySQLUtil.truncateTable(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        EquationApplication.main(args);
    }
}
