/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.Preferencias_cursos_profesoresDTO;
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
@Component("preferencias_cursos_profesores")
public class Preferencias_cursos_profesoresDAO implements IBDCrud<Preferencias_cursos_profesoresDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT "
            + "idcurso,idprofesor,cyclepreferencia "
            + "FROM preferencias_cursos_profesores "
            + "WHERE idcurso = ? ";
    private static final String SQL_SELECT_ALL = "SELECT "
            + "idcurso,idprofesor,cyclepreferencia "
            + "FROM preferencias_cursos_profesores ";
    private static String SQL_CONSULTAR_UNO = "SELECT "
            + "idcurso,idprofesor,cyclepreferencia "
            + "FROM preferencias_cursos_profesores WHERE ";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idcurso,idprofesor,cyclepreferencia "
            + "FROM preferencias_cursos_profesores WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(Preferencias_cursos_profesoresDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Preferencias_cursos_profesoresDTO objetoAntiguo, Preferencias_cursos_profesoresDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Preferencias_cursos_profesoresDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Preferencias_cursos_profesoresDTO> consultarTodo() throws BussinessException {
        ArrayList<Preferencias_cursos_profesoresDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        Preferencias_cursos_profesoresDTO preferencias;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    preferencias = new Preferencias_cursos_profesoresDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
                    ArrayList.add(preferencias);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public Preferencias_cursos_profesoresDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        Preferencias_cursos_profesoresDTO preferencias = new Preferencias_cursos_profesoresDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                preferencias.setIdcurso(rs.getInt(1));
                preferencias.setIdprofesor(rs.getInt(2));
                preferencias.setCyclepreferencia(rs.getString(3));
            }
            return preferencias;
        } catch (SQLException ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return preferencias;
    }

    @Override
    public Preferencias_cursos_profesoresDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        SQL_CONSULTAR_UNO = "SELECT "
                + "idcurso,idprofesor,cyclepreferencia "
                + "FROM preferencias_cursos_profesores WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        Preferencias_cursos_profesoresDTO preferencias = new Preferencias_cursos_profesoresDTO();
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
                preferencias.setIdcurso(rs.getInt(1));
                preferencias.setIdprofesor(rs.getInt(2));
                preferencias.setCyclepreferencia(rs.getString(3));
            }
            return preferencias;
        } catch (SQLException ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return preferencias;
    }

    @Override
    public ArrayList<Preferencias_cursos_profesoresDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        ArrayList<Preferencias_cursos_profesoresDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT "
                + "idcurso,idprofesor,cyclepreferencia "
                + "FROM preferencias_cursos_profesores "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        Preferencias_cursos_profesoresDTO preferencias;
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
                    preferencias = new Preferencias_cursos_profesoresDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
                    ArrayList.add(preferencias);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Preferencias_cursos_profesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<Preferencias_cursos_profesoresDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Preferencias_cursos_profesoresDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Preferencias_cursos_profesoresDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
