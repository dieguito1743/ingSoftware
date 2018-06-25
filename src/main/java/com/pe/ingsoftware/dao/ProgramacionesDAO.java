/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.ProgramacionesDTO;
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
@Component("programaciones")
public class ProgramacionesDAO implements IBDCrud<ProgramacionesDTO> {

    private static final String SQL_INSERT = "INSERT "
            + "INTO programaciones "
            + "(idprofesor, idcurso, idusuario, cycleprogramacion, groupprogramacion, statusprogramacion) "
            + "VALUES (?,?,?,?,?,?) ";
    private static final String SQL_SELECT_WHERE = "SELECT "
            + "idprogramacion, idprofesor, idcurso, idusuario, cycleprogramacion, groupprogramacion, statusprogramacion "
            + "FROM programaciones "
            + "WHERE idprogramacion = ? ";
    private static String SQL_CONSULTAR_UNO = "SELECT "
            + "idprogramacion, idprofesor, idcurso, idusuario, cycleprogramacion, groupprogramacion, statusprogramacion "
            + "FROM programaciones "
            + "WHERE ";
    private static final String SQL_UPDATE = "UPDATE "
            + "programaciones "
            + "SET idprofesor = ?, idusuario = ? "
            + "WHERE idprogramacion = ?";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(ProgramacionesDTO objetoNuevo) throws BussinessException {
        int retorno = -1;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, objetoNuevo.getIdprofesor());
            ps.setNull(1,java.sql.Types.INTEGER);
            ps.setInt(2, objetoNuevo.getIdcurso());
            ps.setInt(3, objetoNuevo.getIdusuario());
            ps.setInt(4, objetoNuevo.getCycleprogramacion());
            ps.setInt(5, objetoNuevo.getGroupprogramacion());
            ps.setInt(6, 0);
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean actualizar(ProgramacionesDTO objetoAntiguo, ProgramacionesDTO objetoActualizar) throws BussinessException {
        boolean retorno = false;
        PreparedStatement ps;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, objetoActualizar.getIdprofesor());
            ps.setInt(2, objetoActualizar.getIdusuario());
            ps.setInt(3, objetoAntiguo.getIdprogramacion());
            if (ps.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean borrar(ProgramacionesDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProgramacionesDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProgramacionesDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        ProgramacionesDTO curso = new ProgramacionesDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                curso.setIdprogramacion(rs.getInt(1));
                curso.setIdprofesor(rs.getInt(2));
                curso.setIdcurso(rs.getInt(3));
                curso.setIdusuario(rs.getInt(4));
                curso.setCycleprogramacion(rs.getInt(5));
                curso.setGroupprogramacion(rs.getInt(6));
                curso.setStatusprogramacion(rs.getInt(7));
            }
            return curso;
        } catch (SQLException ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return curso;
    }

    @Override
    public ProgramacionesDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        SQL_CONSULTAR_UNO = "SELECT "
                + "idprogramacion, idprofesor, idcurso, idusuario, cycleprogramacion, groupprogramacion, statusprogramacion "
                + "FROM programaciones "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        ProgramacionesDTO objetoDTO = new ProgramacionesDTO();
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
                objetoDTO.setIdprogramacion(rs.getInt(1));
                objetoDTO.setIdprofesor(rs.getInt(2));
                objetoDTO.setIdcurso(rs.getInt(3));
                objetoDTO.setIdusuario(rs.getInt(4));
                objetoDTO.setCycleprogramacion(rs.getInt(5));
                objetoDTO.setGroupprogramacion(rs.getInt(6));
                objetoDTO.setStatusprogramacion(rs.getInt(7));
                
            }
            return objetoDTO;
        } catch (SQLException ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProgramacionesDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return objetoDTO;
    }

    @Override
    public ArrayList<ProgramacionesDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProgramacionesDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProgramacionesDTO> selectPrograma() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProgramacionesDTO> selectPlan(String filtro) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
