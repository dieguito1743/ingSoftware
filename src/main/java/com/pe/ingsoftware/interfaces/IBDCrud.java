/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.interfaces;

import com.pe.ingsoftware.util.BussinessException;
import java.util.ArrayList;

/**
 *
 * @author dbermudez
 */
public interface IBDCrud<Clase> {

    /**
     * Este metodo inserta un <b>Objeto Nuevo</b> en la base de datos.
     * <br>
     * Para invocar a que tabla de la base de dats va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param objetoNuevo indica el objeto nuevo que se va Insertar en la tabla
     * @return <b>entero</b> retorna la ultima llave primaria, si menor igual
     * que 0, no se inserto nada.
     */
    int insertar(Clase objetoNuevo) throws BussinessException;

    /**
     * Este metodo actualiza un <b>Objeto Antiguo</b> en la base de datos.
     * <br>
     * Para invocar a que tabla de la base de dats va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param objetoAntiguo indica el objeto antiguo que se va Actualizar en la
     * tabla
     * @param objetoActualizar posee los nuevos datos que se actualizaran en
     * ObjetoAntiguo
     * @return <b>true</b> si el objeto fue actualizado sin problemas.
     * <br>
     * <b>false</b> si el objeto no se actualizo.
     */
    boolean actualizar(Clase objetoAntiguo, Clase objetoActualizar) throws BussinessException;

    /**
     * Este metodo borra un <b>Objeto</b> en la base de datos.
     * <br>
     * Para invocar a que tabla de la base de dats va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param objetoBorrar indica el objeto que se borrara de la base de datos
     * @return <b>true</b> si el objeto fue borrado satisfactoriamente.
     * <br>
     * <b>false</b> si el objeto fue borrado.
     */
    boolean borrar(Clase objetoBorrar) throws BussinessException;

    /**
     * Este metodo realiza un 'SELECT * FROM TABLE;'
     * <br>
     * Para invocar a que tabla de la base de datos va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @return <b>ArrayList</b> retorna un ArrayList de Objetos de la consulta
     */
    ArrayList<Clase> consultarTodo() throws BussinessException;

    /**
     * Este metodo realiza un 'SELECT * FROM TABLE WHERE PRIMARYKEY =
     * primaryKey;'
     * <br>
     * Para invocar a que tabla de la base de datos va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param primaryKey el valor de la llave Primaria.
     * @return <b>Object</b> retorna un Objeto de la Clase que se especifico en
     * el Contructor
     */
    Clase consultarUno(Object primaryKey) throws BussinessException;

    /**
     * Este metodo realiza un 'SELECT * FROM TABLE WHERE CAMPO = valorCampo;'
     * <br>
     * Para invocar a que tabla de la base de datos va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param campo indica el nombre de la columna o campo del cual se quiere
     * filtrar
     * @param valorCampo indica el valor que va tomar el <b>campo</b>
     * @param tipoCampo indica de que tipo dedatos es el campo.<br>
     * 0 - tipo Int o Integer.<br>
     * 1 - tipo Double.<br>
     * 2 - tipo String.<br>
     * 3 - tipo Time "HH:MM:SS".<br>
     * Default - String.<br>
     * @return <b>Objeto</b> retorna un Objeto de la Clase espeficicada en el
     * Constructor.
     */
    Clase consultarUno(Object campo, Object valorCampo, int tipoCampo);

    /**
     * Este metodo realiza un 'SELECT * FROM TABLE WHERE CAMPO = valorCampo;'
     * <br>
     * Para invocar a que tabla de la base de datos va, especifique el tipo de
     * contructor. 'clase' especifica el tipo de contructor.
     *
     * @param campo indica el nombre de la columna o campo del cual se quiere
     * filtrar
     * @param valorCampo indica el valor que va tomar el <b>campo</b>
     * @param tipoCampo indica de que tipo dedatos es el campo.<br>
     * 0 - tipo Int o Integer.<br>
     * 1 - tipo Double.<br>
     * 2 - tipo String.<br>
     * 3 - tipo Time "HH:MM:SS".<br>
     * Default - String.<br>
     * @return <b>ArrayList</b> retorna un ArrayList de Objetos de la consulta
     */
    ArrayList<Clase> consultarTodoDe(Object campo, Object valorCampo, int tipoCampo);
}
