package br.ufpb.dcx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.dcx.models.Role;

public interface UserProfileRepository extends JpaRepository<Role, Long>{
	
	Role findById(Long id);
}
