package br.ufpb.dcx.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufpb.dcx.models.Role;
import br.ufpb.dcx.repository.UserProfileRepository;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role>{

	@Autowired
	UserProfileRepository userProfileRepo;	
	
	@Override
	public Role convert(Object element) {
		Long id = Long.parseLong((String) element);
		Role userProfile = userProfileRepo.findById(id);
		return userProfile;
	}

}
