/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mr_tech
 */
public class Query {
    public Connection connection = null;
    public Statement statement = null;
    PreparedStatement preparedStatement = null;
    public void createConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_universitas?user=root&password=12345678");
        this.statement = connection.createStatement();
    }
    public void selectDatabase(String database) throws SQLException{
        this.statement.executeUpdate("USE " + database);
    }
    public void createPreparedStatement(String query) throws SQLException{
        this.preparedStatement = this.connection.prepareStatement(query);
    }
}
