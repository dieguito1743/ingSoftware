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
public class Programaciones_aulasDTO {

    private int idaula;
    private int idprogramacion;
    private int idhorario;
    private int idusuario;

    public Programaciones_aulasDTO() {
    }

    public Programaciones_aulasDTO(int idaula, int idprogramacion, int idhorario, int idusuario) {
        this.idaula = idaula;
        this.idprogramacion = idprogramacion;
        this.idhorario = idhorario;
        this.idusuario = idusuario;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public int getIdprogramacion() {
        return idprogramacion;
    }

    public void setIdprogramacion(int idprogramacion) {
        this.idprogramacion = idprogramacion;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

}
