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
public class AulasDTO {

    private int idaula;
    private String numberaula;
    private int flooraula;
    private String pavilionaula;
    private String typeaula;
    private int statusaula;

    public AulasDTO() {
    }

    public AulasDTO(int idaula, String numberaula, int flooraula, String pavilionaula, String typeaula, int statusaula) {
        this.idaula = idaula;
        this.numberaula = numberaula;
        this.flooraula = flooraula;
        this.pavilionaula = pavilionaula;
        this.typeaula = typeaula;
        this.statusaula = statusaula;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
    }

    public String getNumberaula() {
        return numberaula;
    }

    public void setNumberaula(String numberaula) {
        this.numberaula = numberaula;
    }

    public int getFlooraula() {
        return flooraula;
    }

    public void setFlooraula(int flooraula) {
        this.flooraula = flooraula;
    }

    public String getPavilionaula() {
        return pavilionaula;
    }

    public void setPavilionaula(String pavilionaula) {
        this.pavilionaula = pavilionaula;
    }

    public String getTypeaula() {
        return typeaula;
    }

    public void setTypeaula(String typeaula) {
        this.typeaula = typeaula;
    }

    public int getStatusaula() {
        return statusaula;
    }

    public void setStatusaula(int statusaula) {
        this.statusaula = statusaula;
    }

}
