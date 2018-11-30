package com.example.springcloudclientfeign.schedule;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

//根据@Output("exchange name")创建相关Exchange和对应的queue
@EnableBinding(value = {SinkSender.class, SinkReceiver.class})
public class SinkBinder {
	
	@StreamListener(SinkReceiver.INPUT1)
	public void receiveDemo1(Object payload) {
	}
	
	@StreamListener(SinkReceiver.INPUT2)
	public void receiveDemo2(Object payload) {
	}
	
	@StreamListener(SinkReceiver.INPUT3)
	public void receiveDemo3(Object payload) {
	}

	@StreamListener(SinkReceiver.INPUT4)
	public void receiveDemo4(Object payload) {
	}
}