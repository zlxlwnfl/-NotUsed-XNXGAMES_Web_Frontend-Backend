package com.juri.XNXGAMES.service;

import java.util.List;

import javax.ws.rs.core.Response;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;

public interface UserService {

	Response create(String userName, String password);
	List<UserRepresentation> findAll();
	UserRepresentation findById(String id);
	UserRepresentation findByUsername(String userName);
	RoleRepresentation assignRole(String userId, RoleRepresentation roleRepresentation);
	
}
