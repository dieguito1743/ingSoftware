/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dto;

/**
 *
 * @author DiegoDavid
 */
public class Preferencias_cursos_profesoresDTO {

    private int idcurso;
    private int idprofesor;

    public Preferencias_cursos_profesoresDTO() {
    }

    public Preferencias_cursos_profesoresDTO(int idcurso, int idprofesor) {
        this.idcurso = idcurso;
        this.idprofesor = idprofesor;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

}
