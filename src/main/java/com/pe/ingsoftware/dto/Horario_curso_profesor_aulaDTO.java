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
public class Horario_curso_profesor_aulaDTO {

    private int idcurso;
    private int idprofesor;
    private int idhorario;
    private int idaula;

    public Horario_curso_profesor_aulaDTO() {
    }

    public Horario_curso_profesor_aulaDTO(int idcurso, int idprofesor, int idhorario, int idaula) {
        this.idcurso = idcurso;
        this.idprofesor = idprofesor;
        this.idhorario = idhorario;
        this.idaula = idaula;
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

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

}
