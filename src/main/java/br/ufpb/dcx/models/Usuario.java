package br.ufpb.dcx.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USUARIO_ROLE", 
    			joinColumns = {@JoinColumn(name = "USUARIO_ID")}, 
    			inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
	private Set<Role> userProfiles = new HashSet<Role>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(Set<Role> userProfiles) {
		this.userProfiles = userProfiles;
	}
}
