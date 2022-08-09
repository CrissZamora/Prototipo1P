package JFRAME;

import CLASS.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario Lopez
 */
public class Usuarios {
    public void consultarUsuario(String user, String pass)
    {
        // TODO add your handling code here:
        conexion db = new conexion();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
    try {

        Connection cn = db.conectar();
        PreparedStatement pst = cn.prepareStatement("SELECT usuario, contraseña FROM admin");
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuarioCorrecto = rs.getString(1);
            passCorrecto = rs.getString(2);
        }

        if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
            JOptionPane.showMessageDialog(null, "Login ha correcto Bienvenido " + user);
            MENU ventana = new MENU();
            ventana.setVisible(true);
        } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {

            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            INICIOS ventana = new INICIOS();
            ventana.setVisible(true);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error " + e);
    }
    }
}
