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
public class Programaciones_horariosDTO {

    private int idprogramacion;
    private int idhorario;

    public Programaciones_horariosDTO() {
    }

    public Programaciones_horariosDTO(int idprogramacion, int idhorario) {
        this.idprogramacion = idprogramacion;
        this.idhorario = idhorario;
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

}
