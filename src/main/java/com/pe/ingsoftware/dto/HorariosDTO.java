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
public class HorariosDTO {

    private int idhorario;
    private int cyclehorario;
    private String dayhorario;
    private String timestarthorario;
    private String timeendhorario;
    private int statushorario;

    public HorariosDTO() {
    }

    public HorariosDTO(int idhorario, int cyclehorario, String dayhorario, String timestarthorario, String timeendhorario, int statushorario) {
        this.idhorario = idhorario;
        this.cyclehorario = cyclehorario;
        this.dayhorario = dayhorario;
        this.timestarthorario = timestarthorario;
        this.timeendhorario = timeendhorario;
        this.statushorario = statushorario;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorarios) {
        this.idhorario = idhorarios;
    }

    public int getCyclehorario() {
        return cyclehorario;
    }

    public void setCyclehorario(int cyclehorario) {
        this.cyclehorario = cyclehorario;
    }

    public String getDayhorario() {
        return dayhorario;
    }

    public void setDayhorario(String dayhorario) {
        this.dayhorario = dayhorario;
    }

    public String getTimestarthorario() {
        return timestarthorario;
    }

    public void setTimestarthorario(String timestarthorario) {
        this.timestarthorario = timestarthorario;
    }

    public String getTimeendhorario() {
        return timeendhorario;
    }

    public void setTimeendhorario(String timeendhorario) {
        this.timeendhorario = timeendhorario;
    }

    public int getStatushorario() {
        return statushorario;
    }

    public void setStatushorario(int statushorario) {
        this.statushorario = statushorario;
    }

}
