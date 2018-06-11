/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dto;

import java.sql.Date;

/**
 *
 * @author DiegoDavid
 */
public class SesionesDTO {

    private int idsesion;
    private Date daysesion;

    public SesionesDTO() {
    }

    public SesionesDTO(int idsesion, Date daysesion) {
        this.idsesion = idsesion;
        this.daysesion = daysesion;
    }

    public int getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(int idsesion) {
        this.idsesion = idsesion;
    }

    public Date getDaysesion() {
        return daysesion;
    }

    public void setDaysesion(Date daysesion) {
        this.daysesion = daysesion;
    }

}
