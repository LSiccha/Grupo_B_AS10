/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.semana10;

import java.sql.*;


/**
 *
 * @author Sistemas
 */
public class DBConnection {
    DBConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
            "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10578899",
            "sql10578899", "8S17DwNaT8");
            
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from Alumnos"
            );
            int id;
            String name;
            String apellido;
            int edad;
            String escuela;
            
            while (resultSet.next()) {
                id = resultSet.getInt("ID");
                name = resultSet.getString("NombreAlumno");
                apellido = resultSet.getString("ApellidoAlumno");
                edad = resultSet.getInt("EdadAlumno");
                escuela = resultSet.getString("EscuelaAlumno");
                        
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + name);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("Escuela: " + escuela);
                System.out.println("");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    
}
