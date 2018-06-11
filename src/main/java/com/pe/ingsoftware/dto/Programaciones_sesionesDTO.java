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
public class Programaciones_sesionesDTO {

    private int idprogramacion;
    private int idsesion;

    public Programaciones_sesionesDTO() {
    }

    public Programaciones_sesionesDTO(int idprogramacion, int idsesion) {
        this.idprogramacion = idprogramacion;
        this.idsesion = idsesion;
    }

    public int getIdprogramacion() {
        return idprogramacion;
    }

    public void setIdprogramacion(int idprogramacion) {
        this.idprogramacion = idprogramacion;
    }

    public int getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(int idsesion) {
        this.idsesion = idsesion;
    }

}
