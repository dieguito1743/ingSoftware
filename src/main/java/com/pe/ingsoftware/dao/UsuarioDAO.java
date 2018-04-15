/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.UsuarioDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbermudez
 */
@Component("usuario")
public class UsuarioDAO implements IBDCrud<UsuarioDTO> {
    
    private static final Conexion cnn = Conexion.crearConexion();

    public UsuarioDAO() {
    }

    @Override
    public int insertar(UsuarioDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean actualizar(UsuarioDTO objetoAntiguo, UsuarioDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean borrar(UsuarioDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<UsuarioDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UsuarioDTO consultarUno(Object primaryKey) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UsuarioDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<UsuarioDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
