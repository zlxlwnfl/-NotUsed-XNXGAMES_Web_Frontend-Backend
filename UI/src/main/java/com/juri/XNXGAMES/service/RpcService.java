package com.juri.XNXGAMES.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.juri.XNXGAMES.DTO.PostGetDTO;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RpcService {

    private RestTemplate restTemplate;
    private static final String RESILIENCE4J_INSTANCE = "default";

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE)
	@Bulkhead(name = RESILIENCE4J_INSTANCE)
	@Retry(name = RESILIENCE4J_INSTANCE)
    public PostGetDTO getPost(String postId) {
    	ResponseEntity<PostGetDTO> result;
    	
    	result = restTemplate.getForEntity(
    			"http://localhost:8000/public/board/post?postId=" + postId,
    			PostGetDTO.class);
    	
    	return result.getBody();
    }
	
}
