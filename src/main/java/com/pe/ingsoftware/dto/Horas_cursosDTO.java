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
public class Horas_cursosDTO {

    private int idhora_curso;
    private String typehora_curso;
    private int numberhourhora_curso;
    private int idcurso;

    public Horas_cursosDTO() {
    }

    public Horas_cursosDTO(int idhora_curso, String typehora_curso, int numberhourhora_curso, int idcurso) {
        this.idhora_curso = idhora_curso;
        this.typehora_curso = typehora_curso;
        this.numberhourhora_curso = numberhourhora_curso;
        this.idcurso = idcurso;
    }

    public int getIdhora_curso() {
        return idhora_curso;
    }

    public void setIdhora_curso(int idhora_curso) {
        this.idhora_curso = idhora_curso;
    }

    public String getTypehora_curso() {
        return typehora_curso;
    }

    public void setTypehora_curso(String typehora_curso) {
        this.typehora_curso = typehora_curso;
    }

    public int getNumberhourhora_curso() {
        return numberhourhora_curso;
    }

    public void setNumberhourhora_curso(int numberhourhora_curso) {
        this.numberhourhora_curso = numberhourhora_curso;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

}
