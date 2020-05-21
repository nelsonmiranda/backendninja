package com.udemy.backendninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario_rol", uniqueConstraints = @UniqueConstraint( columnNames = {"usuario", "rol" }))
public class UsuarioRol {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;
	
	@Column(name = "rol", nullable = false, length = 45)
	private String rol;
	
	public UsuarioRol() {
		super();
	}

	public UsuarioRol(Integer id, Usuario usuario, String rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioRol [id=" + id + ", usuario=" + usuario + ", rol=" + rol + "]";
	}
	
}
