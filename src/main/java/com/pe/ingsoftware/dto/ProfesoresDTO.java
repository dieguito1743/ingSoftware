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
public class ProfesoresDTO {

    private int idprofesor;
    private String nameprofesor;
    private String lastnameprofesor;
    private String codprofesor;
    private int statusprofesor;

    public ProfesoresDTO() {
    }

    public ProfesoresDTO(int idprofesor, String nameprofesor, String lastnameprofesor, String codprofesor, int statusprofesor) {
        this.idprofesor = idprofesor;
        this.nameprofesor = nameprofesor;
        this.lastnameprofesor = lastnameprofesor;
        this.codprofesor = codprofesor;
        this.statusprofesor = statusprofesor;
    }

    public int getIdProfesor() {
        return idprofesor;
    }

    public void setIdProfesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getNameProfesor() {
        return nameprofesor;
    }

    public void setNameProfesor(String nameprofesor) {
        this.nameprofesor = nameprofesor;
    }

    public String getLastNameProfesor() {
        return lastnameprofesor;
    }

    public void setLastNameProfesor(String lastnameprofesor) {
        this.lastnameprofesor = lastnameprofesor;
    }

    public String getCodProfesor() {
        return codprofesor;
    }

    public void setCodProfesor(String codprofesor) {
        this.codprofesor = codprofesor;
    }

    public int getStatusPorfesor() {
        return statusprofesor;
    }

    public void setStatusPorfesor(int statusprofesor) {
        this.statusprofesor = statusprofesor;
    }

}
