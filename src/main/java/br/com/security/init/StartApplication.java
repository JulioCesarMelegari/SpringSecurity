package br.com.security.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.security.model.Usuario;
import br.com.security.repository.UsuarioRepository;


@Component
public class StartApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = repository.findByUsuarionome("admin");
		if(usuario == null) {
			usuario = new Usuario();
			usuario.setNome("admin");
			usuario.setEmail("adm@lynx.com.br");
			usuario.setSenha("adm");
			usuario.getRoles().add("ADMINISTRADORES");
			repository.save(usuario);
		}
		usuario = repository.findByUsuarionome("usuario");
		if(usuario == null) {
			usuario = new Usuario();
			usuario.setNome("user");
			usuario.setEmail("user@lynx.com.br");
			usuario.setSenha("user");
			usuario.getRoles().add("USUARIOS");
			repository.save(usuario);
		}
	}
	

}
