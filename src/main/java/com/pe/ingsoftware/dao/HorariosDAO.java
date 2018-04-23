/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.HorariosDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author DiegoDavid
 */
@Component("horarios")
public class HorariosDAO implements IBDCrud<HorariosDTO> {

    private static final String SQL_INSERT = "INSERT INTO HORARIOS (cyclehorario, dayhorario, timestarthorario, timeendhorario, statushorario) VALUES (?,?,?) ";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM HORARIOS WHERE idhorario = ? ";
    private static final String SQL_SELECT_ALL = "SELECT * FROM HORARIOS ";
    private static String SQL_CONSULTAR_UNO = "SELECT * FROM HORARIOS WHERE ";
    private static String SQL_CONSULTAR_TODO_DE = "SELECT * FROM HORARIOS WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(HorariosDTO objetoNuevo) throws BussinessException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
        Time timeStart = null;
        Time timeEnd = null;
        try {
            timeStart = (Time) sdf.parse(objetoNuevo.getTimestarthorario());
            timeEnd = (Time) sdf.parse(objetoNuevo.getTimeendhorario());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int retorno = -1;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, objetoNuevo.getCyclehorario());
            ps.setString(2, objetoNuevo.getDayhorario());
            ps.setTime(3, timeStart);
            ps.setTime(4, timeEnd);
            ps.setInt(5, objetoNuevo.getStatushorario());
            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean actualizar(HorariosDTO objetoAntiguo, HorariosDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(HorariosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HorariosDTO> consultarTodo() throws BussinessException {
        ArrayList<HorariosDTO> ArrayList = new ArrayList();
        PreparedStatement ps;
        ResultSet rs;
        HorariosDTO horario;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            if (!rs.next()) {
                ArrayList = null;
            } else {
                do {
                    horario = new HorariosDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    ArrayList.add(horario);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public HorariosDTO consultarUno(Object primaryKey) throws BussinessException {
        PreparedStatement ps;
        ResultSet rs;
        HorariosDTO horario = new HorariosDTO();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_SELECT_WHERE);
            ps.setInt(1, Integer.parseInt(primaryKey.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                horario.setIdhorarios(rs.getInt(1));
                horario.setCyclehorario(rs.getInt(2));
                horario.setDayhorario(rs.getString(3));
                horario.setTimestarthorario(rs.getString(4));
                horario.setTimeendhorario(rs.getString(5));
                horario.setStatushorario(rs.getInt(6));
            }
            return horario;
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return horario;
    }

    @Override
    public HorariosDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        SQL_CONSULTAR_UNO = "SELECT * FROM CURSOS WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        HorariosDTO horario = new HorariosDTO();
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
                horario.setIdhorarios(rs.getInt(1));
                horario.setCyclehorario(rs.getInt(2));
                horario.setDayhorario(rs.getString(3));
                horario.setTimestarthorario(rs.getString(4));
                horario.setTimeendhorario(rs.getString(5));
                horario.setStatushorario(rs.getInt(6));
            }
            return horario;
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return horario;
    }

    @Override
    public ArrayList<HorariosDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        ArrayList<HorariosDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT * FROM CURSOS WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        HorariosDTO horario;
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
                    horario = new HorariosDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
                    ArrayList.add(horario);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HorariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<HorariosDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HorariosDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HorariosDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
