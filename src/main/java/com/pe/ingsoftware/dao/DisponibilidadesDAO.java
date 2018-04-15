/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.DisponibilidadesDTO;
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
 * @author DiegoDavid
 */
@Component("disponibilidades")
public class DisponibilidadesDAO implements IBDCrud<DisponibilidadesDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT * FROM DISPONIBILIDADES WHERE iddisponibilidad = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM DISPONIBILIDADES";
    private static String SQL_CONSULTAR_UNO = "SELECT * FROM DISPONIBILIDADES WHERE";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT * FROM DISPONIBILIDADES WHERE";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(DisponibilidadesDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(DisponibilidadesDTO objetoAntiguo, DisponibilidadesDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(DisponibilidadesDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DisponibilidadesDTO> consultarTodo() throws BussinessException {
        ArrayList<DisponibilidadesDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        DisponibilidadesDTO disponibilidad;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    disponibilidad = new DisponibilidadesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                    ArrayList.add(disponibilidad);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public DisponibilidadesDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        DisponibilidadesDTO disponibilidad = new DisponibilidadesDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                disponibilidad.setIddisponibilidad(rs.getInt(1));
                disponibilidad.setDaydisponibilidad(rs.getString(2));
                disponibilidad.setHourstartdisponibilidad(rs.getString(3));
                disponibilidad.setHourenddisponibilidad(rs.getString(4));
                disponibilidad.setStatusdisponibilidad(rs.getInt(5));
                disponibilidad.setIdprofesor(rs.getInt(6));
            }
            return disponibilidad;
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return disponibilidad;
    }

    @Override
    public DisponibilidadesDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) {
        SQL_CONSULTAR_UNO = SQL_CONSULTAR_UNO + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        DisponibilidadesDTO disponibilidad = new DisponibilidadesDTO();
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
                disponibilidad.setIddisponibilidad(rs.getInt(1));
                disponibilidad.setDaydisponibilidad(rs.getString(2));
                disponibilidad.setHourstartdisponibilidad(rs.getString(3));
                disponibilidad.setHourenddisponibilidad(rs.getString(4));
                disponibilidad.setStatusdisponibilidad(rs.getInt(5));
                disponibilidad.setIdprofesor(rs.getInt(6));
            }
            return disponibilidad;
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return disponibilidad;
    }

    @Override
    public ArrayList<DisponibilidadesDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) {
        ArrayList<DisponibilidadesDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = SQL_CONSULTAR_TODO_DE + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        DisponibilidadesDTO disponibilidad;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_CONSULTAR_TODO_DE);
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
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    disponibilidad = new DisponibilidadesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                    ArrayList.add(disponibilidad);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DisponibilidadesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

}
