package jwtspringsec.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
public class UserApp {
	@Id
	@GeneratedValue
private Long id;
@Column(unique=true)
private String username;
private String password;
@ManyToMany(fetch = FetchType.EAGER)
private Collection<RoleApp> roles=new ArrayList<RoleApp>();

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
@JsonIgnore
public String getPassword() {
	return password;
}
@JsonSetter
public void setPassword(String password) {
	this.password = password;
}
public Collection<RoleApp> getRoles() {
	return roles;
}
public void setRoles(Collection<RoleApp> roles) {
	this.roles = roles;
}
}
