/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JFRAME;

import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import JFRAME.conexion;

/**
 *
 * @author Usuario
 */
public class PEDIDO {
      public void RellenaconsqlPelicula(String tabla, JTable visor)
    {
        String sql = "Select * from " + tabla;
        Statement st;
        conexion conn = new conexion();
        Connection conexion = (Connection) conn.conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("idpedido");
        model.addColumn("fecha_s_pedido");
        model.addColumn("fecha_e_pedido");
        model.addColumn("tipo_pago");
        model.addColumn("plazo_pago");
        model.addColumn("total_pago");
        model.addColumn("PROVEEDORES_idproveedores");
        
        visor.setModel(model);
        String [] dato = new String[5];
        try{
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {      
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                dato[4] = rs.getString(5);
                model.addRow(dato);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
