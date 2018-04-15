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
public class CursosDTO {

    private int idcurso;
    private String namecurso;
    private String codcurso;
    private String cyclecurso;
    private String plancurso;
    private String programcurso;
    private int statuscurso;

    public CursosDTO() {
    }

    public CursosDTO(int idcurso, String namecurso, String codcurso, String cyclecurso, String plancurso, String programcurso, int statuscurso) {
        this.idcurso = idcurso;
        this.namecurso = namecurso;
        this.codcurso = codcurso;
        this.cyclecurso = cyclecurso;
        this.plancurso = plancurso;
        this.programcurso = programcurso;
        this.statuscurso = statuscurso;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNamecurso() {
        return namecurso;
    }

    public void setNamecurso(String namecurso) {
        this.namecurso = namecurso;
    }

    public String getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(String codcurso) {
        this.codcurso = codcurso;
    }

    public String getCyclecurso() {
        return cyclecurso;
    }

    public void setCyclecurso(String cyclecurso) {
        this.cyclecurso = cyclecurso;
    }

    public String getPlancurso() {
        return plancurso;
    }

    public void setPlancurso(String plancurso) {
        this.plancurso = plancurso;
    }

    public String getProgramcurso() {
        return programcurso;
    }

    public void setProgramcurso(String programcurso) {
        this.programcurso = programcurso;
    }

    public int getStatuscurso() {
        return statuscurso;
    }

    public void setStatuscurso(int statuscurso) {
        this.statuscurso = statuscurso;
    }

}
