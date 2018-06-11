/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.ProfesoresDTO;
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
@Component("profesores")
public class ProfesoresDAO implements IBDCrud<ProfesoresDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES "
            + "WHERE idprofesor = ? ";
    private static final String SQL_SELECT_ALL = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES ";
    private static String SQL_CONSULTAR_UNO = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES "
            + "WHERE ";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES "
            + "WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(ProfesoresDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(ProfesoresDTO objetoAntiguo, ProfesoresDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(ProfesoresDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProfesoresDTO> consultarTodo() throws BussinessException {
        ArrayList<ProfesoresDTO> profesorArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        ProfesoresDTO profesor;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                profesorArrayList = null;
            } else {
                do {
                    profesor = new ProfesoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                    profesorArrayList.add(profesor);
                } while (rs.next());
            }
            return profesorArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return profesorArrayList;
    }

    @Override
    public ProfesoresDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        ProfesoresDTO profesor = new ProfesoresDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                profesor.setIdprofesor(rs.getInt(1));
                profesor.setnameprofesor(rs.getString(2));
                profesor.setlastnameprofesor(rs.getString(3));
                profesor.setcodprofesor(rs.getString(4));
                profesor.setstatusprofesor(rs.getInt(5));
            }
            return profesor;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return profesor;
    }

    @Override
    public ProfesoresDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        SQL_CONSULTAR_UNO = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES "
            + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        ProfesoresDTO profesor = new ProfesoresDTO();
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
                profesor.setIdprofesor(rs.getInt(1));
                profesor.setnameprofesor(rs.getString(2));
                profesor.setlastnameprofesor(rs.getString(3));
                profesor.setcodprofesor(rs.getString(4));
                profesor.setstatusprofesor(rs.getInt(5));
            }
            return profesor;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return profesor;
    }

    @Override
    public ArrayList<ProfesoresDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        ArrayList<ProfesoresDTO> profesorArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idprofesor,nameprofesor,lastnameprofesor,codprofesor,statusprofesor "
            + "FROM PROFESORES "
            + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        ProfesoresDTO profesor;
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
                profesorArrayList = null;
            } else {
                do {
                    profesor = new ProfesoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                    profesorArrayList.add(profesor);
                } while (rs.next());
            }
            return profesorArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProfesoresDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return profesorArrayList;
    }

    @Override
    public ArrayList<ProfesoresDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProfesoresDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProfesoresDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
