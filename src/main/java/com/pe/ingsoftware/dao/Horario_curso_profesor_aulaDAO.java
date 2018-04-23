/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dao;

import com.pe.ingsoftware.dto.Horario_curso_profesor_aulaDTO;
import com.pe.ingsoftware.interfaces.IBDCrud;
import com.pe.ingsoftware.util.BussinessException;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author DiegoDavid
 */
@Component("horario_curso_profesor_aula")
public class Horario_curso_profesor_aulaDAO implements IBDCrud<Horario_curso_profesor_aulaDTO> {

    @Override
    public int insertar(Horario_curso_profesor_aulaDTO objetoNuevo) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Horario_curso_profesor_aulaDTO objetoAntiguo, Horario_curso_profesor_aulaDTO objetoActualizar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Horario_curso_profesor_aulaDTO objetoBorrar) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesor_aulaDTO> consultarTodo() throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario_curso_profesor_aulaDTO consultarUno(Object primaryKey) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario_curso_profesor_aulaDTO consultarUno(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesor_aulaDTO> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesor_aulaDTO> selectPrograma() throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesor_aulaDTO> selectPlan(String filtro) throws BussinessException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Horario_curso_profesor_aulaDTO> consultarTodoDe(Object campo1, Object valorCampo1, int tipoCampo1, Object campo2, Object valorCampo2, int tipoCampo2) throws BussinessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
