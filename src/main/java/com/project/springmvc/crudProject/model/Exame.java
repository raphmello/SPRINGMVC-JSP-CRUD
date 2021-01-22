package com.project.springmvc.crudProject.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Exame {
    
	private int id;
   
	@NotNull(message = "requerido")
	@Size(min = 1, message = "requerido")
    private String paciente;
	
	@NotNull(message = "requerido")
	@Size(min = 1, message = "requerido")
    private String exame;
   
	@NotNull(message = "requerido")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataExame;
    
	
    private String observacaoResultado;
 
    public Exame() {
    }

	public Exame(String paciente, String exame, Date dataExame, String observacaoResultado) {
		super();
		this.paciente = paciente;
		this.exame = exame;
		this.dataExame = dataExame;
		this.observacaoResultado = observacaoResultado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

	public String getObservacaoResultado() {
		return observacaoResultado;
	}

	public void setObservacaoResultado(String observacaoResultado) {
		this.observacaoResultado = observacaoResultado;
	}
 
}
