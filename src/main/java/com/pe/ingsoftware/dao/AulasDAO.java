/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.AulasDTO;
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
@Component("aulas")
public class AulasDAO implements IBDCrud<AulasDTO> {

    private static final String SQL_SELECT_WHERE = "SELECT * FROM AULAS WHERE idaula = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM AULAS";
    private static String SQL_CONSULTAR_UNO = "SELECT * FROM AULAS WHERE";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT * FROM AULAS WHERE";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(AulasDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(AulasDTO objetoAntiguo, AulasDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(AulasDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AulasDTO> consultarTodo() throws BussinessException {
        ArrayList<AulasDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        AulasDTO aula;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    aula = new AulasDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    ArrayList.add(aula);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public AulasDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        AulasDTO aula = new AulasDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                aula.setIdaula(rs.getInt(1));
                aula.setNumberaula(rs.getString(2));
                aula.setFlooraula(rs.getInt(3));
                aula.setPavilionaula(rs.getString(4));
                aula.setTypeaula(rs.getString(5));
                aula.setStatusaula(rs.getInt(6));
            }
            return aula;
        } catch (SQLException ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return aula;
    }

    @Override
    public AulasDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) {
        SQL_CONSULTAR_UNO = SQL_CONSULTAR_UNO + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        AulasDTO aula = new AulasDTO();
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
                aula.setIdaula(rs.getInt(1));
                aula.setNumberaula(rs.getString(2));
                aula.setFlooraula(rs.getInt(3));
                aula.setPavilionaula(rs.getString(4));
                aula.setTypeaula(rs.getString(5));
                aula.setStatusaula(rs.getInt(6));
            }
            return aula;
        } catch (SQLException ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return aula;
    }

    @Override
    public ArrayList<AulasDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) {
        ArrayList<AulasDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = SQL_CONSULTAR_TODO_DE + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        AulasDTO aula;
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
                    aula = new AulasDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    ArrayList.add(aula);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

}
