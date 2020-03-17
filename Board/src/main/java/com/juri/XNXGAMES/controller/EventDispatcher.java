package com.juri.XNXGAMES.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;

import lombok.AllArgsConstructor;

@Component
public class EventDispatcher {

	private RabbitTemplate rabbitTemplate;
	private String exchange;

	@Autowired
	EventDispatcher(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		this.exchange = "BoardExchange";
	}
	
	public void boardToMemberPostSend(BoardToMemberPostMessage message) {
		rabbitTemplate.convertAndSend(exchange, "BoardToMember.Post", message);
	}
	
}
