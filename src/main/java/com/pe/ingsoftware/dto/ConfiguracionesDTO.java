package com.pe.ingsoftware.dto;

public class ConfiguracionesDTO {
	private int idconfiguracion;
	private String cycleconfiguracion;
	private int statusconfiguracion;

	public ConfiguracionesDTO() {
	}

	public ConfiguracionesDTO(int idconfiguracion, String cycleconfiguracion, int statusconfiguracion) {
		super();
		this.idconfiguracion = idconfiguracion;
		this.cycleconfiguracion = cycleconfiguracion;
		this.statusconfiguracion = statusconfiguracion;
	}

	public int getIdconfiguracion() {
		return idconfiguracion;
	}

	public void setIdconfiguracion(int idconfiguracion) {
		this.idconfiguracion = idconfiguracion;
	}

	public String getCycleconfiguracion() {
		return cycleconfiguracion;
	}

	public void setCycleconfiguracion(String cycleconfiguracion) {
		this.cycleconfiguracion = cycleconfiguracion;
	}

	public int getStatusconfiguracion() {
		return statusconfiguracion;
	}

	public void setStatusconfiguracion(int statusconfiguracion) {
		this.statusconfiguracion = statusconfiguracion;
	}

}
