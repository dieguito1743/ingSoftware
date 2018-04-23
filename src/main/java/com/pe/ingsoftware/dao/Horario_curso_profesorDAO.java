/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dao.conexion.Conexion;
import com.pe.ingsoftware.dto.Horario_curso_profesorDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author DiegoDavid
 */
@Component("horario_curso_profesor")
public class Horario_curso_profesorDAO implements IBDCrud<Horario_curso_profesorDTO> {

    private static final String SQL_INSERT = "INSERT INTO horario_curso_profesor (idcurso, idprofesor, idhorario) VALUES (?,?,?) ";

    private static final Conexion cnn = Conexion.crearConexion();

    @Override
    public int insertar(Horario_curso_profesorDTO objetoNuevo) throws BussinessException {
        int retorno = -1;
        PreparedStatement ps;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, objetoNuevo.getIdcurso());
            ps.setInt(2, objetoNuevo.getIdprofesor());
            ps.setInt(3, objetoNuevo.getIdhorario());
            if (ps.executeUpdate() > 0) {
                retorno = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Horario_curso_profesorDTO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Horario_curso_profesorDTO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean actualizar(Horario_curso_profesorDTO objetoAntiguo, Horario_curso_profesorDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Horario_curso_profesorDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesorDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario_curso_profesorDTO consultarUno(Object primaryKey) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario_curso_profesorDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesorDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesorDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesorDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesorDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
