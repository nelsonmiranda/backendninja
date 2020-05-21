package com.udemy.backendninja.model;

public class UsuarioCredential {

	private String usuario;
	private String password;

	public UsuarioCredential() {
	}

	public UsuarioCredential(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
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

	@Override
	public String toString() {
		return "UsuarioCredential [usuario=" + usuario + ", password=" + password + "]";
	}

}
