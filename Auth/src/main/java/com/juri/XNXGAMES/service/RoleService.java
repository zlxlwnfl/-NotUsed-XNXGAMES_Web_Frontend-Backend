package com.juri.XNXGAMES.service;

import java.util.List;

import org.keycloak.representations.idm.RoleRepresentation;

public interface RoleService {

	public void create(String roleName);
	public List<RoleRepresentation> findAll();
	public RoleRepresentation findByName(String roleName);
	
}
