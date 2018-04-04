package br.ufpb.dcx.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufpb.dcx.models.Role;
import br.ufpb.dcx.models.Usuario;
import br.ufpb.dcx.repository.UsuarioRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
		
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario user = usuarioRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Usuario user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role userProfile : user.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		return authorities;
	}
}
