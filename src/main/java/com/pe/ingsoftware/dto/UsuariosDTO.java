/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dto;

/**
 *
 * @author dbermudez
 */
public class UsuariosDTO {

    private int idusuario;
    private String username;
    private String userpass;
    private String usertype;
    private String useremail;
    private String userdependency;
    private int userstatus;
    private int timeOut;

    public UsuariosDTO() {
    }

    public UsuariosDTO(int idusuario, String username, String userpass, String usertype, String useremail, String userdependency, int userstatus, int timeOut) {
        this.idusuario = idusuario;
        this.username = username;
        this.userpass = userpass;
        this.usertype = usertype;
        this.useremail = useremail;
        this.userdependency = userdependency;
        this.userstatus = userstatus;
        this.timeOut = timeOut;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserdependency() {
        return userdependency;
    }

    public void setUserdependency(String userdependency) {
        this.userdependency = userdependency;
    }

    public int getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

}
