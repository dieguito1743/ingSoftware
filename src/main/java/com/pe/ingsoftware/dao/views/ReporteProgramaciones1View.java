package com.pe.ingsoftware.dao.views;

public class ReporteProgramaciones1View {

    int idprogramacion;
    int idcurso;
    int idprofesor;
    int cycleprogramacion;
    int groupprogramacion;
    String cyclecurso;
    String plancurso;
    String programcurso;
    String namecurso;
    String nameprofesor;
    String lastnameprofesor;

    public ReporteProgramaciones1View() {
    }

    public ReporteProgramaciones1View(int idprogramacion, int idcurso, int idprofesor, int cycleprogramacion, int groupprogramacion, String cyclecurso, String plancurso, String programcurso, String namecurso, String nameprofesor, String lastnameprofesor) {
        this.idprogramacion = idprogramacion;
        this.idcurso = idcurso;
        this.idprofesor = idprofesor;
        this.cycleprogramacion = cycleprogramacion;
        this.groupprogramacion = groupprogramacion;
        this.cyclecurso = cyclecurso;
        this.plancurso = plancurso;
        this.programcurso = programcurso;
        this.namecurso = namecurso;
        this.nameprofesor = nameprofesor;
        this.lastnameprofesor = lastnameprofesor;
    }

    public int getIdprogramacion() {
        return idprogramacion;
    }

    public void setIdprogramacion(int idprogramacion) {
        this.idprogramacion = idprogramacion;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getCycleprogramacion() {
        return cycleprogramacion;
    }

    public void setCycleprogramacion(int cycleprogramacion) {
        this.cycleprogramacion = cycleprogramacion;
    }

    public int getGroupprogramacion() {
        return groupprogramacion;
    }

    public void setGroupprogramacion(int groupprogramacion) {
        this.groupprogramacion = groupprogramacion;
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

    public String getNamecurso() {
        return namecurso;
    }

    public void setNamecurso(String namecurso) {
        this.namecurso = namecurso;
    }

    public String getNameprofesor() {
        return nameprofesor;
    }

    public void setNameprofesor(String nameprofesor) {
        this.nameprofesor = nameprofesor;
    }

    public String getLastnameprofesor() {
        return lastnameprofesor;
    }

    public void setLastnameprofesor(String lastnameprofesor) {
        this.lastnameprofesor = lastnameprofesor;
    }

}
