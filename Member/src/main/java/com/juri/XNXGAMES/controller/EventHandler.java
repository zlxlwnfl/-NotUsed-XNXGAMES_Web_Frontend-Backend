package com.juri.XNXGAMES.controller;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.juri.XNXGAMES.domain.BoardToMemberPostMessage;
import com.juri.XNXGAMES.service.MemberPostService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventHandler {

	MemberPostService memberPostService;
	
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "BoardToMemberQueue", durable = "true"),
			exchange = @Exchange(value = "BoardExchange", type = "topic", durable = "true"),
			key = "BoardToMember.Post"
			))
	public void boardToMemberPostHandle(final BoardToMemberPostMessage message) {
		if(message.getType() == "create")
			memberPostService.insertMemberPost(message);
		else if(message.getType() == "delete")
			memberPostService.deleteMemberPost(message);
	}
	
}
