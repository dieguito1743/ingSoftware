/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.CursosDTO;
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
@Component("cursos")
public class CursosDAO implements IBDCrud<CursosDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT * FROM CURSOS WHERE idcurso = ? ";
    private static final String SQL_SELECT_ALL = "SELECT * FROM CURSOS ";
    private static String SQL_CONSULTAR_UNO = "SELECT * FROM CURSOS WHERE ";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT * FROM CURSOS WHERE ";
    private static final String SQL_SELECT_PROGRAM = "SELECT distinct programcurso FROM cursos ";
    private static final String SQL_SELET_PLAN = "SELECT distinct plancurso FROM cursos where programcurso = ? ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public ArrayList<CursosDTO> selectPrograma() throws BussinessException {
        ArrayList<CursosDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_PROGRAM);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    curso = new CursosDTO();
                    curso.setProgramcurso(rs.getString(1));
                    ArrayList.add(curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<CursosDTO> selectPlan(String filtro) throws BussinessException {
        ArrayList<CursosDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELET_PLAN);
            ps.setString(1, filtro);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    curso = new CursosDTO();
                    curso.setPlancurso(rs.getString(1));
                    ArrayList.add(curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public int insertar(CursosDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(CursosDTO objetoAntiguo, CursosDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(CursosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CursosDTO> consultarTodo() throws BussinessException {
        ArrayList<CursosDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    curso = new CursosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    ArrayList.add(curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public CursosDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso = new CursosDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                curso.setIdcurso(rs.getInt(1));
                curso.setNamecurso(rs.getString(2));
                curso.setCodcurso(rs.getString(3));
                curso.setCyclecurso(rs.getString(4));
                curso.setPlancurso(rs.getString(5));
                curso.setProgramcurso(rs.getString(6));
                curso.setStatuscurso(rs.getInt(7));
            }
            return curso;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return curso;
    }

    @Override
    public CursosDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        SQL_CONSULTAR_UNO = "SELECT * FROM CURSOS WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso = new CursosDTO();
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
                curso.setIdcurso(rs.getInt(1));
                curso.setNamecurso(rs.getString(2));
                curso.setCodcurso(rs.getString(3));
                curso.setCyclecurso(rs.getString(4));
                curso.setPlancurso(rs.getString(5));
                curso.setProgramcurso(rs.getString(6));
                curso.setStatuscurso(rs.getInt(7));
            }
            return curso;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return curso;
    }

    @Override
    public ArrayList<CursosDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        ArrayList<CursosDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT * FROM CURSOS WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso;
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
                    curso = new CursosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    ArrayList.add(curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<CursosDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        ArrayList<CursosDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT * FROM CURSOS WHERE " + campo1.toString() + " = ? and " + campo2.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        CursosDTO curso;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_CONSULTAR_TODO_DE);
            switch (tipoCampo1) {
                case 0:
                    ps.setInt(1, Integer.parseInt(valorCampo1.toString()));
                    break;
                case 1:
                    ps.setDouble(1, Double.parseDouble(valorCampo1.toString()));
                    break;
                case 2:
                    ps.setString(1, valorCampo1.toString());
                    break;
                case 3:
                    Time time = null;
                    ps.setTime(1, time.valueOf(valorCampo1.toString()));
                    break;
                default:
                    ps.setString(1, valorCampo1.toString());
                    break;
            }
            switch (tipoCampo1) {
                case 0:
                    ps.setInt(2, Integer.parseInt(valorCampo2.toString()));
                    break;
                case 1:
                    ps.setDouble(2, Double.parseDouble(valorCampo2.toString()));
                    break;
                case 2:
                    ps.setString(2, valorCampo2.toString());
                    break;
                case 3:
                    Time time = null;
                    ps.setTime(2, time.valueOf(valorCampo2.toString()));
                    break;
                default:
                    ps.setString(2, valorCampo2.toString());
                    break;
            }
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    curso = new CursosDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    ArrayList.add(curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

}
