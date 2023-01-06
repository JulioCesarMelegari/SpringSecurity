package br.com.security.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.security.model.Usuario;
import br.com.security.repository.UsuarioRepository;


@Service
public class SecurityDatabaseService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario userEntity = repository.findByUsuarionome(username);
		if(userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		userEntity.getRoles().forEach(role ->{
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		UserDetails user = new org.springframework.security.core.userdetails.User(userEntity.getNome(),
				userEntity.getSenha(),
				authorities);
		return user;
	}
	
	
}
