package com.udemy.backendninja.service.impl;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.Usuario;
import com.udemy.backendninja.entity.UsuarioRol;
import com.udemy.backendninja.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService {

	@Autowired  
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsuario(username);
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getUsuarioRol());
		return buildUsuario(usuario, authorities);
	}

	private User buildUsuario(Usuario usuario, List<GrantedAuthority> authorities){
		
		return new User(usuario.getUsuario(), usuario.getPassword(), usuario.isActivo(),
				true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<UsuarioRol> usuarioRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		usuarioRoles.forEach((usuarioRol) ->{
			auths.add(new SimpleGrantedAuthority(usuarioRol.getRol()));
		});
		
		return new ArrayList<GrantedAuthority>(auths);
	}
}
