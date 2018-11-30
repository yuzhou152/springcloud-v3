package com.example.springcloudserver.schedule;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

//根据@Output("exchange name")创建相关Exchange和对应的queue
@EnableBinding(value = {SinkSender.class, SinkReceiver.class})
public class SinkListener {
	@StreamListener(SinkReceiver.INPUT1)
	public void receiveDemo1(Object payload) {
		System.out.println("Receiver Demo 1 : " + payload.toString());
	}
	
	@StreamListener(SinkReceiver.INPUT2)
	public void receiveDemo2(Object payload) {
		System.out.println("Receiver Demo 2 : " + payload.toString());
	}
	
	/**
	 * 按原路返回消息
	 */
	@StreamListener(SinkReceiver.INPUT3)
	@SendTo(SinkReceiver.INPUT4)
	public String receiveDemo3(Object payload) {
		System.out.println("Receiver Demo 3 : " + payload.toString());
		return "I got it!" + payload;
	}

	@StreamListener(SinkReceiver.INPUT4)
	public void receiveDemo4(Object payload) {
		System.out.println("Receiver Demo 4 : " + payload.toString());
	}
}