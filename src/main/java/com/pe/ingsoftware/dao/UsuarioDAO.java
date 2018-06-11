/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.UsuariosDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbermudez
 */
@Component("usuario")
public class UsuarioDAO implements IBDCrud<UsuariosDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT "
            + "idusuario,username,userpass,usertype,useremail,userdependency,userstatus "
            + "FROM usuarios "
            + "WHERE idusuario = ? ";
    private static String SQL_CONSULTAR_UNO = "SELECT "
            + "idusuario,username,userpass,usertype,useremail,userdependency,userstatus "
            + "FROM usuarios "
            + "WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    public UsuarioDAO() {
    }

    @Override
    public int insertar(UsuariosDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean actualizar(UsuariosDTO objetoAntiguo, UsuariosDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean borrar(UsuariosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<UsuariosDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UsuariosDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        UsuariosDTO objetoDTO = new UsuariosDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                objetoDTO.setIdusuario(rs.getInt(1));
                objetoDTO.setUsername(rs.getString(2));
                objetoDTO.setUserpass(rs.getString(3));
                objetoDTO.setUsertype(rs.getString(4));
                objetoDTO.setUseremail(rs.getString(5));
                objetoDTO.setUserdependency(rs.getString(6));
                objetoDTO.setUserstatus(rs.getInt(7));
            }
            return objetoDTO;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return objetoDTO;
    }

    @Override
    public UsuariosDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        SQL_CONSULTAR_UNO = "SELECT "
                + "idusuario,username,userpass,usertype,useremail,userdependency,userstatus "
                + "FROM usuarios "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        UsuariosDTO objetoDTO = new UsuariosDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_CONSULTAR_UNO);
            switch (tipoCampo) {
                case 0:
                    ps.setInt(1, Integer.parseInt(valorCampo.toString()));
                    break;
                case 1:
                    ps.setDouble(1, Double.parseDouble(valorCampo.toString()));
                    break;
                case 2:
                    ps.setString(1, valorCampo.toString());
                    break;
                case 3:
                    Time time = null;
                    ps.setTime(1, time.valueOf(valorCampo.toString()));
                    break;
                default:
                    ps.setString(1, valorCampo.toString());
                    break;
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                objetoDTO.setIdusuario(rs.getInt(1));
                objetoDTO.setUsername(rs.getString(2));
                objetoDTO.setUserpass(rs.getString(3));
                objetoDTO.setUsertype(rs.getString(4));
                objetoDTO.setUseremail(rs.getString(5));
                objetoDTO.setUserdependency(rs.getString(6));
                objetoDTO.setUserstatus(rs.getInt(7));
            }
            return objetoDTO;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return objetoDTO;
    }

    @Override
    public ArrayList<UsuariosDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuariosDTO> selectPrograma() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuariosDTO> selectPlan(String filtro) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuariosDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
