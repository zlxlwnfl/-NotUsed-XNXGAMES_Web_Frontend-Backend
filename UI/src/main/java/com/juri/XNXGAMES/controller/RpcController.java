package com.juri.XNXGAMES.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.juri.XNXGAMES.DTO.PostGetDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rpc/*")
@AllArgsConstructor
public class RpcController {

    private RestTemplate restTemplate;

    @GetMapping("/getPost")
    public PostGetDTO getPost(String postId) {
    	ResponseEntity<PostGetDTO> result;
    	
    	result = restTemplate.postForEntity(
    			"http://localhost:8000/public/board/post/getPost?postId=" + postId,
    			null,
    			PostGetDTO.class);
    	
    	return result.getBody();
    }
	
}
