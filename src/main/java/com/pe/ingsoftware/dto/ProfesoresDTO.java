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

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public String getnameprofesor() {
        return nameprofesor;
    }

    public void setnameprofesor(String nameprofesor) {
        this.nameprofesor = nameprofesor;
    }

    public String getlastnameprofesor() {
        return lastnameprofesor;
    }

    public void setlastnameprofesor(String lastnameprofesor) {
        this.lastnameprofesor = lastnameprofesor;
    }

    public String getcodprofesor() {
        return codprofesor;
    }

    public void setcodprofesor(String codprofesor) {
        this.codprofesor = codprofesor;
    }

    public int getstatusprofesor() {
        return statusprofesor;
    }

    public void setstatusprofesor(int statusprofesor) {
        this.statusprofesor = statusprofesor;
    }

}
