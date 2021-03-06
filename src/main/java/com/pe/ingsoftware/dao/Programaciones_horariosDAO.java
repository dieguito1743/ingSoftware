/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.ProgramacionesDTO;
import com.pe.ingsoftware.dto.Programaciones_horariosDTO;
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
@Component("programaciones_horarios")
public class Programaciones_horariosDAO implements IBDCrud<Programaciones_horariosDTO> {

    private static final String SQL_INSERT = "INSERT "
            + "INTO programaciones_horarios "
            + "(idprogramacion, idhorario) "
            + "VALUES (?,?) ";

    private static String SQL_CONSULTAR_TODO_DE = "SELECT "
            + "idprogramacion, idhorario"
            + "FROM programaciones_horarios "
            + "WHERE ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(Programaciones_horariosDTO objetoNuevo) throws BussinessException {
        int retorno = -1;
        PreparedStatement ps;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objetoNuevo.getIdprogramacion());
            ps.setInt(2, objetoNuevo.getIdhorario());
            if (ps.executeUpdate() > 0) {
                retorno = 1;
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
    public boolean actualizar(Programaciones_horariosDTO objetoAntiguo, Programaciones_horariosDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Programaciones_horariosDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_horariosDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Programaciones_horariosDTO consultarUno(Object primaryKey) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Programaciones_horariosDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_horariosDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        ArrayList<Programaciones_horariosDTO> ArrayList = new ArrayList();
        SQL_CONSULTAR_TODO_DE = "SELECT "
                + "idprogramacion, idhorario "
                + "FROM programaciones_horarios "
                + "WHERE " + campo.toString() + " = ?";
        PreparedStatement ps;
        ResultSet rs;
        Programaciones_horariosDTO objetoDTO;
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
                    objetoDTO = new Programaciones_horariosDTO(rs.getInt(1), rs.getInt(2));
                    ArrayList.add(objetoDTO);
                } while (rs.next());
            }
            return ArrayList;
        } catch (SQLException ex) {
            Logger.getLogger(Programaciones_horariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Programaciones_horariosDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ArrayList;
    }

    @Override
    public ArrayList<Programaciones_horariosDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_horariosDTO> selectPrograma() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_horariosDTO> selectPlan(String filtro) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
