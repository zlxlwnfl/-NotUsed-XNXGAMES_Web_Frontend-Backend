package com.juri.XNXGAMES.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import com.juri.XNXGAMES.config.KeycloakClientConfig;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private Keycloak keycloak;
	
	@Override
	public Response create(String userName, String password) {
		CredentialRepresentation cr = new CredentialRepresentation();
		cr.setTemporary(false);
		cr.setType(CredentialRepresentation.PASSWORD);
		cr.setValue(password);
		
		UserRepresentation ur = new UserRepresentation();
		ur.setUsername(userName);
		ur.setCredentials(Arrays.asList(cr));
		ur.setEnabled(true);
		
		return keycloak.realm(KeycloakClientConfig.realm).users().create(ur);
	}

	@Override
	public List<UserRepresentation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRepresentation findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRepresentation findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleRepresentation assignRole(String userId, RoleRepresentation roleRepresentation) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
