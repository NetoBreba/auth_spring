package br.ufpb.dcx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.dcx.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);
}
