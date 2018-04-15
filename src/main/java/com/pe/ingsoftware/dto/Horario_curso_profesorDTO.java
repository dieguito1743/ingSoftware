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
public class Horario_curso_profesorDTO {

    private int idcurso;
    private int idprofesor;
    private int idhorario;

    public Horario_curso_profesorDTO() {
    }

    public Horario_curso_profesorDTO(int idcurso, int idprofesor, int idhorario) {
        this.idcurso = idcurso;
        this.idprofesor = idprofesor;
        this.idhorario = idhorario;
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

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

}
