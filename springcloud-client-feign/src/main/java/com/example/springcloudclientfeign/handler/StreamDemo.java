package com.example.springcloudclientfeign.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudclientfeign.schedule.SinkSender;

@RestController
public class StreamDemo {

	@Autowired
	private SinkSender sinkSender;
	
	@Autowired
	private MessageChannel input_exchange4;
	
	@RequestMapping("/send")
	public boolean send() {
		sinkSender.output1().send(MessageBuilder.withPayload(" From SinkSender1.").build());
		sinkSender.output2().send(MessageBuilder.withPayload(" From SinkSender2.").build());
		sinkSender.output3().send(MessageBuilder.withPayload(" From SinkSender3.").build());
		return true;
	}

	/**
	 * 直接定义MessageChannel，
	 * 	1.由input_exchange1指向Exchange名
	 * 	2.由@Qualifier指向Exchange名
	 * 
	 * @不推荐使用
	 */
	@Deprecated
	@RequestMapping("/sendByChannel")
	public boolean sendByChannel() {
		return input_exchange4.send(MessageBuilder.withPayload(" From SinkSender1.").build());
	}
	
}
