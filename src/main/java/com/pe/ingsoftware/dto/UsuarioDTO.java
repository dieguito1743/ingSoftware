/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.ingsoftware.dto;

/**
 *
 * @author dbermudez
 */
public class UsuarioDTO {

    private String idUser;
    private String name;
    private String email;
    private int age;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String idUser, String name, String email, int age) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
