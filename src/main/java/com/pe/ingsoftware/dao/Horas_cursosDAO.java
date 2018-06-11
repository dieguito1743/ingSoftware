/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.Horas_cursosDTO;
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
@Component("horas_cursos")
public class Horas_cursosDAO implements IBDCrud<Horas_cursosDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT "
            + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
            + "FROM HORAS_CURSOS "
            + "WHERE idhora_curso = ? ";
    private static final String SQL_SELECT_ALL = "SELECT "
            + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
            + "FROM HORAS_CURSOS ";
    private static String SQL_CONSULTAR_UNO = "SELECT "
            + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
            + "FROM HORAS_CURSOS "
            + "WHERE ";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
            + "FROM HORAS_CURSOS "
            + "WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(Horas_cursosDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Horas_cursosDTO objetoAntiguo, Horas_cursosDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Horas_cursosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horas_cursosDTO> consultarTodo() throws BussinessException {
        ArrayList<Horas_cursosDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        Horas_cursosDTO horas_curso;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    horas_curso = new Horas_cursosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    ArrayList.add(horas_curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public Horas_cursosDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        Horas_cursosDTO horas_curso = new Horas_cursosDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                horas_curso.setIdhora_curso(rs.getInt(1));
                horas_curso.setTypehora_curso(rs.getString(2));
                horas_curso.setNumberhourhora_curso(rs.getInt(3));
                horas_curso.setIdcurso(rs.getInt(4));
            }
            return horas_curso;
        } catch (SQLException ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return horas_curso;
    }

    @Override
    public Horas_cursosDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        SQL_CONSULTAR_UNO = "SELECT "
                + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
                + "FROM HORAS_CURSOS "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        Horas_cursosDTO horas_curso = new Horas_cursosDTO();
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
                horas_curso.setIdhora_curso(rs.getInt(1));
                horas_curso.setTypehora_curso(rs.getString(2));
                horas_curso.setNumberhourhora_curso(rs.getInt(3));
                horas_curso.setIdcurso(rs.getInt(4));
            }
            return horas_curso;
        } catch (SQLException ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return horas_curso;
    }

    @Override
    public ArrayList<Horas_cursosDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        ArrayList<Horas_cursosDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT "
                + "idhora_curso,typehora_curso,numberhourhora_curso,idcurso "
                + "FROM HORAS_CURSOS "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        Horas_cursosDTO horas_curso;
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
                    horas_curso = new Horas_cursosDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                    ArrayList.add(horas_curso);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Horas_cursosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<Horas_cursosDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horas_cursosDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horas_cursosDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
