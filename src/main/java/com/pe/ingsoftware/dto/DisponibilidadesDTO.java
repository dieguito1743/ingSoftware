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
public class DisponibilidadesDTO {

    private int iddisponibilidad;
    private String cycledisponibilidad;
    private String daydisponibilidad;
    private String hourstartdisponibilidad;
    private String hourenddisponibilidad;
    private int statusdisponibilidad;
    private int idprofesor;

    public DisponibilidadesDTO() {
    }

    public DisponibilidadesDTO(int iddisponibilidad, String cycledisponibilidad, String daydisponibilidad, String hourstartdisponibilidad, String hourenddisponibilidad, int statusdisponibilidad, int idprofesor) {
        this.iddisponibilidad = iddisponibilidad;
        this.cycledisponibilidad = cycledisponibilidad;
        this.daydisponibilidad = daydisponibilidad;
        this.hourstartdisponibilidad = hourstartdisponibilidad;
        this.hourenddisponibilidad = hourenddisponibilidad;
        this.statusdisponibilidad = statusdisponibilidad;
        this.idprofesor = idprofesor;
    }

    public String getCycledisponibilidad() {
        return cycledisponibilidad;
    }

    public void setCycledisponibilidad(String cycledisponibilidad) {
        this.cycledisponibilidad = cycledisponibilidad;
    }

    public int getIddisponibilidad() {
        return iddisponibilidad;
    }

    public void setIddisponibilidad(int iddisponibilidad) {
        this.iddisponibilidad = iddisponibilidad;
    }

    public String getDaydisponibilidad() {
        return daydisponibilidad;
    }

    public void setDaydisponibilidad(String daydisponibilidad) {
        this.daydisponibilidad = daydisponibilidad;
    }

    public String getHourstartdisponibilidad() {
        return hourstartdisponibilidad;
    }

    public void setHourstartdisponibilidad(String hourstartdisponibilidad) {
        this.hourstartdisponibilidad = hourstartdisponibilidad;
    }

    public String getHourenddisponibilidad() {
        return hourenddisponibilidad;
    }

    public void setHourenddisponibilidad(String hourenddisponibilidad) {
        this.hourenddisponibilidad = hourenddisponibilidad;
    }

    public int getStatusdisponibilidad() {
        return statusdisponibilidad;
    }

    public void setStatusdisponibilidad(int statusdisponibilidad) {
        this.statusdisponibilidad = statusdisponibilidad;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

}
