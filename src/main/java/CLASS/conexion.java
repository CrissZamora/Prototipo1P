/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CLASS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conexion extends javax.swing.JFrame {
    private static Connection conn;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String password="root";
    private static final String url="jdbc:mysql://localhost:3306/Prototipo1P";
    
    public Connection conectar(){
        conn=null;
        try{
            conn=(Connection) DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            
        JOptionPane.showMessageDialog(null, "Error! "+ e.toString());
    }
        return conn;
    }
}