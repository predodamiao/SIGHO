package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/sigho", "root", "");
        return conexao;
    }

}
