package com.juri.XNXGAMES.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Component
public class EventDispatcher {

	private RabbitTemplate rabbitTemplate;
	private static final String EXCHANGE = "BoardExchange";
	private static final String RESILIENCE4J_INSTANCE = "default";

	EventDispatcher(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE)
	@Bulkhead(name = RESILIENCE4J_INSTANCE)
	@Retry(name = RESILIENCE4J_INSTANCE)
	public void boardToMemberPostSend(BoardToMemberPostMessage message) {
		rabbitTemplate.convertAndSend(EXCHANGE, "BoardToMember.Post", message);
	}
	
}
