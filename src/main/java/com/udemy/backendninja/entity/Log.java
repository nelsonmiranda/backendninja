package com.udemy.backendninja.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "detalle")
	private String detalle;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "url")
	private String url;

	public Log() {
		super();
	}

	public Log(Date fecha, String detalle, String usuario, String url) {
		super();
		this.fecha = fecha;
		this.detalle = detalle;
		this.usuario = usuario;
		this.url = url;
	}

	public Log(int id, Date fecha, String detalle, String usuario, String url) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.detalle = detalle;
		this.usuario = usuario;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", fecha=" + fecha + ", detalle=" + detalle + ", usuario=" + usuario + ", url=" + url
				+ "]";
	}

}
