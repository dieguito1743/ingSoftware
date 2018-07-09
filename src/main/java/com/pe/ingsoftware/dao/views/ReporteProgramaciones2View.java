package com.pe.ingsoftware.dao.views;

public class ReporteProgramaciones2View {

	int idprogramacion;
	int idcurso;
	int idprofesor;
	int idaula;
	int idhorario;
	int cycleprogramacion;
	int groupprogramacion;
	String cyclecurso;
	String plancurso;
	String programcurso;
	String namecurso;
	String nameprofesor;
	String lastnameprofesor;
	String numberaula;
	String pavilionaula;
	String dayhorario;
	String timestarthorario;
	String timeendhorario;

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

	public int getIdaula() {
		return idaula;
	}

	public void setIdaula(int idaula) {
		this.idaula = idaula;
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

	public String getNumberaula() {
		return numberaula;
	}

	public void setNumberaula(String numberaula) {
		this.numberaula = numberaula;
	}

	public String getPavilionaula() {
		return pavilionaula;
	}

	public void setPavilionaula(String pavilionaula) {
		this.pavilionaula = pavilionaula;
	}

	public ReporteProgramaciones2View() {
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

	public ReporteProgramaciones2View(int idprogramacion, int idcurso,
			int idprofesor, int idaula, int idhorario, int cycleprogramacion,
			int groupprogramacion, String cyclecurso, String plancurso,
			String programcurso, String namecurso, String nameprofesor,
			String lastnameprofesor, String numberaula, String pavilionaula,
			String dayhorario, String timestarthorario, String timeendhorario) {
		this.idprogramacion = idprogramacion;
		this.idcurso = idcurso;
		this.idprofesor = idprofesor;
		this.idaula = idaula;
		this.cycleprogramacion = cycleprogramacion;
		this.groupprogramacion = groupprogramacion;
		this.cyclecurso = cyclecurso;
		this.plancurso = plancurso;
		this.programcurso = programcurso;
		this.namecurso = namecurso;
		this.nameprofesor = nameprofesor;
		this.lastnameprofesor = lastnameprofesor;
		this.numberaula = numberaula;
		this.pavilionaula = pavilionaula;
		this.dayhorario = dayhorario;
		this.timestarthorario = timestarthorario;
		this.timeendhorario = timeendhorario;
		this.idhorario = idhorario;
	}

	public ReporteProgramaciones2View(int idprogramacion, int idcurso,
			int idprofesor, int idaula, int cycleprogramacion,
			int groupprogramacion, String cyclecurso, String plancurso,
			String programcurso, String namecurso, String nameprofesor,
			String lastnameprofesor, String numberaula, String pavilionaula) {
		this.idprogramacion = idprogramacion;
		this.idcurso = idcurso;
		this.idprofesor = idprofesor;
		this.idaula = idaula;
		this.cycleprogramacion = cycleprogramacion;
		this.groupprogramacion = groupprogramacion;
		this.cyclecurso = cyclecurso;
		this.plancurso = plancurso;
		this.programcurso = programcurso;
		this.namecurso = namecurso;
		this.nameprofesor = nameprofesor;
		this.lastnameprofesor = lastnameprofesor;
		this.numberaula = numberaula;
		this.pavilionaula = pavilionaula;
	}

	public int getIdhorario() {
		return idhorario;
	}

	public void setIdhorario(int idhorario) {
		this.idhorario = idhorario;
	}

}
