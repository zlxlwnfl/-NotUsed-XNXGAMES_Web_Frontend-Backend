package com.juri.XNXGAMES.service;

import java.util.List;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.config.KeycloakClientConfig;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

	private Keycloak keycloak;
	
	public void create(String roleName) {
		RoleRepresentation role = new RoleRepresentation();
		role.setName(roleName);
		
		keycloak
			.realm(KeycloakClientConfig.realm)
			.roles()
			.create(role);
	}
	
	public List<RoleRepresentation> findAll() {
		return keycloak
					.realm(KeycloakClientConfig.realm)
					.roles()
					.list();
	}
	
	public RoleRepresentation findByName(String roleName) {
		return keycloak
					.realm(KeycloakClientConfig.realm)
					.roles()
					.get(roleName)
					.toRepresentation();
	}
	
}
