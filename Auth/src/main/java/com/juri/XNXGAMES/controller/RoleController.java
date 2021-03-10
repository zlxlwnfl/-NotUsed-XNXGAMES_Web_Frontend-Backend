package com.juri.XNXGAMES.controller;

import java.util.List;

import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.service.RoleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/role/*")
@AllArgsConstructor
public class RoleController {

	private RoleService roleService;
	
	@PostMapping("/")
	public ResponseEntity<Void> createRole(@RequestParam String roleName) {
		roleService.create(roleName);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{roleName}")
	public ResponseEntity<RoleRepresentation> findByName(@PathVariable String roleName) {
		return new ResponseEntity<>(roleService.findByName(roleName), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RoleRepresentation>> findAllRole() {
		return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
	}
	
}
