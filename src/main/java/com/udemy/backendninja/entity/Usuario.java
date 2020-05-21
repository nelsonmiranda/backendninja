package com.udemy.backendninja.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "usuario", unique = true, nullable = false, length = 45)
	private String usuario;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "activo", nullable = false)
	private boolean activo;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
	private Set<UsuarioRol> usuarioRol = new HashSet<UsuarioRol>();


	public Usuario() {
		super();
	}

	public Usuario(String usuario, String password, boolean activo) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.activo = activo;
	}

	public Usuario(String usuario, String password, boolean activo, Set<UsuarioRol> usuarioRol) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.activo = activo;
		this.usuarioRol = usuarioRol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Set<UsuarioRol> getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(Set<UsuarioRol> usuarioRol) {
		this.usuarioRol = usuarioRol;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", activo=" + activo + ", usuarioRol="
				+ usuarioRol + "]";
	}

}
