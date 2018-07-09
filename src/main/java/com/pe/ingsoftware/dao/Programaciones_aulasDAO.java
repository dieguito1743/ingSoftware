/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.Programaciones_aulasDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

/**
 *
 * @author DiegoDavid
 */
@Component("programaciones_aulas")
public class Programaciones_aulasDAO implements IBDCrud<Programaciones_aulasDTO> {

	
	private static final String SQL_INSERT = "INSERT "
            + "INTO programaciones "
            + "(idprogramacion, idaula, idhorario, idusuario) "
            + "VALUES (?,?,?,?) ";
	private static final Conexion cnn = Conexion.crearConexion();
	
    @Override
    public int insertar(Programaciones_aulasDTO objetoNuevo) throws BussinessException {
    	int retorno = -1;
        PreparedStatement ps;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objetoNuevo.getIdprogramacion());
            ps.setInt(2, objetoNuevo.getIdaula());
            ps.setInt(3, objetoNuevo.getIdhorario());
            ps.setInt(4, objetoNuevo.getIdusuario());
            if (ps.executeUpdate() > 0) {
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Programaciones_aulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Programaciones_aulasDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean actualizar(Programaciones_aulasDTO objetoAntiguo, Programaciones_aulasDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Programaciones_aulasDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_aulasDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Programaciones_aulasDTO consultarUno(Object primaryKey) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Programaciones_aulasDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_aulasDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_aulasDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_aulasDTO> selectPrograma() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Programaciones_aulasDTO> selectPlan(String filtro) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
