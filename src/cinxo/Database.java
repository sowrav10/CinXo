/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinxo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    
    public static Connection connectDb() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/moviebook", "root", ""
            );
            return connect;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

