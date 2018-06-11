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
    private String cyclepreferencia;

    public Preferencias_cursos_profesoresDTO() {
    }

    public Preferencias_cursos_profesoresDTO(int idcurso, int idprofesor, String cyclepreferencia) {
        this.idcurso = idcurso;
        this.idprofesor = idprofesor;
        this.cyclepreferencia = cyclepreferencia;
    }

    public String getCyclepreferencia() {
        return cyclepreferencia;
    }

    public void setCyclepreferencia(String cyclepreferencia) {
        this.cyclepreferencia = cyclepreferencia;
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
