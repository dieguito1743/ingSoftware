package com.pe.ingsoftware.dto;

public class ProgramacionesDTO {

    private int idprogramacion;
    private int idprofesor;
    private int idcurso;
    private int idusuario;
    private int cycleprogramacion;
    private int groupprogramacion;
    private int statusprogramacion;

    public ProgramacionesDTO() {
    }

    public ProgramacionesDTO(int idprogramacion, int idprofesor, int idcurso, int idusuario, int cycleprogramacion, int groupprogramacion, int statusprogramacion) {
        this.idprogramacion = idprogramacion;
        this.idprofesor = idprofesor;
        this.idcurso = idcurso;
        this.idusuario = idusuario;
        this.cycleprogramacion = cycleprogramacion;
        this.groupprogramacion = groupprogramacion;
        this.statusprogramacion = statusprogramacion;
    }

    public int getIdprogramacion() {
        return idprogramacion;
    }

    public void setIdprogramacion(int idprogramacion) {
        this.idprogramacion = idprogramacion;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getCycleprogramacion() {
        return cycleprogramacion;
    }

    public void setCycleprogramacion(int cycleprogramacion) {
        this.cycleprogramacion = cycleprogramacion;
    }

    public int getGroupprogramacion() {
        return groupprogramacion;
    }

    public void setGroupprogramacion(int groupprogramacion) {
        this.groupprogramacion = groupprogramacion;
    }

    public int getStatusprogramacion() {
        return statusprogramacion;
    }

    public void setStatusprogramacion(int statusprogramacion) {
        this.statusprogramacion = statusprogramacion;
    }

}
