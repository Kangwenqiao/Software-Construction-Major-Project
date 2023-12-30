package javafx; // Author: wqKang
// Author: wqKang
// Author: wqKang

import Mysql.MySQLUtil;

import java.sql.Connection;
import java.sql.SQLException;

// Author: wqKang
public class MainNew { // Author: wqKang
    public static void main(String[] args) { // Author: wqKang
        try (Connection connection = MySQLUtil.getConnection()) { // Author: wqKang
            MySQLUtil.truncateTable(connection); // Author: wqKang
        } catch (SQLException | ClassNotFoundException e) { // Author: wqKang
            e.printStackTrace(); // Author: wqKang
        } // Author: wqKang
        EquationApplication.main(args); // Author: wqKang
    } // Author: wqKang
} // Author: wqKang
