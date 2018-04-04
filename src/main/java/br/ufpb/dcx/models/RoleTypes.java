package br.ufpb.dcx.models;

import java.io.Serializable;

public enum RoleTypes implements Serializable{
	USER("USER"),
	ADMIN("ADMIN");
	
	String roleTypes;
	
	private RoleTypes(String roleTypes) {
		this.roleTypes = roleTypes;
	}
	
	public String getUserProfileType() {
		return this.roleTypes;
	}
	
}
